/**
 * @author Harry Tran on 6/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FlippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
		int lengthA = A.length;
		for (int i = 0; i < lengthA; ++i) {
			int left = 0;
			int right = A[i].length - 1;
			int tmp;
			while (left < right) {
				tmp = A[i][left];
				A[i][left] = 1 - A[i][right];
				A[i][right] = 1 - tmp;
				left++;
				right--;
			}
			if (left == right) A[i][left] = 1 - A[i][left];
		}
		return A;
	}
}
