/**
 * @author Harry Tran on 7/3/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SingleElementInSortedArray {
	public int singleNonDuplicate(int[] nums) {
		int l = 0, r = nums.length;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (    (mid==0 || nums[mid-1] != nums[mid]) &&
					(mid==nums.length - 1 || nums[mid] != nums[mid + 1])) return nums[mid];
			if ((mid - l + 1) % 2 == 0) {
				if (nums[mid] != nums[mid + 1]) l = mid + 1;
				else r = mid - 1;
			}
			else {
				if (nums[mid] != nums[mid + 1]) r = mid;
				else l = mid + 2;
			}
		}
		return 0;
	}
}
