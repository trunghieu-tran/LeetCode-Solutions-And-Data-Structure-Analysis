import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Harry Tran on 7/28/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */

public class PopulatingNextRightPointers2 {


	public void connect(TreeLinkNode root) {
		if (root != null) {
			Queue<TreeLinkNode> q = new LinkedList<>();
			q.add(root);

			while (!q.isEmpty()) {
				Queue<TreeLinkNode> tmpQ = new LinkedList<>();

				TreeLinkNode last = null;
				while (!q.isEmpty()) {
					TreeLinkNode n = q.poll();
					if (n.left != null) {
						tmpQ.add(n.left);
						if (last != null) {
							last.next = n.left;
						}
						last = n.left;
					}

					if (n.right != null) {
						tmpQ.add(n.right);
						if (last != null) {
							last.next = n.right;
						}
						last = n.right;
					}
				}
				q.addAll(tmpQ);
			}
		}
		System.out.println("DOne");
	}

	public static void main(String[] args) {
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		PopulatingNextRightPointers2 p = new PopulatingNextRightPointers2();
		p.connect(n1);

	}
}
