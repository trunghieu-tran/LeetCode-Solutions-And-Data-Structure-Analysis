/**
 * @author Harry Tran on 6/29/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ReverseWordsInString {
	public String reverseWords(String s) {
		String[] str = s.split(" ");
		StringBuilder res = new StringBuilder(str[0]).reverse();
		for (int i = 1; i < str.length; ++i) {
			res.append(" ").append(new StringBuilder(str[i]).reverse());
		}
		return res.toString();
	}
}
