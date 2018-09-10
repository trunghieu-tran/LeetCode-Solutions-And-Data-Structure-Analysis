import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PrimeNumberOfSetBits {

	public int countPrimeSetBits(int L, int R) {
		Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3,5,7, 11, 13, 17, 19, 23));
		int res = 0;
		for (int i = L; i <= R; ++i) {
			int cnt = Integer.bitCount(i);
			if (primes.contains(cnt)) ++res;
		}
		return res;
	}
}
