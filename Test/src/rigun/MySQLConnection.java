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
			System.out.println("�뱶�씪�씠踰� �쟻�옱 �꽦怨�!!");
		} 
		catch(ClassNotFoundException e) {
			// TODO Auto-generated method stub
			System.out.println("�뱶�씪�씠踰� �쟻�옱 �삤瑜�!!");
		}
	
		try {
		// 2. DB 연결
			Connection con = DriverManager.getConnection(URL, ID, PW);
		
		// 3. SQL문장 작성 및 전송
			Statement stmt = con.createStatement();
			
			String sql = "insert into department (deptno, deptname, floor)" +
						 " VALUES (7, '성공', 3)";
			int result = stmt.executeUpdate(sql);
			System.out.println("寃곌낵媛� ��" + result);
			// 결과값은 행의수로 반환되기 때문에 result = 1 출력
			
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	
	}

}
