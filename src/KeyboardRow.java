import java.util.ArrayList;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class KeyboardRow {
	public String[] findWords(String[] words) {
		String[] rows = new String[]{
				"qwertyuiopQWERTYUIOP",
				"asdfghjklASDFGHJKL",
				"zxcvbnmZXCVBNM"
		};

		ArrayList<String> result = new ArrayList<>();
		for (String str : words) {
			int row = 0;
			if (rows[1].indexOf(str.charAt(0)) != -1)
				row = 1;
			else
			if (rows[2].indexOf(str.charAt(0)) != -1)
				row = 2;

			boolean isOk = true;
			for (int i = 1; i < str.length(); ++i)
				if (rows[row].indexOf(str.charAt(i)) == -1) {
					isOk = false;
					break;
				}
			if (isOk) result.add(str);
		}

		return result.toArray(new String[result.size()]);
	}
}
