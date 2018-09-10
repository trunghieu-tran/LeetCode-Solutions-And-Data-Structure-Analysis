/**
 * @author Harry Tran on 6/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		for (char chr : moves.toCharArray()) {
			if (chr == 'L') --x;
			else
				if (chr =='R') ++x;
				else
					if (chr == 'U') ++y;
					else --y;
		}
		return (x == 0 && y == 0);
	}
}
