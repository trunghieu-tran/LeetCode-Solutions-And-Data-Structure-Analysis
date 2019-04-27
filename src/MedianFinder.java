import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Harry Tran on 9/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MedianFinder {
	Queue<Integer> maxLow;
	Queue<Integer> minHi;
	/** initialize your data structure here. */
	public MedianFinder() {
		maxLow = new PriorityQueue<>();
		minHi = new PriorityQueue<>(Comparator.reverseOrder());
	}

	private void balance() {
		while (maxLow.size() < minHi.size()) {
			maxLow.offer(minHi.poll());
		}
		while (maxLow.size() > minHi.size() + 1) {
			minHi.offer(maxLow.poll());
		}
	}

	public void addNum(int num) {
		if (maxLow.isEmpty()) {
			maxLow.add(num);
		} else
			if (minHi.isEmpty()) {
				minHi.add(num);
			} else {
				int vmaxL = maxLow.peek();
				if (num <= vmaxL) maxLow.offer(num);
				else minHi.offer(num);
			}
		balance();
	}

	public double findMedian() {
		double res = 0.0;
		if (maxLow.size() > 0) {
			if (maxLow.size() == minHi.size())
				res = (maxLow.peek() + minHi.peek()) / 2;
			else
				res = maxLow.peek();
		}
		return res;
	}
}
