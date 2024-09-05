package STRING;


/*
    Time Complexity: O(N^2)
    Space Complexity: O(N^2)

    where 'N' is the length of the String.
*/

import java.util.ArrayList;

public class countPalindromicSubseq 
{
    public static int countPalindromicSubseq(String s) 
    {
        int n = s.length();

        int mod = 1000000000 + 7
        ;
        //    Dynamic programming matrix to store the number of palindromic subsequences.
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) 
        {

            dp.add(new ArrayList<Integer>(n));
            for (int j = 0; j < n; j++) 
            {
                dp.get(i).add(0);
            }
        }

        //    Start traversing the given String.
        for (int i = n - 1; i >= 0; i--) 
        {
            for (int j = i; j < n; j++) 
            {
                //    Length of the current subString.
                int len = j - i + 1;

                if (len == 1) 
                {
                    //    Every single character in the String is a palindrome itself.
                    dp.get(i).set(j, 1);
                } 
                else if (len == 2) 
                {
                    if (s.charAt(i) == s.charAt(j)) 
                    {
                        //    Each subsequence of current subtring will be palindrome.
                        dp.get(i).set(j, 3);
                    } 
                    else 
                    {
                        //    Two palindromes of single character.
                        dp.get(i).set(j, 2);
                    }
                } 
                else 
                {
                    if (s.charAt(i) == s.charAt(j)) 
                    {
                        dp.get(i).set(j, (1 + dp.get(i + 1).get(j) + dp.get(i).get(j - 1)) % mod);
                    } 
                    else 
                    {
                        dp.get(i).set(j, ((dp.get(i + 1).get(j) + dp.get(i).get(j - 1)) % mod - dp.get(i + 1).get(j - 1) + mod) % mod);
                    }
                }
            }
        }

        return dp.get(0).get(n - 1);
    }
}