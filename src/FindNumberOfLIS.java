/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FindNumberOfLIS {
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;

		int[] f = new int[n]; // f[i] - longest sub-sequence ending at i
		int[] cnt = new int[n]; // cnt[i] - num of longest;

		f[0] = 1;
		cnt[0] = 1;

		int maxL = 1;
		int c = 1;
		for (int i = 1; i < n; ++i) {
			f[i] = 1;
			cnt[i] = 1;
			for (int j = 0; j < i; ++j)
				if (nums[j] < nums[i]) {
					if (f[j] + 1 > f[i]) {
						f[i] = f[j] + 1;
						cnt[i] = cnt[j];
					} else
					if (f[j] + 1 == f[i]) {
						cnt[i] += cnt[j];
					}
				}
			if (f[i] > maxL) {
				maxL = f[i];
				c = cnt[i];
			} else
				if (f[i] == maxL) {
					c += cnt[i];
				}
		}
		return c;
	}
}
