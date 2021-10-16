package rigun;

import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel1016_05 extends JPanel {
	// 컴포넌트에 그리는 메소드 , x는 → y는 ↓ 갈수록 증가 
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawString("안녕하세요", 10, 10);
		g.drawLine(10, 20, 110, 20);
		g.drawRect(10, 30, 100, 100);
	}
}
class MyFrame1016_05 extends JFrame {
	MyFrame1016_05() {
		setTitle("ㅇㅅㅇ");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel1016_05 p = new MyPanel1016_05();
		setVisible(true);
		this.add(p);
	//  = this.add(new MyPanel016_05()); 따로 선언 안하고 바로 생성자로 추가해도 가능
		
	}
}

public class Practice_1016_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame1016_05 f = new MyFrame1016_05();
	}

}
