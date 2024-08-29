package ARRAY;

import java.util.*;

class findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        /* Initialize count and max_count 
               to track current and maximum consecutive 1s */
        int cnt = 0;
        int maxi = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If the current element is 1, increment the count
            if (nums[i] == 1) {
                cnt++;

                // Update maxi if current count is greater than maxi
                maxi = Math.max(maxi, cnt);

            } else {
                // If the current element is 0, reset the count
                cnt = 0;
            }
        }
        // Return the maximum count of consecutive 1s
        return maxi;
    }

    public static void main(String[] args) {
     
        int[] nums = {1, 1, 0, 1, 1, 1};

        // Create an instance of the findMaxConsecutiveOnes class
        findMaxConsecutiveOnes sol = new findMaxConsecutiveOnes();

        // Find and print the maximum consecutive 1s
        int ans = sol.findMaxConsecutiveOnes(nums);
        System.out.println("The maximum consecutive 1's are " + ans);
    }
}