import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Date;
import java.awt.GridLayout;


public class BookListViewer extends JFrame implements ActionListener {
	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton previousBtn, nextBtn, insertBtn, finishBtn;			// 객체들 선언 , 이후 생성해야 함. 
	private ResultSet rs;	// 멤버 변수로 만들기 위해 변수 따로 선언
	private Connection con; // 멤버 변수로 만들기 위해 변수 따로 선언
	// 생성자 생성
	public BookListViewer() throws Exception { 	
		/*
		 * DB에서 책 레코드들을 가져오자
		 * 1) JDBC 드라이버 적재
		 * 2) DB 연결
		 * 3) PreparedStatement 객체 생성
		 * 4) SQL 문 실행 ! 
		 */
		
	// 1) JDBC 드라이버 적재
		Class.forName("org.mariadb.jdbc.Driver");				// JDBC 드라이버
		con = DriverManager.getConnection(
	               "jdbc:mariadb://localhost:3306/rigun",		// DB 주소
	               "su1318ho",										// 아이디
	               "rlaflrjs1!");									// 비밀번호
		String sql = "select * from books order by book_id desc";		// 가장 최신의 정보대로 정렬되도록 order by 절 사용 
		
	// 이제 서버에 보내야 함	
		PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);			// 이제 실행준비 완료됨... , 아직 실행 X , 여러가지 검사를 해야함
		
	// select 문을 실행 할 경우 executeQuert() 메서드를 사용 , 그 외 insert, delete, update 문을 실행 할 경우 executeUpdate() 메서드 사용하자 !!!
	// select 문은 결과집합 을 반환받아야 함 , 그 외는 아님
		 rs = pstmt.executeQuery();
		// 로칼 변수 이므로 실행끝나면 다른 메서드로 접근 불가  , 따라서 멤버 변수로 만든다 = ResultSet rs = ~~~  = > rs = ~~~  ( 변수 따로선언 )
		
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		// 이 JFrame 객체 (this)의 Layout을 GridLayout 으로 설정 (0,2) = Low는 0 Column 2 개로 배치한다...
		this.setLayout(new GridLayout(0,2));
		
		// 컴포넌트들을 생성
		this.add(new JLabel("ID",JLabel.CENTER));	// 라벨 생성 , 중앙에 배치해라 "ID"라는 값으로  
		idField = new JTextField(10);
		this.add(idField);							// 생성된 컴포넌트들을 JFrame 객체 (this)에 추가한다.
		
		this.add(new JLabel("Title",JLabel.CENTER));	// 라벨 생성 
		titleField = new JTextField(10);
		this.add(titleField);
		
		this.add(new JLabel("Publisher",JLabel.CENTER));	// 라벨 생성  
		publisherField = new JTextField(10);
		this.add(publisherField);
		
		this.add(new JLabel("Year",JLabel.CENTER));	// 라벨 생성 
		yearField = new JTextField(10);
		this.add(yearField);
		
		this.add(new JLabel("Price",JLabel.CENTER));	// 라벨 생성  
		priceField = new JTextField(10);
		this.add(priceField);
		
		// 버튼 컴포넌트들의 클릭이벤트를 처리하기 위해 액션리스너를 이 객체 (this)로 설정한다.
		previousBtn = new JButton("Previous");
		previousBtn.addActionListener(this);
		this.add(previousBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(this);
		this.add(insertBtn);
		
		finishBtn = new JButton("Finish");
		finishBtn.addActionListener(this);
		this.add(finishBtn);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	// 	
		this.setResizable(false);   	// 사이즈가 늘려지지않도록 설정
		this.setSize(350,200);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] arg) throws Exception {		// throws 사용 , Exception 발생시 날린다 . 
		// BookListViewer 클래스 인스턴스 생성
		new BookListViewer();			// 스레드 : 실행 흐름 , 프로그램을 실행 시키면 하나의 실행흐름으로 돌아감 / 이것은 멀티스레드 : 실행이 끝나도 흐름이 살아있음	
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	// 이벤트 처리 
		// TODO Auto-generated method stub
	try {
			if (e.getSource() == previousBtn )	{	// getSource = 선언된 객체를 부름
				System.out.println("PreviousBtn clicked...");
				// 결과집합의 커서(포인터)를 이전으로 이동시켜 
				rs.previous();
				// 그 커서가 가리키는 결과 레코드의 칼럼값을 뽑아와서 적절한 JTextField 값으로 설정 
				setCurrentBookInfo2TextField();
				
			} else if (e.getSource() == nextBtn) {
				System.out.println("NextBtn clicked...");
				// 결과집합의 커서(포인터)를 다음으로 이동시켜 그 커서가 가리키는 결과 레코드의 칼럼값을 뽑아와서 적절한 JTextField 값으로 설정
				// 그 밑에도 동일하게 코드를 작성해야 하는데 중복을 제거하기 위해 하나로 만들자 ! 
				rs.next();
				setCurrentBookInfo2TextField();
			} else if (e.getSource() == insertBtn) {
				System.out.println("InsertBtn clicked...");
				
			} else if (e.getSource() == finishBtn) {
				System.out.println("FinishBtn clicked...");
				System.out.println("프로그램을 종료합니다...");
				System.exit(0);		// 프로세스 종료
				con.close();		// DB도 종료
			}
	} catch(Exception error) {
		System.out.println(error.getMessage());
	}
	
}
	
	private void setCurrentBookInfo2TextField() throws Exception {
		// 현재 레코드의 boko_id, title, publisher, year, 값들을 뽑아오자 !
		int bookID = rs.getInt("book_id");		// 1 로 적어도 동일
		String title = rs.getString("title");	// 2  
		String publisher = rs.getString("publisher");	// 3
		Date year = rs.getDate("year");		// 4
		int price = rs.getInt("price");		// 5
		
		idField.setText(String.valueOf(bookID));   	// book_id가 int 이므로 String 타입으로 변환하자
		titleField.setText(title);
		publisherField.setText(publisher);
		yearField.setText(year.toString());				// 마찬가지로 toString으로 
		priceField.setText(String.valueOf(price));	
	}

}
