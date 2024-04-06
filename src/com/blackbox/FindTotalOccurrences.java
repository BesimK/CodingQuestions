 package com.blackbox;

public class FindTotalOccurrences {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        int target = 3;
        System.out.println("Total occurrences of " + target + ": " + findTotalOccurrences(arr, target));
    }

    public static int findTotalOccurrences(int[] arr, int target) {
        int firstOccurrence = findFirstOccurrence(arr, target);
        if (firstOccurrence == -1) {
            return 0;
        } else {
            return findLastOccurrence(arr, target) - firstOccurrence + 1;
        }
    }

    private static int findFirstOccurrence(int[] arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        int result = -1;
        while (leftPointer <= rightPointer) {
            int mid = leftPointer + (rightPointer - leftPointer) / 2;
            if (arr[mid] == target) {
                result = mid;
                rightPointer = mid - 1;
            } else if (arr[mid] < target) {
                leftPointer = mid + 1;
            } else {
                rightPointer = mid - 1;
            }
        }
        return result;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        int result = -1;
        while (leftPointer <= rightPointer) {
            int mid = leftPointer + (rightPointer - leftPointer) / 2;
            if (arr[mid] == target) {
                result = mid;
                leftPointer = mid + 1;
            } else if (arr[mid] < target) {
                leftPointer = mid + 1;
            } else {
                rightPointer = mid - 1;
            }
        }
        return result;
    }
}