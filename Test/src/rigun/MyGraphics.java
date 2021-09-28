package rigun;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

	/**
	 * @date 2021년 09월 28일 
	 * @see 그래픽을 사용하여 선,도형 등을 그려보자
	 * 		JPanel 을 상속 받아서 
	 * 		paintComponent 메소드 사용	
	 */


class MyPanel extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// 붓의 색깔을 변경하자 ( 텍스트 출력 전에 설정해야 함 ! ) 
		g.setColor(Color.blue);
		
		// 그래픽 텍스트를 출력하자
		g.drawString("안녕하세요 김리건 님", 10, 10);
		
		g.setColor(Color.red);
		// 선 출력 (10,20) (110,20)
		g.drawLine(10, 20, 110, 20);
		// 사각형 출력
		g.drawRect(10, 30, 100, 100);
	}
}

public class MyGraphics extends JFrame {
	public MyGraphics() {
		setTitle("그래픽");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		MyPanel p = new MyPanel();
		setVisible(true);
		add(p);
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyGraphics f = new MyGraphics();
	}
	
}

