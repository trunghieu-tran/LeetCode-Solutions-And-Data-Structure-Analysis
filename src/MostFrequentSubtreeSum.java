import java.util.HashMap;
import java.util.Map;

/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MostFrequentSubtreeSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	Map<Integer, Integer> map = new HashMap<>();

	private int traverse(TreeNode node) {
		if (node == null) return 0;

		int sum = node.val + traverse(node.left) + traverse(node.right);
		map.put(sum, map.getOrDefault(sum , 0) + 1);
		return sum;
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null) return new int[0];

		int x = traverse(root);
		int cnt = 1, best = 0;
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (freq > best) {
				best = freq;
				cnt = 1;
			} else
				if (freq == best) cnt++;
		}
		int[] res = new int[cnt];
		int i = 0;
		for (int key : map.keySet())
			if (map.get(key) == best)
				res[i++] = key;
		return res;
	}
}
