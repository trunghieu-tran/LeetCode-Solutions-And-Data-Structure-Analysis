/**
 * @author Harry Tran on 7/11/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class RecoverBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	TreeNode n1 = null;
	TreeNode n2 = null;
	TreeNode last = new TreeNode(Integer.MIN_VALUE);

	private void traverse(TreeNode node) {
		if (node == null) return;
//		if (n1 != null && n2 != null) return;

		traverse(node.left);

		if (n1 == null && node.val < last.val) n1 = last;
		if (n1 != null && node.val < last.val) n2 = node;
		last = node;

		traverse(node.right);
	}
	public void recoverTree(TreeNode root) {
		traverse(root);

		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
	}
}
