package ARRAY;

import java.util.*;

class singleNumber {
    public int singleNumber(int[] nums) {
        // XOR all the elements in nums:
        int xorr = 0;
        for (int num : nums) {
            xorr ^= num;
        }
        return xorr;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        
        // Create an instance of the singleNumber class
        singleNumber finder = new singleNumber();
        
        // Get the single element using the class method
        int ans = finder.singleNumber(nums);

        System.out.println("The single element is: " + ans);
    }
}
