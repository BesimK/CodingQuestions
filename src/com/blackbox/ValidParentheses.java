package com.blackbox;

public class ValidParentheses {

    public static boolean isValid(String s) {
        // Early exit for odd-length strings
        if ((s.length() % 2) != 0) return false;

        char[] stack = new char[s.length()];
        int stackPointer = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack[stackPointer++] = c; // Push to stack
                    break;
                case ')':
                    if (stackPointer == 0 || stack[--stackPointer] != '(') return false;
                    break;
                case '}':
                    if (stackPointer == 0 || stack[--stackPointer] != '{') return false;
                    break;
                case ']':
                    if (stackPointer == 0 || stack[--stackPointer] != '[') return false;
                    break;
            }
        }
        return stackPointer == 0;
    }

    public static void main(String[] args) {
        String input = "()[]{}";
        System.out.println("Is the input string valid? " + isValid(input));
    }
}