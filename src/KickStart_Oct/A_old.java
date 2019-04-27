package KickStart_Oct;

import java.io.*;

/**
 * @author Harry Tran on 10/20/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class A_old {

	public static String input = "/Study/Leetcode/src/KickStart_Oct/A-large-practice.in";
	public static String output = "/Study/Leetcode/src/KickStart_Oct/A-large.out";

	private static int process(String A, String B, int L) {
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();

		int res = 0;
		for (int i = 0; i < L; ++i)
			for (int j = i; j < L; ++j) {
				int le = j - i + 1;

				int[] count = new int[26];
				for (int k = i; k <= j; ++k) count[a[k] - 'A']++;

				boolean ok = false;
				for (int i2 = 0; i2 < L - le + 1; ++i2) {
					int[] count2 = new int[26];

					for (int j2 = i2; j2 <= i2 + le - 1; ++j2)
						count2[b[j2] - 'A']++;

					boolean found = true;
					for (int j2 = 0; j2 < 26; ++j2)
						if (count2[j2] != count[j2]) {
							found = false;
							break;
						}

					if (found) {
						ok = true;
						break;
					}
				}
				if (ok) ++res;
			}
		return res;
	}

	private static String template(int i, int res) {
		return "Case #" + Integer.toString(i) + ": " + Integer.toString(res) + "\n";
	}

	public static void loadTest() {
		String data = FileIO.readStringFromFile(input);
		String[] lines = data.split("\\n");
		int nTest = Integer.parseInt(lines[0]);
		int i = 0;
		int cc = 0;
		StringBuilder result = new StringBuilder();
		while (--nTest >= 0) {
			// Do something with test
			int L = Integer.parseInt(lines[++i]);
			String A = lines[++i];
			String B = lines[++i];
			int res = process(A, B, L);
			result.append(template(++cc, res));
		}
		FileIO.writeStringToFile(output, result.toString());
	}



	public static void main(String[] args) {
		A_old.loadTest();
	}
}
