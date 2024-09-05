import java.util.*;

class lcsspace {
    /* Function to calculate the length
    of the Longest Common Subsequence */
    public int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        /* Initialize two arrays to store the
        current and previous rows of the DP table */
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        /* Base case is covered as we have initialized
        the prev and cur arrays to 0. */

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                
                // Characters match, increment LCS length
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // Update the previous row with the current row
            System.arraycopy(cur, 0, prev, 0, m + 1);
        }
        // Return the length of Longest Common Subsequence
        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        
        // Create an instance of lcsspace class
        lcsspace sol = new lcsspace();
        
        // Call the function to find and output
        System.out.println("The Length of Longest Common Subsequence is " + sol.lcs(s1, s2));
    }
}
