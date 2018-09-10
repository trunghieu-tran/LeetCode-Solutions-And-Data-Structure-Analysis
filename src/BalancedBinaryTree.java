/**
 * @author Harry Tran on 7/11/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BalancedBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	boolean res = true;

	private int traverse(TreeNode node) {
		if (node == null) return 0;
		int ileft = traverse(node.left);
		int iright = traverse(node.right);
		if (Math.abs(ileft - iright) > 1) {
			res = false;
		}
		return Math.max(ileft, iright) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		int i = traverse(root);
		return res;
	}
}
