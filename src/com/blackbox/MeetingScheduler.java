package com.blackbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingScheduler {

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return this.start != other.start ? this.start - other.start : this.end - other.end;
        }
    }

    public static List<String> findAvailableSlots(List<String> scheduleA, String workHoursA,
                                                  List<String> scheduleB, String workHoursB, int duration) {
        List<Interval> mergedSchedule = new ArrayList<>();
        // Add work hours as bookends to ensure meetings don't get scheduled before/after work
        addWorkHoursAndMeetings(mergedSchedule, scheduleA, workHoursA);
        addWorkHoursAndMeetings(mergedSchedule, scheduleB, workHoursB);

        Collections.sort(mergedSchedule);

        // Merge overlapping intervals
        List<Interval> merged = mergeIntervals(mergedSchedule);

        // Find gaps for the meeting
        List<String> availableSlots = new ArrayList<>();
        for (int i = 0; i < merged.size() - 1; i++) {
            int gapStart = merged.get(i).end;
            int gapEnd = merged.get(i + 1).start;
            if (gapEnd - gapStart >= duration) {
                availableSlots.add(formatTime(gapStart) + "-" + formatTime(gapEnd));
            }
        }

        return availableSlots;
    }

    private static void addWorkHoursAndMeetings(List<Interval> mergedSchedule, List<String> schedule, String workHours) {
        mergedSchedule.add(new Interval(parseTime(workHours.split("-")[0]), parseTime(workHours.split("-")[1])));
        for (String meeting : schedule) {
            String[] parts = meeting.split("-");
            mergedSchedule.add(new Interval(parseTime(parts[0]), parseTime(parts[1])));
        }
    }

    private static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).end < interval.start) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, interval.end);
            }
        }
        return merged;
    }

    private static int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static String formatTime(int minutes) {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
    }

    public static void main(String[] args) {
        List<String> scheduleA = List.of("09:00-10:13", "12:47-13:00", "16:00-18:00");
        String workHoursA = "09:00-19:00";
        List<String> scheduleB = List.of("10:00-11:30", "12:30-14:45", "14:50-15:00", "16:00-17:00");
        String workHoursB = "08:00-18:00";
        int duration = 30; // Meeting duration in minutes

        List<String> availableSlots = findAvailableSlots(scheduleA, workHoursA, scheduleB, workHoursB, duration);
        System.out.println("Available slots:");
        availableSlots.forEach(System.out::println);
    }
}