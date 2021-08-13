import java.net.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;

public class HttpURLTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String site = "http://www.google.com/search?q=java";
		URL url = new URL("site");
		// serach?q=java 는 google 창에서 java를 검색한 주소값임 , java 뒤에 값들은 생략 
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int responseCode = con.getResponseCode();
		System.out.println("Response code: " + responseCode);
//		
		
		InputStream stream = con.getInputStream();
		InputStreamReader isreader = new InputStreamReader(stream,"Utf-8");
		BufferedReader reader =new BufferedReader(isreader);
		
		
		String line;
		StringBuffer buf = new StringBuffer();
		
		while((line=reader.readLine())!=null) {
			buf.append(line);
		}
		// Get 방식 : 홈페이지에 쿼리까지 다 나오는 주소를 끌거오는것 
		// 한글이 안 꺠지려면 READ를 열때 UTF-8로 설정해야 함 .
		reader.close();
		System.out.print(buf);
		
	}

}
