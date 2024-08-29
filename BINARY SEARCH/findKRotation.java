import java.util.*;

class findKRotation {
    /* Function to find the number of
       rotations in a rotated sorted array */
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            /* Search space is already sorted
               then nums.get(low) will always be
               the minimum in that search space */
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                }
                break;
            }
            
            // If left part is sorted update the ans
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                }
                // Eliminate left half
                low = mid + 1;
            } else {
                /* update the ans if it 
                   is less than nums.get(mid) */
                if (nums.get(mid) < ans) {
                    index = mid;
                    ans = nums.get(mid);
                }
                // Eliminate right half
                high = mid - 1;
            }
        }
        // Return the index as answer
        return index;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
        
        // Create an object of the findKRotation class
        findKRotation sol = new findKRotation();
        
        int ans = sol.findKRotation(nums);
        
        // Print the result
        System.out.println("The array is rotated " + ans + " times.");
    }
}
