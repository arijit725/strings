package org.arijit.string.combination.substring;

public class LongestSubstringWithoutRepeate {

	public static void main(String args[]) {
		String str = "abcabcbb";
		int l = lengthOfLongestSubstring(str);
		System.out.println("Length: "+l);
	}

	public static int lengthOfLongestSubstring(String s) {
		char[] arr = s.toCharArray();
		int ref[] = new int[26];
		for (int i = 0; i < ref.length; i++) {
			ref[i] = -1;
		}
		int start = 0;
		int end = 0;
		int maxLen = 0;
		int maxStart = 0;
		int maxEnd = 0;
		int len = 0;
		while (end < arr.length) {
			if (ref[arr[end] - 'a'] == -1) {
				// this character is being encountered for first time;
				ref[arr[end] - 'a'] = end;
				
			} else if (ref[arr[end] - 'a'] < start)
			// if character reappear but out of the window we are checking
			{
				ref[arr[end] - 'a'] = end; // update latest index
				
			} else if (ref[arr[end] - 'a'] >= start && ref[arr[end] - 'a'] <= end) {
				// if the last appared index is in between the window we are checking, then we
				// need to move ahead our start position.
				start = ref[arr[end] - 'a'] + 1;
				ref[arr[end] - 'a'] = end; //also we need to update last apperance of index

			}

			len = end - start + 1;
			if (len >= maxLen) {
				maxLen = len;
				maxStart = start;
				maxEnd = end;
			}
			end++;

		}
		System.out.println(s.substring(maxStart, maxEnd + 1));
		return maxLen;
	}
}
