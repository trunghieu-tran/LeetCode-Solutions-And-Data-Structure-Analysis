import java.util.LinkedList;
import java.util.List;

/**
 * @author Harry Tran on 7/10/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private void traverse(TreeNode node, List<Integer> res) {
		if (node == null) return;
		traverse(node.left, res);
		res.add(node.val);
		traverse(node.right, res);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		if (root == null) return res;
		traverse(root, res);
		return res;
	}
}
