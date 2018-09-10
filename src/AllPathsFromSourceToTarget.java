import java.util.*;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class AllPathsFromSourceToTarget {
	private void dfs(int node, int[][] graph, Stack<Integer> trace,
	                 List<List<Integer>> result) {
		if (node == graph.length - 1) {
			result.add(new ArrayList<>(trace));
			return;
		}

		for (int i = 0; i < graph[node].length; ++i) {
			int nextNode = graph[node][i];

			trace.push(nextNode);

			dfs(nextNode, graph, trace, result);

			trace.pop();
		}

	}
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		Stack<Integer> trace = new Stack<>();

		trace.push(0);
		dfs(0, graph, trace, res);
		return res;
	}
}
