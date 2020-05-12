package org.arijit.string.combination.substring;

public class SmallestWIndowAllCharacters {
	public static void main(String args[]) {
		String str = "aabcbcddbca";
		System.out.println(smallestWindow(str));
	}

	private static String smallestWindow(String str) {
		if (str == null || str.length() == 0)
			return null;
		char[] arr = str.toCharArray();
		int start = 0;
		int end = 0;
		int count = 0;
		int unique = uniqueCharCount(str);
		int ref[] = new int[128];
		for (int i = 0; i < ref.length; i++)
			ref[i] = -1;
		int minWindowLen = Integer.MAX_VALUE;
		int minStart = 0;
		int minEnd = 0;

		while (end < arr.length) {

			char ch = arr[end];
			if (start == ref[ch] && count > 0) {
				start++; // we are shrinking from start if repetating character appears. count = 0 will
							// make sure we are checking only when we are changing window.
			} else if (ref[ch] == -1 || ref[ch] <= start) // first time in this window
			{
				count++;
				ref[ch] = end;

			}
			end++;
			if (count == unique) {
				

				int len = end - start + 1;
				if (minWindowLen > len) {
					len = minWindowLen;
					minStart = start;
					minEnd = end;
				}
				count = 0;
				end = end - 1;
				start = end;
			}

		}
		String str1 = str.substring(minStart, minEnd);
		return str1;
	}

	private static int uniqueCharCount(String str) {
		int ref[] = new int[128];
		int unique = 0;
		for (char ch : str.toCharArray()) {
			if (ref[ch] == 1)
				continue;
			ref[ch] = 1;
			unique++;
		}
		return unique;
	}

}
