import java.util.*;

class equalPartitionspace {
    /* Function to check if it's possible to partition
    the array into two subsets with equal sum*/
    private boolean func(int n, int[] arr) {
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

            /* Initialize a vector to represent
            the previous row of the DP table*/
            boolean[] prev = new boolean[k + 1];
            prev[0] = true;

            /* Initialize the first row based 
            on the first element of the array*/
            if (arr[0] <= k)
                prev[arr[0]] = true;

            // Fill in the DP table using a bottom-up approach
            for (int ind = 1; ind < n; ind++) {
                
                /* Initialize a vector to represent
                the current row of the DP table*/
                boolean[] cur = new boolean[k + 1];
                cur[0] = true;

                for (int target = 1; target <= k; target++) {
                    // Exclude the current element
                    boolean notTaken = prev[target];

                    /* Include the current element 
                    if it doesn't exceed the target*/
                    boolean taken = false;
                    if (arr[ind] <= target)
                        taken = prev[target - arr[ind]];

                    // Update the current row of the DP table
                    cur[target] = notTaken || taken;
                }

                /* Set the current row as the 
                previous row for the next iteration*/
                prev = cur;
            }

            /* The final result is in the last cell 
            of the previous row of the DP table*/
            return prev[k];
        }
    }

    /* Function to check if the array can 
    be partitioned into two equal subsets*/
    public boolean equalPartition(int n, int[] arr) {
        // Return the result
        return func(n, arr);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        // Create an instance of equalPartitionspace class
        equalPartitionspace sol = new equalPartitionspace();

        if (sol.equalPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
}
