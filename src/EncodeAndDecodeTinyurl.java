import java.util.HashMap;

/**
 * @author Harry Tran on 6/30/18.
 * @project Leetcode
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class EncodeAndDecodeTinyurl {
	private HashMap<Integer, String> data = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		int hashNum = longUrl.hashCode();
		String str = "http://tinyurl.com/" + Integer.toString(hashNum);
		data.put(hashNum, longUrl);
		return str;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		String[] tmp = shortUrl.split("/");
		int hashNum = Integer.parseInt(tmp[3]);
		return data.get(hashNum);
	}
}
