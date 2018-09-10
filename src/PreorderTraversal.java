import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Harry Tran on 7/23/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		if (root == null) return res;

		st.push(root);
		while (!st.empty()) {
			TreeNode n = st.pop();

			res.add(n.val);
			if (n.right != null) st.push(n.right);
			if (n.left != null) st.push(n.left);
		}
		return res;
	}
}
