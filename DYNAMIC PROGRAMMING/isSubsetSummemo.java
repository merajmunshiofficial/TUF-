import java.util.*;

class isSubsetSummemo {
    /* Function to check if there is a subset of
    arr with sum equal to 'target' using memoization*/
    private boolean func(int ind, int target, int[] arr, int[][] dp) {
        // Base cases
        if (target == 0)
            return true;
        
        if (ind == 0)
            return arr[0]== target;
            
        /* If the result for this subproblem has 
        already been calculated, return it*/
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;
        
        // Try not taking the current element into subset
        boolean notTaken = func(ind - 1, target, arr, dp);
        
        /* Try taking the current element into the
        subset if it doesn't exceed the target*/
        boolean taken = false;
        if (arr[ind] <= target)
            taken = func(ind - 1, target - arr[ind], arr, dp);
        
        /* Store the result in the DP table and 
        return whether either option was successful*/
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }
    
    /* Function to check if there is a subset
    of 'arr' with sum equal to 'target'*/
    public boolean isSubsetSum(int[] arr, int target) {
        // Declare a DP table with dimensions [n][k+1]
        int dp[][] = new int[arr.length][target + 1];
        
        // Initialize DP table with -1 
        for (int row[] : dp)
            Arrays.fill(row, -1);
            
        // Return the result
        return func(arr.length - 1, target, arr, dp);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 4;
        
        // Create an instance of isSubsetSummemo class
        isSubsetSummemo sol = new isSubsetSummemo();
        
        // Call the isSubsetSum function and print the result
        if (sol.isSubsetSum(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
