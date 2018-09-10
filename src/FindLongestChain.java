import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FindLongestChain {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
		int res = 0;
		int last = Integer.MIN_VALUE;
		int len = pairs.length;
		for (int i = 0; i < len; ++i)
			if (pairs[i][0] > last) {
				last = pairs[i][1];
				++res;
			}
		return res;
	}
	public int findLongestChain2(int[][] pairs) {
		java.util.Arrays.sort(pairs, new java.util.Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		int len = pairs.length;
//		for (int i = 0; i < len; ++i) System.out.println(Integer.toString(pairs[i][0]) +  " " + Integer.toString(pairs[i][1]));

		int[] f = new int[len];
		f[0] = 1;
		int res = 1;
		for (int i = 1; i < len; ++i) {
			f[i] = 1;
			for (int j = 0; j < i; ++j)
				if (pairs[j][1] < pairs[i][0]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			res = Math.max(res, f[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] pairs = {{9,10},{9,10},{4,5},{-9,-3},{-9,1},{0,3},{6,10},{-5,-4},{-7,-6}};
		FindLongestChain flc = new FindLongestChain();
		System.out.println(flc.findLongestChain(pairs));
	}
}
