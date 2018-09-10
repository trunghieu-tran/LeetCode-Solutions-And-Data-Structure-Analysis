/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ConstructStringFromBTree {
	public String tree2str(TreeNode t) {
		if (t == null) return "";

		StringBuilder res = new StringBuilder();

		res.append(t.val);

		if (t.left == null && t.right == null) return res.toString();

		if (t.right == null) {
			return res.append("(").append(tree2str(t.left)).append(")").toString();
		}
		return res.append("(").append(tree2str(t.left)).append(")(").append(tree2str(t.right)).append(")").toString();
	}
}
