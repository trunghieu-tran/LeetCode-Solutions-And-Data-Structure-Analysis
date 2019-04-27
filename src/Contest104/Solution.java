package Contest104;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 9/29/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Solution {
	public List<String> wordSubsets(String[] A, String[] B) {
		int[] cntB = new int[26];
		for (String s : B) {
			int[] cntTemp = new int[26];
			for (char c : s.toCharArray()) {
				cntTemp[c - 'a']++;
			}
			for (int i = 0; i < 26; ++i)
				cntB[i] = Math.max(cntB[i], cntTemp[i]);
		}
		List<String> res = new ArrayList<>();
		for (String s : A) {
			int[] cntTemp = new int[26];
			for (char c : s.toCharArray()) {
				cntTemp[c - 'a']++;
			}
			boolean ok = true;
			for (int i = 0; i < 26; ++i)
				ok &= cntTemp[i] >= cntB[i];
			if (ok) res.add(s);
		}
		return res;
	}

	int[][][] f;

	private int find(int i, int j, boolean turnMouse, int[][] graph) {
		if (i == 0) return 1;
		if (i == j) return 2;

		if (turnMouse) {
			if (f[i][j][0] != 0) return f[i][j][0];

			boolean hasHole = false;
			for (int x : graph[i]) {
				hasHole |= (x == 0);
			}
			if (hasHole) {
				f[i][j][0] = 1;
				return 1;
			}

			boolean[] tmp = new boolean[3];
			for (int x : graph[i]) {
				if (x == j) continue;
				int rr = find(x, j, false, graph);
				tmp[rr] = true;
			}
			f[i][j][0] = 3;
			if (tmp[1] && !tmp[0] && !tmp[2]) f[i][j][0] = 1;
			if (tmp[2] && !tmp[0] && !tmp[1]) f[i][j][0] = 2;

			return f[i][j][0];
		} else {
			if (f[i][j][1] != 0) return f[i][j][1];

			boolean meet = false;
			for (int x : graph[j]) {
				meet |= (x == i);
			}
			if (meet) {
				f[i][j][1] = 2;
				return 2;
			}

			boolean[] tmp = new boolean[3];
			for (int x : graph[j]) {
				if (x == 0) continue;
				int rr = find(i, x, true, graph);
				tmp[rr] = true;
			}
			f[i][j][1] = 3;
			if (tmp[1] && !tmp[0] && !tmp[2]) f[i][j][1] = 1;
			if (tmp[2] && !tmp[0] && !tmp[1]) f[i][j][1] = 2;

			return f[i][j][1];
		}
	}

	public int catMouseGame(int[][] graph) {
		int n = graph.length;
		f = new int[n][n][2];
		// f[i][j] : mouse at i, cat at j
		int resM = find(1, 2, true, graph);
		if (resM == 3) return 0;
		else return resM;
	}

	public static void main(String[] args) {
		System.out.println("hi");
	}
}
