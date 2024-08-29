package ARRAY;

import java.util.*;

class moveZeroes {
    public int[] moveZeroes(int[] nums) {
    // Initialize j to -1
        int j = -1;
       // length of nums
        int n = nums.length; 
        
        // place the pointer j:
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // no non-zero elements:
        if (j == -1) return nums;

        /*Move the pointers i and 
        j and swap accordingly*/
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        
        // Create instance of moveZeroes class
        moveZeroes moveZeroes = new moveZeroes();
        
        int[] ans = moveZeroes.moveZeroes(arr);
        
        // Print the elements
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
    
}

