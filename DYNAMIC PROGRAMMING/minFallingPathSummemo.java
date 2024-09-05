import java.util.*;

class minFallingPathSummemo {
    /* Function to recursively find the
    minimum path sum for a given cell*/
    private int func(int i, int j, int m, int[][] matrix, int[][] dp) {
        // Base Conditions
        if (j < 0 || j >= m)
            return (int) 1e9; 
        if (i == 0)
            return matrix[0][j]; 
        
        /* If the result for this cell is
        already calculated, return it*/
        if (dp[i][j] != -1)
            return dp[i][j];
    
        /* Calculate the minimum path sum by 
        considering three possible directions:
        up, left diagonal, and right diagonal*/
        int up = matrix[i][j] + func(i - 1, j, m, matrix, dp);
        int leftDiagonal = matrix[i][j] + func(i - 1, j - 1, m, matrix, dp);
        int rightDiagonal = matrix[i][j] + func(i - 1, j + 1, m, matrix, dp);
    
        // Store the minimum of the three paths in dp
        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    // Function to find the minimum path sum in given matrix
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
    
        // Memoization table to store computed results
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    
        int mini = Integer.MAX_VALUE;
    
        /* Iterate through each cell in the first row to 
        find minimum path sum starting from each of them*/
        for (int j = 0; j < m; j++) {
            int ans = func(n - 1, j, m, matrix, dp);
            mini = Math.min(mini, ans);
        }
        // Return the minimum path sum
        return mini;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 10, 4},
            {100, 3, 2, 1},
            {1, 1, 20, 2},
            {1, 2, 2, 1}
        };
    
        // Create an instance of minFallingPathSummemo class
        minFallingPathSummemo sol = new minFallingPathSummemo();
    
        // Call the minFallingPathSum function and print the result
        System.out.println(sol.minFallingPathSum(matrix));
    }
}
