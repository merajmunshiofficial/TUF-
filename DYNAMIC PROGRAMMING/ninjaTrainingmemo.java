import java.util.*;

class ninjaTrainingmemo {
    /* Recursive function to calculate the 
    maximum points for the ninja training*/
    private int func(int day, int last, int[][] points, int[][] dp) {
        // If the result is already calculated, return it
        if (dp[day][last] != -1) return dp[day][last];
        
        // Base case
        if (day == 0) {
            int maxi = 0;
        
            /* Calculate the maximum points for the first day
            by choosing an activity different from last one*/
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            // Store the result in dp array and return it
            return dp[day][last] = maxi;
        }

        // Initialize max points for the current day
        int maxi = 0;
        
        // Iterate through activities for the current day
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                /* Calculate the points for the current activity
                and add it to the maximum points obtained so far */
                int activity = points[day][i] + func(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }
        }

        // Store the result in dp array and return it
        return dp[day][last] = maxi;
    }

    // Function to find the maximum points for ninja training
    public int ninjaTraining(int[][] points) {
        // Get the number of days
        int days = points.length;
        
        // Initialize a memoization table with -1 values
        int dp[][] = new int[days][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);
            
        // Return the maximum points
        return func(days - 1, 3, points, dp);
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        // Create an instance of ninjaTrainingmemo class
        ninjaTrainingmemo sol = new ninjaTrainingmemo();

        // Print the maximum points for ninja training
        System.out.println(sol.ninjaTraining(points));
    }
}
