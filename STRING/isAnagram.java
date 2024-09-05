package STRING;

/*
    Time complexity: O(N)
    Space complexity: O(1)

    where N is the size of the strings.
*/

public class isAnagram {

    public static boolean isAnagram(String str1, String str2) {
        
        // Initializing arrays to count the frequency of characters.
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Counting the frequency of the characters of the first string.
        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i) - 'a']++;
        }

        // Counting the frequency of the characters of the second string.
        for (int i = 0; i < str2.length(); i++) {
            count2[str2.charAt(i) - 'a']++;
        }

        // Comparing both the arrays.
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

}