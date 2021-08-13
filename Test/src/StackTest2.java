import java.util.*;

public class StackTest2 {
	public static void main(String[] args) {
		String str = "apple banana carrot pineapple grape mango strawberry watermelon melon orange tomato";
		
//		String s = str.substring(0, "apple".length());
//		System.out.println(s);
		// 공백문자를 기준으로 하나씩 짤라 주세요
		// 구분자를 입력으로 주고 , 그 구분자(delimiter)로 구분되는
		// 문자열들을 하나씩, 하나씩 뽑아 쓸 수 있게 해주는
		// java.util 패키지의 클래스가 StringTokennizer
		
		StringTokenizer st = new StringTokenizer(str, ", ");
		// ,도 구분자 이므로 "," 가 아니라 ", " (콤마뒤에 한칸 띄우기)
		
//		String s = st.nextToken();
//		System.out.println(s);
	
//		s = st.nextToken();
//		System.out.println(s);
	
		System.out.println("token 수: " + st.countTokens());
		// 토큰을 다 찍어 보는 방법 1 : 토큰의 수만큼 for 문 돌기...
		
		// 토큰을 다 찍어 보는 방법 2 : 아직 나에게 줄 토큰이 남아있는지 물어보고 있으면
		//                     nextToken() 메소드를 호출해 하나씩 받아서 사용
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("[" + token + "]");
		}
	
	
	
	
	}
	
}
