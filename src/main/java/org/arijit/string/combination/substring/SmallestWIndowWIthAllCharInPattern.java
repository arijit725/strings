package org.arijit.string.combination.substring;

/**
 * <pre>
 * Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently.

Examples:

Input: string = “this is a test string”, pattern = “tist”
Output: Minimum window is “t stri”
Explanation: “t stri” contains all the characters of pattern.
 * </pre>
 * 
 * @author arijit
 *
 */
public class SmallestWIndowWIthAllCharInPattern {

	public static void main(String args[]) {
//		String line = "thisisateststring";
//		String pattern = "tist";
		String line = "geeksforgeeks";
		String pattern = "ork";
		findSmallestWindow(line, pattern);
	}

	public static void findSmallestWindow(String line, String pattern) {
		char[] str = line.toCharArray();
		char[] pat = pattern.toCharArray();
		int[] has_char = new int[256];
		int[] ref = new int[256];
		for (int i = 0; i < pat.length; i++) {
			has_char[pat[i]] = has_char[pat[i]] + 1;
		}
		int start = 0;
		int end = 0;
		int count = 0;
		int minLen = Integer.MAX_VALUE;
		int minStart = 0;
		int minEnd = 0;
		while (end < str.length) {
			char ch = str[end];
			ref[ch]++;// increasing character count
			if (has_char[ch] != 0 && ref[ch] <= has_char[ch]) {
				// this character is present in pattern and count of character in str is still
				// less or equal to pattern
				count++;
			}
			if (count == pat.length) {
				// we have got all required char with counts, so try to shrink
				while (has_char[str[start]] == 0 || ref[str[start]] > has_char[str[start]]) {
					// either the character in the current window is not present in pattern or more
					// than required number in pattern
					if (ref[str[start]] > has_char[str[start]]) {
						// we need to reduce the count as we are shrinking
						ref[str[start]]--;
					}
					start++;
				}
				int len = end - start + 1;
				if (len < minLen) {
					minLen = len;
					minStart = start;
					minEnd = end;
				}
			}
			end++;
		}
		System.out.println("Smallest window so far: start: " + minStart + " end: " + minEnd + " stirng: "
				+ line.substring(minStart, minEnd + 1));

	}

}
