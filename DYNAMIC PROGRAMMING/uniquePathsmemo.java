import java.util.*;

class uniquePathsmemo {
    //Function to solve the problem using recursion
    private int func(int i, int j, int[][] dp) {
        // Base case
        if (i == 0 && j == 0) return 1;

        // If we go out of bounds, there are no ways
        if (i < 0 || j < 0) return 0;
        
        /* If the value for this cell 
        is already computed, return it.*/
        if (dp[i][j] != -1)
            return dp[i][j];

        /* Calculate the number of ways by
        moving up and left recursively*/
        int up = func(i - 1, j, dp);
        int left = func(i, j - 1, dp);

        /* Store the result in dp array
        and return the total ways*/
        return dp[i][j] = up + left;
    }
    /*Function to count the total ways
    to reach (0,0) from (m-1,n-1)*/
    public int uniquePaths(int m, int n) {
        // Declare a 2D DP array to store results
        int dp[][] = new int[m][n];
        
        /* Initialize the DP array with 
        -1 to indicate uncomputed values*/
        for (int[] row : dp)
            Arrays.fill(row, -1);
            
        // Return the total count (0-based indexing)
        return func(m - 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        // Create an instance of uniquePathsmemo class
        uniquePathsmemo sol = new uniquePathsmemo();

        // Call the uniquePaths function and print the result
        System.out.println("Number of ways: " + sol.uniquePaths(m, n));
    }
}
