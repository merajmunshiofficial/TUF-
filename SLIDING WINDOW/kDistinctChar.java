import java.util.*;

class kDistinctChar {
    /* Function to find the maximum length of 
    substring with at most k distinct characters */
    public int kDistinctChar(String s, int k) {
        
        // Length of the input string
        int n = s.length();  
        
        /* Variable to store the 
        maximum length of substring */
        int maxLen = 0;  
        
        /* Map to track the count of each
        character in the current window */
        HashMap<Character, Integer> mpp = new HashMap<>();
        
        // Pointers for the sliding window approach
        int l = 0, r = 0;
        
        while(r < n){
            char charR = s.charAt(r);
            mpp.put(charR, mpp.getOrDefault(charR, 0) + 1);
            
            /* If number of different characters exceeds
             k, shrink the window from the left*/
            if(mpp.size() > k){
                char charL = s.charAt(l);
                mpp.put(charL, mpp.get(charL) - 1);
                if(mpp.get(charL) == 0){
                    mpp.remove(charL);
                }
                l++;
            }
            
            /* If number of different characters 
            is at most k, update maxLen*/
            if(mpp.size() <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            
            r++;
        }
        
        // Return the maximum length
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";  
        int k = 2;
        
        // Create an instance of kDistinctChar class
        kDistinctChar sol = new kDistinctChar();
        
        int length = sol.kDistinctChar(s, k);
        
        // Print the result
        System.out.println("Maximum length of substring with at most " + k + " distinct characters: " + length);
    }
}
