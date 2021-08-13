import java.util.*;

public class StackTest3 {
	
	public static void main(String[] args) {
		/*
		 * ( 스택 넣고 ) 만나면 pop 해서 스택에서 빼고
		 * 주어신 식을 다 처리했을 때, 스택히 empty 가 된다.
		 * 만약 empty 가 아니면 잘못된 식
		 */
		// ( ( ) )  < O >   ( ( )  < X > 
		// ( ( ( ) ) => 처리 후에 스택이 empty가 됨
		// ( ) )     => pop 했을때 인출되는 원소가 없어서, 잘못된 식이다.  ( = push   ) = pop
		
		
		// 1. 먼저 수식을 입력받자.
		Scanner input = new Scanner(System.in); // 콘솔 입력을 위한 Scanner 객체 생성
		System.out.println("수식을 입력하세요.");
		String exp = input.nextLine();	// 입력받은 값을 문자열로 받는다
		
		// 2. 입력받은 수식을 공백을 기준으로 문자열 토큰으로 분리하자..
		StringTokenizer st = new StringTokenizer(exp);	// exp 문자열 변수의 값을 받아서 공백을 기준으로 문자열 토큰들로 분리.
		
		// 3. 토큰을 하나씩 뜯어 보면서 여는 괄호이면 스택에 push , 닫는 괄호이면 스택에 pop
		Stack<String> stack = new Stack<>();
		
		while(st.hasMoreTokens()) {   // 아직 줄 토큰이 남았는지 반복 = st.hasMoreElements() 써도 동일.
			String token = st.nextToken();
			// token이 여는 괄호이면 stack에 push 
			if (token.equals("(")) stack.push("(");
			// token이 닫는 괄호이면 stack에 pop , But 스택에 아직 원소를 입력받은게 없어서 에러
			else if (token.equals(")")) {
				// 근데 stack에 원소가 하나도 없다면 닫는 괄호에 매칭되는 여는 괄호가 없다는 의미 ,, 다른 토큰 볼 필요도 없이 종료 ( break )
				if (stack.isEmpty()) {
					System.out.println("잘못된 식입니다...");
					return;
				}
				stack.pop();
			}
			
			
		}
			// 흐름이 여기까지 왔다는 것은
			// 식에 잘못된 것이 없거나 , 여는 괄호가 더 많은 경우 라고 볼 수 있다.
			// 모든 토큰 처리가 끝났고, 그 때까지 잘못된 괄호가 발견되지 않았다.
		if (stack.isEmpty() != true) {
			System.out.println("잘못된 식입니다...");
			return;		// void 라서 값을 return 할 수는 없다 ,  그냥 return; 씀...
		}
		
		// StringTokenize 를 사용하였기 때문에 입력값을 ((  <x>   ( (   <o>   () <o>  ( ()   <x>
		
	
			
		
		
		
		
		
	}
	
			
}
