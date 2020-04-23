package org.arijit.string.combination.binarystring;

/**
 * Generate all binary strings from given pattern
 * @author arijit
 *
 */
public class GenerateBinaryString {

	public static void main(String args[]) {
		String str= "1??0?101";
		generate(str.toCharArray(), 0);
	}
	public static void generate(char[] str, int index){
		if(index==(str.length-1)){
			System.out.println(new String(str));
			return;
		}
		if(str[index]=='?'){
			str[index]='0';
			generate(str, index+1);
			str[index]='1';
			generate(str, index+1);
			// we need to set back'?' at index. unless further combinations would not pick this index to set with 0 or 1.
			str[index]='?';
		}
	else{
		generate(str, index+1);
	}

	}

}
