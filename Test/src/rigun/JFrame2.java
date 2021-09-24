package rigun;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame {
	public MyFrame() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("홍길동");
		
		JButton button1 = new JButton("확인");
		// 컨테이너에 컴포넌트를 추가하기 위해 add 메소드를 추가한다.
		// 추가 전 컨테이너에 레이아웃을 설정해야 함 
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		 
		this.add(button1);
		
		setVisible(true);
	}
}

public class JFrame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame f = new MyFrame();
	}

}
