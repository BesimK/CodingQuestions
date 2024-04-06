package com.blackbox;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // Push the value into the main stack
        stack.push(x);
        // If the minStack is empty or the current value is less than or equal to the current minimum, push it into the minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        // Pop the top value from the main stack
        int value = stack.pop();
        // If the popped value is the current minimum, pop it from the minStack as well
        if (value == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        // Return the top value of the main stack
        return stack.peek();
    }

    public int getMin() {
        // Return the top value of the minStack, which is the current minimum
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum: " + minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());        // Returns 0
        System.out.println("Minimum: " + minStack.getMin()); // Returns -2
    }
}
