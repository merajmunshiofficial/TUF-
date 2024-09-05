import java.util.*;

class lcsmemo {
    /* Function to find the length of the
    Longest Common Subsequence (LCS)*/
    private int func(String s1, String s2, int ind1, int ind2, int[][] dp) {
        // Base case
        if (ind1 < 0 || ind2 < 0)
            return 0;

        /* If the result for this pair of indices
        is already calculated, return it*/
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        /* If the characters at the current 
        indices match, increment the LCS length*/
        if (s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + func(s1, s2, ind1 - 1, ind2 - 1, dp);
        else
            return dp[ind1][ind2] = Math.max(func(s1, s2, ind1, ind2 - 1, dp), func(s1, s2, ind1 - 1, ind2, dp));
    }

    /* Function to calculate the length
    of the Longest Common Subsequence*/
    public int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        //Return the result
        return func(str1, str2, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        
        //Create an instance of lcsmemo class
        lcsmemo sol = new lcsmemo();
        
        // Call the function to find and output
        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs(s1, s2));
    }
}
