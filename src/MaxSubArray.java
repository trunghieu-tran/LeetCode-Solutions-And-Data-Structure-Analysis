/**
 * @author Harry Tran on 7/18/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		int res = nums[0];
		int sum = nums[0];
		int sumMin = nums[0];
		for (int i = 1; i < n; ++i) {
			sum += nums[i];
			if (res < nums[i])
				res = nums[i];
			if (res < sum - sumMin)
				res = sum - sumMin;
			if (res < sum)
				res = sum;
//			res = Math.max(nums[i], res);
//			res = Math.max(sum - sumMin, res);
//			res = Math.max(sum, res);
			sumMin = Math.min(sumMin, sum);
		}
		return res;
	}
}
