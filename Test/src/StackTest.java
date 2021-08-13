import java.util.*;

public class StackTest {
	public static void main(String[] args) {
		/*
		 * Stack : LIFO (Last In First Out)
		 * 추가 : push( )  
		 * 인출 : pop( )
		 * 다음 인출될 원소가 무엇인지 보기 (스택에서 삭제 X) : peek( )
		 */
		/* Generic : 클래스 내부에서 사용할 데이터 타입이 정해진 것이 아니라
		 * 			  그 클래스의 객체를 생성할 때 결정할 수 있도록,
		 *   		  사용할 데이터 타입을 파라미터로 받아서 객체를 생성하는 것.
		 * 			 = 타입 파라미터 (Type Parameter)
		 */
		Stack<Integer> stack = new Stack<>(); 
		for (int i = 0; i < 10; i++) { 
			stack.push(i + 1);		
		}
		System.out.println(stack);		// 1,2,3,4,5,6,7,8,9,10 출력
		
		
		while(!stack.isEmpty()) {   	// !붙여서 아닌동안 반복한다.
			Integer val = stack.pop();	// pop( ) 사용하여 빼낸다.
			System.out.println(val);	// 10,9,8,7,6,5,5,4,3,2,1 출력
		}
		// 큐하고 스택의 차이점? 큐는 선입선출 스택은 후입선출
		
		
	
	}


}
