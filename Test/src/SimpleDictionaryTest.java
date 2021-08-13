import java.util.*;
import java.io.*;

public class SimpleDictionaryTest {
	
	public static void main(String[] args) {
		Properties props = new Properties();
//		File file = new File("dict.props");
		
		try (FileReader reader = new FileReader("dict.props")) {
			props.load(reader);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	
		System.out.println(props.get("사과"));
		System.out.println(props.get("학교"));
		props.put("장미", "rose");
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("dict.props");
			props.store(out, "My Korean-English Dictionary");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
			} catch (Exception ignore) {}
		}
		
		}
}
