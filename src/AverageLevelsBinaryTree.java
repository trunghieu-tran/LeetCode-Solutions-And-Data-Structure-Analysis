import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class AverageLevelsBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private void dfs(TreeNode node, int level, HashMap<Integer, Integer> countNode, HashMap<Integer, Long> sumNode) {
		countNode.put(level, countNode.getOrDefault(level, 0) + 1);
		sumNode.put(level, sumNode.getOrDefault(level, 0L) + (long)node.val);

		if (node.left != null) dfs(node.left, level + 1, countNode, sumNode);
		if (node.right != null) dfs(node.right, level + 1, countNode, sumNode);
	}

	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		HashMap<Integer, Integer> countNode = new HashMap<>();
		HashMap<Integer, Long> sumNode = new HashMap<>();
		dfs(root, 0, countNode, sumNode);

		List<Double> res = new ArrayList<>();
		for (int i = 0; i < countNode.size(); ++i)
			res.add((double) sumNode.get(i) / (double)countNode.get(i));
		return res;
	}
}
