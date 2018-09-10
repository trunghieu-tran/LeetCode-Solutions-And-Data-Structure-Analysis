/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
		int x = n ^ (n / 2);
		System.out.println(x);
		int res = x & (n + 1);
		System.out.println(res);
		System.out.println(7 & 8);
		if (res == 0) return true;
		else return false;
	}
}
