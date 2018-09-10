/**
 * @author Harry Tran on 7/2/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MaxAreaOfIsland {
	private static int height = 0;
	private static int width = 0;
	private static boolean[][] marked;
	private static int[] h = {-1, 0, 0, 1};
	private static int[] c = {0, -1, 1, 0};

	private boolean isOk(int i, int j) {
		return (0 <= i && i < height && 0 <= j && j < width && !marked[i][j]);
	}

	private int BFS(int i, int j, int[][] grid) {
		int cnt = 1;
		for (int k = 0; k < 4; ++k) {
			int ii = h[k] + i;
			int jj = c[k] + j;
			if (!isOk(ii, jj)) continue;
			marked[ii][jj] = true;
			if (grid[ii][jj] == 1) {
				cnt += BFS(ii, jj, grid);
			}
		}
		return cnt;
	}

	public int maxAreaOfIsland(int[][] grid) {
		height = grid.length;
		width = grid[0].length;
		marked = new boolean[height][width];

		int res = 0;
		for (int i = 0; i < height; ++i)
			for (int j = 0; j < width; ++j)
				if (grid[i][j] == 1 && !marked[i][j]) res = Math.max(res, BFS(i, j, grid));
		return res;
	}
}
