import java.util.*;

class wildCardtabu {
    /* Function to check if 'str' matches 
    'pat' using wildcard pattern matching */
    public boolean wildCard(String str, String pat) {
        int n = str.length();
        int m = pat.length();

        /* Create a DP table for 
        memoization, initialized with false */
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Initialize the first row
        for (int j = 1; j <= m; j++) {
            dp[0][j] = (pat.charAt(j - 1) == '*') && dp[0][j - 1];
        }

        // Initialize the first column
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (str.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                /* If the characters at the current
                positions match or str has a '?' */
                if (str.charAt(i - 1) == pat.charAt(j - 1) || str.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (str.charAt(i - 1) == '*') {
                    /* Two options: either '*' represents an 
                    empty string or it matches a character in pat */
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";

        // Create an instance of wildCardtabu class
        wildCardtabu sol = new wildCardtabu();

        // Call wildCard function and print the result
        if (sol.wildCard(S1, S2))
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }
}

