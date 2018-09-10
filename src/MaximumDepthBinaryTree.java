/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MaximumDepthBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
