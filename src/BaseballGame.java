import java.util.ArrayList;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BaseballGame {
	public int calPoints(String[] ops) {
		ArrayList<Integer> points = new ArrayList<>();
		for (String str : ops) {
			int currSize = points.size();
			if (str.equals("+")) {
				points.add(points.get(currSize - 1) + points.get(currSize - 2));
			} else if (str.equals("D")) {
				points.add(points.get(currSize - 1) * 2);
			} else if (str.equals("C")) {
				points.remove(currSize - 1);
			} else {
				int point = Integer.parseInt(str);
				points.add(point);
			}
		}
		int sum = 0;
		for (int i : points) sum += i;
		return sum;
	}
}
