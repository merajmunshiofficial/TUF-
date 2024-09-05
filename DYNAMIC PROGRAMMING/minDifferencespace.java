import java.util.*;

class minDifferencespace {
    /* Function to find the minimum absolute
    difference between two subset sums */
    public int minDifference(int[] arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        /* Initialize a boolean vector 'prev' to
        represent the previous row of the DP table */
        boolean[] prev = new boolean[totSum + 1];
        Arrays.fill(prev, false);

        /* Base case: If no elements are
        selected (sum is 0), it's a valid subset */
        prev[0] = true;

        /* Initialize the first row based
        on the first element of the array */
        if (arr[0] <= totSum)
            prev[arr[0]] = true;

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            /* Initialize a boolean vector 'cur' to
            represent the current row of the DP table */
            boolean[] cur = new boolean[totSum + 1];
            Arrays.fill(cur, false);
            cur[0] = true;

            for (int target = 1; target <= totSum; target++) {
                // Exclude the current element
                boolean notTaken = prev[target];

                /* Include the current element
                if it doesn't exceed the target */
                boolean taken = false;
                if (arr[ind] <= target)
                    taken = prev[target - arr[ind]];

                cur[target] = notTaken || taken;
            }

            // Set 'cur' as the 'prev' for the next iteration
            prev = cur;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                /* Calculate the absolute
                difference between two subset sums */
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        // Create an instance of minDifferencespace class
        minDifferencespace sol = new minDifferencespace();

        System.out.println("The minimum absolute difference is: " + sol.minDifference(arr, n));
    }
}
