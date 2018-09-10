import java.util.Arrays;

/**
 * @author Harry Tran on 7/11/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class UniqueBinarySearchTrees {

	int[][] f = new int[100][100];
	private int find(int vmin, int vmax) {
		if (vmin >= vmax) return 1;
		if (f[vmin][vmax] != -1) return f[vmin][vmax];

		int res = 0;
		for (int i = vmin; i <= vmax; ++i) {
			int left = find(vmin, i - 1);
			int right = find(i + 1, vmax);
			res += left * right;
		}
		f[vmin][vmax] = res;
		return res;
	}

	public int numTrees(int n) {
		if (n == 0) return 1;

		for (int i = 0; i < 100; ++i) {
			Arrays.fill(f[i], -1);
		}

		return find(1, n);
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
		System.out.println(u.numTrees(3));
	}
}
