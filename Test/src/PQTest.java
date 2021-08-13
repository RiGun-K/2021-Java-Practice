import java.util.*;

public class PQTest {
	public static void main(String[] args) {
		test1();
	}
	
	
	public static void test1() {
		Queue<String> q = new PriorityQueue<>();
		
		// 추가하기 = add() 는 인셉션 , offer() 는 false 반환
		q.offer("PineApple");
		q.offer("Banana");
		q.offer("Carrot");
		q.offer("Cheery");
		q.offer("Strawberry");
						
		//엿보기...인출은 아니야~
		// 다음에 인출된 원소가 무엇인지만 확인 (큐에서 삭제 X) 
		// 원소가 없으면 element()는 인셉션 peek() null 반환
		
		System.out.println(q.peek());	 
		System.out.println(q.peek());
		System.out.println(q.peek());
		System.out.println("$$$$$$$$$$$$$$$$$$$");
	
		while(q.size() > 0) { // 뺄때마다 사이즈가 줄기때문에 하나씩 빼다가 마지막에 없으면 0 이되기때문에 0보다 큰값을 넣어서 마지막까지 반복
			System.out.println(q.poll());	// 제거하기 = q.remove() 는 입센션, q.poll() 는 null 반환
		}
	
	}
}
