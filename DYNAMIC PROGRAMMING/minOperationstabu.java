import java.util.*;

class minOperationstabu {
    /* Function to calculate the length 
    of the Longest Common Subsequence*/
    private int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        // Initialize the base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill in the DP table to calculate the length of LCS
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                
                // Characters match, increment LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
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
    /* Function to calculate the minimum insertions
    required to make a string palindrome*/
    public int minOperations(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
    
        /* Calculate the length of the longest 
        common subsequence between str1 and str2*/
        int k = lcs(str1, str2);
    
        /* Calculate the minimum operations
        required to convert str1 to str2*/
        return (n - k) + (m - k);
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";
        
        // Create an instance of minOperationstabu class
        minOperationstabu sol = new minOperationstabu();
        
        // Call the minOperations function and print the result
        System.out.println("The Minimum operations required to convert str1 to str2: " + sol.minOperations(str1, str2));
    }
}
