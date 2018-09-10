/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
		int n = nums.length;
		if (n < 3) return false;
		int v1 = nums[0];
		int v2 = 0;
		boolean v2Found = false;
		for (int i = 1; i < n; ++i) {
			if (v2Found) {
				if (nums[i] > v2) return true;
				if (nums[i] > v1)
					v2 = nums[i];
				else
					v1 = nums[i];
			} else {
				if (nums[i] > v1) {
					v2 = nums[i];
					v2Found = true;
				} else v1 = nums[i];
			}
		}
		return false;
	}
}
