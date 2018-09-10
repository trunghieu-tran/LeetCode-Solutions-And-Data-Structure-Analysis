import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harry Tran on 7/11/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class AllNodesDistanceKInBinaryTree {

	Map<Integer, TreeNode> parents = new HashMap<>();

	private void traverse(TreeNode n) {
		if (n.left != null) {
			parents.put(n.left.val, n);
			traverse(n.left);
		}

		if (n.right != null) {
			parents.put(n.right.val, n);
			traverse(n.right);
		}
	}

	private void finding(TreeNode n, int last, List<Integer> res, int K) {
		System.out.println(n.val);
		if (K == 0) {
			res.add(n.val);
			return;
		}
		// solving its children
		if (n.left != null && last != n.left.val)  {
			finding(n.left, n.val, res, K - 1);
		}
		if (n.right != null && last != n.right.val) {
			finding(n.right, n.val, res, K - 1);
		}
		// Parents
		TreeNode p = parents.getOrDefault(n.val, null);
		if (p != null && last != p.val) {
			finding(p, n.val, res, K - 1);
		}
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new ArrayList<>();
		traverse(root);
		finding(target, -1, res, K);
		return res;
	}
}
