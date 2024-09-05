import java.util.Arrays;

class ninjaTrainingtabu {
    /* Function to calculate the maximum
    points for the ninja training*/
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        // Create a 2D DP table to store the maximum points
        int[][] dp = new int[n][4];

        // Initialize the DP table for the first day (day 0)
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        // Iterate through the days starting from day 1
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                // Iterate through the tasks for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        /* Calculate the points for the current 
                        activity and add it to the maximum points
                        obtained on the previous day */
                        int activity = matrix[day][task] + dp[day - 1][task];

                        /* Update the maximum points for 
                        the current day and last activity*/
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        /* The maximum points for the last day with 
        any activity can be found in dp[n-1][3]*/
        return dp[n - 1][3];
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };
        
        // Create an instance of ninjaTrainingtabu class
        ninjaTrainingtabu sol = new ninjaTrainingtabu();
        
        // Print the maximum points for ninja training
        System.out.println(sol.ninjaTraining(points)); 
    }
}
