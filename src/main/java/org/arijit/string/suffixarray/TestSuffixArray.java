package org.arijit.string.suffixarray;

public class TestSuffixArray {
	
	public static void main(String args[]) {
		String str = "banana";
		SuffixArray suffixArray = new SuffixArray(str);
		suffixArray.create();
	}

}
