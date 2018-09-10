package Contest94;

/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class KokoEatingBananas {
//	1 <= piles.length <= 10^4
//	piles.length <= H <= 10^9
//	1 <= piles[i] <= 10^9

	private boolean isOK(int[] piles, int H, int val) {
		int cc = 0;
		for (int i = 0; i < piles.length; ++i) {
			cc += piles[i] / val;
			if (piles[i] % val != 0) ++cc;
		}
		return cc <= H;
	}

	public int minEatingSpeed(int[] piles, int H) {
		int vmax = Integer.MAX_VALUE - 2;
		int vmin = 1;

		int res = vmax;
		while (vmin <= vmax) {
			int mid = (vmax + vmin) / 2;
			if (isOK(piles, H, mid)) {
				res = mid;
				vmax = mid - 1;
			} else vmin = mid + 1;
		}
		return res;
	}
}
