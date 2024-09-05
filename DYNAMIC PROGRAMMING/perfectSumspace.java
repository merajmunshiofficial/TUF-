import java.util.*;

class perfectSumspace {
    private static final int MODULO = 1000000007;

    // Function to find out number of subsets with sum k
    public int perfectSum(int[] arr, int K) {
        int n = arr.length;

        /* Initialize a vector 'prev' to represent
        the previous row of the DP table */
        int[] prev = new int[K + 1];
        Arrays.fill(prev, 0);

        /* Base case: If the target sum is 0, 
        there is one valid subset (the empty subset) */
        prev[0] = 1;

        /* Initialize the first row based
        on the first element of the array */
        if (arr[0] <= K) {
            prev[arr[0]] = 1;
        }

        /* Fill in the DP table 
        using a bottom-up approach */
        for (int ind = 1; ind < n; ind++) {
            /* Create a vector 'cur' to represent
            the current row of the DP table */
            int[] cur = new int[K + 1];
            Arrays.fill(cur, 0);

            cur[0] = 1;

            for (int target = 1; target <= K; target++) {
                // Exclude the current element
                int notTaken = prev[target];

                /* Include the current element 
                if it doesn't exceed the target */
                int taken = 0;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                // Update the current row of the DP table
                cur[target] = (notTaken + taken) % MODULO;
            }

            // Set 'cur' as 'prev' for the next iteration
            prev = cur;
        }

        /* The final result is in the
        last cell of the 'prev' vector */
        return prev[K];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int k = 3;

        // Create an instance of perfectSumspace class
        perfectSumspace sol = new perfectSumspace();

        // Print the result
        System.out.println("The number of subsets found are " + sol.perfectSum(arr, k));
    }
}
