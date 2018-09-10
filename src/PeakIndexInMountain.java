/**
 * @author Harry Tran on 6/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PeakIndexInMountain {
	public int peakIndexInMountainArray(int[] A) {
		int lengthA = A.length;
		for (int i = 1; i < lengthA - 1; ++i)
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) return i;
		return 0;
	}
}
