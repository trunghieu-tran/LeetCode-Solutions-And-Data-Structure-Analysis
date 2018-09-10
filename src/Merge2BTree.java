/**
 * @author Harry Tran on 6/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Merge2BTree {

	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1==null) return t2;
		if (t2==null) return t1;
		TreeNode newNode = new TreeNode(t1.val + t2.val);
		newNode.right = mergeTrees(t1.right, t2.right);
		newNode.left = mergeTrees(t1.left, t2.left);
		return newNode;
	}
}
