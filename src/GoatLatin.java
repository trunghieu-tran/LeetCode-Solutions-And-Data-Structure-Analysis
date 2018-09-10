import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Harry Tran on 7/1/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class GoatLatin {
	public String toGoatLatin(String S) {
		if (S.length() == 0) return S;

		HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

		String[] str = S.split(" ");
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length; ++i) {
			char chr = str[i].charAt(0);
			if (vowels.contains(chr)) {
				str[i] += "ma";
			} else {
				str[i] = str[i].substring(1, str[i].length()) + chr + "ma";
			}
			for (int j = 0; j < i + 1; ++j) str[i] += "a";

			if (i != 0) res.append(" ").append(str[i]);
			else res.append(str[i]);
		}
		return res.toString();
	}
}
