package STRING;

/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    Where N denotes the length of both strings P and Q.
*/

public class isSubstring
{
    // Function that checks whether string a is present in string b as substring using KMP algorithm.
    public static int isSubstring(String a, String b)
    {
        // Finding the length of both strings.
        int m = a.length();
        int n = b.length();

        // Defining and initializing the pointer variables to preprocess the string 'a'.
        int i = 1, j = 0;

        // Defining the lps array.
        int[] lps = new int[m];

        while (i < m)
        {

            // If the ith index of string a matches with its jth index , then store the value 'j+1' at lps[i] and increment both 'i' and 'j'.
            if (a.charAt(i) == a.charAt(j))
            {
                lps[i] = j + 1;

                i++;

                j++;
            }

            // If the ith index of a does not match with its jth index of 'a' and 'j' > 0, then 'j' redirects to lps[j-1].
            else if (j > 0)
            {
                j = lps[j - 1];
            }

            // If none of the above condition matches then make lps[i] as 0 and increment i.
            else
            {
                lps[i] = 0;
                i++;
            }
        }

        i = 0;
        j = 0;

        //Iterating through both the strings to find a match.
        while (i < n && j < m)
        {
            // If the ith character of 'b' matches with the jth character of 'a', then increment both 'i' and 'j'.
            if (b.charAt(i) == a.charAt(j))
            {
                i++;
                j++;
            }

            // If the above characters do not match and 'j' > 0, then 'j' redirects to lps[j-1].
            else if (j > 0)
            {
                j = lps[j - 1];
            }

            // If none of the above mentioned condition matches, then increment 'i'.
            else
            {
                i++;
            }
        }

        // If 'j' is equal to 'm', then we will return 1 otherwise we will return 0.
        if (j == m)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static int isCyclicRotation(String p, String q)
    {
        // Performing the concatenation of string 'p' with itself.
        String res = p + p;

        // Checking if the substring 'q' is present in the string 'res'.
        return isSubstring(q, res);
    }
}