import java.util.*;
/**
 * @author Harry Tran on 6/29/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ArrayPartition {
	public int arrayPairSum(int[] nums) {
		int res = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i+=2) {
			res += nums[i];
		}
		return res;
	}
}
