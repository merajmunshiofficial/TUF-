package ARRAY;

import java.util.*;
class missingNumber {
    // Function to find missing number in array
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;

        // Calculate XOR of all array elements
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1); // XOR up to [1...N]
            xor2 = xor2 ^ nums[i]; // XOR of array elements
        }

        // XOR of xor1 and xor2 gives missing number
        return (xor1 ^ xor2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};

        // Create an instance of the missingNumber class
        missingNumber missingNumber = new missingNumber();

        /* Call the missingNumber method
        to find the missing number*/
        int ans = missingNumber.missingNumber(nums);

        System.out.println("The missing number is: " + ans);
    }
}
