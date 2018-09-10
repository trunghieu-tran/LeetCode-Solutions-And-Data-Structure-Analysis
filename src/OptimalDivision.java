/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class OptimalDivision {
	public String optimalDivision(int[] nums) {
		int len = nums.length;
		if (len == 1) return nums[0] + "";
		if (len == 2) return nums[0] + "/" + nums[1];
		String res = nums[0] + "/(" + nums[1];
		for (int i = 2; i < len; ++i)
			res += "/" + nums[i];
		res += ")";
		return res;
	}
}
