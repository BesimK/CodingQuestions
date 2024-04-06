package com.blackbox;

class ListNodeForCycleDetector {
    int val;
    ListNodeForCycleDetector next;

    ListNodeForCycleDetector(int val) {
        this.val = val;
        this.next = null;
    }
}

public class CycleDetector {

    public static boolean hasCycle(ListNodeForCycleDetector head) {
        if (head == null) return false;

        ListNodeForCycleDetector tortoise = head; // Moves one step at a time
        ListNodeForCycleDetector hare = head; // Moves two steps at a time

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;      // Move tortoise one step
            hare = hare.next.next;         // Move hare two steps

            if (tortoise == hare) {        // If they meet, a cycle exists
                return true;
            }
        }

        // If hare reaches the end of the list, no cycle exists
        return false;
    }

    public static void main(String[] args) {
        // Example: create a linked list with a cycle for testing
        ListNodeForCycleDetector head = new ListNodeForCycleDetector(1);
        head.next = new ListNodeForCycleDetector(2);
        ListNodeForCycleDetector node3 = new ListNodeForCycleDetector(3);
        head.next.next = node3;
        head.next.next.next = new ListNodeForCycleDetector(4);
        head.next.next.next.next = new ListNodeForCycleDetector(5);
        head.next.next.next.next.next = node3; // Creates a cycle

        System.out.println("Does the linked list have a cycle? " + hasCycle(head));
    }
}