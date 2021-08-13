import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

import java.io.*;		// 입력받은 단어를 텍스트로 저장
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.nio.charset.Charset;



public class SimpleDictionary extends JPanel implements ActionListener {				// 패널 상속 , 이벤트 리스너 
	/*
	 * 단어 입력 받을수 있는 JTextField
	 * 검색버튼 , 추가버튼 , 단어장 구현을 위한 자료구조로 Map 객체
	 */
	private JTextField inputField = new JTextField(30); 	// 멤버변수 생성 , 30칼럼 
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");

	// Map 객체를 단어장 구현 사용할꺼다.
	// <Key, value> 쌍으로 저장. key 는 한글단어 , value는 대응되는 영어단어.
	private Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";
	private static final String driverClassName = "org.mariadb.jdbc.Driver";	// DB에 해당하는 변수 
	
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";		// DB 드라이버 상수 선언
	
	// DB마다 서버 URL 포맷이 다르다 , 찾아봐야 함 !
	private static final String DB_SERVER_URL = "jdbc:mariadb://127.0.0.1:3306/rigun";		// 주소 + DB 이름 
	private static final String DB_USER = "su1318ho";
	private static final String DB_USER_PW = "rlaflrjs1!";
	
	
	// localhost = 127.0.0.1
	
	public SimpleDictionary() {								// 생성자 생성
		// Panel 의 기본 레이아웃 : FlowLayout	 ( 물 흐르는 대로 갖다 붙이는것 )
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		
		// ssearchBtn , addBtn 에 클릭 이벤트가 발생했을 때 처리할 리스너를 지정하자 !!!
		searchBtn.addActionListener(this);					// 객체에 이벤트 처리 
		addBtn.addActionListener(this);
		
		
		this.setPreferredSize(new Dimension(600, 50));
		
		// 파일에 key=value 형태로 저장된 엔트리들을 읽어서 , dict를 구성하자.
	
		
//		buildDictionaryFromFile();
		buildDictionaryFromDB();
	
	}
	
	// DB 연결 메소드
	private void buildDictionaryFromDB() {
		/*
		 * 1> DataBase server에 연결
		 *   a- JDBC 드라이버를 메로리에 로딩(적재)
		 *   b- DriverManager (java.sql 패키지에 정의된 클래스)
		 *      Connection con = DriverManager.getConnection();
		 *      매서들 호출해 연결을 establish
		 *      이 때 연결 정보를 getConnection() 메서드에 전달해줘야 함.
		 *      연결정보 : DB Server의 URL
		 *      	=> (IP주소 , PORT 번호 , DB 이름 , DB 사용자의 아이디와 암호)를 알려줘야 한다...
		 *      
		 *      연결 안되는 경우 : 암호가 틀렸거나 , 서버가 안 열려있을때 , 권한이 없거나 , 네트워크 설정 등등 ...
		 *      Connection 객체에 close 하기전까지 계속 연결되있음 ...	
		 *
		 * 2> Connection 객체를 통해 SQL 문 실행을 서버에 요청하고 그 결과를 받아 처리한다...
		 * 	 크게 두 가지 방법
		 * 		a- con.createStatement() 메소드 호출을 통해 반환되는
		 *  	   Statement 객체를 이용하는 방법 ( 정적 SQL 문 )
		 *  	   정적 SQL문 : 프로그래밍 시점에 실행할 SQL문 결정되고 고정된 경우.  ex) select * from dict;  ( 고정 )
		 *  
		 *      b- con.prepareStatement() 메서드 호출을 통해 반환되는
		 *         PreparedStatement 객체를 이용하는 방법 ( 동적 SQL 문 )
		 *         동적 SQL문 : 프로그래밍 시점에 실행한 SQL문 결정되지 않고 변경되는 SQL문  ex) select * from dict where han = ?  ( 바뀐다 )
		 *
		 * 	  이 예에서는 PreparedStatement 객체를 이용한다.
		 *		String sql = "select * from dict";
		 *		PreparedStatement pstmt = con.prepareStatement(sql);   // 정보를 담고있는 객체를 반환한다.        
		 *
		 *
		 *	 // 실행 준비가 된 PreparedStatement를 실행시키는 방법 또한 2가지 
		 *
		 *	1) 실행할 SQL 문이 insert, delete , 또는 update 문인 경우
		 *		pstmt.executeUpdate();			//  (반환하는 값은 숫자 = insert 또는 delete 등을 한 값)
		 *		"insert into ..." , "update set eng = ... from ..." , "select ... " 등등
		 *  2) 실행할 SQL 문이 select 문인 경우
		 *		ResultSet rs = pstmt.executeQuery();			// 레코드 하나 씩 뽑아 낸다...
		 *		rs.next();	// 하나씩 뽑아낸다 , 없으면 false 반환
		 * 		while(rs.next)	// 반복문을 통하여 없을때 까지 뽑아낸다...
		 * 
		 *	
		 * 3> DB Server와의 연결을 해제(close)를 한다.
		 * 		con.close(); 	
		 *
		 *
		 */
		
		// MySQL JDBC 드라이버를 메로리에 적재 ( DB 연결 하기전 해야함 ) 
		// 드라이버 이름은 다르다 .
		
		try {
			Class.forName(JDBC_DRIVER);	
		} catch (Exception e) {							 // 에러가 발생한다면
			System.out.println(e.getMessage());			 // 메세지 보내고 끝내고 리턴해줘 
			return;
		}
		
		
		// DB 연결하기 
		// URL, ID , PW 값이 일치하더라도 네트워크 연결 상태 등으로 연결이 안될경우가 있으므로 try catch를 사용한다.
		
		try (Connection con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW)) {	// 문제없으면 connection 객체 반환
			
			// SELECT 문 실행.
			String sql = "select * from java";						// 테이블 명 
			PreparedStatement pstmt = con.prepareStatement(sql);	// sql문을 받아 실행 준비를 한다 .  , Prepared~ 객체를 반환 
			ResultSet rs = pstmt.executeQuery();					// 결과 집합으로써 select 문 실행  
			
			// sql = "insert into dict value( ? , ? ) 이라면 = insert 문이라면 
			// pstmt.executeUpdate(); 를 실행한다.
			
			while(rs.next()) {
				// 현재 포인터가 가리키는 칼럼 값을 빼오면 됨.
				// 각 칼럼의 타입에 따라서 , 호출할 메서드가 달라진다  ex) char, vachar 타입의 칼럼은 getString("칼럼이름" 또는 "칼럼 위치");
				// int 타입의 칼럼은 getInt(...);
				// DateTime, Date 타입의 칼럼 값은 getDate();
//				rs.getString("han");
				
				String key = rs.getString("한글단어");					// 뽑아올 테이터 타입에 따라서 다름 , 현재는 String 
				String value = rs.getString("영어단어");
				dict.put(key, value);
				dict.put(value, key);
				// Map을 사용하여 java에 출력하기위해 map에 key,value 쌍으로 집어넣는다.
				
				System.out.println(key + " : " + value);
				
//				String han = rs.getString(1);
//				String eng = rs.getString(2);	// = get.getString(2);
//				
//				dict.put(han, eng);
			}
		}	catch(Exception e) {
			System.out.println(e.getMessage());
		}	
//			finally {
//			con.close();	
//			}
		
	
	
	}
		
		
	
//	
//	private void buildDictionaryFromFile() {
//		// Properts 일종의 Map 인데
//		// Key , value 의 타입이 각각 String , String 으로 고정된 일종의 Map이다.
//		Properties props = new Properties();
//		
//		// 파일에서 읽어서  props 객체의 <key , value> 쌍을 구성할 수 있다.
//		
//		try (FileReader fReader = new FileReader(DIC_FILE_NAME)) {
//			props.load(fReader);
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		Set<Object> set = props.keySet();
//		for (Object obj : set) {
//			dict.put((String)obj, (String)props.get(obj));
//		}
//	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if (key.trim().length() == 0) 		// key가 공백이면(입력하지 않으면) return 하자 = 입력되지 않게 (무시) 
			return;					
		// TODO Auto-generated method stub
		
		// e.getSource() = 소스가 어떤것인지) 가 serachBtn 인지 addBtn 인지 
		
		if (e.getSource() == searchBtn) {	// 이벤트가 발생한 객체를 return 해준다.
			/*
			 * 입력된 단어를 추출 
			 * 그 단어를 Key 값으로 가지는 대응되는 맵 엔트리가 있는지 검사  => dict.get(단어);  
			 * 그 단어 대응되는 값이 있으면 JOptionPane.showMessageDialong() 메서드 호출하여 대응되는 값을 보여준다  
			 * 대응되는 값이 없으면 = (Null이면) JOptionPane.showMessageDialog() 메서드를 호출하여  '단어를 찾을 수 없습니다'라고 출력해준다.
			 * inputField를 빈 문자열로 설정...
			 */	 
			System.out.println("[" + key + "]");
			String value = dict.get(key);
			if (value != null) {	// 대응되는 단어가 있는 경우
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);     // this = SimpleDictionary 객체
			} else {				// 대응되는 단어가 없는 경우
				JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다", key, JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (e.getSource() == addBtn) {
			/*
			 * 입력된 단어를 추출
			 * String value = JOptionPane.showInputDialog() 메서드를 호출하여 추가할 영단어를 입력 받는다.
			 * dict.put(입력필드에 입력된 단어 , inputDialog에 입력된 단어);		// 입력된 단어를 저장
			 * inputField를 빈 문자열로 설정 ↓
			 */
			String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영단어를 입력하세요.");   		// 문자열 변수로 입력된 단어를 받는다.
			
			if(value.trim().length() == 0) return;
			dict.put(key, value);					// dict에 넣는다		<비, rain> 
			dict.put(value, key);					// 쌍으로 넣는다 		<rain, 비>
			
			addWordToFile(key, value);
			// 파일에도 key=value 의 쌍으로 기록해놓자..
			
			// DB에도 <key , value> 의 쌍으로 하나의 레코드로 저장하자..
			addToDB(key,value);
			
			
			JOptionPane.showMessageDialog(this, "["+value+"]영단어가 추가되었습니다.", key, JOptionPane.INFORMATION_MESSAGE);  
			
		}
	
//		inputField.setText("");
		
	}
	
	// addToDB에 해당하는 key와 value에 문자열 타입으로 메소드 선언
	// 메소드가 호출 될때마다 DB 연결하고 전송하는 방식 
	private void addToDB(String key, String value) {
		/*
		 * 1. DB연결 
		 *    	1) 드라이버 클래스는 딱 한 번만 메모리에 적재하면 됨. 근데 , 이미 객체가 생성될 때, 생성자에서 적재되었으므로 생략...
		 *		2) DriverManger.getConnection(url, id, pw) 호출해서 Conncetion 객체를 생성한다.
		 * 
		 * 2. SQL 문 실행
		 * 		1) Connection 객체에게 실행할 SQL 문을 샐행준비 요청하고, con.prepareStatement(sql);
		 * 		2) PreparedStatement 객체가 반환된다. 
		 * 		3) PreparedStatement 객체에게 서버에게 실행요청을 보낸다. ( preparedStatement.executeUpdate() = 실행할 SQL 문이 INSERT, DELETE , UPDATE
		 * 														( preparedStatement.executeQuery() = 실행할 SQL 문이 SELECT 문일 때 
		 * 3. 데이터베이스 연결 해제
		 *		1) con.close();
		 */
		
		
//		2.
//		Connection con = DriverManager.getConnection(상수로 정의한 사용자,비번,URL을 작성);		
// 		드라이버매니저에 연결한다. , 안될 경우 서버가 닫혔거나 , 비번 틀리거나 ,권한 없거나 등등
		
		try (Connection con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW))  {
			String sql = "insert into java values(?,?)";				// 실행전 임시로 ?로 값을 채워야함. , ?값만 주면 실행할 수 있다.  원래는 word1, word2
																	// into 뒤에 테이블 명을 작성 (Gun)
			PreparedStatement pstmt = con.prepareStatement(sql);		// sql문이 서버로 날아간다 . 
		
			// ? 자리에 값을 채운후 , 서버에게 실행준비된 sql 문을 실행하도록 요청
			pstmt.setString(1, key);		// ? 값이 어떤 칼럼인지 어떤 타입인지 작성 , VARCHAR = String 타입임 , 첫번째 에는 key값 전달 
			pstmt.setString(2, value);		// 2번쨰 에는 value	
			
			pstmt.executeUpdate();			// 실행요청 
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();							// 에러 난 곳을 찾아준다.
		}
		
		
		// 예제 똑같이 연습하도록 작성한 것
//		try (Connection con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW)) {  
//			String sql = "insert into JAVA values(?,?)"; 		
//			PreparedStatement pstmt = con.prepareStatement(sql);		// sql 문을 DB 서버로 보내서 실행준비 시켜라.
//			// ?는 PLACE HOLDER 이고 , 실행준비 시킨 후에,
//			// 실행 직전에 ? 자리에 값을 설정하고 , 실행 요청을 보낸다.
//			// ? 자리에 들어갈 column 값의 데이터 타입에 따라 적절한 setXXX 메서드를 호출해야 함.
//			// ex) VARCHAR 타입이므로 setString을 준다 ..... 
			// 		? 자리에 key 와 value 의 값은 
//			pstmt.setString(1, key);
//			pstmt.setString(2, value);
//			
//			// 실행할 SQL 문이 INSERT , DELETE , UPDATE 문일 때, executeUpdate 메서드 호출
//			// executeUpdate 메서드는 실행 후 , 정수 값을 반환한다.
//			// 그 정수 값은 insert, delete , update문의 수행으로 변경된 레코드의 수.
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//		}	
//			e.printStackTrate();
			
				
		
		
 		
		
	}
	
	// dict.props 에 저장됨
	private void addWordToFile(String key, String value) {
		try(FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)) {
			fWriter.write(key+"="+value+ "\n");		// \n = 줄 바꿈   ex ) 학교=school사과=apple -> 학교=school 사과=apple
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// 프레임이 있어야 실행됨
		JFrame frame = new JFrame();
		SimpleDictionary dictPanel = new SimpleDictionary(); 	// SimpleDictionary 객체 생성
		frame.add(dictPanel);
		frame.setTitle("My Korean-English Dictionary");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		
		
	}





}
