package rigun;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

class MyListener1008 implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		int keyCode = e.getKeyCode();
		boolean control = e.isControlDown();
		System.out.println("keyTyped " + c + " " + keyCode + " Ctrl :" + control);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class MyFrame1008 extends JFrame {
	// 생성자
	MyFrame1008() {
		setTitle("");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setLayout(new FlowLayout());
		
		// 이벤트가 적용될 컴포넌트 생성 !
		JTextField tf = new JTextField(30);
		
		// 리스너 등록
		MyListener1008 listener = new MyListener1008();
		tf.addKeyListener(listener);
		
		add(tf);
		setVisible(true);
		
		
	}
}

public class Class_1008 {
	public static void main(String[] args) {
		MyFrame1008 mf = new MyFrame1008();
	}
}
