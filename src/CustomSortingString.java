import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class CustomSortingString {
	public String customSortString_2(String S, String T) {
		int[] count = new int[26];
		for (char chr : T.toCharArray()) {
			count[chr - 'a']++;
		}
		ArrayList<Pair<Integer, Character>> list = new ArrayList<>();
		int lenS = S.length();
		for (int i = 0; i < lenS; ++i)
			list.add(new Pair<>(i, S.charAt(i)));
//		list.sort(Comparator.comparingInt(Pair::getKey));
		Collections.sort(list, new Comparator<Pair<Integer, Character>>() {
			@Override
			public int compare(Pair<Integer, Character> o1, Pair<Integer, Character> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});

		StringBuilder res = new StringBuilder();

		for (Pair<Integer, Character> p : list) {
			 System.out.println(Integer.toString(p.getKey()) + " " + p.getValue());
			char c = p.getValue();
			for (int i = 0; i < count[c - 'a']; ++i)
				res.append(c);
			count[c - 'a'] = 0;
		}
		for (char ch = 'a'; ch <= 'z'; ++ch)
			if (count[ch - 'a'] > 0) {
				for (int i = 0; i < count[ch - 'a']; ++i)
					res.append(ch);
			}
		return res.toString();
	}

	public String customSortString(String S, String T) {
		int[] count = new int[26];
		for (char chr : T.toCharArray()) {
			count[chr - 'a']++;
		}

		StringBuilder res = new StringBuilder();
		for (char chr : S.toCharArray()) {
			int pos = chr - 'a';
			for (int i = 0; i < count[pos]; ++i)
				res.append(chr);
			count[pos] = 0;
		}

		for (int i = 0; i < 26; ++i)
			if (count[i] > 0) {
				for (int j = 0; j < count[i]; ++j)
					res.append((char) (i + 'a'));
			}
		return res.toString();
	}
}
