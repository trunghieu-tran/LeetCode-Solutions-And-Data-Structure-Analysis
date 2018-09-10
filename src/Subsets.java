import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Subsets {

	private void recursion(int pos, int[] nums, ArrayList<Integer> curr, List<List<Integer>> res) {
		if (pos == nums.length) {
			res.add(new ArrayList<>(curr));
			return;
		}

		recursion(pos + 1, nums, curr, res);

		curr.add(nums[pos]);
		recursion(pos + 1, nums, curr, res);
		curr.remove(curr.size() - 1);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		recursion(0, nums, new ArrayList<>(), res);
		return res;
	}
}
