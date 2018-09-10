/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SecondMinNodeInBTree {
	int min = -2;
	int min2 = -1;

	private void traverse(TreeNode n) {
		if (min == -2 || min > n.val) min = n.val;
		if (n.val > min) {
			if (min2 == -1  || min2 > n.val) min2 = n.val;
		}
		if (n.left == null) return;

		int currMin = Math.min(n.left.val, n.right.val);

		if (min2 == -1 || currMin < min2) {
			traverse(n.left);
			traverse(n.right);
		}
	}
	public int findSecondMinimumValue(TreeNode root) {
		traverse(root);
		return min2;
	}
}
