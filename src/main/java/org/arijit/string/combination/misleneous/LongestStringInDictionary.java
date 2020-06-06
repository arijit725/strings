package org.arijit.string.combination.misleneous;

public class LongestStringInDictionary {
	
	public static void main(String args[]) {
		String[] dict = {"pintu"};
		String word = "geeksforgeeks";
		findLongestString(dict, word);
	}

	public static void findLongestString(String[] dict, String word) {
		if (dict == null || dict.length == 0)
			return;
		int i = 0;
		char[] wStr = word.toCharArray();
		String maxWordSoFar = null;
		int maxLen = -1;
		while (i < dict.length) {
			char[] str = dict[i].toCharArray();
			int j = 0;
			int k = 0;		
			while (j < wStr.length && k < str.length) {
				if (wStr[j] == str[k]) {
					j++;
					k++;
				}
				else
					j++;
			}
			if (k == str.length && str.length > maxLen) { //if we have reached till end then only the word is valid
				maxLen = str.length;
				maxWordSoFar = dict[i];
			}
			i++;

		}
		System.out.println("MaxWordSoFar: " + maxWordSoFar);
	}
}
