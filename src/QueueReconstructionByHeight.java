import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue2(int[][] people) {
		ArrayList<Pair<Integer, Integer>> tmp = new ArrayList<>();
		for (int i = 0; i < people.length; ++i) {
			tmp.add(new Pair<>(people[i][0], people[i][1]));
		}

		Collections.sort(tmp, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				if (o1.getValue() < o2.getValue()) return -1;
				if (o1.getValue() > o2.getValue()) return 1;
				return o1.getKey().compareTo(o2.getKey());
			}
		});

		int[][] res = new int[people.length][2];
		ArrayList<Pair<Integer, Integer>> tmp2 = new ArrayList<>();
		for (int i = 0; i < tmp.size(); ++i) {
			System.out.println(Integer.toString(tmp.get(i).getKey()) + " "  + Integer.toString(tmp.get(i).getValue()));
			int cc = 0;
			int h = tmp.get(i).getKey();
			int c = tmp.get(i).getValue();
			boolean added = false;
			for (int j = 0;  j < tmp2.size(); ++j) {
				if (tmp2.get(j).getKey() >= h) ++cc;
				if (cc > c) {
					tmp2.add(j, tmp.get(i));
					added = true;
					break;
				}
			}
			if (!added) tmp2.add(tmp.get(i));
		}

		int cc = 0;
		for (Pair<Integer, Integer> p : tmp2) {
//			System.out.println(Integer.toString(p.getKey()) + " "  + Integer.toString(p.getValue()));
			res[cc][0] = p.getKey();
			res[cc][1] = p.getValue();
			++cc;
		}

		return res;
	}

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, ((o1, o2) -> (o1[0] == o2[0])? o1[1] - o2[1] : o2[0] - o1[0]));
		ArrayList<int[]> res = new ArrayList<>();
		for (int[] p : people)
			res.add(p[1], p);
		return res.toArray(new int[people.length][2]);
	}
}
