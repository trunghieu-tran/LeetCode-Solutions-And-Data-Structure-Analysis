package Contest93;

import javafx.util.Pair;

import java.util.*;

/**
 * @author Harry Tran on 7/14/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class MinRefuelStops {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		if (stations.length == 0) {
			if (target <= startFuel) return 0;
			return -1;
		}
		if (startFuel >= target) return 0;

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int res = 0, lastPos = 0;
		for (int[] station : stations) {
			int pos = station[0];
			int fuel = station[1];

			startFuel -= (pos - lastPos);

			while (!q.isEmpty() && startFuel < 0) {
				startFuel += q.poll();
				res++;
			}
			if (startFuel < 0) return -1;
			q.offer(fuel);
			lastPos = pos;
		}

		startFuel -= target - lastPos;
		while (!q.isEmpty() && startFuel < 0) {
			startFuel += q.poll();
			++res;
		}
		if (startFuel < 0) return -1;
		return res;
	}
	public int minRefuelStops_N2(int target, int startFuel, int[][] stations) {
		if (stations.length == 0) {
			if (target <= startFuel) return 0;
			return -1;
		}

		if (startFuel >= target) return 0;

		int len = stations.length;
		long[] f = new long[len + 1]; // f[i] - furthest position using i refuel

		Arrays.fill(f, startFuel);
		for (int j = 0; j < len; ++j) {
			for (int i = j + 1; i >= 1; --i) {
				if (f[i - 1] >= stations[j][0]) {
					if (f[i] < f[i - 1] + stations[j][1]) {
						f[i] = f[i - 1] + stations[j][1];
					}
				} else break;
			}
		}
		for (int i = 0; i <= len; ++i)
			if (f[i] >= target) return i;
		return -1;
	}

	public int minRefuelStops2(int target, int startFuel, int[][] stations) {
		if (stations.length == 0) {
			if (target <= startFuel) return 0;
			return -1;
		}
		HashMap<Pair<Integer, Integer>, Integer> f = new HashMap<>();
		Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
		HashMap<Pair<Integer, Integer>, Boolean> inq = new HashMap<>();

		Pair<Integer, Integer> stp = new Pair<>(-1, startFuel);
		f.put(stp, 0);
		queue.add(stp);
		inq.put(stp, true);

		while (!queue.isEmpty()) {
			Pair<Integer, Integer> curr = queue.poll();
			inq.put(curr, false);

			int val = f.get(curr);
			int station = curr.getKey();
			int fuel = curr.getValue();
			int pos = station == -1 ? 0 : stations[station][0];

			for (int i = station + 1; i < stations.length; ++i) {
				int newPos = stations[i][0];
				if (newPos - pos <= fuel) {
					Pair<Integer, Integer> newP = new Pair<>(i, fuel - newPos + pos);
					if (!f.containsKey(newP) || f.get(newP) > val) {
						f.put(newP, val);
						if (!inq.getOrDefault(newP, false)) {
							queue.add(newP);
							inq.put(newP, true);
						}
					}
					if (fuel + pos < target) {
						int newFuel = fuel - newPos + pos + stations[i][1];
						Pair<Integer, Integer> newP2 = new Pair<>(i, newFuel);
						if (!f.containsKey(newP2) || f.get(newP2) > val + 1) {
							f.put(newP2, val + 1);
							if (!inq.getOrDefault(newP2, false)) {
								queue.add(newP2);
								inq.put(newP2, true);
							}
						}
					}
				}
			}
		}

		int res = -1;
		for (Pair<Integer, Integer> p : f.keySet()) {
			int i = p.getKey();
			int pos = 0;
			if (i != -1)
				pos = stations[p.getKey()][0];
			int fuel = p.getValue();
			int val = f.get(p);

			if (pos + fuel >= target) {
				if (res == -1 || res > val) res = val;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MinRefuelStops ms = new MinRefuelStops();
//		int target = 100;
//		int fuel = 10;
//		int[][] st = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
//		int target = 100;
//		int fuel = 50;
//		int[][] st = {{25,25},{50,50}};

//		int target = 100;
//		int fuel = 1;
//		int[][] st = {{10, 100}};

		int target = 1000000;
		int fuel = 8663;
		int[][] st =  {{31,195796},{42904,164171},{122849,139112},{172890,121724},{182747,90912},{194124,112994},{210182,101272},{257242,73097},{284733,108631},{369026,25791},{464270,14596},{470557,59420},{491647,192483},{516972,123213},{577532,184184},{596589,143624},{661564,154130},{705234,100816},{721453,122405},{727874,6021},{728786,19444},{742866,2995},{807420,87414},{922999,7675},{996060,32691}};
//		int target = 1000;
//		int fuel = 83;
//		int[][] st = {{25,27},{36,187},{140,186},{378,6},{492,202},{517,89},{579,234},{673,86},{808,53},{954,49}};
		System.out.println(ms.minRefuelStops(target, fuel, st));
	}
}
