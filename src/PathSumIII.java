import javafx.util.Pair;

import java.util.HashMap;

/**
 * @author Harry Tran on 7/13/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PathSumIII {
	HashMap<Pair<TreeNode, Integer>, Integer> map = new HashMap<>();

	private int pathFrom(TreeNode n, int currSum) {
		if (n == null) return 0;
		Pair<TreeNode, Integer> p = new Pair<>(n, currSum);
		if (map.containsKey(p)) {
			return map.get(p);
		}
		int res = (n.val == currSum ? 1 : 0) + pathFrom(n.left, currSum - n.val) + pathFrom(n.right, currSum - n.val);
		map.put(p, res);
		return res;
	}

	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		return pathSum(root.left, sum) + pathSum(root.right, sum) + pathFrom(root, sum);
	}
}
