package rigun;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame1016_06_02 extends JFrame {
	
	// 멤버 변수로 선언 ( 생성자나 다른 메소드에 사용하기 위함 )
	private JButton button;
	
	MyFrame1016_06_02() {
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("버튼을 누르시오");
		button.addActionListener(new MyListener1016_06_02());
		
		this.add(button);
		this.setVisible(true);
	}
	
	// 액션 리스너를 내부 클래스로 생성 , button 객체가 같아야 함 ! 
	class MyListener1016_06_02 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == button) {
				button.setText("버튼을 누르셨습니다");
			} else if(e.getSource() != button) {
				button.setText("잘못 누르셨습니다.");
			}
		}
		
	}
}
public class Practice_1016_06_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame1016_06_02 f = new MyFrame1016_06_02();
	}

}
