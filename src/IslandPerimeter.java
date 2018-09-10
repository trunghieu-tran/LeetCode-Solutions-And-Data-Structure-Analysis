/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		int[] h = {-1, 0, 0, 1};
		int[] c = {0, -1, 1, 0};

		int res = 0;
		int height = grid.length;
		int width = grid[0].length;

		for (int i = 0; i < height; ++i)
			for (int j = 0; j < width; ++j)
				if (grid[i][j] == 1) {
					for (int k = 0; k < 4; ++k) {
						int newi = i + h[k];
						int newj = j + c[k];
						if (newi < 0 || newi >= height || newj < 0 || newj >= width) ++res;
						else res += 1 - grid[newi][newj];
					}
				}
		return res;
	}
}
