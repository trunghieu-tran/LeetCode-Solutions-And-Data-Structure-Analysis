/**
 * @author Harry Tran on 10/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class DesignLinkedList {
	public static void main(String[] args) {
		DesignLinkedList obj = new DesignLinkedList();
		 int param_1 = obj.get(1);
		 obj.addAtHead(1);
		 obj.addAtTail(3);
		 obj.addAtIndex(1,2);
		 int x = obj.get(1);
		 obj.deleteAtIndex(1);
		 int y = obj.get(1);
	}
	class LinkedListNode {
		int val;
		LinkedListNode next;
		LinkedListNode(int val) {
			this.val = val;
		}
	}
	LinkedListNode head, tail;
	int n;

	/** Initialize your data structure here. */
	public DesignLinkedList() {
		head = null;
		tail = head;
		n = 0;
	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (index >= n || index < 0) return -1;
		LinkedListNode curr = head;
		for (int i = 0; i < index; ++i) {
			curr = curr.next;
		}
		return curr.val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		++n;
		LinkedListNode newN = new LinkedListNode(val);
		if (head == null) {
			head = newN;
			tail = head;
		} else {
			newN.next = head;
			head = newN;
		}
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		++n;
		LinkedListNode newN = new LinkedListNode(val);
		if (tail == null) {
			head = newN;
			tail = head;
		} else {
			tail.next = newN;
			tail = newN;
		}
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		if (index > n || index < 0) return;
		if (index == 0) {
			addAtHead(val);
			return;
		}
		if (index == n) {
			addAtTail(val);
			return;
		}

		++n;
		LinkedListNode newN = new LinkedListNode(val);
		LinkedListNode curr = head;
		LinkedListNode last = null;
		for (int i = 0; i < index; ++i) {
			last = curr;
			curr = curr.next;
		}
		newN.next = curr;
		last.next = newN;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index >= n || 0 > index) return;
		--n;
		if (n == 0) {
			head = null;
			tail = null;
			return;
		}

		if (index == 0) {
			head = head.next;
			return;
		}

		LinkedListNode curr = head;
		LinkedListNode last = null;
		for (int i = 0; i < index; ++i) {
			last = curr;
			curr = curr.next;
		}
		last.next = curr.next;
		if (index == n) {
			tail = last;
		}
	}
}
