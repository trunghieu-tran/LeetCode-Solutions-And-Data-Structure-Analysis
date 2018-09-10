/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A) {
		int len = A.length;
		int i = 0;
		int res = 0;

		while (i < len - 2) {
			int j = i + 1;
			int dis = A[j] - A[i];

			while (j < len && A[j] - A[j - 1] == dis) ++j;

			int tmp = j - i;
			if (tmp >= 3) {
				int n = tmp - 2;
				res += (n + 1) * n / 2;
			}
			i = j - 1;
		}
		return res;
	}
}
