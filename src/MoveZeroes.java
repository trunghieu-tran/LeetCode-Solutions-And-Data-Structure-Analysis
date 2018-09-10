/**
 * @author Harry Tran on 7/2/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int len = nums.length;
		int cnt = 0;
		for (int i = 0; i < len; ++i)
			if (nums[i] != 0) nums[cnt++] = nums[i];
		for (int i = cnt; i < len; ++i) nums[i] = 0;
	}
}
