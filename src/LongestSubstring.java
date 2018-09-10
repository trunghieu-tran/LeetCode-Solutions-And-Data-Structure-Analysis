import java.util.HashMap;

/**
 * @author Harry Tran on 6/25/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0, j = 0; j < s.length(); ++j) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(i, map.get(s.charAt(j)) + 1);
			}
			map.put(s.charAt(j), j);
			res = Math.max(res, j - i + 1);
		}
		return res;
	}
}
