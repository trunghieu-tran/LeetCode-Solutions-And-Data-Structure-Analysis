/**
 * @author Harry Tran on 6/25/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class AddTwoNumber {

	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode curr = result;
		int carry = 0;
		while (true) {
			int tmp = l1.val + l2.val + carry;
			carry = tmp / 10;
			curr.val = tmp % 10;

			if (l1.next == null || l2.next == null) break;
			l1 = l1.next;
			l2 = l2.next;
			ListNode newNode = new ListNode(0);
			curr.next = newNode;
			curr = newNode;
		}
		while (l1.next != null) {
			l1 = l1.next;
			int tmp = l1.val + carry;
			carry = tmp / 10;
			ListNode newNode = new ListNode(tmp % 10);
			curr.next = newNode;
			curr = newNode;
		}

		while (l2.next != null) {
			l2 = l2.next;
			int tmp = l2.val + carry;
			carry = tmp / 10;
			ListNode newNode = new ListNode(tmp % 10);
			curr.next = newNode;
			curr = newNode;
		}
		if (carry > 0) {
			ListNode newNode = new ListNode(carry);
			curr.next = newNode;
		}
		return result;
	}

	public static void main(String[] args) {
		int c = 97;
		System.out.println((char) c);
	}
}
