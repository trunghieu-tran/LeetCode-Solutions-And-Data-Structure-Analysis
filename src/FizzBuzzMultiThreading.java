import java.util.ArrayList;
import java.util.List;

/**
 * @author Harry Tran on 10/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */

public class FizzBuzzMultiThreading {

	public static void main(String[] args) {
		List<String> res = FizzBuzzMultiThreading.fizzBuzz(15);
		System.out.println("hi");
		for (String s : res) System.out.println(s);
	}

	public static  List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		Thread[] threads = {new FizzBuzzThread(true, true, n, "FizzBuzz", res),
				new FizzBuzzThread(true, false, n, "Fizz", res),
				new FizzBuzzThread(false, true, n, "Buzz", res),
				new NumberThread(false, false, n, res)};
		for (Thread thread : threads) {
			thread.start();
		}
		return res;
	}
}