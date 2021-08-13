import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class MoreShapers extends JFrame {
	
	public MoreShapers() {
		this.setSize(600, 130);
		this.setTitle("Java 2D Shapers");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		this.add(panel);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MoreShapers();
	}
	
}

class MyPanel extends JPanel {
	ArrayList<Shape> ShapeArray = new ArrayList<Shape>();
	public MyPanel() {
//		Shape rect = new Rectangle2D.Float(10,10,70,80);
		ShapeArray.add(new Rectangle2D.Float(10,10,70,80));
		ShapeArray.add(new RoundRectangle2D.Float(100,10,70,80,20,20));
		ShapeArray.add(new Ellipse2D.Float(210,10,80,80));
		ShapeArray.add(new Arc2D.Float(310,10,80,80,90,90,Arc2D.OPEN));
		ShapeArray.add(new Arc2D.Float(410,10,80,80,0,180,Arc2D.CHORD));
		ShapeArray.add(new Arc2D.Float(510,10,80,80,45,45,Arc2D.PIE));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRanderingint(RanderingHints.KEY_ANTIALTASING, RanderingHints.VALUE_ANTALTAS_ON);
		
		g2.setColor(Color.black);
		g2.setStroke(new Stroke(3));
		for {Shape s : ShapeArray} {
			g2.draw(s);
		}
	}
	
}

