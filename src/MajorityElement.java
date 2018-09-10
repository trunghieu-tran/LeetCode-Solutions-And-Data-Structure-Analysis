import java.util.HashMap;
import java.util.Map;

/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int len = nums.length;
		for (int i = 0; i < len; ++i)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		for (int key : map.keySet())
			if (map.get(key) > len / 2) return key;
		return 0;
	}
}
