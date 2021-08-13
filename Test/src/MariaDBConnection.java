import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.nio.charset.Charset;
import java.awt.event.*;
import java.util.*;
import java.awt.*;




public class MariaDBConnection{

	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";

	private static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/rigun";

	private static final String DB_USERNAME = "su1318ho";

	private static final String DB_PASSWORD = "rlaflrjs1!";
	
	
	private Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";

	

//	private static Connection conn;

	PreparedStatement pstmt = null;



	private static void buildDictionaryFromDB() {



		try {

			Class.forName(DB_DRIVER_CLASS);

			Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

			System.out.println("연결성공");



		} catch (Exception e) {

			// TODO Auto-generated catch block

			System.out.println("드라이브 로딩 실패");
			return;

		} 
		
		
//		
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			
			String sql = "select * from java";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				// 뽑아올 테이터 타입에 따라서 다름 , 
				// 테이블 안에 해당하는 
				
				String key = rs.getString("영어단어");					
				String value = rs.getString("한글단어");
//				dict.put(key, value);
//				dict.put(value, key);
				System.out.println(key + " : " + value);
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		
	
	
	}



	public static void main(String[] args) {

		MariaDBConnection test = new MariaDBConnection();

		test.buildDictionaryFromDB();

	}

}


