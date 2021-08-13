import java.io.InputStream;
import java.net.*;
import java.util.Scanner;
import java.io.*;


		// HTTP 파싱할때 사용하므로 기억 할 것 !
public class URLConnectionReader {
	
	public static void main(String[] args) throws IOException {
		
		
		// 1. URL 객체
		URL site = new URL("https://www.naver.com/");		
	
		// 2. URL 객체로부터 저 사이트로 연결을 시도한다. openConnection()
		URLConnection con = site.openConnection();

		// 3. InputStream 객체를 통해 네트워크 너머의 프로세스가 보내주는 데이터를 읽는다.
		InputStream stream = con.getInputStream();
		
		InputStreamReader isreader = new InputStreamReader(stream, "UTF-8");
	
		BufferedReader reader = new BufferedReader(isreader);
		String line;
	
		
		while ((line = reader.readLine()) !=null) {
			System.out.println(line);
		}
		
		
		
		
		
		// 다 보내면 -1 을 보내려고 함 .
		
		// CRUD
		// Create Read Update Delete
		
		
	
		
		
	}
}
