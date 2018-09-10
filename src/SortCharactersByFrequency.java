import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SortCharactersByFrequency {
	public static  String frequencySort(String s) {
		int[] count = new int[130];
		for (char c : s.toCharArray())
			count[c]++;
		List<Pair<Integer, Integer>> list = new ArrayList<>();
		for (int i = 0; i < 130; ++i)
			if (count[i] > 0) list.add(new Pair<>(count[i], i));
		list.sort(new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				return o2.getKey().compareTo(o1.getKey());
			}
		});
		int len = list.size();
		StringBuilder res = new StringBuilder();
		char[] cc = new char[s.length()];
		int cnt = 0;

		for (int i = 0; i < len; ++i) {
			int num = list.get(i).getKey();
			char c = (char) list.get(i).getValue().intValue();
			for (int j = 0; j < num; ++j)
				cc[cnt++] = c;
//				res.append(c);
		}
//		return res.toString();
		return String.valueOf(cc);
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 500000; ++i)
			sb.append("ab");
		System.out.println(sb.length());
		System.out.println(SortCharactersByFrequency.frequencySort(sb.toString()));
	}
}
