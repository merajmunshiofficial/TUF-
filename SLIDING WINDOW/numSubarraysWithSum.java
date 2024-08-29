import java.util.*;

class numSubarraysWithSum {
    /* Function to find the number of 
    subarrays with sum equal to `goal` */
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        /* Calculate the number of subarrays with 
        sum exactly equal to `goal` by using the 
        difference between subarrays with sum less
        than or equal to `goal` and those with sum
        less than or equal to `goal-1` */
        return numSubarraysWithSumLessEqualToGoal(nums, goal) - numSubarraysWithSumLessEqualToGoal(nums, goal - 1);
    }
    
    /* Helper function to find the number of 
    subarrays with sum less than or equal to `goal` */
    private int numSubarraysWithSumLessEqualToGoal(int[] nums, int goal) {
        
        /* If goal is negative, there 
        can't be any valid subarray sum */
        if (goal < 0) return 0;
        
        // Pointers to maintain the current window
        int l = 0, r = 0; 
        
        /* Variable to track the current
        sum of elements in the window*/
        int sum = 0;      
        
        // Variable to count the number of subarrays
        int count = 0;   
        
        // Iterate through the array 
        while (r < nums.length) {
            sum += nums[r]; 
            
            /* Shrink the window from the left
            side if the sum exceeds `goal` */
            while (sum > goal) {
                sum -= nums[l];  
                
                // Move the left pointer `l` forward
                l++;            
            }
            
            /* Count all subarrays ending at
            `r` that satisfy the sum condition */
            count += (r - l + 1);
            
            // Move the right pointer `r` forward 
            r++; 
        }
        
        // Return the total count of subarrays
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 1, 0};
        int goal = 2;
        
        // Create an instance of numSubarraysWithSum class
        numSubarraysWithSum sol = new numSubarraysWithSum();
        
        int ans = sol.numSubarraysWithSum(nums, goal);
    
        // Print the result
        System.out.println("Number of substrings with sum \"" + goal + "\" is: " + ans);
    }
}
