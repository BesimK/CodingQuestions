package com.blackbox;

public class DecimalPalindromeChecker {

    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes due to the minus sign.
        // Also, if the last digit of the number is 0, to be a palindrome,
        // the first digit of the number also needs to be 0, only possible for 0 itself.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by reversedHalf/10
        // For example, when the input is 12321, at the end of the loop we get x = 12, reversedHalf = 123,
        // since the middle digit doesn't matter in palindrome(it will always equal to itself), we can simply get rid of it.
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        int testNumber = 121;
        System.out.println(testNumber + " is palindrome? " + isPalindrome(testNumber));

        testNumber = -121;
        System.out.println(testNumber + " is palindrome? " + isPalindrome(testNumber));

        testNumber = 10;
        System.out.println(testNumber + " is palindrome? " + isPalindrome(testNumber));
    }
}