import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FindLargestValueEachTreeRow {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	HashMap<Integer, Integer> mapResult = new HashMap<>();

	private void dfs(TreeNode node, int level) {
		mapResult.put(level, Math.max(node.val, mapResult.getOrDefault(level, Integer.MIN_VALUE)));
		if (node.left != null) dfs(node.left, level + 1);
		if (node.right != null) dfs(node.right, level + 1);
	}

	public List<Integer> largestValues(TreeNode root) {
		if (root == null) return new ArrayList<>();
		dfs(root, 0);
		int height = mapResult.size();
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < height; ++i)
			res.add(mapResult.get(i));
		return res;
	}
}
