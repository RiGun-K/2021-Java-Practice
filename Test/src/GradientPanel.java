import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class GradientPanel extends MyPanel {
	//모든 자바는 생성자 1개를 가지기 때문에 만들지 않아도 눈에 보이지 않지만 존재한다.
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		GradientPaint gp = new GradientPaint(0, 10, Color.white, 0, 70, Color.red);
			// 도형 내에서의 x,y좌표를 뜻함.
		
		for(Shape s : ShapeArray) {
//			g2.setPaint(Color.red); // 빨간색
			g2.setPaint(gp);  //그라디에이션
			g2.fill(s);
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600, 130);
		frame.setTitle("Java 2D Shapers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.add(new GradientPanel());
		frame.setVisible(true);
	}
}
