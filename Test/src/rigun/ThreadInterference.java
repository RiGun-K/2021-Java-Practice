package rigun;

class Counter {
	int value;
	
	// synchronized - 동기화 기법 - 0만 출력됨 
	synchronized void inc() {
		value++;
	}
	
	synchronized void dec() {
		value--;
	}
	
	synchronized void printCounter() {
		System.out.println(value);
	}
}


class MyThread extends Thread {
	Counter sharedCounter;	// 객체
	
	// 카운터를 매개변수로 
	MyThread(Counter c) {
		this.sharedCounter = c;
	}

	@Override
	public void run() {
		int i = 0;
		while(i < 1000000) {
			sharedCounter.inc();
			sharedCounter.dec();
			if( i% 100 ==0) {
				sharedCounter.printCounter();
			}
			try {
				sleep( (int) (Math.random()* 3));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
		
	}
	
	
}

public class ThreadInterference {

	public static void main(String[] args) {
		// 공유자원 객체 생성
		Counter c = new Counter();
		
		// 쓰레드 객체 생성 
		MyThread t1 = new MyThread(c);
		MyThread t2 = new MyThread(c);
		
		t1.start();
		t2.start();
	}

}
