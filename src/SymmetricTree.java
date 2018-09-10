/**
 * @author Harry Tran on 7/3/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SymmetricTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private boolean isSymmetric2Nodes(TreeNode n1, TreeNode n2) {
		if (n1 == null) return n2 == null;
		if (n2 == null) return false;

		boolean res = n1.val == n2.val;
		res &= isSymmetric2Nodes(n1.left, n2.right);
		res &= isSymmetric2Nodes(n1.right, n2.left);

		return res;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetric2Nodes(root.left, root.right);
	}
}
