package org.arijit.string.suffixarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SuffixArray {

	private String str ;
	public SuffixArray(String str) {
		this.str = str;
	}
	
	public int[] create() {
		ArrayList<SUffix> list = new ArrayList<>();
		
		for(int i=0;i<str.length();i++) {
			String tmp = str.substring(i);
			SUffix suffix = new SUffix(tmp, i);
			list.add(suffix);
		}
		
		Collections.sort(list, (o1,o2)->{
			return o1.getStr().compareTo(o2.getStr());
					});
		
		int[] suffixArray = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			suffixArray[i]=list.get(i).getIndex();
		}
		
		System.out.println("Arrays: "+Arrays.toString(suffixArray));
		return suffixArray;
	}
	
	private static class SUffix{
		private String str;
		private int index;
		
		public SUffix(String str, int index) {
			this.str = str;
			this.index = index;
		}
		
		public int getIndex() {
			return index;
		}
		public String getStr() {
			return str;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public void setStr(String str) {
			this.str = str;
		}
	}
	
}
