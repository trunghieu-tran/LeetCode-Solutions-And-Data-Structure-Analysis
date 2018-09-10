/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
		if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
		return root;
	}
}
