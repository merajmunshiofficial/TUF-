import java.util.*;

class minInsertiontabu {
    /* Function to calculate the length 
    of the Longest Common Subsequence*/
    private int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and first column to 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        // Return the result
        return dp[n][m];
    }
    /* Function to calculate the length of 
    the Longest Palindromic Subsequence*/
    private int longestPalindromeSubsequence(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }
    /* Function to calculate the minimum insertions
    required to make a string palindrome*/
    public int minInsertion(String s) {
        int n = s.length();
        int k = longestPalindromeSubsequence(s);

        /* The minimum insertions required is the
        difference between the string length and
        its longest palindromic subsequence length*/
        return n - k;
    }

    public static void main(String[] args) {
        String s = "abcaa";
        
        // Create an instance of minInsertiontabu class
        minInsertiontabu sol = new minInsertiontabu();
        
        // Call minInsertion function and print the result
        System.out.println("The Minimum insertions required to make string palindrome: " + sol.minInsertion(s));
    }
}
