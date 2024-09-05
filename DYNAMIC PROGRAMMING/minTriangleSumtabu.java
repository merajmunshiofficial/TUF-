class minTriangleSumtabu {
    // Function to find the minimum path sum using tabulation
    private int func(int[][] triangle, int n, int[][] dp) {
        /* Initialize the bottom row of dp 
        with the values from the triangle*/
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        // Iterate through the triangle rows in reverse order
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the minimum path sum for current cell
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                // Store the minimum of the two possible paths in dp
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        // Top-left cell of dp now contains the minimum path sum
        return dp[0][0];
    }

    // Function to find out the minimum path sum
    public int minTriangleSum(int[][] triangle) {
        // Get the number of rows in the triangle
        int n = triangle.length;
        
        /* Initialize a memoization table
        to store computed results*/
        int[][] dp = new int[n][n];
    
        // Return the minimum path sum
        return func(triangle, n, dp);
    }

    public static void main(String[] args) {
        int[][] triangle = {
            {1},
            {2, 3},
            {3, 6, 7},
            {8, 9, 6, 10}
        };
        
        // Create an instance of the minTriangleSumtabu class
        minTriangleSumtabu sol = new minTriangleSumtabu();
        
        // Call the minTriangleSum function and print result
        System.out.println(sol.minTriangleSum(triangle));
    }
}
