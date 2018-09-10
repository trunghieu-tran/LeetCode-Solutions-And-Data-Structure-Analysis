/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class DiameterOfBinaryTree {

	int res = 0;
	private int maxHeight(TreeNode n) {
		int l = (n.left != null) ? maxHeight(n.left) + 1 : 0;
		int r = (n.right != null) ? maxHeight(n.right) + 1  : 0;

		res = Math.max(res, l + r);
		return Math.max(l, r);
	}
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) return 0;
		maxHeight(root);
		return res;
	}
}
