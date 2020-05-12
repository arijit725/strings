package org.arijit.string.combination.substring;

public class MinimumLengthKDistinct {

	public static void main(String args[]) {
		String str = "ababcb";
		int k = 3;
		System.out.println(searchString(str, k));	
	}
	
	public static String searchString(String str, int k){
		char[] arr = str.toCharArray();
		int ref[] = new int[256];
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		int minStart = 0;
		int minEnd = 0;
		int count = 0;
		while(end<arr.length){
			char ch = arr[end];
			if(ref[ch]==0)
				count++;
			ref[ch]++;
			if(count==k){
				//time to shrink
				while(ref[arr[start]]>1){
					ref[arr[start]]--;
					start++;							
				}
				int len = end-start+1;
				if(len<=minLen){
					minLen = len;
					minStart = start;
					minEnd = end;
				}
			}
			end++;
		}
		if(count<k)
			return null;
		return str.substring(minStart, minEnd+1);
	}
}
