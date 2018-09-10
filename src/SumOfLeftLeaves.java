/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SumOfLeftLeaves {
	int res = 0;
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) return 0;

		if (root.left != null) {
			if (root.left.left == null && root.left.right == null)
				res += root.left.val;
			sumOfLeftLeaves(root.left);
		}
		sumOfLeftLeaves(root.right);

		return res;
	}
}
