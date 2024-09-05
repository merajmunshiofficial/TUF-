import java.util.*;

class minCuttabu {
    // Function to check if substring is a palindrome.
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /* Function to find the minimum number
    of partitions for palindrome partitioning.*/
    public int minCut(String s) {
        int n = s.length();
        
        /* Create a DP array to store
        the minimum number of partitions.*/
        int[] dp = new int[n + 1];
        
        // Initialize the last element to 0.
        dp[n] = 0;

        // Loop through the string in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            
            /* Consider all possible substrings
            starting from the current index.*/
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    /* If the substring is a palindrome, 
                    calculate the cost and minimize it.*/
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        // Subtract 1 as it counts partitions, not cuts.
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        String str = "BABABCBADCEDE";

        // Create an instance of minCuttabu class
        minCuttabu sol = new minCuttabu();
        
        System.out.println("The minimum number of partitions: " + sol.minCut(str));
    }
}
