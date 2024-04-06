package com.blackbox;

public class StringReverser {
    public static String reverseString(String s) {

        char[] charArray = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String input = "Grimoire";
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reverseString(input));
    }
}
