package rigun;

class Buffer {
	int data;
	boolean empty = true;
	
	synchronized int get() {
		while(empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		empty = true;
		notifyAll();
		return data;
	}
	
	synchronized void put(int data) {
		// 비어있지 않으면 
		while(!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		empty = false;
		this.data = data;
		notifyAll();
		
	}
}

// 생산자 클래스
class Producer implements Runnable {

	// Buffer 멤버변수
	Buffer buffer;
	
	Producer(Buffer b) {
		this.buffer = b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			buffer.put(i);
			System.out.println("생산자: " + i + "번 케이크 생산" );
		}
		
		// 예외처리 
		try {
			Thread.sleep( (int)(Math.random()*3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}

// 소비자 클래스
class Consumer implements Runnable {


	// Buffer 멤버변수
	Buffer buffer;
	
	Consumer(Buffer b) {
		this.buffer = b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<10; i++) {
			int data = buffer.get();
			System.out.println("소비자: " + data + "번 케이크 생산" );
		}
		
		// 예외처리 
		try {
			Thread.sleep( (int)(Math.random()*100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

public class ProducerConsumerTest {
	// 공유자원 인 Buffer 객체를 생성 
	Buffer b = new Buffer();
	
	// 생산자 쓰레드 객체를 생성
	Thread p1 = new Thread(new Producer(b));
	p1.start();
	
	// 소비자 쓰레드 객체를 생성 
	Thread c1 = new Thread(new Consumer(b));
	c1.start();
}
