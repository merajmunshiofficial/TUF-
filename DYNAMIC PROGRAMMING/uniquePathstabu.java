class uniquePathstabu {
    // Function to solve the problem using tabulation
    int func(int m, int n, int[][] dp) {
        // Loop through the grid using two nested loops
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base condition
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    /* Skip the rest of the loop and 
                    continue with the next iteration.*/
                    continue; 
                }

                /* Initialize variables to store the number
                of ways from cell above (up) and left (left)*/
                int up = 0;
                int left = 0;

                /* If we are not at first row (i > 0), update
                'up' with the value from the cell above*/
                if (i > 0)
                    up = dp[i - 1][j];

                /* If we are not at the first column (j > 0),
                update 'left' with value from the cell to left*/
                if (j > 0)
                    left = dp[i][j - 1];

                /* Calculate the number of ways to reach the 
                current cell by adding 'up' and 'left'*/
                dp[i][j] = up + left;
            }
        }

        // The result is stored in bottom-right cell (m-1, n-1)
        return dp[m - 1][n - 1];
    }

    /* Function to count the total ways 
    to reach (0,0) from (m-1,n-1)*/
    public int uniquePaths(int m, int n) {
        /* Initialize a memoization table (dp)
        to store the results of subproblems*/
        int[][] dp = new int[m][n];

        // Return the total count (0-based indexing)
        return func(m, n, dp);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        // Create an instance of uniquePathstabu class
        uniquePathstabu sol = new uniquePathstabu();

        // Call the uniquePaths function and print the result
        System.out.println("Number of ways: " + sol.uniquePaths(m, n));
    }
}
