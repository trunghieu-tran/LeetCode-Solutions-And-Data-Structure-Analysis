/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int height = matrix.length;
		int width = matrix[0].length;
		for (int i = 1; i < height; ++i)
			for (int j = 1; j < width; ++j) {
				if (matrix[i][j] != matrix[i -1][j -1]) return false;
			}
		return true;
	}
}
