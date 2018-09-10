/**
 * @author Harry Tran on 6/29/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class NumOfLineToWriteString {
	public int[] numberOfLines(int[] widths, String S) {
		int numLine = 1;
		int lastLine = 0;
		for (char ch : S.toCharArray()) {
			int size = widths[ch - 'a'];
			if (lastLine + size <= 100) lastLine += size;
			else {
				lastLine = size;
				numLine++;
			}
		}
		return new int[]{numLine, lastLine};
	}
	//[4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
	//"bbbcccdddaaa"
}
