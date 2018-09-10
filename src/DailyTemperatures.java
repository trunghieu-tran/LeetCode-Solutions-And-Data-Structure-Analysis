/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length;

		if (len == 0) return new int[0];

		int[] next = new int[len];

		next[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			int j = i + 1;

			while (j < len && j != 0 && temperatures[i] >= temperatures[j]) j = next[j];

			if (j == 0) next[i] = 0;
			else next[i] = j;

			next[i] = j;
		}

		int[] res = new int[len];
		for (int i = 0; i < len; ++i)
			if (next[i] != 0) res[i] = next[i] - i;
		return res;
	}
}
