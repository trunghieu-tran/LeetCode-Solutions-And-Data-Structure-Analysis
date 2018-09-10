/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MinimumDeleteSum {
	public int minimumDeleteSum(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] f = new int[n1][n2];
		int sum1 = (int) s1.charAt(0);
		int sum2 = (int) s2.charAt(0);

		f[0][0] = s1.charAt(0) == s2.charAt(0) ? (int) s1.charAt(0) : 0;
		for (int i = 1; i < n1; ++i) {
			f[i][0] = s1.charAt(i) == s2.charAt(0) ? (int) s1.charAt(i) : 0;
			f[i][0] = Math.max(f[i][0], f[i - 1][0]);
			sum1 += (int) s1.charAt(i);
		}
		for (int j = 1; j < n2; ++j) {
			f[0][j] = s1.charAt(0) == s2.charAt(j) ? (int) s2.charAt(j) : 0;
			f[0][j] = Math.max(f[0][j], f[0][j - 1]);
			sum2 += (int) s2.charAt(j);
		}

		for (int i = 1; i < n1; ++i)
			for (int j = 1; j < n2; ++j) {
				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				if (s1.charAt(i) == s2.charAt(j))
					f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + (int) s1.charAt(i));
			}

		return sum1 - 2 * f[n1 - 1][n2 - 1] + sum2;
	}
}
