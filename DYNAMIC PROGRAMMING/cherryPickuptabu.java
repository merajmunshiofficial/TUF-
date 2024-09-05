import java.util.*;

class cherryPickuptabu {
    /* Function to find the maximum cherries 
    that can be collected using tabulation*/
    private int func(int n, int m, int[][] matrix) {
        // Initialize a 3D DP array to store computed results
        int[][][] dp = new int[n][m][m];

        // Initialize the DP array for the last row
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = matrix[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
            }
        }

        /* Outer nested loops for traversing the DP array
        from the second-to-last row up to the first row*/
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options 
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = matrix[i][j1];
                            else
                                ans = matrix[i][j1] + matrix[i][j2];

                            // Check if the move is valid 
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                /* A very large negative value 
                                to represent an invalid move*/
                                ans += -1e9; 
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj]; 
                                
                            // Update the maximum result
                            maxi = Math.max(ans, maxi); 
                        }
                    }
                    /* Store the maximum result for 
                    this state in the DP array*/
                    dp[i][j1][j2] = maxi; 
                }
            }
        }

        /* The maximum cherries that can be collected is
        stored at the top-left corner of the DP array*/
        return dp[0][0][m - 1];
    }

    // Function to find the maximum cherries picked
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Return the answer
        return func(n, m, matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 3, 1, 2},
            {3, 4, 2, 2},
            {5, 6, 3, 5}
        };

        // Create an instance of cherryPickuptabu class
        cherryPickuptabu sol = new cherryPickuptabu();

        // Call cherryPickup function and print the result
        System.out.println(sol.cherryPickup(matrix));
    }
}
