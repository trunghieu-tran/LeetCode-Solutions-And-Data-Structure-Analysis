/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class InvertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode tmp = new TreeNode(root.val);
		tmp.left = invertTree(root.right);
		tmp.right = invertTree(root.left);
		return tmp;
	}
}
