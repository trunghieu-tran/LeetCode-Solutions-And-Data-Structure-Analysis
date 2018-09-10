import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PartitionLabels {
	public List<Integer> partitionLabels_1(String S) {
		HashMap<Character, Integer> map = new HashMap<>();
		int lengthS = S.length();
		for (int i = lengthS - 1; i >= 0; --i) {
			if (map.containsKey(S.charAt(i))) continue;
			map.put(S.charAt(i), i);
		}
		int begin = 0;
		int last = 0;
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < lengthS; ++i) {
			int newLast = map.get(S.charAt(i));
			if (newLast <= i && last <= i) {
				res.add(last - begin + 1);
				begin = i + 1;
				last = i + 1;
			} else {
				last = Math.max(last, newLast);
			}
		}
		return res;
	}

	public List<Integer> partitionLabels_2(String S) {
		int[] pos = new int[26];

		int lengthS = S.length();
		for (int i = 0; i < lengthS; ++i)
			pos[S.charAt(i) - 'a'] = i;

		int begin = 0;
		int last = 0;
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < lengthS; ++i) {
			last = Math.max(last, pos[S.charAt(i) - 'a']);
			if (last == i) {
				res.add(last - begin + 1);
				begin = i + 1;
			}
		}
		return res;
	}
}
