import java.util.*;

class distinctSubsequencestabu {
    private static final int prime = (int)(1e9 + 7);
    /* Function to count the number of
    distinct subsequences of s in t*/
    public int distinctSubsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        /* Initialize the first row: empty string t can
        be matched with any non-empty s in one way*/
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        /* Initialize the first column:
        s can't match any non-empty t*/
        for (int i = 1; i <= m; i++) {
            dp[0][i] = 0;
        }
        
        // Fill in the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    /* If the characters match, consider two options:
                    either leave one character in s and t or leave 
                    one character in s and continue matching t*/
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
                } else {
                    /* If the characters don't match, we can
                    only leave the current character in s*/
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        /* The value at dp[n][m] contains
        the count of distinct subsequences*/
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        //Create an instace of distinctSubsequencestabu class
        distinctSubsequencestabu sol = new distinctSubsequencestabu();
        
        // Print the result
        System.out.println("The Count of Distinct Subsequences is " + sol.distinctSubsequences(s1, s2));
    }
}
