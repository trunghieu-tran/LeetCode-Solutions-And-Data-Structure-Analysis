import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BinaryTreePaths {
	List<String> res = new ArrayList<>();

	private void traverse(TreeNode n, StringBuilder curr) {
		if (n.left != null) {
			StringBuilder tmp = new StringBuilder(curr);
			tmp.append("->").append(n.left.val);
			traverse(n.left, tmp);
		}

		if (n.right != null) {
			StringBuilder tmp = new StringBuilder(curr);
			tmp.append("->").append(n.right.val);
			traverse(n.right, tmp);
		}
		if (n.left == null && n.right == null) {
			res.add(curr.toString());
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) return res;
		StringBuilder curr = new StringBuilder();
		curr.append(root.val);
		traverse(root, curr);
		return res;
	}



	public static void sss(StringBuilder s) {
		if (s.toString().length() >= 10) return;
		s.append("abc");
		sss(s);
	}
	public static void main(String[] args) {
		StringBuilder tmp = new StringBuilder();
		BinaryTreePaths.sss(tmp);
		System.out.println(tmp.toString());
	}
}
