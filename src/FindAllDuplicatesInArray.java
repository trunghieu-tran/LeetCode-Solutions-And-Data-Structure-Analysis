import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FindAllDuplicatesInArray {
	public List<Integer> findDuplicates(int[] nums) {
		ArrayList<Integer> res = new ArrayList<>();
//		[4,3,2,7,8,2,3,1]
		/*
			ix = 3;
			[4,3,2,-7,8,2,3,1]
			idx = 2
			[4,3,-2,-7,8,2,3,1]
			idx = 1
			[4,-3,-2,-7,8,2,3,1]
			idx = 6
			[4,-3,-2,-7,8,2,-3,1]
			idx = 7
			[4,-3,-2,-7,8,2,-3,-1]
			idx = 1
			[4,-3,-2,-7,8,2,-3,-1] => add to res ...
		 */
		int leng = nums.length;
		for (int i = 0; i < leng; ++i) {
			int idx = Math.abs(nums[i]) - 1;
			if (nums[idx] < 0) res.add(idx + 1);
			else
				nums[idx] *= -1;
		}
		return res;
	}
}
