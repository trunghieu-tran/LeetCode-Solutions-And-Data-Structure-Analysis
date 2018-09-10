/**
 * @author Harry Tran on 6/29/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class NumberComplement {
	public int findComplement(int num) {
		int i = 31;
		while ((num & (1 << i)) == 0) --i; // first bit 1
		for (int j = i; j >= 0; --j)
			num ^= (1 << j);
		return num;
	}

	public static void main(String[] args) {
		NumberComplement nc = new NumberComplement();
		nc.findComplement(7);
	}
}
