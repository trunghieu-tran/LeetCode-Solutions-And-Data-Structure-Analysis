package Contest93;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Harry Tran on 7/14/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class AdvantageShuffle {
	public int[] advantageCount(int[] A, int[] B) {
		int len = A.length;
		Arrays.sort(A);

		int[] res = new int[len];
		boolean[] marked = new boolean[len];
		Arrays.fill(marked, false);
		Arrays.fill(res, -1);

		int ii = 0;
		for (int i = 0; i < len; ++i) {
			int l = 0;
			int r = len - 1;
			int best = -1;
			while (l <= r)  {
				int mid = (l + r) / 2;
				if (A[mid] > B[i]) {
					best = mid;
					r = mid -1;
				} else {
					l = mid + 1;
				}
			}
			if (best != -1) {
				while (best < len && marked[best]) best++;
				if (best < len) {
					marked[best] = true;
					res[i] = A[best];
				} else {
					while (ii < len && marked[ii]) ++ii;
					res[i] = A[ii];
					marked[ii] = true;
				}
			} else {
				while (ii < len && marked[ii]) ++ii;
				res[i] = A[ii];
				marked[ii] = true;
			}
		}
		return  res;
	}
}
