package rigun;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyButton extends JFrame {

	// JFrame틀을 상속받아와서 나머지 컨테이너(버튼 등)을 작성하여 완성시켜보자 ! 
	MyButton() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("김리건");
	
		// 배치 레이아웃 객체를 생성하여 지정한다.
		 setLayout(new FlowLayout());
		
		// 2. 컨테이너 안에 컴포넌트(버튼)을 추가한다.
		JButton button = new JButton("누르지 마시오");
		
		// 3. 버튼생성 후 컨테이너에 추가한다.
		this.add(button);
		
		setVisible(true);
		}
}

public class JButtonTest {
	
	public static void main(String[] args) {
	MyButton b = new MyButton();

	}


}
