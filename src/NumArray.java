/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class NumArray {
	int[] f;
	public NumArray(int[] nums) {
		int len = nums.length;
		f = new int[len];
		if (len == 0) return;
		f[0] = nums[0];
		for (int i = 1; i < len; ++i)
			f[i] = f[i - 1] + nums[i];
	}

	public int sumRange(int i, int j) {
		if (f.length == 0) return 0;
		if (i < 0) i = 0;
		if (j >= f.length) j = f.length - 1;
		if (i == 0) return f[j];
		else return f[j] - f[i - 1];
	}
}
