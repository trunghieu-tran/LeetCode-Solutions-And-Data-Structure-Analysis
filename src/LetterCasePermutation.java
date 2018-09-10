import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 7/2/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LetterCasePermutation {

	private void finding(int pos, String curr, String S, ArrayList<String> res) {
		if (pos == S.length()) {
			res.add(curr);
			return;
		}

		char chr = S.charAt(pos);

		if (Character.isDigit(chr)) finding(pos + 1, curr + chr, S, res);
		else {
			finding(pos + 1, curr + Character.toUpperCase(chr), S, res);
			finding(pos + 1, curr + Character.toLowerCase(chr), S, res);
		}
	}
	public List<String> letterCasePermutation(String S) {
		ArrayList<String> res = new ArrayList<>();
		finding(0, "", S, res);
		return res;
	}
}
