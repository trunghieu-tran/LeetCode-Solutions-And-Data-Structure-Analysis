import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Tran HIeu", 1);
		int x = 10;
		int y = 20;
		String s = x + " " + y;
		System.out.println(s);
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null  || headB == null) return null;

		Info fa = getInfo(headA);
		Info fb = getInfo(headB);

		if (fa.tail != fb.tail) return null;

		ListNode shorter = fa.size > fb.size ? headB : headA;
		ListNode longer  = fa.size > fb.size ? headA : headB;

		longer = gotoKthNode(longer, Math.abs(fa.size - fb.size));

		while (longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(10);
		q.poll();
		List<Integer> l = new LinkedList<>();
		l.iterator();
		l.isEmpty();

		return shorter;
	}

	private ListNode gotoKthNode(ListNode n, int k) {
		for (int i = 0; i < k; ++i) {
			n = n.next;
		}
		return n;
	}

	private Info getInfo(ListNode n) {
		int size = 1;
		ListNode curr = n;
		while (curr.next != null) {
			curr = curr.next;
			++size;
		}
		return new Info(curr, size);
	}
}

class Info {
	public ListNode tail;
	public int size;
	public Info(ListNode tail, int size){
		this.tail = tail;
		this.size = size;
	}
}