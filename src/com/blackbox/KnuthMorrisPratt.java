package com.blackbox;

public class KnuthMorrisPratt {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0; // Edge case for empty needle

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // Mismatch found, move to the next position in haystack
                }
            }
            // If the loop completed, a match was found
            if (j == m) return i;
        }

        return -1; // No match found
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println("Index: " + strStr(haystack, needle));
    }
}
