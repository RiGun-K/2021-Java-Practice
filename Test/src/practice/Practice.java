package practice;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 자료형(타입) 변수명
		// 첫글자는 소문자 , 두단어 이상은 이후 첫글자에 대문자
		int count = 10;
		
		count = 20;
		// count = 11.1;  ( X - 자료형 double로 작성 )
		System.out.print(count);
		
		// 하나의 정해진 값은 상수를 사용하면 편리하다 
		final int PRICE = 8920;
		int time = 5 * PRICE;
		System.out.println("오늘 내가 일한 일당은" + time + "입니다.");
	
	    ///////////////////////////////////////////////////////
		
		/*
		 * 자료형 타입
		 * 
		 *  char ( 2byte , 한 글자만 가능 )
		 *  -> byte -> short -> char -> int -> long
		 *  
		 *  실수형
		 *  float -> double 
		 *  단, float 는 값 뒤에 f를 붙여야 함 ! 
		 *  = float f = 32.4f;
		 */
		
		int x = 50000;
		long y = x;
		/* 묵시적 형변환
		 * 작은놈 (int) => 큰놈 (long) 형변환 ( O )
		 * 큰놈 => 작은놈 형변환 ( X ) 
		 */
		long x2 = 5;
//		int y2 = x2;
		int y2 = (int) x2;
		// 명시적 형변환 = 타입을 ( ) 붙여주면 가능 ! 
		
	}

}
