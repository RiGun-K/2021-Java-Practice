package rigun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLConnection4 {

	private static final String URL = "jdbc:oracle:thin:@10.30.3.95:1521:orcl";
	private static final String ID = "c##2001291"; 
	private static final String PW =  "p2001291";
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("무엇을 할 것인가요? \n 1. 추가 2. 조회 3. 삭제 4.검색");
		
		int keyData = input.nextInt();
		
		switch(keyData) {
		case 1:		
			insertDB();
			break;
		case 2:
			selectDB();
			break;	
		
		}
		
	}
		
		private static void insertDB() {
			// TODO Auto-generated method stub
			Connection con = insertConnection();
			// 아래의 makeConnection 과 연결
			
		
		}
		
		private static Connection insertConnection() {
		
			String url = "jdbc:oracle:thin:@10.30.3.95:1521:orcl";
			 String user = "c##2001291"; 
			 String pw =  "p2001291";
			
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
					} 
					catch(ClassNotFoundException e) {
						// TODO Auto-generated method stub
						e.printStackTrace();
					}
					System.out.println("드라이버 적재성공");
					
					Connection con;
					try {
					// 2. DB 연결 
						con = DriverManager.getConnection(url, user, pw);
						Statement stmt = con.createStatement();
						
						
						String sql = "insert into department (deptno, deptname, floor)" +
									 " VALUES (2, '판매', 3)";
						
						int result = stmt.executeUpdate(sql);
						System.out.println("결과값 은" + result);
						// 결과값은 행의수로 반환되기 때문에 result = 1 출력 
						
						stmt.close();
						con.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				
					return null;
		}
		
		
		private static void selectDB() {
			// TODO Auto-generated method stub
			Connection con = selectConnection();	
		}
		private static Connection selectConnection() {
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
				
				String sql = "select * from department";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					int id = rs.getInt("deptno");					
					String name = rs.getString("deptname");
					String floor = rs.getString("floor");
					
					System.out.println(id + " | " + name + " | " + floor);
					
				}
				
				pstmt.close();
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}



}