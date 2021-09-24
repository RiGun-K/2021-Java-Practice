package rigun;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

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
