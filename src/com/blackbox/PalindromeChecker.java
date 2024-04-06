package com.blackbox;

public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = cleaned.length() - 1;

        // Check for palindrome
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false; // Characters at the left and right do not match
            }
            left++;  // Move the left pointer to the right
            right--; // Move the right pointer to the left
        }

        return true; // The string is a palindrome
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama";
        System.out.println("Is palindrome: " + isPalindrome(input));
    }
}