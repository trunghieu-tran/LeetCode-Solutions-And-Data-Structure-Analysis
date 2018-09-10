import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 6/28/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SelfDividingNum {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList<>();
		for (int i = left; i <= right; ++i) {
			int j = i;
			boolean isOk = true;
			while (j > 0 && isOk) {
				int xmod = j % 10;
				isOk &= ((xmod != 0) && (i % xmod == 0));
				j /= 10;
			}
			if (isOk) res.add(i);
		}
		return res;
	}
}
