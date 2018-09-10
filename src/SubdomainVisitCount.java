import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harry Tran on 6/29/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class SubdomainVisitCount {
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<>();
		ArrayList<String> res = new ArrayList<>();

		for (String str : cpdomains) {
			String[] tmp = str.split(" ");
			String[] tmp2 = tmp[1].split("\\.");
			int cnt = Integer.parseInt(tmp[0]);

			map.put(tmp[1], map.getOrDefault(tmp[1], 0) + cnt);

			int id = tmp2.length - 1;
			map.put(tmp2[id], map.getOrDefault(tmp2[id], 0) + cnt);

			if (id == 2) {
				String sub2 = tmp2[1] + "." + tmp2[2];
				map.put(sub2, map.getOrDefault(sub2, 0) + cnt);
			}
		}

		for (String str : map.keySet()) {
			res.add(Integer.toString(map.get(str)) + " " + str);
		}

		return res;
	}
}
