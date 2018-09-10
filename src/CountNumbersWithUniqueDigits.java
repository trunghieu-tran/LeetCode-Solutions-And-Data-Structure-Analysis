/**
 * @author Harry Tran on 7/15/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class CountNumbersWithUniqueDigits {

	private int getBit(int num, int i) {
		return (num >> i) & 1;
	}

	private int onBit(int num, int i) {
		return num | (1 << i);
	}

	int[][][] f;
	int n;
	private int count(int pos, int status, int bigger0) {
		if (pos == n) {
			return 1;
		}
		if (f[pos][status][bigger0] != -1) return f[pos][status][bigger0];

		int res = 0;

		if (bigger0 == 1) {
			if (getBit(status, 0) == 0) {
				res += count(pos + 1, onBit(status, 0), 1);
			}
		} else {
			res += count(pos + 1, status, 0);
		}

		for (int i = 1; i < 10; ++i) {
			if (getBit(status, i) == 0) {
				res += count(pos + 1, onBit(status, i), 1);
			}
		}

		f[pos][status][bigger0] = res;
		return res;
	}

	public int countNumbersWithUniqueDigits(int n) {
		f = new int[n + 1][1024][2];
		for (int i = 0; i < n + 1; ++i)
			for (int j = 0; j < 1024; ++j)
				for (int k = 0; k < 2; ++k)
					f[i][j][k] = -1;
		this.n = n;
		return count(0, 0, 0);
	}
}
