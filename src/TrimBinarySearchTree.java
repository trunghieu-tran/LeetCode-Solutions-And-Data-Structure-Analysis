/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class TrimBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) return null;

		if (root.val > R) return  trimBST(root.left, L, R);

		if (root.val < L) return  trimBST(root.right, L, R);

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}
}
