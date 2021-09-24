package rigun;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	public MyFrame() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("홍길동");
		
		// 아이콘 설정
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("c:\\dd.jpg");
		this.setIconImage(img);
		
		// 프레임의 위치를 선정
			// setLocation(200,100);
		Dimension screenSize = kit.getScreenSize();
		setLocation(screenSize.width/2, screenSize.height/2);
		
//		JButton button1 = new JButton("확인");
//		// 컨테이너에 컴포넌트를 추가하기 위해 add 메소드를 추가한다.
//		// 추가 전 컨테이너에 레이아웃을 설정해야 함 
//		FlowLayout layout = new FlowLayout();
//		this.setLayout(layout);
//		 
//		this.add(button1);
		
	// 1. 패널을 생성
		JPanel panel  = new JPanel();
		JPanel panel2  = new JPanel();
	// 2. 패널에 들어갈 컴포넌트 생성
		JLabel label = new JLabel();
		label.setText("안녕하세요 라벨입니다.");
		JButton button1 = new JButton("확인");
	//	버튼 비활성화 
		button1.setEnabled(false);
		
		JButton button2 = new JButton("취소");
		
		JTextField t1 = new JTextField(15);
		t1.setText("WD-A 학생입니다");
	// 3. 생성된 컴포넌트를 패널에 추가 ( 레이아웃 해줘야 함 )
		panel.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(t1);
	// 4. 완료된 패널을 프레임에 추가 (레리아웃도 해줘야 함 ) 
		this.setLayout(new FlowLayout());
		this.add(panel);
		this.add(panel2);
		setVisible(true);
	}
}

public class JFrame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame f = new MyFrame();
	}

}
