import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 두 사람이 탁구 게임을 할 수 있는 프로그램을 작성해보자.
// MiniPingPongGame 클래스가 Ball 객체와 Racquet 객체를 포함하도록 설계 

public class MiniPingPongGame extends JPanel implements KeyListener {
	private Ball ball;				// 객체 생성
	private Racquet racquet1;
	private Racquet racquet2;
	
	public MiniPingPongGame() {
		ball = new Ball(this, Color.red);
		this.setBackground(Color.green);
		racquet1 = new Racquet(this, 10, 150, Color.blue);
		racquet2 = new Racquet(this, 560, 150, Color.yellow);
		this.setFocusable(true);
		this.addKeyListener(this);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		racquet1.KeyPressed(e);
		racquet2.KeyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {	// 키보드가 눌리면 라켓에 이벤트 전달
		racquet1.KeyPressed(e);
		racquet2.KeyPressed(e);
	}
	
	private void move() {		// 공과 라켓을 이동
		ball.move();
		racquet1.move();
		racquet2.move();
	}
	
	@Override					// 공과 라켓을 화면에 그린다.
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.draw(g2d);
		racquet1.draw(g2d);
		racquet2.draw(g2d);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Ping Pong 게임");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MiniPingPongGame game = new MiniPingPongGame();
				
		frame.add(game);
		frame.setVisible(true);
		
		while (true) {			// 게임메인 루프로서 공과 라켓을 이동하고 화면에 다시 그린다.
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
		


	
class Ball {
	private static final int RADIUS = 20;
	private int x = 0, y = 0, xSpeed = 1, ySpeed = 1;
	private MiniPingPongGame game;
	private Color color;
		
	public Ball(MiniPingPongGame game, Color color) {
		this.game = game;
		this.color = color;
	}
	
	void move() {				// 공을 움직이는 코드
		if (x + xSpeed < 0)		// 왼쪽 모서리에 닿았다면 xSpeed = 1;
			xSpeed = 1;
		if (x + xSpeed > game.getWidth() - 2 * RADIUS)	// 오른쪽 모서리에 닿았다면 ~
			xSpeed = -1;
		if (y + ySpeed < 0)		// 위쪽 모서리에 ~
			ySpeed = 1;
		if (y + ySpeed > game.getHeight() - 2 * RADIUS)	// 아래쪽 모서리에 ~
			ySpeed = -1;
		if (collision()) {		// 만약 라켓에 닿았다면 xSpeed 값을 반전한다.
			xSpeed = -xSpeed;
		}
		x += xSpeed;
		y += ySpeed;
	}
	
	private boolean collision() {			// 충돌했는지 검사한다.
			
//		true,false 계산, true 이면 true 둘다 false 면 false 
		
//		return game.racquet1.getBounds().intersects(getBounds()) || game.
//		racquet2.getBounds().intersects(getBounds());
		
	
		Rectangle r1 = game.racquet1.getBounds();
		Rectangle r2 = game.racquet2.getBounds();
		Rectangle myr = getBounds();
		boolean r1c = r1.intersects(myr);
		boolean r2c = r2.intersects(myr);
		
		return r1c || r2c;

	}
	
	public void draw(Graphics2D g) {		// 공을 그리는 메소드
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}
		
		
}
	
class Racquet {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 80;
	private int x = 0, y = 0;
	
	
	private int xSpeed = 0;
	private int ySpeed = 0;
	private MiniPingPongGame game;
	private Color color;
	
	public Racquet(MiniPingPongGame game, int x, int y, Color color) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.color = color;
		
	}
	
	public void move() {		// 라켓을 이동하는 메소드, 위쪽 모서리와 아래쪽 모서리 사이에 위치한다면 y += ySpeed;
		if (y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT)
			y += ySpeed;
	}
	
	public void draw(Graphics2D g) {	// x,y 좌표에 사각형 그리기
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void KeyReleased(KeyEvent e) {
		ySpeed = 0;
	}
	
	public void KeyPressed(KeyEvent e) {		// 키 이벤트를 처리하는 메소드 , 위쪽 화살표이면 ySpeed = -3;   / 아래쪽 화살표이면 ySpeed = 3;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			ySpeed = -3;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN);
			ySpeed = 3;
	}
	
	public Rectangle getBounds() {
		return new Rectangle (x, y, WIDTH, HEIGHT);
	}  
}


}
