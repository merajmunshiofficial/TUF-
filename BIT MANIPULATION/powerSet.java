import java.util.List;
import java.util.ArrayList;
import java.util.*;

class powerSet {
    /* Function call to get the
    Power set of given array */
    public List<List<Integer>> powerSet(int[] nums) {
        
        // Variable to store size of array
        int n = nums.length;
        
        // To store the answer
        List<List<Integer>> ans = new ArrayList<>();
        
        /* Variable to store the 
        count of total susbsets */
        int count = (1 << n);
        
        // Traverse for every value
        for (int val = 0; val < count; val++) {
            
            // To store the current subset
            List<Integer> subset = new ArrayList<>();
            
            // Traverse on n bits
            for (int i = 0; i < n; i++) {
                if ((val & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            
            /* Add the current subset 
            to final answer */
            ans.add(subset);
        }
        
        // Return stored answer
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        
        /* Creating an instance of 
        powerSet class */
        powerSet sol = new powerSet(); 
        
        /* Function call to get the
        Power set of given array */
        List<List<Integer>> ans = sol.powerSet(nums);
        
        ans.sort(Comparator.comparingInt(List::size));
        
        // Output
        System.out.println("The power set for the given array is: ");
        
        for (List<Integer> subset : ans) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
