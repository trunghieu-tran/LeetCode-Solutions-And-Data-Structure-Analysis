import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; ++i)
			if (i % 3 != 0 && i % 5 != 0) res.add(Integer.toString(i));
			else
				if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
				else
					if (i % 3 == 0) res.add("Fizz");
					else res.add("Buzz");

		return res;
	}
}
