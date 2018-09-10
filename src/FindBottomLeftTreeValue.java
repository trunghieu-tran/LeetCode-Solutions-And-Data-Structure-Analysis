import java.util.HashMap;

/**
 * @author Harry Tran on 7/3/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FindBottomLeftTreeValue {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	HashMap<Integer, TreeNode> map = new HashMap<>();

	private int dfs(TreeNode node, int level) {
		if (node == null) return level - 1;

		if (!map.containsKey(level)) {
			map.put(level, node);
		}

		return Math.max(dfs(node.left, level + 1), dfs(node.right, level + 1));
	}
	public int findBottomLeftValue(TreeNode root) {
		int height = dfs(root, 0);
		return map.get(height).val;
	}
}
