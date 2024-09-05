import java.util.Arrays;

class knapsack01tabu {
    // Function to solve the 0/1 Knapsack problem
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        /* Declare a 2D DP table with dimensions
        n x W+1 and initialize it with zeros*/
        int[][] dp = new int[n][W + 1];

        /* Base condition: Fill in the first 
        row for the weight of the first item*/
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        // Fill in DP table using a bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                /* Calculate the maximum value by either
                excluding the current item or including it*/
                int notTaken = dp[ind - 1][cap];
                int taken = Integer.MIN_VALUE;

                /* Check if the current item can be included
                without exceeding the knapsack's capacity*/
                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];
                }

                // Update the DP table
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        // The final result is in the last cell
        return dp[n - 1][W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        // Create an instance of knapsack01tabu class
        knapsack01tabu sol = new knapsack01tabu();
        
        // Call the function to find the maximum value
        int result = sol.knapsack01(wt, val, n, W);
        
        // Output the result
        System.out.println("The Maximum value of items is " + result);
    }
}
