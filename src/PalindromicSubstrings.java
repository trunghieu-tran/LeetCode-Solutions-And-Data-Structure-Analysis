/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int len = s.length();

		int[][] isPalndromic = new int[len][len];

		for (int i = 0; i < len; ++i) isPalndromic[i][i] = 1;

		for (int i = 0; i < len - 1; ++i)
			if (s.charAt(i) == s.charAt(i + 1)) isPalndromic[i][i + 1] = 1;

		for (int le = 3; le <= len; ++le)
			for (int i = 0; i < len - le + 1; ++i) {
				int j = i + le - 1;
				if (s.charAt(i) == s.charAt(j))
					isPalndromic[i][j] = isPalndromic[i + 1][j - 1];
			}

		int cnt = 0;
		for (int i = 0; i < len; ++i)
			for (int j = i; j < len; ++j)
				cnt += isPalndromic[i][j];
		return cnt;
	}
}
