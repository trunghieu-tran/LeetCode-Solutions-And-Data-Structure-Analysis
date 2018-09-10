/**
 * @author Harry Tran on 6/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		x = x^y;
		return Integer.bitCount(x);
	}
}
