package ARRAY;

import java.util.*;

class reverseArray {
    // Function to reverse the array
    public void reverseArray(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    // Function to rotate the array to the left by k positions
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;

        // Reverse the first k elements
        reverseArray(nums, 0, k - 1);

        // Reverse the last n-k elements
        reverseArray(nums, k, n - 1);

        // Reverse the whole array
        reverseArray(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        //Create an instance of the reverseArray class
        reverseArray sol = new reverseArray();

        // Call the function to rotate the array
        sol.rotateArray(arr, k);

        System.out.println("After rotating the elements to the left: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}