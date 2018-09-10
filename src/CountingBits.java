/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class CountingBits {
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		for (int i = 0; i <= num; ++i)
			res[i] = Integer.bitCount(i);
		return res;
	}
}
