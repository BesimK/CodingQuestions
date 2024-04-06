package com.blackbox;

public class MissingNumberFinder {

    public static int findMissingNumber(int[] array) {
        int n = array.length + 1; // Since one number is missing in the array
        int totalSum = n * (n + 1) / 2; // Sum of first n natural numbers

        int arraySum = 0;
        for (int num : array) {
            arraySum += num; // Sum of numbers in the array
        }

        return totalSum - arraySum; // The missing number
    }

    public static void main(String[] args) {
        int[] inputArray = {3, 7, 1, 2, 8, 4, 5};
        System.out.println("The missing number is: " + findMissingNumber(inputArray));
    }
}