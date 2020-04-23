package org.arijit.string.combination.binarystring;

public class GenerateString1 {

	private static void generate(char[] cArray, int n, char[] data, int index, int bCount, int cCount, int maxB,
			int maxC, int[] totalCount) {
		if (index == n) {
			System.out.println(data);
			totalCount[0] = ++totalCount[0];
			return;
		}
		for (int i = 0; i < cArray.length; i++) {
			if (cArray[i] == 'b' && bCount >= maxB) {
				continue;

			} else if (cArray[i] == 'c' && cCount >= maxC) {
				continue;

			}
			data[index] = cArray[i];
			if (cArray[i] == 'b') {
				// you should not do bCount ++ as it will change bCount. Now when after
				// recursion this stack will again get control it will have increased b value
				// even when no 'b' is encountered.
				generate(cArray, n, data, index + 1, bCount + 1, cCount, maxB, maxC, totalCount);
			} else if (cArray[i] == 'c') {
				generate(cArray, n, data, index + 1, bCount, cCount + 1, maxB, maxC, totalCount);
			} else {
				generate(cArray, n, data, index + 1, bCount, cCount, maxB, maxC, totalCount);
			}

		}
	}

	public static void main(String args[]) {
		char[] cArray = { 'a', 'b', 'c' };
		int n = 3;
		char[] data = new char[n];
		int[] totalCount = new int[1];
		generate(cArray, n, data, 0, 0, 0, 1, 2, totalCount);
		System.out.println("Total String count: " + totalCount[0]);
	}
}
