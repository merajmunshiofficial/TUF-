import java.util.*;

class houseRobbermemo {
    // Function to solve the problem using memoization
    private int func(int ind, int[] arr, int[] dp) {
        // Base cases
        if (ind == 0)
            return arr[ind];
        if (ind < 0)
            return 0;

        // If dp[ind] already has a value, return it
        if (dp[ind] != -1) {
            return dp[ind];
        }

        // Choosing the current element
        int pick = arr[ind] + func(ind - 2, arr, dp);

        // Skipping the current element
        int nonPick = func(ind - 1, arr, dp);

        /* Store the result in dp 
        array and return the maximum*/
        return dp[ind] = Math.max(pick, nonPick);
    }

    // Function to find the maximum money robber can rob
    public int houseRobber(int[] money) {
        int n = money.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return money[0];

        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        // Populate arr1 and arr2
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                arr1[i] = money[i];
            if (i != 0)
                arr2[i - 1] = money[i];
        }

        // Initialize the dp arrays with -1
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int ans1 = func(arr1.length - 1, arr1, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int ans2 = func(arr2.length - 1, arr2, dp2);

        // Return the maximum of ans1 and ans2
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 2, 6};
        
        //Create an instance of houseRobbermemo class
        houseRobbermemo sol = new houseRobbermemo();
        
        System.out.println(sol.houseRobber(arr));
    }
}
