/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ReshapMatrix {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int height = nums.length;
		int width = nums[0].length;
		if (width * height != r * c) return nums;
		int[][] res = new int[r][c];
		int ii = 0;
		int jj = 0;
		for (int i = 0; i < height; ++i)
			for (int j = 0; j < width; ++j) {
				res[ii][jj] = nums[i][j];

				if (jj == c - 1) {
					jj = 0;
					ii++;
				} else jj++;
			}
		return res;
	}
}
