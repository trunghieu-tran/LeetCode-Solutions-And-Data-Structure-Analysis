import javafx.util.Pair;

import java.util.*;

/**
 * @author Harry Tran on 7/10/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class NQueens {
	List<List<String>> res = new ArrayList<>();
	int[] row;
	int[] col;
	int[] diag;
	int[] diag2;
	int N;

	private void recursive(int i, int lastX, char[][] curr) {
		if (i == N) {
			List<String> tmp = new ArrayList<>();
			for (char[] chrs : curr) {
				String str = String.valueOf(chrs);
				tmp.add(str);
			}
			res.add(tmp);
			return;
		}

		int x = lastX + 1;
		if (row[x] == 0)
			for (int y = 0; y < N; ++y)
				if (col[y] == 0) {
					int d = x + y;
					int d2 = x - y + (N - 1); //row - col + (N - 1)
					if (diag[d] == 0 && diag2[d2] == 0) {
						diag[d] = 1;
						diag2[d2] = 1;
						row[x] = 1;
						col[y] = 1;
						curr[x][y] = 'Q';

						recursive(i + 1, x, curr);

						diag[d] = 0;
						diag2[d2] = 0;
						row[x] = 0;
						col[y] = 0;
						curr[x][y] = '.';
					}
				}
	}

	public List<List<String>> solveNQueens(int n) {
		this.N = n;
		row = new int[N];
		col = new int[N];
		diag = new int[N * 2 + 1];
		diag2 = new int[N * 2 + 1];
		char[][] curr = new char[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				curr[i][j] = '.';
		recursive(0, -1, curr);
		return res;
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<List<String>> res = nq.solveNQueens(14);
		System.out.println(res.size());
	}
}
