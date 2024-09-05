import java.util.List;
import java.util.ArrayList;
import java.util.*;

class minCostmemo {
    // Function to calculate the minimum cost incurred
    private int func(int i, int j, int[] cuts, int[][] dp) {
        /* Base case: If i is greater than
        j, there are no cuts to consider.*/
        if (i > j) {
            return 0;
        }

        // Check if the subproblem is already solved
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            /* Calculate the cost for 
            making a cut at position 'ind'.*/
            int ans = cuts[j + 1] - cuts[i - 1] + func(i, ind - 1, cuts, dp) + func(ind + 1, j, cuts, dp);

            mini = Math.min(mini, ans);
        }
        // Return the result
        return dp[i][j] = mini;
    }

    // Function to compute the minimum cost
    public int minCost(int n, List<Integer> cuts) {
        int c = cuts.size();
        /* Convert List<Integer> to int[] */
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts.get(i);
        }
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);

        // Create a DP table to store calculated values.
        int[][] dp = new int[c + 1][c + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function to find minimum cost.
        return func(1, c, newCuts, dp);
    }

    public static void main(String[] args) {
        List<Integer> cuts = new ArrayList<>();
        cuts.add(3);
        cuts.add(5);
        cuts.add(1);
        cuts.add(4);
        int n = 7;

        // Create an instance of minCostmemo class
        minCostmemo sol = new minCostmemo();

        System.out.println("The minimum cost incurred is: " + sol.minCost(n, cuts));
    }
}
