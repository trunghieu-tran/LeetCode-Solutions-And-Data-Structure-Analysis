package Contest105;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Harry Tran on 10/6/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Solution {

	public static void main(String[] args) {
		//["CBTInserter","insert","insert","get_root"]
		//[[[1,2,3,4,5,6]],[7],[8],[]]
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		root.setChildren(n2, n3);
		n2.setChildren(n4,n5);
		n3.setChildren(n6, null);
		Solution sl = new Solution(root);
		System.out.println(sl.insert(7));
		System.out.println(sl.insert(8));
		System.out.println("DONE");
	}

	Map<TreeNode, Integer> nChild;
	Map<TreeNode, Integer> level;
	Map<TreeNode, TreeNode> parent;
	TreeNode root;

	private int getPower(int a, int b) {
		return (int) Math.pow(a, b);
	}

	public Solution(TreeNode root) {
		this.root = root;
		nChild = new HashMap<>();
		level = new HashMap<>();
		parent = new HashMap<>();
		init(root);
	}

	private void init(TreeNode node) {
		int c = 1;
		int l = 1;
		if (node.left != null) {
			parent.put(node.left, node);
			init(node.left);
			c += nChild.get(node.left);
			l = 1 + level.get(node.left);

			if (node.right != null) {
				parent.put(node.right, node);
				init(node.right);
				c += nChild.get(node.right);
			}
		}
		nChild.put(node, c);
		level.put(node, l);
	}

	public int insert(int v) {
		return insertTo(root, v);
	}

	private int insertTo(TreeNode node, int v) {
		if (node.left == null) {
			TreeNode newN = new TreeNode(v);
			nChild.put(newN, 1);
			level.put(newN, 1);
			parent.put(newN, node);

			node.left = newN;

			TreeNode p = newN;
			boolean inc = true;
			while (p != null) {
				TreeNode par = parent.getOrDefault(p, null);
				if (par == null) break;
				nChild.put(par, nChild.get(par) + 1);
				if (inc) {
					int levelP = level.get(par);
					if (levelP == level.get(p)) {
						level.put(par, levelP + 1);
					} else inc = false;
				}
				p = par;
			}

			return node.val;
		}
		if (node.right == null) {
			TreeNode newN = new TreeNode(v);
			nChild.put(newN, 1);
			level.put(newN, 1);
			parent.put(newN, node);

			node.right = newN;

			TreeNode p = newN;
			while (p != null) {
				TreeNode par = parent.getOrDefault(p, null);
				if (par == null) break;
				nChild.put(par, nChild.get(par) + 1);
				p = par;
			}

			return node.val;
		}

		int childLeft = getPower(2, level.get(node.left)) - 1;
		int childRight = getPower(2, level.get(node.right)) - 1;

		if (childLeft > nChild.get(node.left)) {
			return insertTo(node.left, v);
		}
		if (childRight > nChild.get(node.right)) {
			return insertTo(node.right, v);
		}
		return insertTo(node.left, v);
	}

	public TreeNode get_root() {
		return this.root;
	}
}
