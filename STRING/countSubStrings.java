package STRING;

/*
        Time Complexity: O(N)
        Space complexity: O(1)

        Where N denotes the length of the given string.
*/

public class countSubStrings {
	public static int helper(String str, int k) {

		int i = 0, j = 0, currCount = 0;
		int result = 0;

		// Array to store count of characters.
		int[] count = new int[26];

		while (j < str.length()) {
			// Index for current character.
			int index = str.charAt(j) - 'a';

			// Increment count for the current character.
			count[index]++;

			if (count[index] == 1) {
				currCount++;
			}

			// Decrement count and increase ith pointer.
			while (currCount > k) {
				count[str.charAt(i) - 'a']--;
				if (count[str.charAt(i) - 'a'] == 0) {
					currCount--;
				}

				i++;
			}

			// Total substrings.
			result += (j - i + 1);
			j++;
		}
		return result;
	}

	public static int countSubStrings(String str, int k) {

		// Calculating for at most k and at most k-1 distinct chars.
		int ans = helper(str, k) - helper(str, k - 1);
		return ans;
	}

}
