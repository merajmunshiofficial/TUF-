import java.util.*;

class equalPartitiontabu {
    /* Function to check if it's possible to partition
    the array into two subsets with equal sum*/
    private boolean func(int ind, int target, int n, int[] arr) {
        int totSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        /* If the total sum is odd, it cannot 
        be partitioned into two equal subsets*/
        if (totSum % 2 == 1)
            return false;
        else {
            int k = totSum / 2;

            /* Create a DP table with dimensions
            n x k+1, initialized with false*/
            boolean[][] dp = new boolean[n][k + 1];

            /* Base case: If the target sum is 0, it can
            be achieved by not selecting any elements*/
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            /* Initialize the first row based 
            on the first element of the array*/
            if (arr[0] <= k)
                dp[0][arr[0]] = true;

            // Fill in the DP table using bottom-up approach
            for (int i = 1; i < n; i++) {
                
                for (int targetVal = 1; targetVal <= k; targetVal++) {
                    // Exclude the current element
                    boolean notTaken = dp[i - 1][targetVal];

                    /* Include the current element 
                    if it doesn't exceed the target*/
                    boolean taken = false;
                    if (arr[i] <= targetVal)
                        taken = dp[i - 1][targetVal - arr[i]];

                    // Update the DP table
                    dp[i][targetVal] = notTaken || taken;
                }
            }

            /* The final result is in the
            last cell of the DP table*/
            return dp[n - 1][k];
        }
    }

    /* Function to check if the array can 
    be partitioned into two equal subsets*/
    public boolean equalPartition(int n, int[] arr) {
        int totSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        /* If the total sum is odd, it cannot 
        be partitioned into two equal subsets*/
        if (totSum % 2 == 1)
            return false;
        else {
            int k = totSum / 2;

            // Return the result
            return func(n - 1, k, n, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        // Create an instance of equalPartitiontabu class
        equalPartitiontabu sol = new equalPartitiontabu();

        if (sol.equalPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
