/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class HouseRobber {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0) return 0;
		if (len == 1) return nums[0];
		if (len == 2) return Math.max(nums[0], nums[1]);
		int[] f = new int[len];
		// f[i] - max value obtained when visiting the i-th house
		f[0] = nums[0];
		f[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < len; ++i)
			f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
		return f[len - 1];
	}
}
