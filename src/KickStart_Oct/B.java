package KickStart_Oct;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Harry Tran on 10/21/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class B {
	public static String input = "/Study/Leetcode/src/KickStart_Oct/B-small-practice.in";
	public static String output = "/Study/Leetcode/src/KickStart_Oct/B-small.out";

	private static String template(int i, long res) {
		return "Case #" + Integer.toString(i) + ": " + Long.toString(res) + "\n";
	}


	public static long process(int n, int q, int[] l, int[] r, int[] k) {
		List<Pair<Integer, Integer> > qs = new ArrayList<>();
		for (int i = 0; i < q; ++i) {
			qs.add(new Pair<>(k[i], i + 1));
		}
		Collections.sort(qs, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				return o1.getKey() - o2.getKey();
			}
		});

//		for (Pair<Integer, Integer> p : qs)
//			System.out.println(Integer.toString(p.getKey()) + " "  + Integer.toString(p.getValue()));

		List<Pair<Integer, Integer>> a = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			a.add(new Pair<>(l[i], 1));
			a.add(new Pair<>(r[i], -1));
		}
		Collections.sort(a, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				if (o1.getKey().intValue() == o2.getKey().intValue())
					return o2.getValue() - o1.getValue();
				else
					return o1.getKey() - o2.getKey();
			}
		});

//		for (int i = 0; i < a.size(); ++i) {
//			System.out.print("(" + Integer.toString(a.get(i).getKey()) + " "  + Integer.toString(a.get(i).getValue()) + ")");
//		}
//		System.out.println("\n");

		long res = 0;
		int j = 0; // for question
		int curr = 1;
		int opening = 1;
		int last = a.get(a.size() - 1).getKey();

		while (j < q && qs.get(j).getKey() <= curr) {
			res += (long)last * qs.get(j).getValue();
			++j;
		}

		for (int i = a.size() - 2; i >= 0; --i) {
			if (j == q) break;
			if (a.get(i).getKey() < last) {
				if (opening > 0) {
					int first = a.get(i).getKey() + 1;
					long numStud = (long)(opening * (last - first));
					while (j < q && numStud + curr >= qs.get(j).getKey()) {
						int ll = first;
						int rr = last - 1;
						int pos = -1;
						while (ll <= rr) {
							int mid = (ll + rr) / 2;
							long xx = (long)((last - mid) * opening) + curr;
							if (xx >= qs.get(j).getKey()) {
								pos = mid;
								ll = mid + 1;
							} else rr = mid - 1;
						}
						if (pos == -1) System.out.println(-1);
						res += (long) (pos * qs.get(j).getValue());
						++j;
					}
					curr += numStud;
				}

				last = a.get(i).getKey();

				if (a.get(i).getValue() < 0) opening++;
				curr += opening;
				while (j < q && curr >= qs.get(j).getKey()) {
					res += (long) last * qs.get(j).getValue();
					++j;
				}

				if (a.get(i).getValue() > 0) {
					opening--;
				}
			} else {
				last = a.get(i).getKey();
				if (a.get(i).getValue() < 0) {
					curr++;
					opening++;
				}
				while (j < q && curr >= qs.get(j).getKey()) {
					res += (long) (last * qs.get(j).getValue());
					++j;
				}
				if (a.get(i).getValue() > 0) {
					opening--;
				}
			}
		}

		return res;
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
			String[] line0 = lines[++i].split(" ");
			String[] line1 = lines[++i].split(" ");
			String[] line2 = lines[++i].split(" ");
			String[] line3 = lines[++i].split(" ");

			int n = Integer.parseInt(line0[0]);
			int q = Integer.parseInt(line0[1]);

			int[] l = new int[n + 3];
			int[] r = new int[n + 3];
			int[] k = new int[q + 3];
			long[] x = new long[n + 3];
			long[] y = new long[n + 3];
			long[] z = new long[q + 3];

			x[0]    = Long.parseLong(line1[0]);
			x[1]    = Long.parseLong(line1[1]);
			long a1 = Long.parseLong(line1[2]);
			long b1 = Long.parseLong(line1[3]);
			long c1 = Long.parseLong(line1[4]);
			long m1 = Long.parseLong(line1[5]);

			y[0]    = Long.parseLong(line2[0]);
			y[1]    = Long.parseLong(line2[1]);
			long a2 = Long.parseLong(line2[2]);
			long b2 = Long.parseLong(line2[3]);
			long c2 = Long.parseLong(line2[4]);
			long m2 = Long.parseLong(line2[5]);

			z[0]    = Long.parseLong(line3[0]);
			z[1]    = Long.parseLong(line3[1]);
			long a3 = Long.parseLong(line3[2]);
			long b3 = Long.parseLong(line3[3]);
			long c3 = Long.parseLong(line3[4]);
			long m3 = Long.parseLong(line3[5]);

			for (int ii = 2; ii < n; ++ii) {
				x[ii] = (a1 * x[ii - 1] + b1 * x[ii - 2] + c1) % m1;
				y[ii] = (a2 * y[ii - 1] + b2 * y[ii - 2] + c2) % m2;
			}
			for (int ii = 2; ii < q; ++ii) {
				z[ii] = (a3 * z[ii - 1] + b3 * z[ii - 2] + c3) % m3;
			}

			for (int ii = 0; ii < n; ++ii) {
				l[ii] = (int)(Math.min(x[ii], y[ii]) + 1);
				r[ii] = (int)(Math.max(x[ii], y[ii]) + 1);
			}

			for (int ii = 0; ii < q; ++ii) {
				k[ii] = (int)(z[ii] + 1);
			}
			// Run
			long res = process(n, q, l, r, k);
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
		B.loadTest();
	}
}
