import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Harry Tran on 7/15/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MyCircularDeque {
	Deque<Integer> data;
	int capability;

	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque(int k) {
		data = new ArrayDeque<>(k);
		capability = k;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if (isFull()) return false;
		try {
			data.addFirst(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if (isFull()) return false;
		try {
			data.addLast(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (isEmpty()) return false;
		try {
			data.removeFirst();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (isEmpty()) return false;
		try {
			data.removeLast();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/** Get the front item from the deque. */
	public int getFront() {
		if (isEmpty()) return -1;
		try {
			return data.getFirst();
		} catch (Exception e) {
			return -1;
		}
	}

	/** Get the last item from the deque. */
	public int getRear() {
		if (isEmpty()) return -1;
		try {
			return data.getLast();
		} catch (Exception e) {
			return -1;
		}

	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return data.size() == capability;
	}
}
