import java.util.HashMap;

/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;

		if (nums1.length == 0) return nums1;

		HashMap<Integer, Integer> next = new HashMap<>();

		next.put(nums2[len2 - 1], -1);

		for (int i = len2 - 2; i >= 0; --i) {
			int j = nums2[i + 1];
			while (j != -1 && nums2[i] > j) j = next.getOrDefault(j, -1);
			next.put(nums2[i], j);
		}

		int[] res = new int[len1];
		for (int i = 0; i < len1; ++i)
			res[i] = next.getOrDefault(nums1[i], -1);
		return res;
	}
}
