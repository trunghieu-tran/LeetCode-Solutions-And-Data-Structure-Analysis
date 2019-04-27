package KickStart_Oct;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Harry Tran on 10/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class A {
	public static String input = "/Study/Leetcode/src/KickStart_Oct/A-large-practice.in";
	public static String output = "/Study/Leetcode/src/KickStart_Oct/A-large.out";

	private static long process(int N, int[] a) {
		Arrays.sort(a);
		long res = 0;
		for (int i = 0; i < N; ++i) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = i + 1; j < N; ++j) {
				long tmp = (long)(a[i] * a[j]);
				boolean found = false;
				if (tmp <= 200000) {
					int key = (int) tmp;
					if (map.containsKey(key)) {
						res += (long)map.get(key);
						found = true;
					}
				}
				if (!found && a[i] > 0 && a[j] % a[i] == 0) {
					int key = a[j] / a[i];
					if (map.containsKey(key)) {
						res += (long) map.get(key);
					}
				}
				map.put(a[j], map.getOrDefault(a[j], 0) + 1);
			}
		}
		return res;
	}

	private static String template(int i, long res) {
		return "Case #" + Integer.toString(i) + ": " + Long.toString(res) + "\n";
	}

	public static void loadTest() {
		String data = readStringFromFile(input);
		String[] lines = data.split("\\n");
		int nTest = Integer.parseInt(lines[0]);
		int i = 0;
		int cc = 0;
		StringBuilder result = new StringBuilder();
		while (--nTest >= 0) {
			// Do something with test
			int n = Integer.parseInt(lines[++i]);
			int[] a = new int[n];
			String[] A = lines[++i].split(" ");
			for (int j = 0; j < n; ++j) {
				a[j] = Integer.parseInt(A[j]);
			}
			// Run
			long res = process(n, a);
			result.append(template(++cc, res));
		}
		writeStringToFile(output, result.toString());
	}
	public static String readStringFromFile(String inputFile) {
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile));
			byte[] bytes = new byte[(int) new File(inputFile).length()];
			in.read(bytes);
			in.close();
			return new String(bytes);
		}
		catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	public static void writeStringToFile(String outputFile, String data) {
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter( new FileWriter(outputFile));
			writer.write(data);

		}
		catch ( IOException e)
		{
			System.out.println("Writing error!!!");
		}
		finally
		{
			try
			{
				if ( writer != null)
					writer.close( );
			}
			catch ( IOException e)
			{
				System.out.println("Closing file error!!!");
			}
		}
	}

	public static void main(String[] args) {
		A.loadTest();
	}
}
