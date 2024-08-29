import java.util.*;

class minWindow {
    /* Function to find the minimum length 
    substring in string s that contains
    all characters from string t. */
    public String minWindow(String s, String t) {
        
        /* Variable to store the minimum 
        length of substring found */
        int minLen = Integer.MAX_VALUE;
        
        /* Variable to store the starting index
        of the minimum length substring */
        int sIndex = -1;
        
        /* Array to count frequencies
        of characters in string t*/
        int[] hash = new int[256];
        
        // Count the frequencies of characters in t
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
            
        int count = 0;
        int l = 0, r = 0;
        
        // Iterate through current window 
        while (r < s.length()) {
            // Include the current character in the window
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
                
            /* If all characters from t 
            are found in current window */
            while (count == t.length()) {
                    
                /* Update minLen and sIndex
                if current window is smaller */
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                
                // Remove leftmost character from window
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        
        // Return minimum length substring from s
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";

        // Create an instance of minWindow class
        minWindow sol = new minWindow();

        String ans = sol.minWindow(s, t);

        // Print the result
        System.out.println("Minimum length substring containing all characters from \"" + t + "\" is: " + ans);
    }
}
