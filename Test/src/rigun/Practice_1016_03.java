package rigun;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame_1016 extends JFrame {
	MyFrame_1016() {
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("중간고사 프레임 연습");
		
		// 컴포넌트 비율 자동조정
		setLayout(new FlowLayout());	
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("누르지말라했다.");
		
		JButton button = new JButton("누르지마");
		JButton button2 = new JButton("눌러도 되");
		button.setEnabled(false);
		
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		t2.setEnabled(false);
		// 1차적으로 컴포넌트들을 panel 에 추가
		panel.add(button);
		panel.add(button2);
		panel.add(label);
		panel.add(t1);
		panel.add(t2);
		// 추가된 panel 을 추가
		this.add(panel);
		setVisible(true);
	}
}

public class Practice_1016_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성자 호출
		MyFrame_1016 f = new MyFrame_1016();
	}

}
