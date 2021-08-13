import java.util.*;			// 사용하려는 패키지가 util 패키지에 있음
public class DequeTest {
	public static void main(String[] args) {
		/* 
		 *  Dequq 는 인터페이스.
		 *  이 놈을 구현한 구현 클래스는  ArrayDeque.
		 */
//		Deque<Integer> deque = new Deque<>(); 	//  *  인터페이스의 인스턴스 생성은 X
		Queue<Integer> queue = new ArrayDeque<>();
		/*
		 * Queue : a, b 메소드가 있다면
		 * ArrayDeque : a, b, c, d, e 메소드 가능 
		 */
	 		// q.a(), q.b()  <-- 0
			// q.c()         <-- X 
		
		

		// 1. 큐에 임의 수 10개를 넣고
		// 2. 안에 어떤 순서로 들어가 있는지 보고
		// 3. 하나씩 인출해보자. 	<= FIFO 순으로 나오는지 확인해보자.
		for (int i = 0; i < 10; i++) 
			queue.add(i + 1);				// queue의 사이즈가 1씩 증가 , add() 사용
		
		System.out.println(queue);
		// [1,2,3,4,5,6,7,8,9,10]
		// poll 메소드로 하나씩 인출, FIFO 순으로 나와야 한다.
		// 1, 2, 3, ... 10
		// 큐에 원소가 있으면 인출하자...
		
		while ( /* queue.size() > 0  queue.isEmpty() */ // ture,false값 
				!queue.isEmpty()) {
//			Integer val = queue.poll();		// queue의 사이즈가 1씩 감소 , poll() 사용
			Integer val = queue.remove();
			System.out.println(val);
		}
		System.out.println("큐의 상태...");
		System.out.println(queue);		
		
	}


}
