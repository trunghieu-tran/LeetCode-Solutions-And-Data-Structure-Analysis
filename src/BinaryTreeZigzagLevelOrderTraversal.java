import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BinaryTreeZigzagLevelOrderTraversal {




	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root != null) {
			List<TreeNode> currLevel = new ArrayList<>();
			List<Integer> first = new ArrayList<>();
			first.add(root.val);
			res.add(first);

			currLevel.add(root);
			int level = 0;

			while (currLevel.size() > 0) {
				List<Integer> tmp = new ArrayList<>();
				List<TreeNode> newCurr = new ArrayList<>();

				for (int i = 0; i < currLevel.size(); ++i) {
					TreeNode curr = currLevel.get(i);
					if (curr.left != null) {
						newCurr.add(curr.left);
						tmp.add(curr.left.val);
					}
					if (curr.right != null) {
						newCurr.add(curr.right);
						tmp.add(curr.right.val);
					}
				}

				currLevel = newCurr;

				if (++level % 2 == 1) {
					Collections.reverse(tmp);
				}
				if (tmp.size() > 0) {
					res.add(tmp);
				}
			}
		}
		return res;
	}
}
