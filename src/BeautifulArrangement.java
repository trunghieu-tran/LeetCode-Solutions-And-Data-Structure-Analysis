/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BeautifulArrangement {

	private int getBit(int num, int i) {
		return (num >> i) & 1;
	}

	private int onBit(int num, int i) {
		return num | (1 << i);
	}

	int res = 0;

	private void recursion(int pos, int status, int N) {
		if (pos == N) {
			++res;
			return;
		}
		for (int i = 0;  i < N; ++i)
			if (getBit(status, i) == 0) {
				int numI = i + 1;
				int posI = pos + 1;
				if (numI % posI == 0 || posI % numI == 0)
					recursion(pos + 1, onBit(status, i), N);
			}
	}

	public int countArrangement(int N) {
		if (N == 0) return 1;
		recursion(0, 0, N);
		return res;
	}
}
