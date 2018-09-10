/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LongestUnivaluePath {

	int res = 0;
	private int findLongestPathSubtreeContainsItself(TreeNode n) {
		int tmp1 = 0;
		int tmp2 = 0;
		if (n.left != null) {
			int x = findLongestPathSubtreeContainsItself(n.left);
			if (n.val == n.left.val)
				tmp1 = x + 1;
		}
		if (n.right != null) {
			int x = findLongestPathSubtreeContainsItself(n.right);
			if (n.val == n.right.val)
				tmp2 = x + 1;
		}
		res = Math.max(res, tmp1 + tmp2);
		return Math.max(tmp1, tmp2);
	}

	public int longestUnivaluePath(TreeNode root) {
		if (root != null)
			findLongestPathSubtreeContainsItself(root);
		return res;
	}
}
