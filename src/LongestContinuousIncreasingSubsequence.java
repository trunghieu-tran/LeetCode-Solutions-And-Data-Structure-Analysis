/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		int res = 1;
		int i = 0;
		while (i < n) {
			int j = i + 1;
			while (j < n && nums[j] > nums[j - 1]) ++j;
			res = Math.max(res, j - i);
			i = j;
		}
		return res;
	}
}
