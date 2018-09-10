package Contest92;

import java.util.HashMap;

/**
 * @author Harry Tran on 7/7/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SmallestSubstree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	HashMap<TreeNode, Integer> fDeep = new HashMap<>();
	HashMap<TreeNode, Integer> mapDeep = new HashMap<>();

	TreeNode res = null;
	int deepest = -1;
	int cDeepest = 0;
	boolean found = false;

	private void traverse(TreeNode node, int level) {
		mapDeep.put(node, level);

		if (node.left != null)  {
			traverse(node.left, level + 1);
		}
		if (node.right != null) {
			traverse(node.right, level + 1);
		}

		if (level > deepest) {
			deepest = level;
			cDeepest = 1;
		} else
			if (level == deepest) {
				++cDeepest;
			}
	}

	private void traverse2(TreeNode node) {
		if (found) return;

		int level = mapDeep.getOrDefault(node, 0);
		int cc = 0;
		if (level == deepest) {
			fDeep.put(node, 1);
			cc++;
		}
		else {
			if (node.left != null) {
				traverse2(node.left);
				cc += fDeep.getOrDefault(node.left, 0);
			}

			if (found) return;

			if (node.right != null) {
				traverse2(node.right);
				cc += fDeep.getOrDefault(node.right, 0);
			}

			if (found) return;
		}
		System.out.println(node.val);
		System.out.println(cc);
		System.out.println();
		if (cc == cDeepest) {
			found = true;
			res = node;
		}
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		traverse(root, 0);
		System.out.println(cDeepest);
		System.out.println(deepest);
		System.out.println("---");
		traverse2(root);
		return res;
	}
}
