import java.util.*;

class minDifferencememo {
    // Function to solve the subset sum problem
    private boolean func(int ind, int target, int[] arr, Boolean[][] dp) {
        // Base case: If the target sum is 0, return true
        if (target == 0)
            return true;

        /* Base case: If we have considered all elements 
        and the target is still not 0, return false*/
        if (ind == 0)
            return (arr[0] == target);

        /* If the result for this state 
        is already calculated, return it*/
        if (dp[ind][target] != null)
            return dp[ind][target];

        // Exclude the current element
        boolean notTaken = func(ind - 1, target, arr, dp);

        /* Include the current element if
        it doesn't exceed the target*/
        boolean taken = false;
        if (arr[ind] <= target)
            taken = func(ind - 1, target - arr[ind], arr, dp);

        // Return the result
        return dp[ind][target] = notTaken || taken;
    }

    /* Function to find the minimum absolute
    difference between two subset sums*/
    public int minDifference(int[] arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        /* Initialize a DP table to store 
        the results of the subset sum problem*/
        Boolean[][] dp = new Boolean[n][totSum + 1];

        /* Calculate the subset sum for each 
        possible sum from 0 to the total sum*/
        for (int i = 0; i <= totSum; i++) {
            func(n - 1, i, arr, dp); 
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i] != null && dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        // Create an instance of minDifferencememo class
        minDifferencememo sol = new minDifferencememo();

        System.out.println("The minimum absolute difference is: " + sol.minDifference(arr, n));
    }
}
