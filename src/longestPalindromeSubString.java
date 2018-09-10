/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class longestPalindromeSubString {
	public static String longestPalindrome(String s) {
		int lengS = s.length();

		if (lengS <= 1) return s;
		if (lengS == 2) {
			if (s.charAt(0) == s.charAt(1)) return s;
			else return String.valueOf(s.charAt(0));
		}

		boolean[][] f = new boolean[lengS][lengS];

		for (int i = 0; i < lengS; ++i) f[i][i] = true;
		for (int i = 0; i < lengS - 1; ++i)
			if (s.charAt(i) == s.charAt(i + 1))
				f[i][i + 1] = true;

		for (int len = 3; len <= lengS; ++len) {
			for (int i = 0; i < lengS - len + 1; ++i) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j))
					f[i][j] = f[i + 1][j - 1];
			}
		}

		for (int len = lengS; len >= 1; len--)
			for (int i = 0; i < lengS - len + 1; i++) {
				int j = i + len - 1;
				if (f[i][j]) {
					return s.substring(i, j + 1);
				}
			}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("ccc"));
	}
}
