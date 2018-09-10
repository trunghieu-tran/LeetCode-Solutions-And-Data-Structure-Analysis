/**
 * @author Harry Tran on 6/29/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ShortestDistanceToCharacter {
	public int[] shortestToChar(String S, char C) {
		int lengthS = S.length();
		int[] res = new int[lengthS];
		int[] f_left = new int[lengthS];
		int[] f_right = new int[lengthS];

		f_left[0] = (S.charAt(0) == C) ? 0 : lengthS;
		for (int i = 1; i < lengthS; ++i) {
			if (S.charAt(i) == C) f_left[i] = 0;
			else
				f_left[i] = f_left[i - 1] + 1;
		}

		f_right[lengthS - 1] = (S.charAt(lengthS - 1) == C) ? 0 : lengthS;
		for (int i = lengthS - 2; i >= 0; --i) {
			if (S.charAt(i) == C) f_right[i] = 0;
			else
				f_right[i] = f_right[i + 1] + 1;
		}

		for (int i = 0; i < lengthS; ++i)
			res[i] = Math.min(f_left[i], f_right[i]);
		return res;
	}
}
