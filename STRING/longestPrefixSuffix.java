package STRING;

/*
    Time Complexity: O(n)
    Space Complexity: O(n)

    Where n is the length of the string.
*/
import java.util.Arrays;
public class longestPrefixSuffix {
    public static String longestPrefixSuffix(String str) {
        // Empty lps array.
        int[] lps = new int[str.length()];

        int leftPointer = 0;
        int i = 1;

        // While the right pointer is less than the length of the string.
        while (i < str.length()) {
            // If current character is equal to the right pointer.
            if (str.charAt(i) == str.charAt(leftPointer)) {
                leftPointer += 1;
                lps[i] = leftPointer;
                i += 1;
            }
            // If it is not equal, move the left pointer to start of the current prefix and check again.
            else if (leftPointer != 0) {
                leftPointer = lps[leftPointer - 1];
            }
            // If left pointer is at the start, lps[i] is 0.
            else {
                lps[i] = 0;
                i += 1;
            }
        }

        String ans = str.substring(0, lps[str.length() - 1]);
        return ans;
    }
}