/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SingleNumberIII {

	private  int getBit(int num, int i) {
//		return num & (1 << i);
		return (num >> i) & 1;
	}
	public int[] singleNumber(int[] nums) {
		int len = nums.length;

		int xor = 0;
		for (int i = 0; i < len; ++i)
			xor ^= nums[i];

		int posDiff = 0;
		for (int i = 0; i < 32; ++i)
			if (getBit(xor, i) == 1) {
				posDiff = i;
				break;
			}

		int xor0 = 0;
		int xor1 = 0;
		for (int i = 0; i < len; ++i)
			if (getBit(nums[i], posDiff) == 0) xor0 ^= nums[i];
			else xor1 ^= nums[i];
		return new int[]{xor0, xor1};
	}
}
