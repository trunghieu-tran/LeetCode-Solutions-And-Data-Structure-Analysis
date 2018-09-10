import javafx.util.Pair;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MaxBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private int[] p = new int[4000];

	private void build(int [] nums, int left, int right, int node) {
		if (left == right) {
			p[node] = left;
			return;
		}
		int mid = (left + right) / 2;
		build(nums, left, mid, node * 2);

		p[node] = p[node * 2];

		if (mid < right) {
			build(nums, mid + 1, right, node * 2 + 1);
			if (nums[p[node]] < nums[p[node * 2 + 1]]) {
				p[node] = p[node * 2 + 1];
			}
		}
	}

	private int get(int[] nums, int node, int left, int right, int u, int v) {
		if (left > v || right < u) return -1;
		if (u <= left && right <= v) return p[node];
		int mid = (left + right) / 2;
		int res = -1;

		int p1 = get(nums, node * 2, left, mid, u, v);
		if (p1 != -1) {
			res = p1;
		}

		if (mid < right) {
			int p2 = get(nums, node * 2 + 1, mid + 1, right, u, v);
			if (p2 != -1) {
				if (res == -1  || nums[res] < nums[p2]) {
					res = p2;
				}
			}

		}
		return res;
	}

	private TreeNode construct(int[] nums, int left, int right) {
//		int mid = get(nums, 1, 0, nums.length - 1, left, right);
		int mid = getMax(nums, left, right);
		TreeNode res = new TreeNode(nums[mid]);
		if (left < mid)
			res.left = construct(nums, left, mid - 1);
		if (mid < right)
			res.right = construct(nums, mid + 1, right);
		return res;
	}

	private int getMax(int[] nums, int left, int right) {
		int res = left;
		for (int i = left + 1; i <= right; ++i)
			if (nums[i] > nums[res]) res = i;
		return res;
	}
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		build(nums, 0, nums.length - 1, 1);
		return construct(nums, 0, nums.length - 1);
	}
}
