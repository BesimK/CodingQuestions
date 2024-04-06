package com.blackbox;

class ListNodeForMergeTwoSortedLists {
    int val;
    ListNodeForMergeTwoSortedLists next;
    ListNodeForMergeTwoSortedLists() {}
    ListNodeForMergeTwoSortedLists(int val) { this.val = val; }
    ListNodeForMergeTwoSortedLists(int val, ListNodeForMergeTwoSortedLists next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {

    public static ListNodeForMergeTwoSortedLists mergeTwoLists(ListNodeForMergeTwoSortedLists l1, ListNodeForMergeTwoSortedLists l2) {
        // Initialize a prehead node and a current node pointer
        ListNodeForMergeTwoSortedLists prehead = new ListNodeForMergeTwoSortedLists(-1);
        ListNodeForMergeTwoSortedLists prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        // Example Usage
        ListNodeForMergeTwoSortedLists l1 = new ListNodeForMergeTwoSortedLists(1, new ListNodeForMergeTwoSortedLists(2, new ListNodeForMergeTwoSortedLists(4)));
        ListNodeForMergeTwoSortedLists l2 = new ListNodeForMergeTwoSortedLists(1, new ListNodeForMergeTwoSortedLists(3, new ListNodeForMergeTwoSortedLists(4)));

        ListNodeForMergeTwoSortedLists merged = mergeTwoLists(l1, l2);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}