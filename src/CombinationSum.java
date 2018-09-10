import javafx.util.Pair;

import java.util.*;

/**
 * @author Harry Tran on 7/4/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class CombinationSum {

//	Map<Pair<Integer, Integer>, List<List<Integer>>> map = new HashMap<>();
//
//	private List<List<Integer>> getCombinationSum(int[] candidates, int target, int pos, ArrayList<Integer> curr) {
//		Pair<Integer, Integer> p = new Pair<>(target, pos);
//
//		if (map.containsKey(p)) return map.get(p);
//
//
//		for (int i = 0; i <= target / candidates[pos]; ++i) {
//			int tmp = i * candidates[pos];
//			for (int j = 0; j < i; ++j) curr.add(candidates[pos]);
//
//			for (int j = 0; j < i; ++j) curr.remove(curr.size() - 1);
//		}
//	}
//
//	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//		if (candidates.length == 0) {
//			return new ArrayList<>();
//		}
//		Arrays.sort(candidates);
//		return getCombinationSum(candidates, target, 0, new ArrayList<>());
//	}



	// === ver 1

	List<List<Integer>> res = new ArrayList<>();
	HashMap<Pair<Integer, Integer>, Boolean> map = new HashMap<>();

	private boolean getCombination(int[] candidates, int pos, int target, ArrayList<Integer> curr) {
		if (target == 0) {
			res.add(new ArrayList<>(curr));
			map.put(new Pair<>(pos, target), true);
			return true;
		}
		if (pos == candidates.length) {
			map.put(new Pair<>(pos, target), false);
			return false;
		}
		if (target < candidates[pos]) {
			map.put(new Pair<>(pos, target), false);
			return false;
		}

		boolean solved = false;
		for (int i = 0; i <= target / candidates[pos]; ++i) {
			int tmp = i * candidates[pos];

			boolean needSolved = map.getOrDefault(new Pair<>(pos + 1, target - tmp), true);
			if (!needSolved) continue;

			for (int j = 0; j < i; ++j) curr.add(candidates[pos]);
			solved |= getCombination(candidates, pos + 1, target - tmp, curr);
			for (int j = 0; j < i; ++j) curr.remove(curr.size() - 1);
		}
		map.put(new Pair<>(pos, target), solved);
		return solved;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0) {
			return new ArrayList<>();
		}
		Arrays.sort(candidates);
		getCombination(candidates, 0, target, new ArrayList<>());
		return res;
	}
}
