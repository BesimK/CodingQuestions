package com.blackbox;

import java.util.Arrays;
import java.util.LinkedList;

public class IntervalMerger {

    public static int[][] merge(int[][] intervals) {
        // Edge case: if the intervals array is empty or has only one interval
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals by their starting points
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // If the list of merged intervals is empty or if the current interval does not overlap with the previous,
            // simply add the interval.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // Otherwise, there is an overlap, so we merge the current and previous intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] mergedIntervals = merge(intervals);

        System.out.println("Merged intervals: ");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}