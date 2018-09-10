/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Search2DMatrix {

	private boolean bi_searchRow(int i, int j1, int j2, int[][] maxtrix, int target) {
//		if (maxtrix[i][j1] > target || maxtrix[i][j2] < target) return false;
		while (j1 <= j2) {
			int mid = (j1 + j2) / 2;
			if (maxtrix[i][mid] > target) j2 = mid - 1;
			else
				if (maxtrix[i][mid] < target) j1 = mid + 1;
				else return true;
		}
		return false;
	}

	private boolean bi_searchCol(int j, int i1, int i2, int[][] maxtrix, int target) {
//		if (maxtrix[i1][j] > target || maxtrix[i2][j] < target) return false;
		while (i1 <= i2) {
			int mid = (i1 + i2) / 2;
			if (maxtrix[mid][j] > target) i2 = mid - 1;
			else
				if (maxtrix[mid][j] < target) i1 = mid + 1;
				else return true;


		}
		return false;
	}


	private boolean search(int i, int j, int[][] matrix, int target) {
		if (i == 0) return bi_searchRow(0, 0, j, matrix, target);
		if (j == 0) return bi_searchCol(0, 0, i, matrix, target);

		boolean res = bi_searchRow(i, 0, j, matrix, target);
		res |= bi_searchCol(j, 0, i, matrix, target);
		if (!res && matrix[i - 1][j - 1] >= target)
			res |= search(i - 1, j - 1, matrix, target);

		return res;
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		return search(matrix.length - 1, matrix[0].length - 1, matrix, target);
	}
}
