/**
 * @author Harry Tran on 7/12/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ConvertSortedListToBST {
	ListNode currHead;
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		ListNode ln = head;
		int cc = 0;
		while (ln.next != null) {
			++cc;
			ln = ln.next;
		}
		currHead = head;
		return maker(0, cc);
	}

	private TreeNode maker(int l, int r) {
		if (l == r) {
			TreeNode tn = new TreeNode(currHead.val);
			currHead = currHead.next;
			return tn;
		}
		int mid = (r + l + 1) / 2;
		TreeNode tmp = new TreeNode(0);

		tmp.left = maker(l, mid - 1);

		tmp.val= currHead.val;
		currHead = currHead.next;

		if (mid + 1 <= r) {
			tmp.right = maker(mid + 1, r);
		}
		return tmp;
	}

	public static void main(String[] args) {
		int[] arr = {-10,-3,0,5,9};
		ListNode head = new ListNode(arr[0]);
		ListNode last = head;
		for (int i = 1; i < arr.length; ++i) {
			ListNode tmp = new ListNode(arr[i]);
			last.next = tmp;
			last = tmp;
		}
		ConvertSortedListToBST c = new ConvertSortedListToBST();
		TreeNode res = c.sortedListToBST(head);
	}
}
