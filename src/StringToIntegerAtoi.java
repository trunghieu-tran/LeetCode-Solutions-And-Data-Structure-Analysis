/**
 * @author Harry Tran on 7/10/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class StringToIntegerAtoi {
	public static int myAtoi(String str) {
		if (str.isEmpty()) return 0;

		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ') ++i;
		if (i >= str.length()) return 0;

		char c1 = str.charAt(i);
		if (c1 != '-' && c1 != '+' && (c1 > '9' || c1 < '0')) return 0;

		boolean am = false;
		if (str.charAt(i) == '-') {
			am = true;
			++i;
		} else
			if (str.charAt(i) == '+') ++i;

		while (i < str.length() && str.charAt(i) == '0') ++i;
		if (i >= str.length() || str.charAt(i) > '9' || str.charAt(i) < '0') return 0;

		int j = i + 1;
		while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') ++j;
		String snum = str.substring(i, j);
		try {
			if (j - i >= 11) {
				if (am) return Integer.MIN_VALUE;
				else return Integer.MAX_VALUE;
			}
			long num = Long.parseLong(snum);
			if (am) num = -num;

			if (num > Integer.MAX_VALUE)
				return  Integer.MAX_VALUE;
			else if (num  < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			return (int) num;
		} catch (Exception e) {
			return 0;
		}

	}

	public static void main(String[] args) {
		System.out.println(StringToIntegerAtoi.myAtoi("  -2147483648"));
	}
}
