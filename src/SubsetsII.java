import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SubsetsII {
	private void recursion(int pos, int[] nums, ArrayList<Integer> curr, List<List<Integer>> res) {
		if (pos == nums.length) {
//			res.add(new ArrayList<>(curr));
			return;
		}


		for (int i = pos; i < nums.length; ++i) {
			if (i == pos || nums[i] != nums[i - 1]) {
				curr.add(nums[i]);
				res.add(new ArrayList<>(curr));
				recursion(i + 1, nums, curr, res);
				curr.remove(curr.size() - 1);
			}
		}
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		recursion(0, nums, new ArrayList<>(), res);
		res.add(new ArrayList<>());
		return res;
	}
}
