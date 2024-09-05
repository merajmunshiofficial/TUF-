package STRING;

/*
    Time Complexity: O(n+m)

    Space Complexity: O(n)

    Where 'n' is the length of 'text' and 'm' is the length of 'pat'.

*/
import java.util.ArrayList;
import java.util.List;
public class firstOccurence {
    public static int firstOccurence(String text, String pat){
        final long p = 31;
        final long mod = 1_000_000_009;
        int n = text.length();
        int m = pat.length();

        // If 'pat' has a length greater than length of 'text',
        // it won't occur in 'text'.
        if (m > n) {
            return -1;
        }

        // Precalculating powers of 'p'.
        List<Long> pw = new ArrayList<>();
        pw.add(1L);
        for (int i = 1; i < n; i++) {
            pw.add((pw.get(i - 1) * p) % mod);
        }

        // Calculating hashes of all prefixes of 'text'.
        List<Long> pre = new ArrayList<>();
        pre.add(0L);
        for (int i = 0; i < n; i++) {
            pre.add((pre.get(i) + pw.get(i) * (text.charAt(i) - 'a' + 1)) % mod);
        }

        // Calculating hash of 'pat'.
        long hash_pat = 0;
        for (int i = 0; i < m; i++) {
            hash_pat = (hash_pat + (pw.get(i) * (pat.charAt(i) - 'a' + 1)) % mod) % mod;
        }

        // Check all substrings of size 'm' of 'text' for hash value equal to 'hash_pat'.
        for (int i = 0; i <= n - m; i++) {
            long cur_hash = (pre.get(i + m) + mod - pre.get(i)) % mod;
            if (cur_hash == (hash_pat * pw.get(i)) % mod) {
                return i;
            }
        }

        return -1;
    }
}