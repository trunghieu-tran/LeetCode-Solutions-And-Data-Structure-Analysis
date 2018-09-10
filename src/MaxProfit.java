/**
 * @author Harry Tran on 7/18/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MaxProfit {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int len = prices.length;
		if (len <= 1) return maxProfit;

		int vmin = prices[0];
		for (int i = 1; i < len; ++i) {
			maxProfit = Math.max(maxProfit, prices[i] - vmin);
			vmin = Math.min(vmin, prices[i]);
		}
		return maxProfit;
	}
}
