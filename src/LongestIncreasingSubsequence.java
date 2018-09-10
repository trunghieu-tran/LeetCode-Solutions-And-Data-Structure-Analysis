import java.util.Arrays;

/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if (len == 0) return 0;

		int[] val = new int[len]; // val[i] - last value of the sub-sequence of length = i
		int size = 1;
		val[0] = nums[0];

		for (int i = 1; i < len; ++i) {
			int k = Arrays.binarySearch(val, 0, size, nums[i]);
			// if k < 0, we have index: -1, -2, -3 .... .
			// Thus, to recover the real index, k = -(k + 1)
			if (k < 0) {
				k = -(k + 1);
			}
			val[k] = nums[i];
			if (k == size) {
				++size;
			}
		}
		return size;
	}
}
