package STRING;



/*

    Time complexity: O(N)
    Space complexity: O(C)

    where 'N' is the length of the string.
    where 'C' is the number of different characters.

*/

public class areIsomorphic
{
    public static boolean areIsomorphic(String str1, String str2)
    {
        int n = str1.length();
        int m = str2.length();

        // Length of both strings must be same for one to one corresponance
        if (m != n)
        {
            return false;
        }

        final int MAX_CHARS = 26;

        // To mark visited characters in str2
        boolean[] marked = new boolean[MAX_CHARS];

        // To store mapping of every character from str1 to that of str2. Initialize all entries of map as -1.
        int[] hash = new int[MAX_CHARS];

        for (int i = 0; i < MAX_CHARS; i++)
        {
            hash[i] = -1;
        }

        // Process all characters one by on
        for (int i = 0; i < n; i++)
        {
            // If current character of str1 is seen first time in it.
            if (hash[str1.charAt(i) - 'a'] == -1)
            {
                // If current character of str2 is already seen, one to one mapping not possible
                if (marked[str2.charAt(i) - 'a'] == true)
                {
                    return false;
                }

                // Mark current character of str2 as visited
                marked[str2.charAt(i) - 'a'] = true;

                // Store mapping of current characters
                hash[str1.charAt(i) - 'a'] = str2.charAt(i);
            }

            // Check if previous appearance mapped to same character of str2
            else if (hash[str1.charAt(i) - 'a'] != str2.charAt(i))
            {
                return false;
            }
        }

        return true;
    }

}