package ARRAY;

import java.util.ArrayList;

class leaders {
    //Function to find the leaders in an array.
    public int[] leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (nums.length == 0) {
            return nums; // Return an empty array if nums is empty
        }
        
        // Last element of the array is always a leader
        int max = nums[nums.length - 1];
        ans.add(nums[nums.length - 1]);
        
        // Check elements from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        
        /* Convert ArrayList<Integer> to
         int[] in reverse order*/
        int[] result = new int[ans.size()];
        for (int i = ans.size() - 1; i >= 0; i--) {
            result[ans.size()- 1 - i] = ans.get(i);
        }
        
        // Return the result array
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};
        
        // Create an instance of the leaders class
        leaders finder = new leaders();
        
        // Get leaders using class method
        int[] ans = finder.leaders(nums);
      
        System.out.print("Leaders in the array are: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }


}

