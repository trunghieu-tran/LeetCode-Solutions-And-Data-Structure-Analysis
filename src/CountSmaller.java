import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harry Tran on 7/24/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class CountSmaller {

	public class TreeNode {
		int val;
		int sum;
		TreeNode left;
		TreeNode right;
		TreeNode(int x, int y) { val = x; sum = y ;}
	}

	private int get(TreeNode node, int val) {
		node.sum++;
		int res = 0;
		if (val >= node.val) {
			if (val > node.val) res++;
			if (node.left != null) res += node.left.sum;
			if (node.right != null) {
				res += get(node.right, val);
			} else {
				node.right = new TreeNode(val, 1);
			}
		} else {
			if (node.left == null) {
				node.left = new TreeNode(val, 1);
			} else {
				res += get(node.left, val);
			}
		}
		return res;
	}

	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		if (n == 0) return new ArrayList<>();

		Integer[] res = new Integer[n];
		TreeNode root = new TreeNode(nums[n - 1], 1);
		res[n - 1] = 0;

		for (int i = n - 2; i >= 0; --i) {
			res[i] = get(root, nums[i]);
		}
		return Arrays.asList(res);
	}

	public static void main(String[] args) {
		int[] nums = {5,2,6,1};
		CountSmaller cs = new CountSmaller();
		List<Integer> res = cs.countSmaller(nums);
		for (int i = 0; i < res.size(); ++i)
			System.out.println(res.get(i));
	}
}
