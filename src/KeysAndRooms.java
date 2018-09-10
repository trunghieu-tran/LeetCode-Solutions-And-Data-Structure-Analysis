import java.util.List;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class KeysAndRooms {

	private void traverse(int curr, boolean[] marked, List<List<Integer>> rooms) {
		for (int i = 0; i < rooms.get(curr).size(); ++i) {
			int next = rooms.get(curr).get(i);
			if (!marked[next]) {
				marked[next] = true;
				traverse(next, marked, rooms);
			}
		}
	}
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int start = 0;
		boolean[] marked = new boolean[rooms.size()];
		marked[0] = true;
		traverse(0, marked, rooms);
		for (int i = 0; i < rooms.size(); ++i)
			if (!marked[i]) return false;
		return true;
	}
}
