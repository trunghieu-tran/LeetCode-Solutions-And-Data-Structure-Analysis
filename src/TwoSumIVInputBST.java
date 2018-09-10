import java.util.HashSet;
import java.util.Set;

/**
 * @author Harry Tran on 7/10/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class TwoSumIVInputBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	Set<Integer> set = new HashSet<>();

	private boolean traverse(TreeNode node, int target) {
		if (node == null) return false;
		if (set.contains(target - node.val)) return true;
		set.add(node.val);
		return traverse(node.left, target) || traverse(node.right, target);
	}

	public boolean findTarget(TreeNode root, int k) {
		if (root == null) return false;
		return traverse(root, k);
	}
}
