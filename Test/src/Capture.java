import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capture {
	public static void main(String[] args) {
		JFrame capture = new JFrame();
		capture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d;
		Rectangle rect = new Rectangle(500, 500);
		capture.setSize(d = new Dimension(500, 500));
		
		JButton btnl = new JButton("화면 캡쳐");
		
		
		
		try {
			Robot robot = new Robot();		// 화면을 캡쳐하기 위한 외부 클래스의 도움을 주는 Robot 클래스 생성
			final BufferedImage image = robot.createScreenCapture(rect);	// 원하는 화면을 캡쳐하여 BufferedImage 객체로 반환
			image.flush();
			
			// 이미지를 표시하는 패널 작성
			JPanel panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(image, 0, 0, d.width, d.height, this);
				}
			};
			panel.add(btnl, BorderLayout.SOUTH);
			panel.setOpaque(false);
			panel.prepareImage(image, panel);
			panel.repaint();
			
			
			capture.getContentPane().add(panel);	// 프레임에 패널추가
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		capture.setVisible(true);
	}

}
