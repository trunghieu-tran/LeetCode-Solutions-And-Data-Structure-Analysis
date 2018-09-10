/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MinDepth {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int left = minDepth(root.left) + 1;
		int right = minDepth(root.right) + 1;
		return Math.min(left, right);
	}
}
