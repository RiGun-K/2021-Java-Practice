package rigun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection4 {

	private static final String URL = "jdbc:oracle:thin:@10.30.3.95:1521:orcl";
	private static final String ID = "c##2001291"; 
	private static final String PW =  "p2001291";
	
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공!!");
		} 
		catch(ClassNotFoundException e) {
			// TODO Auto-generated method stub
			System.out.println("드라이버 적재 오류!!");
		}
		
	
		try {
			Connection con = DriverManager.getConnection(URL, ID, PW);
			
			// 3. SQL문장 작성 및 전송
			Statement stmt = con.createStatement();
				
			String sql = "insert into department (deptno, deptname, floor)" +
							 " VALUES (7, '관리', '2')";
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
