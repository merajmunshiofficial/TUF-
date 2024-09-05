import java.util.*;

class isSubsetSumspace {
    /* Function to check if there is a subset
    of 'arr' with a sum equal to 'target'*/
    private boolean func(int n, int target, int[] arr) {
        /* Initialize an array 'prev' to store
        the previous row of the DP table*/
        boolean[] prev = new boolean[target + 1];
        
        /* Base case: If the target sum is 0, we 
        can always achieve it by taking no elements*/
        prev[0] = true;
        
        /* Base case: If the first element of 
        'arr' is less than or equal to 'target'*/
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }
        
        /* Iterate through the elements
        of 'arr' and update the DP table*/
        for (int ind = 1; ind < n; ind++) {
            /* Initialize a new array 'cur' to store
            the current state of the DP table*/
            boolean[] cur = new boolean[target + 1];
            
            /* Base case: If the target sum is 0, we 
            can achieve it by taking no elements*/
            cur[0] = true;
            
            for (int i = 1; i <= target; i++) {
                /* If we don't take the current element, the 
                result is the same as the previous row*/
                boolean notTaken = prev[i];
                
                /* If we take the current element, subtract its
                value from the target and check the previous row*/
                boolean taken = false;
                if (arr[ind] <= i) {
                    taken = prev[i - arr[ind]];
                }
                
                /* Store the result in the current DP
                table row for the current subproblem*/
                cur[i] = notTaken || taken;
            }
            
            /* Update 'prev' with the current 
            row 'cur' for the next iteration*/
            prev = cur;
        }
        
        // The final result is stored in prev[target]
        return prev[target];
    }
    
    /* Function to check if there is a subset 
    of 'arr' with sum equal to 'target'*/
    public boolean isSubsetSum(int[] arr, int target) {
        // Return the result
        return func(arr.length, target, arr);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 4;
        
        // Create an instance of isSubsetSumspace class
        isSubsetSumspace sol = new isSubsetSumspace();
        
        // Call the isSubsetSum function and print the result
        if (sol.isSubsetSum(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
