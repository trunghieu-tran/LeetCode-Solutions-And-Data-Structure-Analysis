/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ConvertBSTToGreaterTree {

	int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		if (root == null) return root;
		convertBST(root.right);
		root.val += sum;
		sum = root.val;
		convertBST(root.left);
		return root;
	}
}
