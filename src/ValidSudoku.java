/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ValidSudoku {


	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];

		for (int i = 0; i < 9; ++i)
			for (int j = 0; j < 9; ++j)
				if (board[i][j] != '.') {
					int num = Character.digit(board[i][j], 10);
					if (row[i][num]) return false;
					if (col[j][num]) return false;
					row[i][num] = true;
					col[j][num] = true;

					int boxNum = (i / 3) * 3 + (j / 3);
					if (box[boxNum][num]) return false;
					box[boxNum][num] = true;
				}
		return true;
	}
}
