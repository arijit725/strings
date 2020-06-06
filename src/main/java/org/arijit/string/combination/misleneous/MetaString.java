package org.arijit.string.combination.misleneous;

public class MetaString {

	public static void main(String args[]) {
		String str1 = "Converse";
		String str2 = "Conserve";
		System.out.println(checkMetaString(str1, str2));
	}

	public static boolean checkMetaString(String str1, String str2) {		
		int diff1 = -1;
		int diff2 = -1;
		if (str1 == null || str2 == null)
			return false;
		if (str1.length() != str2.length())
			return false;
		int i = 0;
		int mismatchCount = 0;
		while (i < str1.length()) {

			if (str1.charAt(i) != str2.charAt(i)) {
				diff2 = diff1;
				diff1 = i;
				mismatchCount++;
			}
			if(mismatchCount>2)
			{	//as we are only allowed to have 1 swap means there will be two mismatch
				return false;
			}
			i++;
		}
		if (str1.charAt(diff2) == str2.charAt(diff1) && str1.charAt(diff1) == str2.charAt(diff2))
			return true;
		return false;

	}

}
