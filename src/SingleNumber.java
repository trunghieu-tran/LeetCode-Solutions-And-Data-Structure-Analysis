/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int len = nums.length;
		int res = 0;
		for (int i = 0; i < len; ++i) res ^= nums[i];
		return res;
	}
}
