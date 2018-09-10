package Contest93;

import java.util.ArrayList;

/**
 * @author Harry Tran on 7/14/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ReorderedPowerOf2 {

	private boolean isMatch(int N, long x) {
		//System.out.println(Integer.toString(N) + " " + Long.toString(x));
		int[] c = new int[10];
		while (N > 0) {
			c[N % 10]++;
			N /= 10;
		}
		while (x > 0) {
			long mod = x;
			mod = mod % 10;
			c[(int) mod]--;
			x /= 10;
		}
		for (int i = 0; i < 10; ++i)
			if (c[i] != 0) return false;
		//System.out.println(x);
		return true;
	}

	public boolean reorderedPowerOf2(int N) {
		ArrayList<Long> data = new ArrayList<>();
		double x = 2.0;
		for (int i = 0; i < 40; ++i) {
			long tmp = (long) Math.pow(x, (double) i);
			data.add(tmp);
		}
		for (int i = 0; i < data.size(); ++i) {
			if (isMatch(N, data.get(i))) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ReorderedPowerOf2 r = new ReorderedPowerOf2();
		System.out.println(r.reorderedPowerOf2(123456789));
	}
}
