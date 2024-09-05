import java.util.*;

class minTriangleSummemo {
    // Function to find the minimum path sum using memoization
    private int func(int i, int j, int[][] triangle, int n, int[][] dp) {
        /* If the result for this cell is
        already calculated, return it*/
        if (dp[i][j] != -1)
            return dp[i][j];

        // If we're at bottom row, return value of current cell
        if (i == n - 1)
            return triangle[i][j];

        // Calculate the sum of two possible paths
        int down = triangle[i][j] + func(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + func(i + 1, j + 1, triangle, n, dp);

        // Store the minimum sum in dp and return it
        return dp[i][j] = Math.min(down, diagonal);
    }

    // Function to find out the minimum path sum
    public int minTriangleSum(int[][] triangle) {
        // Get the number of rows in the triangle
        int n = triangle.length;

        // Initialize a memoization table to store computed results
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Return the minimum path sum
        return func(0, 0, triangle, n, dp);
    }

    public static void main(String[] args) {
        int[][] triangle = {{1},
                            {2, 3},
                            {3, 6, 7},
                            {8, 9, 6, 10}};

        // Create an instance of minTriangleSummemo class
        minTriangleSummemo sol = new minTriangleSummemo();

        // Call the minTriangleSum function and print result
        System.out.println("Minimum path sum in triangle: " + sol.minTriangleSum(triangle));
    }
}
