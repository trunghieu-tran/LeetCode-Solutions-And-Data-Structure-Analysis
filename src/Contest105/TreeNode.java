package Contest105;

/**
 * @author Harry Tran on 10/6/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	public void setChildren(TreeNode left, TreeNode right) {this.left = left; this.right = right;}

}
