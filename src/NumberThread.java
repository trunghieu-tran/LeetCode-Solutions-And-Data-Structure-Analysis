import java.util.List;

/**
 * @author Harry Tran on 10/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */

public class NumberThread extends FizzBuzzThread {
	public NumberThread(boolean div3, boolean div5, int max, List<String> res) {
		super(div3, div5, max, null, res);
	}
	public void addToRes() {
		res.add(String.valueOf(current));
	}
}