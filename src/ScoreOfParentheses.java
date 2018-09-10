/**
 * @author Harry Tran on 7/3/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ScoreOfParentheses {
	public int scoreOfParentheses(String S) {
		int res = 0, numOfOpen = 0;
		int lenS = S.length();
		for (int i = 0; i < lenS; ++i) {
			if (S.charAt(i) == '(') {

				if (S.charAt(i + 1) == ')')
					res += 1 << numOfOpen;

				numOfOpen++;
			} else numOfOpen--;
		}
		return res;
	}
}
