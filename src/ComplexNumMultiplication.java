/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ComplexNumMultiplication {
	public String complexNumberMultiply(String a, String b) {
		String[] tmpa = a.split("\\+");
		String[] tmpb = b.split("\\+");

		int a1 = Integer.parseInt(tmpa[0]);
		int b1 = Integer.parseInt(tmpa[1].split("i")[0]);

		int a2 = Integer.parseInt(tmpb[0]);
		int b2 = Integer.parseInt(tmpb[1].split("i")[0]);

		int newa = a1 * a2 - b1 * b2;
		int newb = a1 * b2 + b1 * a2;

		return Integer.toString(newa) + "+" + Integer.toString(newb) + "i";
	}
}
