import javafx.util.Pair;

import java.util.*;

/**
 * @author Harry Tran on 10/20/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int val = nums[i] + nums[j];
				if (!map.containsKey(val)) {
					map.put(val, new ArrayList<>());
				}
				map.get(val).add(new Pair<>(i, j));
			}
		}

		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int val = target - nums[i] - nums[j];

				if (map.containsKey(val)) {
					List<Pair<Integer, Integer>> pairs = map.get(val);
					for (Pair<Integer, Integer> p : pairs) {

						if (i == p.getKey() || i == p.getValue() ||
								j == p.getKey() || j == p.getValue()) continue;
						List<Integer> r = Arrays.asList(nums[p.getKey()], nums[p.getValue()], nums[i], nums[j]);
						Collections.sort(r);
						res.add(r);
					}
				}
			}
		}

		Collections.sort(res, new Comparator<List<Integer>>() {

			public int compare(List<Integer> l1, List<Integer> l2) {
				for (int i = 0; i < l1.size(); ++i)
					if (!Objects.equals(l1.get(i), l2.get(i)))
						return l1.get(i) - l2.get(i);
				return 0;
			}

		});
		for (List<Integer> l : res) {
			for (int x : l)
				System.out.print(Integer.toString(x) +  " ");
			System.out.println();
		}
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < res.size(); ++i) {
			// // [98,218,352,389]
			// if (res.get(i).get(0) == 98 && res.get(i).get(1) == 218 ) {
			//     for (int x : res.get(i))
			//         System.out.print(x);
			//     System.out.println();
			// }
			if (i == 0 || ans.isEmpty() || compare2List(res.get(i), ans.get(ans.size() - 1)) != 0) {
				ans.add(res.get(i));
			}
		}
		return ans;
	}
	public int compare2List(List<Integer> l1, List<Integer> l2) {
		for (int i = 0; i < l1.size(); ++i)
			if (!Objects.equals(l1.get(i), l2.get(i)))
				if (l1.get(i) < l2.get(i)) return -1;
				else return 1;
		// return l1.get(i) - l2.get(i);
		return 0;
	}

	public static void main(String[] args) {
		FourSum f = new FourSum();
		int[] arr = {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485};
		int target = 1057;
		List<List<Integer>> res = f.fourSum(arr, target);
		for (List<Integer> l : res) {
			for (int x : l) System.out.print(Integer.toString(x) + " ");
			System.out.println();
		}
	}
}
