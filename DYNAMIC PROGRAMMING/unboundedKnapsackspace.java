import java.util.*;

class unboundedKnapsackspace {
    // Function to solve the unbounded knapsack problem
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        // Create a vector to store current DP state
        int[] cur = new int[W + 1];

        // Base Condition
        for (int i = wt[0]; i <= W; i++) {
            // Calculate the maximum value for first item
            cur[i] = (i / wt[0]) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Maximum value without taking current item
                int notTaken = cur[cap];

                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap)
                    // Maximum value by taking current item
                    taken = val[ind] + cur[cap - wt[ind]];

                /* Store the maximum value 
                in the current DP state*/
                cur[cap] = Math.max(notTaken, taken);
            }
        }
        /* Return the maximum value considering
        all items and the knapsack capacity*/
        return cur[W];
    }

    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int W = 10;
        int n = wt.length;

        // Create an instance of unboundedKnapsackspace class
        unboundedKnapsackspace sol = new unboundedKnapsackspace();

        // Print the result
        System.out.println("The Maximum value of items the thief can steal is " + sol.unboundedKnapsack(wt, val, n, W));
    }
}

