/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null) {
			return root.val == sum;
		}
		boolean res = false;
		if (root.left != null)
			res |= hasPathSum(root.left, sum - root.val);
		if (root.right != null)
			res |= hasPathSum(root.right, sum - root.val);
		return res;
	}
}
