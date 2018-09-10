/**
 * @author Harry Tran on 7/17/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ClimbStairs {
	public int climbStairs(int n) {
		int[] f = new int[n + 2];
		f[1] = 1;
		f[2] = 2;
		for (int i = 3; i <= n; ++i)
			f[i] = f[i - 1] + f[i - 2];
		return f[n];
	}
}
