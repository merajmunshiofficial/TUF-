package STRING;

/*
    Time Complexity: O( n + m )
    Space Complexity: O( k )
    Where n, m and k is the length of string 's', 'pattern'
    and concatenated string 'nStr' respectively.
*/

import java.util.ArrayList;
import java.util.List;
public class search {
    public static List< Integer > search(String s, String pattern){
        // 'n' and 'm' are the sizes of 's' and 'pattern' respectively
        int n = s.length();
        int m = pattern.length();

        // Declaring an empty array
        int l = 0, r = 0;
        String nStr = pattern + "#" + s;
        int k = nStr.length();

        // Making an array(z array) of length K
        List<Integer> ans = new ArrayList<>();

        // Making an array(z array) of length K
        int[] zarr = new int[k];
        zarr[0] = 0;
        for (int i = 1; i < k; i++) {
            if (i > r) {

                // Resetting L and R
                l = i;
                r = i;

                // Calulting z[i]
                while (r < k && nStr.charAt(r - l) == nStr.charAt(r)) {
                    r++;
                }

                zarr[i] = (r--) - l;

                // Checking if this zarr[i] is equal to the length of p or not.
                if (zarr[i] == m) {
                    ans.add(i + 1 - m - 1);
                }

            } else {
                int pos = i - l;

                if (zarr[pos] < r - i + 1) {
                    zarr[i] = zarr[pos];

                    // Checking if this zarr[i] is equal to the length of p or not.
                    if (zarr[i] == m) {
                        ans.add(i + 1 - m - 1);
                    }

                } else {
                    l = i;

                    // Calulting z[i]
                    while (r < k && nStr.charAt(r - l) == nStr.charAt(r)) {
                        r++;
                    }

                    zarr[i] = (r--) - l;

                    // Checking if this zarr[i] is equal to the length of p or not.
                    if (zarr[i] == m) {
                        ans.add(i + 1 - m - 1);
                    }
                }
            }
        }

        return ans;
    }
}