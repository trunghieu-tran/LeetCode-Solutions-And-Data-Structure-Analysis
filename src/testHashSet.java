import java.util.HashSet;
import java.util.Set;

/**
 * @author Harry Tran on 7/27/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class testHashSet {
	//static  Set<A> set = new HashSet<>();



	public  static void main(String[] args) {
		Set<A> test = new HashSet<>();
		test.add(new A(1, "a"));
		test.add(new A(1, "a"));
		System.out.println(test.size());

	}
}
class A {
	int id;
	String str;

	public A(int id, String str) {
		this.id = id;
		this.str = str;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((A) obj).id && this.str.equals(((A) obj).str);
//		return this.equals((A)obj);
	}

	@Override
	public int hashCode() {
		return (id + ""+ str).hashCode();
	}
}
