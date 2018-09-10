/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class IsSubtree {


	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null) return false;
		if (t == null) return false;
		return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
	};

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null) return false;
		if (t == null) return false;
		return isSubtree(s.left, t) || isSubtree(s.right, t) || isSame(s, t);
	}
}
