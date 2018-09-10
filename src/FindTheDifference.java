/**
 * @author Harry Tran on 7/10/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		int[] cnt = new int[26];
		for (char c : t.toCharArray())
			cnt[c - 'a']++;
		for (char c : s.toCharArray())
			cnt[c - 'a']--;

		for (int i = 0; i < 26; ++i)
			if (cnt[i] < 0) return (char) (i + 48);
		return 'a';
	}
}
