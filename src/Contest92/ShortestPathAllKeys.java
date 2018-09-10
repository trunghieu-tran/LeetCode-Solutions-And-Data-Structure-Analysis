package Contest92;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Harry Tran on 7/7/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ShortestPathAllKeys {

	int[][][] f = new int[33][33][66];
	HashMap<Character, Integer> map = new HashMap<>();
	int done;
	private boolean isOk(int x, int y, String[] grid) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length()) return false;
		return grid[x].charAt(y) != '#';
	}

	private int getBit(int num, int i) {
		return (num >> i) & 1;
	}

	private int onBit(int num, int i) {
		return num | (1 << i);
	}

	int[] hh = {-1, 0, 0, 1};
	int[] cc = {0, -1, 1, 0};

	private void dfs(int x, int y, int status, String[] grid) {
		// int[] : x, y, status
		Queue<Integer[]> queue = new LinkedList<>();
		HashMap<Integer[], Boolean> inqueue = new HashMap<>();

		Integer[] tmp = new Integer[]{x, y, status};
		queue.add(tmp);
		inqueue.put(tmp, true);

		while (!queue.isEmpty()) {
			Integer[] curr = queue.poll();
			x = curr[0];
			y = curr[1];
			status = curr[2];
			inqueue.put(curr, false);

			for (int k = 0; k < 4; ++k) {
				int xx = x + hh[k];
				int yy = y + cc[k];
				if (!isOk(xx, yy, grid)) continue;
				char chr = grid[xx].charAt(yy);
				if ('a' <= chr && chr <= 'z') {
					int bit = map.get(chr);
					int newStatus = onBit(status, bit);
					Integer[] tmpNext = new Integer[]{xx, yy, newStatus};
					if (f[xx][yy][newStatus] > f[x][y][status] + 1) {
						f[xx][yy][newStatus] = f[x][y][status] + 1;
						if (!inqueue.getOrDefault(tmpNext, false)) {
							inqueue.put(tmpNext, true);
							queue.add(tmpNext);
						}
					}

				} else
				if ('A' <= chr && chr <= 'Z') {
					int bit = map.get(Character.toLowerCase(chr));
					if (getBit(status, bit) == 0) continue;
					Integer[] tmpNext = new Integer[]{xx, yy, status};
					if (f[xx][yy][status] > f[x][y][status] + 1) {
						f[xx][yy][status] = f[x][y][status] + 1;
						if (!inqueue.getOrDefault(tmpNext, false)) {
							inqueue.put(tmpNext, true);
							queue.add(tmpNext);
						}
					}


				}
				else if (chr == '.' || chr == '@') {
					Integer[] tmpNext = new Integer[]{xx, yy, status};
					if (f[xx][yy][status] > f[x][y][status] + 1) {
						f[xx][yy][status] = f[x][y][status] + 1;
						if (!inqueue.getOrDefault(tmpNext, false)) {
							inqueue.put(tmpNext, true);
							queue.add(tmpNext);
						}
					}
				}
			}
		}

	}

	public int shortestPathAllKeys(String[] grid) {
		for (int i = 0; i < 33; ++i)
			for (int j = 0; j < 33; ++j)
				for (int k = 0; k < 66; ++k)
					f[i][j][k] = 1000000000;
		int x = 0, y = 0;
		int cc = 0;
		for (int i = 0; i < grid.length; ++i)
			for (int j = 0; j < grid[0].length(); ++j) {
				char chr = grid[i].charAt(j);
				if (chr == '@') {
					x = i;
					y = j;
					f[x][y][0] = 0;
				}
				if ('a' <= chr && chr <= 'z') {
					map.put(chr, cc++);
				}
			}

		done = (1 << cc) - 1;
		dfs(x, y, 0, grid);


		int res = -1;
		for (int i = 0; i < grid.length; ++i)
			for (int j = 0; j < grid[0].length(); ++j)
				if (f[i][j][done] != 1000000000) {
					if (res == -1) res = f[i][j][done];
					else res = Math.min(res, f[i][j][done]);
				}
		return res;
	}

	public static void main(String[] args) {
		ShortestPathAllKeys sp = new ShortestPathAllKeys();
		String[] grid = new String[]{"@...a",".###A","b.BCc"};
		System.out.println(sp.shortestPathAllKeys(grid));
	}
}
