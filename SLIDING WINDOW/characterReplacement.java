import java.util.*;

class characterReplacement {
    /*Function to find the longest substring 
    with at most k characters replaced*/
    public int characterReplacement(String s, int k) {
        
        /* Variable to store the maximum
        length of substring found*/
        int maxLen = 0;
        
        /* Variable to track the maximum frequency
        of any single character in the current window*/
        int maxFreq = 0;
        
        // Pointers to maintain the current window [l, r]
        int l = 0, r = 0;
        
        // Hash array to count frequencies of characters
        int[] hash = new int[26];

        // Iterate through each starting point of substring
        while (r < s.length()) {
            /* Update frequency of current
            character in the hash array*/
            hash[s.charAt(r) - 'A']++;
            
            // Update max frequency encountered
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            
            // Check if current window is invalid
            if ((r - l + 1) - maxFreq > k) {
                /* Slide the left pointer to 
                make the window valid again*/
                hash[s.charAt(l) - 'A']--;
                
                // Move left pointer forward
                l++;
            }
            
            /* Update maxLen with the length 
            of the current valid substring*/
            maxLen = Math.max(maxLen, r - l + 1);
            
            // Move right pointer forward to expand window
            r++;
        }

        /* Return the maximum length of substring
        with at most k characters replaced*/
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;

        // Create an instance of characterReplacement class
        characterReplacement sol = new characterReplacement();

        int length = sol.characterReplacement(s, k);

        // Print the result
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + length);
    }
}
