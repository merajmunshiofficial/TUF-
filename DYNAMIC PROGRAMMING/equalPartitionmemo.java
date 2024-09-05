import java.util.*;

class equalPartitionmemo {
    /* Function to check if it's possible to partition
    the array into two subsets with equal sum*/
    private boolean func(int ind, int target, int[] arr, int[][] dp) {
        /* Base case: If the target sum 
        is 0, we found a valid partition*/
        if (target == 0)
            return true;

        /* Base case: If we have considered all elements 
        and the target is still not 0, return false*/
        if (ind == 0)
            return arr[0] == target;

        /* If the result for this state is 
        already calculated, return it*/
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        // Exclude the current element
        boolean notTaken = func(ind - 1, target, arr, dp);

        /* Include the current element if
        it doesn't exceed the target*/
        boolean taken = false;
        if (arr[ind] <= target)
            taken = func(ind - 1, target - arr[ind], arr, dp);

        // Store the result and return it
        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return dp[ind][target] == 1;
    }

    /* Function to check if the array can 
    be partitioned into two equal subsets*/
    public boolean equalPartition(int n, int[] arr) {
        int totSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        /* If the total sum is odd, it cannot be 
        partitioned into two equal subsets*/
        if (totSum % 2 == 1)
            return false;
        else {
            int k = totSum / 2;

            /* Initialize a DP table with dimensions
            n x k+1 and initialize with -1*/
            int[][] dp = new int[n][k + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            // Return the result
            return func(n - 1, k, arr, dp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        // Create an instance of equalPartitionmemo class
        equalPartitionmemo sol = new equalPartitionmemo();

        if (sol.equalPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
