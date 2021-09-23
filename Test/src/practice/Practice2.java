package practice;

import java.util.Iterator;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *  연산자  : + - / % ...
		 * 피연산자  : 변수 리터럴 ( 대상이 되는 데이터 )
		 */

		int i1 = -5;
		int i2 = +i1;
		int i3 = -i1;
		
		System.out.println(i2); // -5 ( 그대로 )
		System.out.println(i3); //  5 ( 전환 )
		
		int i = 5;
		int j = 2;
		int k = 10;
		System.out.println(i / 2); // 정수값 2출력 
		System.out.println(i /(double)j ); // 실수형으로 형변환하면 2.5 출력
		System.out.println(i % j); // 나머지 값 1출력
		System.out.println(i - j * k); // 5 - 20 = 15
		/////////// sysout + ctrl + space 단축키  //////////////////
		
		
		
		// 1. == 같다
		// 2. != 다르다
		// 비교값은 true false 로 출력됨 
		
		// a = ++b	// 전위연산자 , b에 1 증가 후 a에 대입  
		// a = b++  // 후위연산자 , 먼저 a에 대입후 1 증가
		System.out.println(i++ - 5);	// 0
		System.out.println(i);			// 1 + i 
		/* 변수의 값은 출력후 사라지지 않고 메모리에 저장됨 */
		
		
		// ( && > || )
		// && = 양 쪽 모두 true => true
		// || = 하나만 true => true
		System.out.println(i > j && j > k);
		System.out.println(i > j || j > k);
	}

}
