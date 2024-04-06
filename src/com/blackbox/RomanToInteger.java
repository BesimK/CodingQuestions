package com.blackbox;

public class RomanToInteger {

    // Assuming all Roman numeral characters fall within the ASCII range, use direct indexing.
    private static final int[] values = new int[128]; // ASCII range suffices
    static {
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;
    }

    public static int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;
        for (char c : s.toCharArray()) {
            int value = values[c];
            if (prevValue < value) {
                total -= prevValue;
            } else {
                total += prevValue;
            }
            prevValue = value;
        }
        return total + prevValue; // Add the last value outside the loop
    }

    public static void main(String[] args) {
        String romanNumeral = "MCMXCIV";
        System.out.println(romanNumeral + " -> " + romanToInt(romanNumeral));
    }
}