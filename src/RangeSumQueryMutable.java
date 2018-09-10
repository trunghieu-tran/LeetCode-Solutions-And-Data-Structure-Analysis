/**
 * @author Harry Tran on 7/22/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class RangeSumQueryMutable {
	class NumArray {

		class TreeNode {
			int sum;
			TreeNode left;
			TreeNode right;
			public TreeNode(int sum, TreeNode l, TreeNode r) {
				this.sum = sum;
				this.left = l;
				this.right = r;
			}
		}

		TreeNode root;
		int n;

		public NumArray(int[] nums) {
			n = nums.length - 1;
			root = buildTree(0, n, nums);
		}

		private TreeNode buildTree(int start, int end, int[] nums) {
			if (start > end) return null;
			if (start == end) {
				return new TreeNode(nums[start], null, null);
			}
			int mid = (start + end) / 2;
			TreeNode l = buildTree(start, mid, nums);
			TreeNode r = buildTree(mid + 1, end, nums);
			return new TreeNode( l.sum + r.sum, l, r);
		}

		private void updateTree(int start, int end, int i, int val, TreeNode node) {
			if (i > end || i < start) return;
			if (start == end) {
				node.sum = val;
				return;
			}
			int mid = (start + end) / 2;
			if (mid >= i) {
				updateTree(start, mid, i, val, node.left);
			} else
				updateTree(mid + 1, end, i, val, node.right);
			node.sum = node.left.sum + node.right.sum;
		}

		private int getSum(int start, int end, int i, int j, TreeNode node) {
			if (start > end || start > j || end < i) return 0;
			if (start == end) return node.sum;
			int mid = (start + end) / 2;
			return getSum(start, mid, i, j, node.left) + getSum(mid + 1, end, i, j, node.right);
		}

		public void update(int i, int val) {
			updateTree(0, n, i, val, root);
		}

		public int sumRange(int i, int j) {
			return getSum(0, n, i, j, root);
		}
	}

	public static void main(String[] args) {
//		 NumArray obj = new NumArray(nums);
//		 obj.update(i,val);
//		 int param_2 = obj.sumRange(i,j);
	}
}
