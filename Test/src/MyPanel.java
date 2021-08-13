import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.*;

public class MyPanel extends JPanel implements ActionListener { // JPanel을 상속받는다.
		private Timer timer; // 멤버변수 선언
		private BufferedImage image;
		private final int START_X = 0;
		private final int START_Y = 250;
		private int x,y;
		
		public MyPanel()  {
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension (500, 300));
			this.setDoubleBuffered(true);
			
			File file = new File("space.jpg"); // 파일 객체 생성  + 상대경로 설정
			System.out.println(file.getAbsolutePath());
			try {
				image = ImageIO.read(file);
			}	catch(IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
			x = START_X;
			y = START_Y;
			
			timer = new Timer(20, this);   // 20 마다 타이머 이벤트 발생
			timer.start();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image , x , y , this);
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			/* 
			 * 이미지의 x,y 좌표를 적절히 변경
			 */
			x += 1;
			y -= 1;
		
			repaint();
		}
		
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			frame.add(new MyPanel());
			frame.setTitle("애니메이션 테스트");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500, 300);
			frame.setVisible(true);
		}
	}
