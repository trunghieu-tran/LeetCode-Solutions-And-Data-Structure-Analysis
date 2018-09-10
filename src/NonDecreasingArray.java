/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class NonDecreasingArray {
	public boolean checkPossibility_2(int[] nums) {
		int len = nums.length;
		int pos = -1;


		for (int i = 0; i < len - 1; ++i) {
			if (nums[i] > nums[i + 1]) {
				if (pos != -1) return false;
				pos = i;
			}
		}
		return pos == -1 || pos == 0 || pos == len - 2 ||
				nums[pos - 1] <= nums[pos + 1] || nums[pos] <= nums[pos + 2];
	}
}
