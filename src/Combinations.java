import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Combinations {


	private int getBit(int num, int i) {
		return (num >> i) & 1;
	}

	private int onBit(int num, int i) {
		return num | (1 << i);
	}
	private void recursion(int pos, int last, int n, int k, int status, int[] curr) {
		if (pos == k) {
			res.add(Arrays.stream(curr).boxed().collect(Collectors.toList()));
			return;
		}

		for (int i = last + 1; i <= n; ++i)
			if (getBit(status, i - 1) == 0) {
				curr[pos] = i;
				recursion(pos + 1, i, n, k, onBit(status, i - 1), curr);
			}
	}

	private void recursion2(int pos, int cnt, int n, int k, int[] curr) {
		if (cnt == k) {
//			res.add(new ArrayList<>(curr));
			res.add(Arrays.stream(curr).boxed().collect(Collectors.toList()));
			return;
		}

		if (pos == n) return;
		if (n - pos < k - cnt) return;

		recursion2(pos + 1, cnt, n, k, curr);

//		curr.set(cnt, pos + 1);
		curr[cnt] = pos + 1;
		recursion2(pos + 1, cnt + 1, n, k, curr);
	}

	private List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k) {
		if (n == 0 || k > n) return res;
		if (k == 0) {
			res.add(new ArrayList<>());
			return res;
		}
		int[] curr = new int[k];
//		List<Integer> curr = Arrays.asList(new Integer[k]);
//		recursion(0, 0,  n, k, 0, curr);
		recursion2(0, 0, n, k, curr);
		return res;
	}
}
