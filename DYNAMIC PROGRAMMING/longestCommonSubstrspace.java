import java.util.*;

class longestCommonSubstrspace {
    /* Function to find the length of 
    the Longest Common Substring (LCS) */
    public int longestCommonSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
    
        /* Initialize two arrays to store 
        previous and current row values*/
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        
        /* Initialize the answer variable to
        store the maximum LCS length found*/
        int ans = 0; 
    
        // Loop through both strings
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Characters match, increment substring length
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    int val = 1 + prev[j - 1];
                    cur[j] = val;
                    
                    /* Update the maximum substring
                    length found so far*/
                    ans = Math.max(ans, val);
                } else {
                    /* Characters don't match,
                    substring length becomes 0*/
                    cur[j] = 0;
                }
                
            }
            /* Update the previous row with 
            the values of the current row*/
            System.arraycopy(cur, 0, prev, 0, m + 1);
        }
        // Return the length of Longest Common Substring
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Create an instance of longestCommonSubstrspace class
        longestCommonSubstrspace sol = new longestCommonSubstrspace();
        
        // Print the result
        System.out.println("The Length of Longest Common Substring is " + sol.longestCommonSubstr(s1, s2));
    }
}
