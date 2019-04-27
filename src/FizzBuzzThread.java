import java.util.List;

/**
 * @author Harry Tran on 10/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FizzBuzzThread extends Thread{
	private static Object lock = new Object();
	protected static int current = 1;
	protected static List<String> res;
	private int max;
	private boolean div3, div5;
	private String toPrint;

	public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint, List<String> res) {
		this.div3 = div3;
		this.div5 = div5;
		this.max = max;
		this.toPrint = toPrint;
		this.res = res;
	}

	public void addToRes() {
		res.add(toPrint);
	}

	public void run() {
		while (true) {
			synchronized(lock) {
				if (current > max) return;
				if ((current % 3 == 0) == div3 &&
						(current % 5 == 0) == div5) {
					addToRes();
					++current;
				}
			}
		}
	}
}