/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BinaryTreeTilt {
	int sumTilt = 0;

	private int sum(TreeNode n) {
		if (n == null) return 0;
		int l = sum(n.left);
		int r = sum(n.right);
		sumTilt += Math.abs(l - r);
		return l + r + n.val;
	}
	public int findTilt(TreeNode root) {
		if (root == null) return 0;
		sum(root);
		return sumTilt;
	}
}
