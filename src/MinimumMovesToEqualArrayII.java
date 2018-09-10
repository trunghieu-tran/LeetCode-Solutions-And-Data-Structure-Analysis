import java.util.Arrays;

/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MinimumMovesToEqualArrayII {
	public int minMoves2(int[] nums) {
		int res = 0;
		int i = 0, j = nums.length - 1;
		Arrays.sort(nums);
		while (i < j) {
			res += nums[j--] - nums[i++];
		}
		return  res;
	}
}
