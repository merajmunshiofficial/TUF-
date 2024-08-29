package ARRAY;

import java.util.*;

class sortZeroOneTwo {
    // Function to sort the array containing only 0s, 1s, and 2s
    public void sortZeroOneTwo(int[] nums) {
        // 3 pointers: low, mid, high
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                
                /* Swap nums[low] and nums[mid], then 
                move both low and mid pointers forward*/
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
                
            } else if (nums[mid] == 1) {
                // Move mid pointer forward
                mid++;
            } else {
                /* Swap nums[mid] and nums[high], 
                then move high pointer backward*/
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 0, 1};
        
        // Create an instance of sortZeroOneTwo class
        sortZeroOneTwo sol = new sortZeroOneTwo();
        
        sol.sortZeroOneTwo(nums);
        
        // Print the array elements after sorting
        System.out.println("After sorting:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
