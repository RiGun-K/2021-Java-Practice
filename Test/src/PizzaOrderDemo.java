import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

 class MyFrame extends JFrame implements ActionListener {	// MyFrame 클래스 정의 JFrame 으로 부터 상속
	private int sum, temp1, temp2, temp3;					// 액션리스너 구현
	private JButton order_button, cancle_button;			// 컴포넌트와 컨테이너 참조변수
	private JPanel down_Panel;
	private JTextField text;
	
	WelcomePanel welcome_panel = new WelcomePanel();
	
	// 문구, 타입, 토핑, 크기 패널 생성
	TypePanel TypePanel = new TypePanel();
	ToppingPanel ToppingPanel = new ToppingPanel();
	SizePanel SizePanel = new SizePanel();
	
	public MyFrame() {	// 생성자 정의
		this.setSize(500, 200);	 	// 프레임 크기 정의
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 종료 설정
		this.setTitle("피자 주문");		// 타이틀 초기화
		
		this.order_button = new JButton("주문");		// 주문 버튼 생성
		this.order_button.addActionListener(this);	// 이벤트 처리등록
		this.cancle_button = new JButton("취소");		// 취소 버튼 생성
		this.cancle_button.addActionListener(this);	// 이벤트 처리등록
		
		this.text = new JTextField();				// 텍스트 필드 생성
		text.setEditable(false);					// 수정 불가
		text.setColumns(6);							// 길이 6 칸
		
		down_Panel = new JPanel();					// 패널 생성
		down_Panel.add(this.order_button);			// 주문 버튼 취소 버튼 추가
		down_Panel.add(this.cancle_button);
		down_Panel.add(this.text);					// 텍스트 필드 추가
		
		this.setLayout(new BorderLayout());			// 프레임 배치관리자 설정
		
		this.add(welcome_panel, BorderLayout.NORTH);	// 웰컴 패널 북쪽
		this.add(down_Panel, BorderLayout.SOUTH);		// 버튼 패널 남쪽
		this.add(SizePanel, BorderLayout.EAST);			// 사이즈 패널 동쪽
		this.add(TypePanel, BorderLayout.WEST);			// 타입 패널 서쪽
		this.add(ToppingPanel, BorderLayout.CENTER);	// 토핑 패널 중앙
		
		this.setVisible(true);							// 프레임 화면 표시
	}
	
	public void acticonPerformed(ActionEvent e) {		// 액션 이벤트 처리
		if (e.getSource() == this.order_button) {		// 액션소스 검출 '주문' 버튼시
			this.text.setText(" " + 20000);				// 텍스트 필드 출력
		}
		
		if (e.getSource() == this.cancle_button) {		// 액션 소스가 취소 버튼일경우
			
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum   = 0;
			this.text.setText(" " + sum);				// 전부 초기화 후 초기값 출력
		}
	}
	
	class WelcomePanel extends JPanel {					// 웰컴 패널 클래스 정의 JPanel 상속
		private JLabel message;							// 메세지 라벨 참조 변수
		
		public WelcomePanel() {							// 생성자
			message = new JLabel("자바 피자에 오신것을 환영합니다");
			add(message);								// 라벨 생성후 객체에 추가
		}
	}
	
	class TypePanel extends JPanel {					// 타입 패널 정의 JPanel 상속
		private JRadioButton combo, potato, bulgogi;	// 라디오 버튼 정의
		private ButtonGroup bg;							// 버튼 그룹 정의
		
		public TypePanel() {							// 생성자
			setLayout(new GridLayout(3, 1));			// 배치관리자 정의
			combo = new JRadioButton("콤보", true);		// 라디오 버튼 생성
			potato = new JRadioButton("포테이토", true);
			bulgogi = new JRadioButton("불고기", true);
			
			bg = new ButtonGroup();						// 버튼그룹 정의후 묶기
			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);
			
			setBorder(BorderFactory.createTitledBorder("종류"));	// 버튼그룹 정리
			
			add(combo);		// 객체에 라디오 버튼 추가
			add(potato);
			add(bulgogi);
			
		}
	}
	
	class ToppingPanel extends JPanel {		// 토핑 패널정의 JPanel 상속
		private JRadioButton pepper, cheese, peperoni, bacon;		// 라디오버튼 참조변수
		private ButtonGroup bg;										// 버튼그룹 참조변수
		
		public ToppingPanel() {		// 생성자
			setLayout(new GridLayout(4, 1));		// 배치관리자 일렬
			
			pepper = new JRadioButton("피망", true);		// 라디오 버튼생성
			cheese = new JRadioButton("치즈");
			peperoni = new JRadioButton("페페로니");
			bacon = new JRadioButton("베이컨");
			
			bg = new ButtonGroup();						// 버튼그룹 생성후 라디오 버튼 묶기
			bg.add(peperoni);
			bg.add(cheese);
			bg.add(pepper);
			bg.add(bacon);
			// 버튼그룹 정리
			setBorder(BorderFactory.createTitledBorder("추가토핑"));
			
			add(pepper);			// 객체에 라디오 버튼추가 
			add(cheese);
			add(peperoni);
			add(bacon);
		}
	}
	
	class SizePanel extends JPanel {			// 사이즈 패널정의 JPanel 상속
		private JRadioButton samll, medium, large;		// 라디오 버튼 참조변수
		private ButtonGroup bg;							// 버튼그룹 참조변수
		
		public SizePanel() {							// 생성자
			setLayout(new GridLayout(3, 1));			// 배치관리자
			
			samll = new JRadioButton("small", true);	// 라디오 버튼생성
			medium = new JRadioButton("Medium");
			large = new JRadioButton("Large");
			
			bg = new ButtonGroup();						// 버튼그룹 생성
			bg.add(samll);
			bg.add(medium);
			bg.add(large);
			// 버튼그룹 정리
			setBorder(BorderFactory.createTitledBorder("크기"));
			
			add(samll);									// 객체에 라디오 버튼추가
			add(medium);
			add(large);
					
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {		// 드라이버 클래스 
		// TODO Auto-generated method stub
		
	}
}

	public class PizzaOrderDemo {						// 드라이버 클래스 
		public static void main(String[] args) {
			MyFrame mf = new MyFrame();
		}
	}