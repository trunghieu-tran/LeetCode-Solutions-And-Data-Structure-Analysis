/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int len = prices.length;
		if (len <= 1) return 0;
		int[][] dp = new int[len][2];
		// dp[i][0] - best profit with buying 1 stock until i-th
		// dp[i][1] - best profit with selling all stock until i-th
//		dp[0][0] = dp[0][1] = 0;
		dp[1][0] = - Math.min(prices[0], prices[1]);
		dp[1][1] = Math.max(0, prices[1] - prices[0] + fee);

		for (int i = 2; i < len; ++i) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
			System.out.println(Integer.toString(dp[i][0]) +  " " + Integer.toString(dp[i][1]));
		}
		return Math.max(dp[len - 1][0], dp[len - 1][1]);
	}
}
