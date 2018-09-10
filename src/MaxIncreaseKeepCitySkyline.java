/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MaxIncreaseKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int size = grid.length;
		int[] topBottom = new int[size];
		int[] leftRight = new int[size];

		for (int i = 0; i < size; ++i)
			for (int j = 0; j < size; ++j) {
				topBottom[j] = Math.max(topBottom[j], grid[i][j]);
				leftRight[i] = Math.max(leftRight[i], grid[i][j]);
			}
		int res = 0;
		for (int i = 0; i < size; ++i)
			for (int j = 0; j < size; ++j)
				res += Math.min(topBottom[j], leftRight[i]) - grid[i][j];
		return res;
	}
}
