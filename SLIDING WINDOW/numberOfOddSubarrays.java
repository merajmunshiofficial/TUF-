import java.util.*;

class numberOfOddSubarrays {
    /* Function to find the number of 
    nice subarrays with k odd numbers */
    public int numberOfOddSubarrays(int[] nums, int k) {
        
        /* Calculate the number of subarrays with 
        sum exactly equal to `k` by using the 
        difference between subarrays with sum less
        than or equal to `k` and those with sum
        less than or equal to `k-1` */
        return helper(nums, k) - helper(nums, k - 1);
    }
    
    /* Helper function to find the number of 
    subarrays with sum less than or equal to goal */
    private int helper(int[] nums, int goal) {
        
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
            sum += nums[r] % 2; 
            
            /* Shrink the window from the left
            side if the sum exceeds `goal` */
            while (sum > goal) {
                sum -= nums[l] % 2;  
                
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
        int[] nums = {1, 1, 2, 1, 1};
        int k = 1;
        
        // Create an instance of numberOfOddSubarrays class
        numberOfOddSubarrays sol = new numberOfOddSubarrays();
        
        int ans = sol.numberOfOddSubarrays(nums, k);
    
        // Print the result
        System.out.println("Number of nice subarrays with \"" + k + "\" odd numbers is: " + ans);
    }
}