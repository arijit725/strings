package org.arijit.string.suffixarray;

public class PatternSearchWIthSuffixArray {

	public static void main(String args[]) {
		String str = "banana";
		String pattern = "nan";
		search(str, pattern);
	}
	
	
	private static int compare(String str, String pattern) {
	     return str.startsWith(pattern) ? 0 : str.compareTo(pattern);
	}
	
	public static void search(String str, String pattern) {
		SuffixArray suffix = new SuffixArray(str);
		int suffixArray[] = suffix.create();
		int low = 0;
		int high = suffixArray.length-1;
		while(low<high) {
			int mid = low+(high-low)/2;
			String tmp = str.substring(mid);
			System.out.println("Comparing: "+tmp+" :: "+pattern);
			int cmp =compare(tmp,pattern);
			if(cmp==0) {
				System.out.println("Match Found at index: "+mid);
				return;
			}
			if(cmp<0)
				high = mid-1;
			else
				low = mid+1;
			
		}
		System.out.println("Pattern not found");
	}
}
