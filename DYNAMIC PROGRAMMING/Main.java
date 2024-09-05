import java.util.*;

class targetSummemo {
    /* Function to count partitions of the 
    array into subsets with a given target sum */
    private int func(int ind, int target, int[] arr, int[][] dp) {
        // Base case
        if (ind == 0) {
            // Include or exclude the element
            if (target == 0 && arr[0] == 0)
                return 2; 
            // One way to partition
            if (target == 0 || target == arr[0])
                return 1; 
            return 0;
        }
    
        /* If the result for this index and target
        sum is already calculated, return it */
        if (dp[ind][target] != -1)
            return dp[ind][target];
        
        /* Calculate the number of ways
        without taking the current element */
        int notTaken = func(ind - 1, target, arr, dp);
    
        /* Calculate the number of ways
        by taking the current element */
        int taken = 0;
        if (arr[ind] <= target)
            taken = func(ind - 1, target - arr[ind], arr, dp);
        
        /* Store the sum of ways in
        the DP array and return it */
        return dp[ind][target] = (notTaken + taken);
    }

    /* Function to count the number 
    of ways to achieve the target sum */
    public int targetSum(int n, int target, int[] nums) {
        int totSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }
    
        // Not possible to achieve the target sum
        if (totSum - target < 0)
            return 0; 
        /* The difference between the total 
        sum and target sum must be even */
        if ((totSum - target) % 2 == 1)
            return 0; 
    
        // Calculate the required sum for each subset
        int s2 = (totSum - target) / 2; 
    
        // Initialize DP table
        int[][] dp = new int[n][s2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Return the result
        return func(n - 1, s2, nums, dp); 
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int target = 3;
        int n = nums.length; 
    
        // Create an instance of targetSummemo class
        targetSummemo sol = new targetSummemo();

        // Print the result
        System.out.println("The total number of ways is " + sol.targetSum(n, target, nums));
    }
}
