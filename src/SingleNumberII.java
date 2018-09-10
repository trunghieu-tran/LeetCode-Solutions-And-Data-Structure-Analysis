/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SingleNumberII {
	private int getBit(int num, int i) {
		return (num >> i) & 1;
	}

	private int onBit(int num, int i) {
		return (1 << i) | num;
	}

	public int singleNumber(int[] nums) {
		int len = nums.length;
		int res = 0;
		for (int i = 0; i < 32; ++i) {
			int sum = 0;
			for (int j = 0; j < len; ++j)
				sum += getBit(nums[j], i);
			if (sum % 3 != 0)
				res = onBit(res, i);
		}
		return res;
	}
}
