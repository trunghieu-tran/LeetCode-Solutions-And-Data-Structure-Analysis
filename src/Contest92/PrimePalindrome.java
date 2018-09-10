package Contest92;

/**
 * @author Harry Tran on 7/7/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class PrimePalindrome {
	private boolean isPrime(int n) {
		if (n < 2) return false;
		for (long i = 2; i*i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isPalindrome(int n) {
		String str = Integer.toString(n);
		return isPalindromeStr(str);
	}

	public boolean isPalindromeStr(String str) {
		int length = str.length();
		int forward = 0;
		int backward = length - 1;
		while (backward > forward) {
			char forwardChar = str.charAt(forward++);
			char backwardChar = str.charAt(backward--);
			if (forwardChar != backwardChar)
				return false;
		}
		return true;
	}

	public int primePalindrome(int N) {
		while (true) {
			if (isPalindrome(N))
				if (isPrime(N)) return N;
			++N;
		}
	}

	public static void main(String[] args) {
		PrimePalindrome p = new PrimePalindrome();
		System.out.println(p.primePalindrome(100000));
	}
}
