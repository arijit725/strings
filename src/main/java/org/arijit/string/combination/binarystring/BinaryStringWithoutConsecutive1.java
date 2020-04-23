package org.arijit.string.combination.binarystring;

public class BinaryStringWithoutConsecutive1 {

	private static void generate(int len, char data[], int index) {
		if(index==len) {
			System.out.println(data);
			return;
		}
		data[index]='0';
		generate(len, data, index+1);		
		if(index==0) {
			data[index]='1';
			generate(len, data, index+1);
		}
		else if(index>0 && data[index-1]!='1') {
			// we have made sure no consecutive 1 present.
			data[index]='1';
			generate(len, data, index+1);
		}
				
	}
	
	public static void main(String args[]) {
		int len = 3;
		char data[] = new char[len];
		generate(len, data, 0);
	}
}
