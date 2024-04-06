package com.blackbox;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0; // Pointer for the position of the next unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i]; // Move the next unique element to the position j
            }
        }
        return j + 1; // The length of the array containing only unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 6, 6};
        int len = removeDuplicates(nums);
        System.out.println("Length of array after removing duplicates: " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}