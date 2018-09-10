package Contest94;

import java.util.Arrays;

/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LenLongestFibSubseq {
	public int lenLongestFibSubseq(int[] A) {
		int n = A.length;
		int[][] f = new int[n][n];

		for (int i = 0; i < n - 1; ++i)
			for (int j = i + 1; j < n; ++j)
				f[i][j] = 2;

		int res = 0;
		for (int j = 2; j < n; ++j)
			for (int i = 1; i < j; ++i) {
				int k = Arrays.binarySearch(A, 0, i, A[j] - A[i]);
				if (k < 0) continue;
				f[i][j] = Math.max(f[i][j], f[k][i] + 1);
				res = Math.max(res, f[i][j]);
			}

		return res;
	}
}
