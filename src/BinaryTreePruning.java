/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BinaryTreePruning {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private boolean isOK(TreeNode node) {
		boolean res = false;
		if (node.left != null) {
			if (isOK(node.left)) res = true;
			else
				node.left = null;
		}
		if (node.right != null) {
			if (isOK(node.right)) res = true;
			else
				node.right = null;
		}
		res |= (node.val == 1);
		return res;
	}

	public TreeNode pruneTree(TreeNode root) {
		if (isOK(root)) return root;
		else return null;
	}
}
