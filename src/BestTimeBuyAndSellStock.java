/**
 * @author Harry Tran on 7/18/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BestTimeBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int n = prices.length;

		if (n  <= 1) return 0;
		int res = 0;
		for (int i = 1; i < n; ++i) {
			if (prices[i] > prices[i - 1])
				res += prices[i] - prices[i - 1];
		}

		return res;
	}
}
