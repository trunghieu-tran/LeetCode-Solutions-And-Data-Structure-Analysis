import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class GenerateParentheses {
	List<String> res = new ArrayList<>();

	private void recursion(int i, int nOpening, int n, char[] curr) {
		if (i == n * 2) {
			if (nOpening == 0) res.add(new String(curr));
			return;
		}

		if (nOpening < n) {
			curr[i] = '(';
			recursion(i + 1, nOpening + 1, n, curr);
		}

		if (nOpening > 0) {
			curr[i] = ')';
			recursion(i + 1, nOpening - 1, n, curr);
		}
	}

	public List<String> generateParenthesis(int n) {
		char[] curr = new char[n * 2];
		recursion(0, 0, n, curr);
		return res;
	}
}
