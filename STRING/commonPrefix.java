
package STRING;

/*
   Time Complexity  : O(n*m)
   Space Complexity : O(m)

   where 'n' is the size of 'arr' and 'm' is the maximum length of 'arr[i]'.
*/

public class commonPrefix {
    public static String commonPrefix(String []arr,int n){
        String prefix = arr[0];

        // Iterating over all the strings and finding the common prefix.
        for (int i = 1; i < n; i++)
        {
            prefix = com_prefix(prefix, arr[i]);
        }

        // Base case of no common prefix.
        if (prefix == "")
        {
            return "-1";
        }

        return prefix;
    }

    // Function to find the common prefix of two strings.
    public static String com_prefix(String out1, String out2)
    {
        String out = "";
        int n1 = out1.length(), n2 = out2.length();
        for (int i = 0, j = 0; i < n1 && j < n2; i++, j++)
        {
            if (out1.charAt(i) != out2.charAt(j))
            {
                break;
            }
            out += out1.charAt(i);
        }
        return out;
    }
}