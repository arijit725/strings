package org.arijit.string.combination.substring;

public class LongestSubstringWithKUniqueCharacter {

	public static void main(String args[]) {
		String str = "abbc";
		System.out.println(searchString(str, 2));
	}
	
	public static String searchString(String str, int k){
		char[] arr = str.toCharArray();
		int[] ref = new int[256];
		for(int i=0;i<ref.length;i++)
			ref[i]=-1;
		int start =0;
		int end = 0;
		int maxLen = 0;
		int maxStart = 0;
		int maxEnd = 0;
		int count=0;
		while(end<arr.length){
			char ch = arr[end];
			//check if character is not present in current window
			if(start>ref[ch]){
				// new charecter, update window
				count++;	
		
			}
			if(count==k){
				//we got string with unique charecter. now decide max len or not
				int len = end-start+1;
				if(len>=maxLen){
					maxLen = len;
					maxStart = start;
					maxEnd = end;
				}			
	
			}
			else if(count>k){
					count--;
					start = ref[arr[start]]+1;
					end--;
			}
			ref[ch] = end; //update latest occurance of character
			end++;
		}
		return str.substring(maxStart, maxEnd+1);
	}
}
