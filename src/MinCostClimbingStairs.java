/**
 * @author Harry Tran on 7/17/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int len = cost.length;
		if (len == 2) return Math.min(cost[0], cost[1]);

		int[] f = new int[len];
		for (int i = 2; i < len; ++i)
			f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
		return Math.min(f[len - 1] + cost[len - 1], f[len - 2] + cost[len - 2]);
	}
}
