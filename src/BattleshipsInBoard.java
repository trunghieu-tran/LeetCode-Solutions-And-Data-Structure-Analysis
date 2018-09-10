/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BattleshipsInBoard {
	public int countBattleships(char[][] board) {
		int height = board.length;
		int width = board[0].length;

		int res = 0;
		for (int i = 0; i < height; ++i)
			for (int j = 0; j < width; ++j)
				if (board[i][j] == 'X') {
					boolean ok1 = i == 0 || board[i - 1][j] != 'X';
					boolean ok2 = j == 0 || board[i][j - 1] != 'X';
					if (ok1 && ok2) ++res;
				}
		return res;
	}
}
