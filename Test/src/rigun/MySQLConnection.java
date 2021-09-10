package rigun;

public class MySQLConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 확인");
		} 
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 오류");
		}
	
		
	}

}
