import java.util.*;

class editDistancespace {
    /* Function to calculate the minimum number 
    of operations required to transform start into target */
    public int editDistance(String start, String target) {
        int n = start.length();
        int m = target.length();

        /* Declare two arrays to store previous
        and current row of edit distances */
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Initialize the first row
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        // Calculate edit distances row by row
        for (int i = 1; i <= n; i++) {
            // Initialize the first column of current row
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                // If the characters match, no additional cost
                if (start.charAt(i - 1) == target.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    // Take minimum of three choices
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                }
            }
            // Update the previous row with current row
            System.arraycopy(cur, 0, prev, 0, m + 1);
        }

        // The value at cur[m] contains the edit distance
        return cur[m];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        // Create an instance of editDistancespace
        editDistancespace sol = new editDistancespace();

        // Call the editDistance function and print the result
        System.out.println("The minimum number of operations required is: " + sol.editDistance(s1, s2));
    }
}
