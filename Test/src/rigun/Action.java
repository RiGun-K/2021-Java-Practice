package rigun;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyListener implements ActionListener {
	int count = 1;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyFrame3.button.setText(count++ + "번 버튼이 눌러졌어여");
		
		if(count == 15) {
			MyFrame3.button.setText("그만 눌러라 이놈아");
		}
	}
	
}

// MyFrame은 동일 패키지에 이미 사용중이므로 해당 Frame이 실행되므로 MyFrame3으로 변경하였음..

class MyFrame3 extends JFrame {
	static JButton button;
	MyFrame3() {
		setTitle("그래픽");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		button = new JButton("버튼을 눌러 주세요");
		add(button);
		
		// 이벤트 리스너를 이벤트 소스에 등록한다. 
		button.addActionListener(new MyListener());
		
		setVisible(true);
	}
	
}

public class Action {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame3 f = new MyFrame3();
	}

}
