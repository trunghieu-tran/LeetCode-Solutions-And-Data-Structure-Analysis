/**
 * @author Harry Tran on 7/20/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MyCircularQueue2 {
	int[] data;
	int last;
	int first;
	int size;
	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue2(int k) {
		data = new int[k];
		size = k;
		last = 0;
		first = 0;
	}

	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if (isFull()) return false;
		data[last++ % size] = value;
		return true;
	}

	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if (isEmpty()) return false;
		++first;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		if (isEmpty()) return -1;
		return data[first % size];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		if (isEmpty()) return -1;
		return data[(last-1) % size];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return last == first;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return last - first == size;
	}
}
