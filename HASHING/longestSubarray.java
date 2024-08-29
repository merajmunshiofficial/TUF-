package HASHING;


import java.util.*;

class longestSubarray {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length; 
        int maxLength = 0;

        // starting index
        for (int startIndex = 0; startIndex < n; startIndex++) { 
            // ending index
            for (int endIndex = startIndex; endIndex < n; endIndex++) { 
                /* add all the elements of 
                   subarray = nums[startIndex...endIndex]  */
                int currentSum = 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    currentSum += nums[i];
                }

                if (currentSum == k) {
                    maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 1, 1 };
        int k = 1;

        // Create an instance of the longestSubarray class
        longestSubarray longestSubarray = new longestSubarray();
        // Function call to get the result
        int len = longestSubarray.longestSubarray(nums, k);
        
        System.out.println("The length of the longest subarray is: " + len);
    }
}
