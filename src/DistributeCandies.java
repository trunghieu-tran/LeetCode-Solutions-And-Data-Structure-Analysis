import java.util.HashSet;
import java.util.Set;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class DistributeCandies {
	public int distributeCandies_2(int[] candies) {
		int numC = candies.length;
		Set<Integer> setC = new HashSet<>();
		for (int i = 0; i < numC; ++i)
			setC.add(candies[i]);

		return (setC.size() > numC / 2) ? numC / 2 : setC.size();
	}
	public int distributeCandies(int[] candies) {
		int numC = candies.length;
		int half = numC / 2;
		boolean[] marked = new boolean[200001];
		int cnt = 0;
		for (int i = 0; i < numC && cnt < half; ++i) {
			int ii = 100000 + candies[i];
			if (!marked[ii]) {
				marked[ii] = true;
				cnt++;
			}
		}
		return (cnt > half) ? half : cnt;
	}
}
