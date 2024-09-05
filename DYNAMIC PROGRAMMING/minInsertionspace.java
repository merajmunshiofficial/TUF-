import java.util.*;

class minInsertionspace {
    /* Function to calculate the length 
    of the Longest Common Subsequence*/
    private int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        /* Create two arrays to store the 
        previous and current rows of DP values */
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        /* Base Case is covered as we have
        initialized the prev and cur to 0. */

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // Update the prev array with current values
            System.arraycopy(cur, 0, prev, 0, m + 1);
        }
        // The value at prev[m] contains length of LCS
        return prev[m];
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
        
        // Create an instance of minInsertionspace class
        minInsertionspace sol = new minInsertionspace();
        
        // Call minInsertion function and print the result
        System.out.println("The Minimum insertions required to make string palindrome: " + sol.minInsertion(s));
    }
}
