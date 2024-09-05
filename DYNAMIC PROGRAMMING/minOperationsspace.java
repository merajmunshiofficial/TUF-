import java.util.*;

class minOperationsspace {
    /* Function to calculate the length 
    of the Longest Common Subsequence*/
    private int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        /* Declare two arrays to store the 
        previous and current rows of DP values*/
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        /* Base Case is covered as we have
        initialized the prev and cur to 0.*/

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // Update the prev array with current values
            prev = cur;
        }
        // The value at prev[m] contains length of LCS
        return prev[m];
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

        // Create an instance of minOperationsspace class
        minOperationsspace sol = new minOperationsspace();

        // Call the minOperations function and print the result
        System.out.println("The Minimum operations required to convert str1 to str2: " + sol.minOperations(str1, str2));
    }
}
