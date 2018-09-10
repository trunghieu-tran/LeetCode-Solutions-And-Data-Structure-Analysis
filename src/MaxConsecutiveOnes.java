/**
 * @author Harry Tran on 7/2/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int len = nums.length;

		if (len == 0) return 0;

		int last0 = -1;
		int res = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				res = Math.max(i - 1 - last0, res);
				last0 = i;
			}
		}
		if (nums[len - 1] == 1) {
			res = Math.max(res, len - 1 - last0);
		}
		return res;
	}
}
