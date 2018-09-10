
/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SudokuSolver {
	boolean[][] row = new boolean[9][9];
	boolean[][] col = new boolean[9][9];
	boolean[][] box = new boolean[9][9];

	int[][] boardI = new int[9][9];

	boolean isResolved = false;


	private int getBoxNum(int i, int j) {
		return (i / 3) * 3 + (j / 3);
	}

	private void recursion_solving(int resolvedNum) {
		if (resolvedNum == 81) {
			System.out.println("Resolved");
			isResolved = true;
			return;
		}

		int posI = 0, posJ = 0, posB = 0;
		int best = 10;
		for (int i = 0; i < 9; ++i)
			if (best > 1)
				for (int j = 0; j < 9; ++j)
					if (boardI[i][j] == -1) {
						int boxNum = getBoxNum(i, j);
						int cnt = 0;

						for (int val = 0; val < 9; ++val)
							if (row[i][val] || col[j][val] || box[boxNum][val]) continue;
							else cnt++;

						if (cnt == 0) return;

						if (cnt < best) {
							best = cnt;
							posI = i;
							posJ = j;
							posB = boxNum;

							if (best == 1) break;
						}
					}


		for (int val = 0; val < 9; ++val) {
			if (row[posI][val] || col[posJ][val] || box[posB][val]) continue;

			boardI[posI][posJ] = val;
			row[posI][val] = true;
			col[posJ][val] = true;
			box[posB][val] = true;

			recursion_solving(resolvedNum + 1);
			if (isResolved) return;

			boardI[posI][posJ] = -1;
			row[posI][val] = false;
			col[posJ][val] = false;
			box[posB][val] = false;
		}
	}

	public void solveSudoku(char[][] board) {
		int resolvedNum = 0;

		for (int i = 0; i < 9; ++i)
			for (int j = 0; j < 9; ++j)
				if (board[i][j] != '.') {
					int num = Character.digit(board[i][j], 10) - 1;
					int boxNum = getBoxNum(i, j);
					boardI[i][j] = num;
					resolvedNum++;

					row[i][num] = true;
					col[j][num] = true;
					box[boxNum][num] = true;

				} else boardI[i][j] = -1;


		recursion_solving(resolvedNum);

		for (int i = 0; i < 9; ++i)
			for (int j = 0; j < 9; ++j)
				board[i][j] = Character.forDigit(boardI[i][j] + 1, 10);

	}

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						{'6','.','.','1','9','5','.','.','.'},
						{'.','9','8','.','.','.','.','6','.'},
						{'8','.','.','.','6','.','.','.','3'},
						{'4','.','.','8','.','3','.','.','1'},
						{'7','.','.','.','2','.','.','.','6'},
						{'.','6','.','.','.','.','2','8','.'},
						{'.','.','.','4','1','9','.','.','5'},
						{'.','.','.','.','8','.','.','7','9'}};

		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(board);
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j)
				System.out.print(board[i][j] +  " ");
			System.out.println();
		}
	}
}
