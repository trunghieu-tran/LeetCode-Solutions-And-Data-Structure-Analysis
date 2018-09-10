/**
 * @author Harry Tran on 7/10/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SameTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null)
			return q == null;
		return (q != null)  && (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
