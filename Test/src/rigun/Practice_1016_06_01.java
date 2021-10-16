package rigun;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 1. 리스너를 독립적인 클래스로 작성 
class MyListener1016_06 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		// 이벤트 처리 
		JButton button = (JButton) e.getSource();
		button.setText("ㄹㅇ버튼눌렀구만");
	}
	
}

class MyFrame1016_06 extends JFrame {
	MyFrame1016_06() {
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		this.setLayout(new FlowLayout());
		
		JButton button = new JButton("누르지마시오.");
		// "누르지마시오" 버튼에 이벤트 리스너 등록
		button.addActionListener(new MyListener1016_06());
		this.add(button);
		
		this.setVisible(true);
		
	}
}
public class Practice_1016_06_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame1016_06 f = new MyFrame1016_06();
	}

}
