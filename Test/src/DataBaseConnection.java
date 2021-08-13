import java.net.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.*;
import java.sql.*;
import java.io.*;

public class DataBaseConnection {

	static Connection con = null;
	private static ResultSet rs;
	private static final String ID = "su1318ho";
	private static final String PW = "rlaflrjs1!";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/rigun";
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	
	public static void main(String[] args) {
			
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL,ID,PW);
			String sql = "select * from java";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String key = rs.getString("한글단어");
				String value = rs.getString("영어단어");
				
				System.out.println(key+ ":" +value);
			}
				
			
		}
		
		catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
			
		}
	
	
	}
	
}
