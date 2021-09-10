package rigun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

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
			
			String sql = "insert into books (book_id, title, publisher, year, price)" +
						 " VALUES (5, '객체지향', '영진출판사', 2021, 100)";
			int result = stmt.executeUpdate(sql);
			System.out.println("결과값 은" + result);
			
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	
	}

}
