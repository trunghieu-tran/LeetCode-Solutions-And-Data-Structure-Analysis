import java.util.HashSet;

/**
 * @author Harry Tran on 6/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class UniqueMorseCodeWords {
	public int uniqueMorseRepresentations(String[] words) {
		String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
				"....","..",".---","-.-",".-..","--","-.",
				"---",".--.","--.-",".-.","...","-","..-",
				"...-",".--","-..-","-.--","--.."};

		HashSet<String> setTrans = new HashSet<>();
		for (String str : words) {
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < str.length(); ++i) {
				tmp.append(MORSE[str.charAt(i) - 'a']);
			}
			setTrans.add(tmp.toString());
		}
		return setTrans.size();
	}
}
