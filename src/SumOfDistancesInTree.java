import java.util.*;

/**
 * @author Harry Tran on 7/9/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SumOfDistancesInTree {
	List<Set<Integer>> nextNodes = new ArrayList<>();
	List<Set<Integer>> nextNodes2 = new ArrayList<>();
	int[] nChild;
	int[] res;
	int N;
	private void traverse(int u, int parent) {
		for (int v : nextNodes.get(u))
			if (v != parent) {
				nextNodes2.get(u).add(v);
				traverse(v, u);
				nChild[u] += nChild[v];
				res[u] += res[v] + nChild[v]; // res[v] - result for subtree v
			}
	}

	private void traverse2(int u) {
		for (int v : nextNodes2.get(u))
			{
				res[v] = res[u] - nChild[v] + (N - nChild[v]);
				traverse2(v);
			}
	}

	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		res = new int[N];

		if (N == 1) {
			res[0] = 0;
			return res;
		}

		for (int i = 0; i < N; ++i) {
			nextNodes.add(new HashSet<>());
			nextNodes2.add(new HashSet<>());
		}

		for (int[] e : edges) {
			nextNodes.get(e[0]).add(e[1]);
			nextNodes.get(e[1]).add(e[0]);
		}
		this.N = N;
		nChild = new int[N];
		Arrays.fill(nChild, 1);

		traverse(0, -1);
		traverse2(0);
		return res;
	}
}
