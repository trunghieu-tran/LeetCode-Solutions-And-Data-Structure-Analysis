import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 7/10/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class UniqueBinarySearchTreesII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


	private List<TreeNode> generate(int vmin, int vmax) {
		List<TreeNode> res = new ArrayList<>();

		if (vmin > vmax) {
			res.add(null);
			return res;
		}

		if (vmin == vmax) {
			res.add(new TreeNode(vmax));
			return res;
		}

		for (int i = vmin; i <= vmax; ++i) {
			List<TreeNode> lefts = generate(vmin, i - 1);
			List<TreeNode> rights = generate(i + 1, vmax);
			for (TreeNode left : lefts)
				for (TreeNode right : rights) {
					TreeNode tmp = new TreeNode(i);
					tmp.left = left;
					tmp.right = right;
					res.add(tmp);
				}
		}
		return res;
	}

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) return new ArrayList<>();
		return generate(1, n);
	}
}
