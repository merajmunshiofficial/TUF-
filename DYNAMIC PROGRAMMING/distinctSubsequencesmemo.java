import java.util.*;

class distinctSubsequencesmemo {
    private static final int prime = (int)(1e9 + 7);
    /* Function to count the number of 
    distinct subsequences of s2 in s1*/
    private int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        /* If s2 has been completely matched,
        return 1 (found a valid subsequence)*/
        if (ind2 < 0)
            return 1;
            
        /* If s1 has been completely traversed
        but s2 hasn't, return 0*/
        if (ind1 < 0)
            return 0;
            
        /* If the result for this state has
        already been calculated, return it*/
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        int result = 0;

        /* If the characters match, consider two options:
        either leave one character in s1 and s2 or leave 
        one character in s1 and continue matching s2*/
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);

            result = (leaveOne + stay) % prime;
        } else {
            /* If characters don't match, just leave
            one character in s1 and continue matching s2*/
            result = countUtil(s1, s2, ind1 - 1, ind2, dp);
        }
        // Store the result and return it
        dp[ind1][ind2] = result;
        return result;
    }
    /* Function to count the number of
    distinct subsequences of s in t*/
    public int distinctSubsequences(String s, String t) {
        int lt = s.length();
        int ls = t.length();
        int[][] dp = new int[lt][ls];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countUtil(s, t, lt - 1, ls - 1, dp);
    }

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        //Create an instace of distinctSubsequencesmemo class
        distinctSubsequencesmemo sol = new distinctSubsequencesmemo();
        
        // Print the result
        System.out.println("The Count of Distinct Subsequences is " + sol.distinctSubsequences(s1, s2));
    }
}
