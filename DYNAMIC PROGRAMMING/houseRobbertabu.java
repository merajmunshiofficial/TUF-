import java.util.*;

class houseRobbertabu {
    // Function to solve the problem using memoization
    private int func(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Base case
        dp[0] = nums[0];

        // Iterate through the elements of the array
        for (int i = 1; i < n; i++) {
            
            /* Calculate maximum value by either picking
            the current element or not picking it */
            int pick = nums[i];
            if (i > 1)
                pick += dp[i - 2];
            int nonPick = dp[i - 1];

            // Store the maximum value in dp array
            dp[i] = Math.max(pick, nonPick);
        }

        /* The last element of the dp array
        will contain the maximum sum */
        return dp[n - 1];
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
        int ans1 = func(arr1);

        int ans2 = func(arr2);

        // Return the maximum of ans1 and ans2
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 2, 6};
        
        //Create an instance of houseRobbertabu class
        houseRobbertabu sol = new houseRobbertabu();
        
        System.out.println(sol.houseRobber(arr));
    }
}
