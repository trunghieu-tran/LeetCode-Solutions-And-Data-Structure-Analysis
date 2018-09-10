/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ConvertSortedArrayToBinarySearchTree {

	private void maker(int i, int j, TreeNode n, int[] nums) {
		if (i == j) {
			n.val = nums[i];
			return;
		}
		if ((j - i) % 2 == 0) {
			TreeNode left = new TreeNode(0);
			TreeNode right = new TreeNode(0);
			n.left = left;
			n.right = right;
			int mid = (j + i) / 2;
			n.val = nums[mid];
			maker(i, mid - 1, left, nums);
			maker(mid + 1, j, right, nums);
		} else {
			int mid = (i + j + 1) / 2;
			n.val = nums[mid];

			TreeNode left = new TreeNode(0);
			n.left = left;
			maker(i, mid - 1, left, nums);

			if (mid + 1 <= j) {
				TreeNode right = new TreeNode(0);
				n.right = right;
				maker(mid + 1, j, right, nums);
			}
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode res = new TreeNode(0);
		if (nums.length > 0) maker(0, nums.length -1, res, nums);
		return res;
	}
}
