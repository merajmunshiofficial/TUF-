import java.util.*;

class minCutmemo {
    // Function to check if substring is a palindrome.
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /* Recursive function to find the minimum 
    number of partitions to make palindromes.*/
    private int minPartitions(int i, int n, String str, int[] dp) {
        // Base case: If we've reached the end of string.
        if (i == n) return 0;

        // Check if the subproblem is already solved
        if (dp[i] != -1) return dp[i];

        int minCost = Integer.MAX_VALUE;
        /* Consider all possible substrings 
        starting from the current index.*/
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                /* If the substring is a palindrome,
                calculate the cost and minimize it.*/
                int cost = 1 + minPartitions(j + 1, n, str, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        // Return the result
        return dp[i] = minCost;
    }

    /* Main function to find the minimum number
    of partitions for palindrome partitioning.*/
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        /* Calling recursive function and subtracting 
        1 as it counts partitions, not cuts.*/
        return minPartitions(0, n, s, dp) - 1;
    }

    public static void main(String[] args) {
        String str = "BABABCBADCEDE";

        // Create an instance of minCutmemo class
        minCutmemo sol = new minCutmemo();

        // Print the result
        System.out.println("The minimum number of partitions: " + sol.minCut(str));
    }
}
