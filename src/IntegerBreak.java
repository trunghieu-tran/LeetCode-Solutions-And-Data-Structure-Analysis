/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class IntegerBreak {

	public int integerBreak(int n) {
		if (n == 2) return 1;
		if (n == 3) return 2;
		if (n == 4) return 4;

		double res = n;
		for (int i = 0; i <= n / 3; ++i) {
			int x = i * 3;
			int y = n - x;
			if (y % 2 != 0) continue;
			double t2 = Math.pow(2.0, y / 2);
			double t3 = Math.pow(3.0, i);
			res = Math.max(res, (int) t2 * t3);
		}
		return (int) res;
	}
}
