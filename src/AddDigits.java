/**
 * @author Harry Tran on 7/3/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class AddDigits {
	public int addDigits(int num) {
		return 1 + (num - 1) % 9;
	}
}
