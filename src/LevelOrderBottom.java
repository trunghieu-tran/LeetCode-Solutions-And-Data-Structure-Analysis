import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LevelOrderBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
//		List<List<Integer>> res = new ArrayList<>();

		ArrayDeque<List<Integer>> res = new ArrayDeque<>();
		if (root != null) {
			List<TreeNode> list = new ArrayList<>();
			list.add(root);

			List<Integer> first = new ArrayList<>();
			first.add(root.val);
			res.addFirst(first);

			while (list.size() > 0) {
				List<TreeNode> newList = new ArrayList<>();
				List<Integer> varList = new ArrayList<>();

				for (int i = 0; i < list.size(); ++i) {
					TreeNode left = list.get(i).left;
					TreeNode right = list.get(i).right;
					if (left != null) {
						newList.add(left);
						varList.add(left.val);
					}
					if (right != null) {
						newList.add(right);
						varList.add(right.val);
					}
				}

				list = newList;
				if (list.size() > 0) {
					res.addFirst(varList);
				}
			}
		}
		return new ArrayList<>(res);
	}
}
