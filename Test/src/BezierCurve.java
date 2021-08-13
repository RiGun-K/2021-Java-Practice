import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;

public class BezierCurve extends JPanel implements MouseListener, MouseMotionListener {
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};

	private int drageIndex = -1;  // 현재 선택된(클릭)된 점

	public BezierCurve() {
		
	}

	@Override
	public void paintComponent(Graphics g) {
		 // 점 4개 찍기
		g.setColor(Color.blue);
		g.fillRect(xs[0], ys[0], 16, 16);
		g.fillRect(xs[2], ys[2], 16, 16);
		
		g.setColor(Color.red);
		g.fillRect(xs[1], ys[1], 16, 16);
		g.fillRect(xs[3], ys[3], 16, 16);
	
		// 점 4개를 이용해서 베지어 곡선 그리기
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.black);
		GeneralPath path = new GeneralPath();
		path.moveTo(xs[0], ys[0]);
		path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
		
		g2d.draw(path);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (drageIndex != -1) {
			xs[drageIndex] = e.getX();
			ys[drageIndex] = e.getY();
		}
		
		repaint();
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		drageIndex = -1;
		// 4개의 점 중에서 어떤 점을 찍었는지 검사
		e.getX(); e.getY();
		
		for (int i =0; i < 4; i++) {
			Rectangle r = new Rectangle(xs[1]-4, ys[1]-4, 20, 20);
			if (r.contains(e.getX(), e.getY()) == true); {
				drageIndex = i;
				break;
			}
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
