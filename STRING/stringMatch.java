package STRING;

/*
    Time complexity: O(n + m)
    Space complexity: O(m)

    Where 'n' and 'm' are the lengths of 'text' and 'pattern' respectively.
*/

import java.util.ArrayList;
import java.util.List;
public class stringMatch {
    public static List< Integer > stringMatch(String text, String pattern) {
        int n = text.length(), m = pattern.length();

        // List storing the indices of occurrences
        List< Integer > ans = new ArrayList<>();

        // Initializing LPS array
        int []lps = new int[m];
        lps[0] = 0;
        int i = 1, j = 0;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j > 0)
                j = lps[j - 1];
            else {
                lps[i] = 0;
                i++;
            }
        }

        i = 0;
        j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j > 0)
                j = lps[j - 1];
            else
                i++;

            // If the pattern matches
            if (j == m) {
                ans.add(i - m + 1);
                j = lps[j - 1];
            }
        }

        return ans;
    }
}