package rigun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// URL 객체를 이용하여 해당 주소의 데이터를 읽어온다 ! 

public class URLConnection1105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL myBlog = null;
		try {
			myBlog = new URL("https://rigun.tistory.com/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			URLConnection nc = myBlog.openConnection();
			InputStream is = nc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			
			String data;
			
			while( (data = br.readLine()) != null) {
				System.out.println(data);
			}
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
