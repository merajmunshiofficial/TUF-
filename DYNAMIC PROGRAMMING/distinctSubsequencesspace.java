import java.util.Arrays;

class distinctSubsequencesspace {
    private static final int prime = 1000000007;

    /* Function to count the number of
    distinct subsequences of s in t*/
    public int distinctSubsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        /* Declare an array to store the count of 
        distinct subsequences for each character in t*/
        int[] prev = new int[m + 1];

        // Initialize the count for an empty string 
        prev[0] = 1;

        // Iterate through s and t to calculate counts
        for (int i = 1; i <= n; i++) {
            /* Iterate in reverse direction to
            avoid overwriting values prematurely*/
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    /* If the characters match, consider two options:
                    either leave one character in s and t or leave 
                    one character in s and continue matching t*/
                    prev[j] = (prev[j - 1] + prev[j]) % prime;
                }
                /* No need for an else statement since we
                can simply leave the previous count as is*/
            }
        }

        /* The value at prev[m] contains
        the count of distinct subsequences*/
        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        // Create an instance of distinctSubsequencesspace class
        distinctSubsequencesspace sol = new distinctSubsequencesspace();

        // Print the result
        System.out.println("The Count of Distinct Subsequences is " + sol.distinctSubsequences(s1, s2));
    }
}
