import java.net.*; 			// 네트워크 관련 - net
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.io.*;			// 입출력 관련 - io
import com.google.gson.Gson;
import java.util.*;
import javax.swing.*;

public class JSONReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		String site = "http://jsonplaceholder.typicode.com/posts";		// 읽을 사이트 지정 
		URL url = new URL(site);		// url 객체 생성
		
		URLConnection con = url.openConnection();
		
		InputStream stream = con.getInputStream();						// 바이트 단위를 읽을경우 사용
		
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");		// 문자열 단위를 읽을경우 사용
		
		BufferedReader bufReader = new BufferedReader(reader);
		String line = null;
		while ((line = bufReader.readLine()) != null) {									// 널이 아닌경우만 한 라인씩 읽는다 . = 다 읽는다
//		System.out.println(line);
			jsonString += line;
//		}
	
		// Gson ( 문자열을 객체로 만들어주는 ) 이라는 라이브러리를 사용해보자. 사용시 자동으로 객체로 인식해서 넘어온다
		// Gson 가져오는 법  : Test에서 우클릭 - Build Path - Add Extreal - 가져오기
		
		
		Gson gson = new Gson();
		String json = "{'userId':1, 'id':1, 'title':'test', 'body':'test body'}";		// Gson 배열
	//  String json = "[{'userId':1, 'id':1, 'title':'test', 'body':'test body'}, {'userId':2, 'id':2, 'title':'test2', 'body':'test2 body'}]";
	//  배열로 생성할 경우 [ ] 를 사용한다 ...
		
		Post[] post = gson.fromJson(jsonString, Post[].class);							
	// 시험) post의 배열로 변환할 경우 Post[] post = gson.fromJson(json, Post[].class);			
		
		/* Post post = new Post();
		 * 
		 * post.setUserId(1);
		 * post.setId(1);
		 * post.setTitle("title");
		 * post.setBody("test body");
		 * return post;
		 * 라는식으로 자동적으로 저장되어 진다. 밑에는 찍어보면 동일하게 나옴 !! 
		 */
		
//		System.out.println(post[0].getUserId());
//		// System.out.println(post.getUserId());
//		System.out.println(post.getId());
//		System.out.println(post.getTitle());
//		System.out.println(post.getBody());
		
		for (Post post : posts) {
			System.out.println(post.getUserId());
			System.out.println(post.getId());
			System.out.println(post.getTitle());
			System.out.println(post.getBody());
			System.out.println("################");
		
		}
		insertIntoDB(posts);
		
	
		
		
	}
		
		private static void insertIntoDB(Post[] posts) {
			/*
			 * 1. Class.forName(...);	// JDBC 드라이버 메모리에 적재
			 * 2. Connection con = DriverManger.getConnection(...);  // DB 서버에 연결
			 * 3. String sql = "insert into posts(userId, id, title, body)
			 * 				values(?, ?, ?, ?);						 // ? 로 줌
			 * 	  PreparedStatement pstmt = con.prepareStatement(sql);
			 * 
			 * 4. ? 자리에 들어갈 값을 설정한다.
			 *    pstmt.setInt(1, post.getUserId());
			 *    pstmt.setInt(2, post.getId());
			 *    pstmt.setString(3, post.getTitle());
			 *    pstmt.setString(4, post.getBody());
			 * 5. 서버에 실행 요청
			 *    pstmt.executeUpdate();		// insert 문이므로 update
			 * 6. con.close();      
			 *    
			 */
			
			Class.forName("org.mariadb.jdbc.Driver");	// 시험시에는 메모장에 적어놓ㄱ\
			String url = "jdbc:mariadb://eatx.shop:3307/김리건";
			String id = "wdj";
			String pw = "wdj123";
			Connection con = DriverManager.getConnection(url, id, pw);
			String sql = "insert into post(userId, id, title, body) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			for (Post post: posts) {
				pstmt.setInt(1, post.getUserId());
				pstmt.setInt(2, post.getId());
				pstmt.setString(3, post.getTitle());
				pstmt.setString(4, post.getBody());
				pstmt.executeUpdate();
			
			}
			con.close();
			
		}
		


}
	

	
	
	
	
	
}
