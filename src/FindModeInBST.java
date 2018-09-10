import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FindModeInBST {
	List<Integer> list = new ArrayList<>();
	int cnt = 0;
	int currVal = 19920704, c = -1;
	private void finding(TreeNode n) {
		if (n == null) return;

		finding(n.left);

		if (n.val == currVal) {
			++c;
		} else {
			c = 1;
			currVal = n.val;
		}

		if (c > cnt) {
			cnt = c;
			list.clear();
			list.add(currVal);

		} else if (c == cnt) {
			list.add(currVal);
		}


		finding(n.right);
	}

	public int[] findMode(TreeNode root) {
		if (root == null) return new int[0];

		finding(root);
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			res[i] = list.get(i);
		return res;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(2);
		n0.right = n1;
		n1.left = n2;

		FindModeInBST f = new FindModeInBST();
		f.findMode(n0);
	}
}
