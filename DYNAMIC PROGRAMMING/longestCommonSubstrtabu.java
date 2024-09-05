import java.util.*;

class longestCommonSubstrtabu {
    /* Function to find the length of 
    the Longest Common Substring (LCS) */
    public int longestCommonSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
    
        // Initialize a 2D DP table with dimensions
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the answer variable
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Characters match, increment substring length
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    
                    /* Update the maximum substring 
                    length found so far */
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    /* Characters don't match, 
                    substring length becomes 0 */
                    dp[i][j] = 0;
                }
            }
        }
        // Return the length of Longest Common Substring
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Create an instance of longestCommonSubstrtabu class
        longestCommonSubstrtabu sol = new longestCommonSubstrtabu();
        
        // Print the result
        System.out.println("The Length of Longest Common Substring is " + sol.longestCommonSubstr(s1, s2));
    }
}
