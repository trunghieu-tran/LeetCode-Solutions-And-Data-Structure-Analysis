import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Permutations {
	List<List<Integer>> res = new ArrayList<>();
	private int getBit(int num, int i) {
		return (num >> i) & 1;
	}

	private int onBit(int num, int i) {
		return num | (1 << i);
	}

	private void recursion(int pos, int n, int[] nums, int status, List<Integer> curr) {
		if (pos == n) {
			res.add(new ArrayList<>(curr));
			return;
		}

		for (int i = 0; i < n; ++i)
			if (getBit(status, i) == 0) {
				curr.set(pos, nums[i]);
				recursion(pos + 1, n, nums, onBit(status, i), curr);
			}

	}


	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			res.add(new ArrayList<>());
			return res;
		}
		int n = nums.length;
		List<Integer> curr = Arrays.asList(new Integer[nums.length]);
		recursion(0, n, nums, 0, curr);
		return res;
	}
}
