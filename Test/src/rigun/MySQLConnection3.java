package rigun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLConnection3 {

	public static void main(String args[]) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("무엇을 할 것인가요? \n 1. 조회 2. 삽입 3. 삭제");
		
		int keyData = input.nextInt();
		
		switch(keyData) {
		case 1:		// 조회 	=> 현재 books 테이블의 정보를 디스플레이 한다.
			display();
			break;
		case 2:
			insertDB();
			break;	// 삽입	=> 사용자로 부터 정보를 입력받아 DB에 삽입한다.
		case 3:
			deleteDB();
			break;	// 삭제	=> 사용자로 부터 정보를 입력받아 DB에 삭제한다.
		}
	
	}

	private static void display() {
		// TODO Auto-generated method stub
		Connection con = makeConnection();
		// 아래의 makeConnection 과 연결
		
	
	}

	private static Connection makeConnection() {
		// TODO Auto-generated method stub
		
		// 로직 작성 
		
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
					return con;
		
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				return null;
				
				
	}

	private static void insertDB() {
		// TODO Auto-generated method stub
		Connection con = insertConnection();
	}

	private static Connection insertConnection() {
		// TODO Auto-generated method stub

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
					
					
					String sql = "insert into books (book_id, title, publisher, year, price)" +
								 " VALUES (5, '객체지향5', '영진출판사5', 2025, 5090)";
					
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

	private static void deleteDB() {
		// TODO Auto-generated method stub
		Connection con = deleteConncetion();
	}

	private static Connection deleteConncetion() {
		// TODO Auto-generated method stub
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
					
					
					String sql = "delete from books where book_id=5";
								 
					
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
	
}
