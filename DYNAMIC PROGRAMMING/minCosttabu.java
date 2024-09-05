import java.util.List;
import java.util.ArrayList;
import java.util.*;


class minCosttabu {
    // Function to compute the minimum cost incurred
    public int minCost(int n, List<Integer> cuts) {
        int c = cuts.size();
        
        /* Modify the cuts array by adding 0
        at the beginning and 'n' at the end.*/
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        // Create a DP table to store calculated values.
        int[][] dp = new int[c + 2][c + 2];

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    /* Calculate the cost for 
                    making a cut at position 'ind'.*/
                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];

                    mini = Math.min(mini, ans);
                }
                // Store the minimum value in dp table
                dp[i][j] = mini;
            }
        }
        // Return the result
        return dp[1][c];
    }

    public static void main(String[] args) {
        List<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int n = 7;

        // Create an instance of minCosttabu class
        minCosttabu sol = new minCosttabu();

        System.out.println("The minimum cost incurred is: " + sol.minCost(n, cuts));
    }
}
