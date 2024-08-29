package ARRAY;

import java.util.*;

class maxProduct {
    // Function to find maximum product subarray
    public int maxProduct(int[] nums) {
        /* Initialize variables to track current max
        product, min product, and overall result*/
        int prod1 = nums[0], prod2 = nums[0], result = nums[0];
        
        /* Iterate through the array 
        starting from the second element*/
        for (int i = 1; i < nums.length; i++) {
            
            /* Calculate the maximum product
            ending at the current index*/
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            
            /* Calculate the minimum product
            ending at the current index*/
            prod2 = Math.min(nums[i], Math.min(prod1 * nums[i], prod2 * nums[i]));
            
            // Update the maximum product found so far
            prod1 = temp;
            
            /* Update the overall result with 
            the maximum product found so far*/
            result = Math.max(result, prod1);
        }
        
        // Return the maximum product subarray found
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 7, 1, 2};
        
        // Create an instance of the maxProduct class
        maxProduct sol = new maxProduct();
        
        int maxProd = sol.maxProduct(nums);
        
        // Print the result
        System.out.println("The maximum product subarray: " + maxProd);
    }
}
