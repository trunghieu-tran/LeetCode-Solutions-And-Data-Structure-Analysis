import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		for (char chr : tasks)
			count[chr-'A']++;
		PriorityQueue<Integer> q = new PriorityQueue<>(26, Comparator.reverseOrder());
		for (int i : count)
			if (i > 0) q.add(i);
		int res = 0;
		while (!q.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				if (!q.isEmpty()) {
					int x = q.poll() - 1;
					if (x  > 0) tmp.add(x);
				}
				res++;
				if (q.isEmpty() && tmp.size() == 0) break;
			}
			q.addAll(tmp);
		}
		return res;
	}
}
