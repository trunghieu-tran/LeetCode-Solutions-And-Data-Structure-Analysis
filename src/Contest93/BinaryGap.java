package Contest93;

/**
 * @author Harry Tran on 7/14/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BinaryGap {
	public int binaryGap(int N) {
		if (N == 0) return 0;
		String b = Integer.toBinaryString(N);
		int max = 0;
		for (int i = 0; i < b.length() - 1; ++i)
			if (b.charAt(i) == '1') {
				int j = i + 1;
				while (j < b.length() && b.charAt(j) == '0') ++j;
				if (j < b.length())
					max = Math.max(j - i, max);
			}
		return max;
	}
}
