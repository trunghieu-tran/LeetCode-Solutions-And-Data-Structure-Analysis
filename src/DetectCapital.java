/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		boolean allCap = Character.isUpperCase(word.charAt(0));
		boolean firstCap = allCap;
		boolean noCap = !allCap;

		int len = word.length();
		for (int i = 1; i < len; ++i) {
			boolean isLower = Character.isLowerCase(word.charAt(i));
			allCap &= !isLower;
			firstCap &= isLower;
			noCap &= isLower;

			if ((!allCap) && (!firstCap) && (!noCap)) return false;
		}
		return true;
	}
}
