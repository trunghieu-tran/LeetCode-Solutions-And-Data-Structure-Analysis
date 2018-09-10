/**
 * @author Harry Tran on 7/15/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class LargestTriangleArea {
	private double getArea(int[] p1, int[] p2, int[] p3) {
		return Math.abs(0.5 * (p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1])));
	}
	public double largestTriangleArea(int[][] points) {
		double res = 0.0;

		int len = points.length;
		for (int i = 0; i < len - 2; ++i)
			for (int j = i + 1; j < len - 1; ++j)
				for (int k = j + 1; k < len; ++k)
					res = Math.max(res, getArea(points[i], points[j], points[k]));
		return res;
	}
}
