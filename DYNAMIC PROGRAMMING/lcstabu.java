import java.util.*;

class lcstabu {
    /* Function to calculate the length
    of the Longest Common Subsequence*/
    public int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        // Initialize the base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill in the DP table to calculate length of LCS
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                
                // Characters match, increment LCS length
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1]; 
                /* Characters don't match, consider
                the maximum from left or above*/    
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]); 
            }
        }
        // Return the length of Longest Common Subsequence
        return dp[n][m]; 
    }

    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        
        // Create an instance of lcstabu class
        lcstabu sol = new lcstabu();
        
        // Call the function to find and output
        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs(s1, s2));
    }
}
