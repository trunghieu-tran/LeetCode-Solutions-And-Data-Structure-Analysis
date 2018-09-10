package Contest94;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LeafSimilar {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private void traverse(TreeNode n, ArrayList<Integer> res) {
		if (n == null) return;

		if (n.left == null && n.right == null) {
			res.add(n.val);
			return;
		}

		traverse(n.left, res);
		traverse(n.right, res);
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<Integer> r1 = new ArrayList<>();
		ArrayList<Integer> r2 = new ArrayList<>();
		traverse(root1, r1);
		traverse(root2, r2);
		if (r1.size() != r2.size()) return false;
		for (int i = 0; i < r1.size(); ++i)
			if (r1.get(i) != r2.get(i)) return false;
		return true;
	}
}
