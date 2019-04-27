package KickStart_Oct;
import java.io.*;
import java.util.*;

/**
 * @author Harry Tran on 5/23/18.
 * @project RecoverJSName
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FileIO {
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
	public static ArrayList<String> getAllSubdirectoryFromDirectory(String dir) {
		ArrayList<String> res = new ArrayList<>();
		File file = new File(dir);
		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		for (String str : directories) {
			res.add(dir + str + "/");
		}
		return res;
	}

	public static Set<String> getAllFilesFromDirectory(String dir) {
		Set<String> res = new HashSet<>();
		File root = new File(dir);
		try {
			File[] fs = root.listFiles();
			for (File f : fs)
				if (!f.isDirectory())
					res.add(f.getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public static ArrayList<String> getAllSubdirectoryFromDirectoryWithNumber(String dir, int num) {
		ArrayList<String> res = new ArrayList<>();
		File file = new File(dir);
		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});

		int cc = 0;
		for (String str : directories) {
			res.add(dir + str + "/");
			if (++cc >= num) break;

		}
		return res;
	}
}
