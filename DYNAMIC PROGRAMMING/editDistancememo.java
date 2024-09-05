import java.util.*;

class editDistancememo {
    /* Function to calculate the edit
    distance between two strings*/
    private int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp) {
        // Base cases
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        /* If the result for this state has
        already been calculated, return it*/
        if (dp[i][j] != -1)
            return dp[i][j];

        /* If the characters at the current 
        positions match, no operation is needed*/
        if (S1.charAt(i) == S2.charAt(j)){
            return dp[i][j] = 0 + editDistanceUtil(S1, S2, i - 1, j - 1, dp);
        }
        // Take minimum of three choices
        else {
            return dp[i][j] = 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1, dp),
                                  Math.min(editDistanceUtil(S1, S2, i - 1, j, dp),
                                           editDistanceUtil(S1, S2, i, j - 1, dp)));
        }
    }
    
    /* Function to calculate the minimum number of 
    operations required to transform start into target*/
    public int editDistance(String start, String target) {
        int n = start.length();
        int m = target.length();

        // Create a DP table to memoize results
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        /* Call the utility function with
        the last indices of both strings*/
        return editDistanceUtil(start, target, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        
        // Create an instance of editDistancememo
        editDistancememo sol = new editDistancememo();

        // Call the editDistance function and print the result
        System.out.println("The minimum number of operations required is: " + sol.editDistance(s1, s2));
    }
}
