package Contest92;

/**
 * @author Harry Tran on 7/7/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class TransposeMatrix {
	public int[][] transpose(int[][] A) {
		int h = A.length;
		int w = A[0].length;
		int[][] res = new int[w][h];

		for (int i = 0; i < h; ++i)
			for (int j = 0; j < w; ++j)
				res[j][i] = A[i][j];
		return  res;
	}
}
