import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Harry Tran on 6/25/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class TwoSum {
	public static  int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < nums.length; ++i) {
			if (hashMap.containsKey(nums[i])) {
				return new int[]{i, hashMap.get(nums[i])};
			} else
			hashMap.put(target - nums[i], i);
		}

		return new int[]{};
	}

	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 11, 15};
		int[] res = TwoSum.twoSum(nums, 9);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
