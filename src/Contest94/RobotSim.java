package Contest94;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Harry Tran on 7/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class RobotSim {

	int res = 0;
	HashMap<Integer, ArrayList<Integer>> mapX = new HashMap<>();
	HashMap<Integer, ArrayList<Integer>> mapY = new HashMap<>();
	int dir = 2;
	int cx = 0, cy = 0;

	private int changeDir(int cmd, int dir) {
		if (cmd == -2) {
			if (dir == 2) return 0;
			if (dir == 0) return 1;
			if (dir == 1) return 3;
			return 2;
		} else {
			if (dir == 2) return 3;
			if (dir == 3) return 1;
			if (dir == 1) return 0;
			return 2;
		}
	}

	private int findMinBiggerVal(int val, ArrayList<Integer> arr) {
		int l = 0;
		int r = arr.size() - 1;
		int res = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr.get(mid) > val) {
				res = mid;
				r = mid - 1;
			} else l = mid + 1;
		}
		return res;
	}

	private int findMaxSmallerVal(int val, ArrayList<Integer> arr) {
		int l = 0;
		int r = arr.size() - 1;
		int res = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr.get(mid) < val) {
				res = mid;
				l = mid + 1;
			} else r = mid - 1;
		}
		return res;
	}

	private void go(int cmd) {
		if (dir == 2) {
			ArrayList<Integer> arr = mapX.getOrDefault(cx, null);
			if (arr == null) {
				cy += cmd;
			} else {
				int id = findMinBiggerVal(cy, arr);
				if (id == -1) {
					cy += cmd;
				} else {
					cy += Math.min(cmd, arr.get(id) - cy - 1);
				}
			}

		}
		if (dir == 1) {
			ArrayList<Integer> arr = mapX.getOrDefault(cx, null);
			if (arr == null) {
				cy -= cmd;
			} else {
				int id = findMaxSmallerVal(cy, arr);
				if (id == -1) {
					cy -= cmd;
				} else {
					cy -= Math.min(cmd, cy - arr.get(id) - 1);
				}
			}
		}
		if (dir == 0) {
			ArrayList<Integer> arr = mapY.getOrDefault(cy, null);
			if (arr == null) {
				cx -= cmd;
			} else {
				int id = findMaxSmallerVal(cx, arr);
				if (id == -1) {
					cx -= cmd;
				} else {
					cx -= Math.min(cmd, cx - arr.get(id) - 1);
				}
			}
		}

		if (dir == 3) {
			ArrayList<Integer> arr = mapY.getOrDefault(cy, null);
			if (arr == null) {
				cx += cmd;
			} else {
				int id = findMinBiggerVal(cx, arr);
				if (id == -1) {
					cx += cmd;
				} else {
					cx += Math.min(cmd, arr.get(id) - cx - 1);
				}
			}
		}

		res = Math.max(res, cx * cx + cy * cy);
	}

	public int robotSim(int[] commands, int[][] obstacles) {

		for (int[] ob : obstacles) {
			int xx = ob[0];
			int yy = ob[1];
			if (mapX.containsKey(xx))
				mapX.get(xx).add(yy);
			else {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(yy);
				mapX.put(xx, tmp);
			}

			if (mapY.containsKey(yy))
				mapY.get(yy).add(xx);
			else {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(xx);
				mapY.put(yy, tmp);
			}
		}

		for (int key : mapX.keySet()) {
			Collections.sort(mapX.get(key));
		}

		for (int key : mapY.keySet()) {
			Collections.sort(mapY.get(key));
		}



		for (int cmd : commands) {
			if (cmd < 0) {
				dir = changeDir(cmd, dir);
			} else {
				go(cmd);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		RobotSim ts = new RobotSim();
		int[] cmds = {-2, 8,3,7, -1};
		int[][] obs = {{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
		System.out.println(ts.robotSim(cmds, obs));
	}
}
