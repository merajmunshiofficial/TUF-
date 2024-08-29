package ARRAY;

import java.util.*;

class rearrangeArray {
    //Function to rearrange elements by their sign
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        
        // Initialize a result vector of size n
        int[] ans = new int[n]; 
        
         /* Initialize indices for positive
         and negative elements*/
        int posIndex = 0, negIndex = 1;
        
        // Traverse through each element in nums
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                
                /* If current element is negative, place
                it at the next odd index in ans*/
                ans[negIndex] = nums[i];
                // Move to the next odd index
                negIndex += 2;
                
            } else {
                ans[posIndex] = nums[i];

                // Move to the next even index
                posIndex += 2;
                
            }
        }
        
        // Return the rearranged array
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5}; 
        
        // Create an instance of the rearrangeArray class
        rearrangeArray sol = new rearrangeArray();
        
        int[] ans = sol.rearrangeArray(A);  
        
        // Print the rearranged array
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
