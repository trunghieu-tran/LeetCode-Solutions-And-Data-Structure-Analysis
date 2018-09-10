import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author Harry Tran on 7/5/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class EmployeeImportance {

	// Employee info
	class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	};

	HashMap<Integer, Employee> map = new HashMap<>();

	private int getImportance_recursive(int id) {
		Employee e = map.get(id);
		int res = e.importance;
		int nSub = e.subordinates.size();
		for (int i = 0; i < nSub; ++i)
			res += getImportance_recursive(e.subordinates.get(i));
		return res;
	}

	public int getImportance(List<Employee> employees, int id) {
		for (Employee e : employees)
			map.put(e.id, e);
		return getImportance_recursive(id);
	}
}
