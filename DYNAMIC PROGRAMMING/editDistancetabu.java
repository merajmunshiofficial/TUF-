import java.util.*;

class editDistancetabu {
    /* Function to calculate the minimum number 
    of operations required to transform start into target */
    public int editDistance(String start, String target) {
        int n = start.length();
        int m = target.length();

        // Create a DP table to store edit distances
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Fill in the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match, no additional cost
                if (start.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // Take minimum of three choices
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // The value at dp[n][m] contains the edit distance
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        
        // Create an instance of editDistancetabu
        editDistancetabu sol = new editDistancetabu();

        // Call the editDistance function and print the result
        System.out.println("The minimum number of operations required is: " + sol.editDistance(s1, s2));
    }
}
