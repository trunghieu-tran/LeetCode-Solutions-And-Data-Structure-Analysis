import java.util.HashSet;

/**
 * @author Harry Tran on 6/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		int res = 0;
		int lengthJ = J.length();
		int marked[] = new int[128];

		for (int i = 0; i < lengthJ; ++i) {
			marked[J.charAt(i)] = 1;
		}

		int lengthS = S.length();
		for (int i = 0; i < lengthS; ++i) {
			if (marked[S.charAt(i)]==1) ++res;
		}
		return res;
	}
}
