import java.util.*;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		 test1();
		
	}
	
	public static void test1() {
		/*
		 * 우선순위 큐 객체를 생성하고
		 * Task 인스턴스를 삽입, 인출 해보자..
		 */
		
		// 우선순위 큐는 기본적으로 오름차순으로 인출된다.
		Queue<Task> queue = new PriorityQueue<>(new TaskComparator()); // 큐가 제네릭이니 <> 안에 클래스를 주자 <Task> // 큐 객체 생성
		
		queue.offer(new Task("작업1", 3));			// Task의 객체 생성 ,우선순위 5 지정
		queue.offer(new Task("작업2", 2));			// add말고 offer (실패시 false 반환) 생성 
		queue.offer(new Task("작업3", 4));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 5));
		// 작업4 - 작업2 - 작업1 - 작업3 - 작업5 순으로 인출
		
		while(queue.isEmpty() == false) { // 원소가 하나도 없을때 까지 원소를 뽑아낸다 
			Task task = queue.poll();	
			
			System.out.println(task);
		}	
		
	}
}

// 클래스 안에 클래스를 두면안됨. (이너 클래스)

class Task implements Comparable<Task> {  // Task 인스턴스를 비교가능한 객체로 생성하기 위해 Comparable 인터페이스 구현. 
	String desc; 	// Task에 대한 설명
	int priority = 5;   // 이 작업의 우선순위의 값을 받는다
	
	@Override 		// Object 클래스에 정의된 toString 메소드를 재 정의 하는것
	public String toString() {
		return "[desc:"+desc+", priority:"+priority+"]";
	}
	
	public Task(String desc, int priority) {
		this.desc = desc;			// 생성자 생성
		this.priority = priority;
	}

//  @Override	// 부모로 부터 상속받은것을 재 정리 하겠다.
	public int compareTo(Task o) {		
		// TODO Auto-generated method stub
		
		// 값을 비교해서 이 객체의 값이 같으면 0 ,크면 양수 ,작으면 음수 반환
//		return this.priority - o.priority;  	
		return (-1) * (this.priority - o.priority); 
		
	}
	

}


class MyQueue <T extends Comparable> {
	Object[] list = new Object[5];
	int idx = 0;
	public boolean offer(T value) {
		list[idx++] = value;
		if (((T)list[0]).compareTo(value) == 0) {		// 0과 같으면 동일
			
		} else if (((T)list[0]).compareTo(value) > 0) { 	// 0 보다 크면 내림차순
			
		} else {		// 0보다 작으면 오름차순
		
		}
		return true;
	}
	
}

class TaskComparator implements Comparator<Task> {	// <---> Comparable // 메인 메소드에서 이것을 실행

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o1.priority - o2.priority;  	// o2 - o1 = 내림차순 ,  o1 - o2 = 오름차순
	}
	
}

