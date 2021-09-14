package rigun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection2 {

	// 개인정보이니 Github을 통해 보신분들은 사용하지 마시오 .. 
	private static final String URL = "jdbc:oracle:thin:@10.30.3.95:1521:orcl";
	private static final String ID = "c##2001291"; 
	private static final String PW =  "p2001291";
	
	public static void main(String[] args) {
		
		
		
		// 1. JDBC 드라이버 적재
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공!!");
		} 
		catch(ClassNotFoundException e) {
			// TODO Auto-generated method stub
			System.out.println("드라이버 적재 오류!!");
		}
	
		try {
		// 2. DB 연결 
			Connection con = DriverManager.getConnection(URL, ID, PW);
		
		// 3. SQL문장 작성 및 전송
			Statement stmt = con.createStatement();
			
			
			String sql = "select * from books";
			
			// select 이므로 executeUpdate => Query
			// ResultSet = 결과 집합 
			ResultSet rs = stmt.executeQuery(sql);
			
			// 결과 집합을 핸들링 하기위해 
		 
			// result는 행단위 , next는 첫번째 행 출력
			// while 반복문을 통해 모든행 출력
			while(rs.next()) {
				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String publisher = rs.getString("publisher");
				int year = rs.getInt("year");
				int price = rs.getInt("price");
				System.out.println("결과 값은 "+ id + ":" + title + ":" + publisher + ":" + year + ":" + price);
			}
			
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	
	}

}