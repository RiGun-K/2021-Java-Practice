  // scanner 안써도 호환 
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Tests {
	
	public static void main(String[] args) {
		add(50, 10);
		System.out.println(add(50, 20)); // return값 받아서 호출
		System.out.println(add(30,10,30));
		System.out.println(add(1,2,3,4,5));
		// 메인 메소드가 길게 작성된다면 추가로 분리해서 작성하는게 좋다
		
		
		Person person = new Person();
		Person person2 = new Person("홍길동",10);
		
//		 제대로 출력되지 않으므로 toString 메소드 생성 ,,밑 하단 참고
		System.out.println(person);		// null , 0 출력
		System.out.println(person2);	//
		
		
		
//  print ( 가로 정렬 )   //  println (세로 정렬 )
		
		System.out.printf("안녕하세요 %s 입니다. 나이는 %d이고 키는 %dcm 입니다.\n","김리건", 27, 173);
/*		
		String s = String.format("저는 %s입니다. 나이는 %d이고 키는 %dcm입니다.", "김리건", 27, 173);
		System.out.println(s);
	
//		String str = "100";
//		int i = Integer.parseInt(str); // 변수 i 에 문자열 str를 숫자형으로 바꾼후 저장
		
		System.out.println(i+30); 		// 130
		System.out.println(str+30);   // +연산자는 피연산자중 하나라도 문자형이면 뒤에 정수형이 오더라도 정수형을 문자형으로 변환후 두개의 문자를 붙인다. 10030
		
//		String str2 = String.valueOf(i); // 반대로 i를 String 열로 변환 
		
//		System.out.println(str2);
//		System.out.println(str2+30);
		
		Random random = new Random();
		int rand = random.nextInt(5)+5;
		System.out.println(rand);
*/		
		
//		Scanner scanner = new Scanner(System.in); 
//		System.out.println(scanner.next()); 
		
//		String str = scanner.next(); 
		// 사용자로부터 입력받은 값을 변수 (문자열)에 담을수 있다.
	
//		int i = scanner.nextInt();
		// int 값을 받는다.

/*		
		int z = 5;
		if ( z > 7) {
			System.out.println("거짓입니다.");
		}	else if ( z > 6 ) {
				System.out.println("거짓입니다.");
		}	else {
				System.out.println("참입니다.");
		}
		
		 // 삼항 연산자 
		
		boolean x = true;
		boolean y = false;
		
		String str;
		
		str = x ? "정답입니다" : "거짓입니다.";
		// 문자열 변수 = 불린변수 ? "문자열" : "문자열";
		System.out.println(str);
		
		
		//   && 모두 참   || 하나만 참   ! 반대
		if ( x || y ) {	
			str = "성공"; 
		} else { 
			str = "실패";
		}
		System.out.println(str);

		
		
		switch (str) {	// boolean 변수는 못옴 str 값을 기준으로 판단한다.
			case "성공":
				System.out.println("0");
				break; // 참 일경우 이후 조건문 판단을 끝낸다 
			case "실패":
				System.out.println("X");
				break;
			default:
				System.out.println("?");
		}
*/		
		// default 값은 case 값들이 아니면 출력 
		
/*		
		//	       초기화		조건        증감
		for ( int i=0; i <10; i++) {
//			if ( i == 7) { 		// i 가 7일경우 == 
//				break;	}		// 멈춘다 7까지 호출
				
			if ( i == 4) {		// i 가 4일경우  
				continue;		// 4만 빼고 호출한다.
			}
			System.out.print(i);
		}
		
		int i =0;
		while ( i < 10) {
			i++;
			System.out.print(i);
		}
		
		int z =0;
		do {
			System.out.println(z);
			z++;
		} while ( z < 10);
		
*/		

		
/*		
		int[] score;				// 선언
		score = new int[5];			// 할당

		int[] score1 = new int[5];	// 선언과 동시에 할당
		
		int count = score.length;	// 배열 score의 개수(길이)를 count에 할당
		System.out.println(count);	// score의 개수 (5) 를 출력
		
		// 배열의 index는 0 부터 마지막-1 까지 
		// 0번째 = 즉 첫번째 값을 10을 할당후 출력가능
		score[0] = 10;
		System.out.println(score[0]);
		
		
		// 배열의 각 index에 숫자를 한번에 할당 가능
		// score2[1]의 값은 20 출력  , 전체길이 -4 또한 20 출력  
		int[] score2 = {10, 20, 30, 40, 50};
		System.out.println(score2[1]);
		System.out.println(score2[score2.length - 4]);
		
		// length(5)의 값을 받아서 for문을 돌려 활용하는 모습 
		// 0,1,2,3,4 호출
		for (int i =0; i < score.length; i++) { 
			System.out.println(i);
		}
	
		
*/	
		
		// int[] score = new int[2];
		// String[] name = new String[2]; 
		// [0] 호출시 int는 0으로 초기화, String은 null 값 호출 !!!
		
/*		
		String[] name = { "김리건", "할수있다." };
		System.out.println(name[0]);
		System.out.println(name[0].length());	// 문자열 "김리건" 3글자
		
		String[] name1 = new String[2];
		System.out.println(name1[0]);			// null 값 호출 비어있음
		System.out.println(name1[0].length());	// 비어있으므로 에러 
		
*/		
		// 배열사용 ArrayList = int , String 보다 훨신 효율적
		
		// 내부에 어떤값을 저장할지 <> 로 지정함 
		// 자바에는 int , long 처럼 동일하게 rapper클래스 사용  / ex)Integer,valueOf..
		
		 
		ArrayList<Integer> scoreList = new ArrayList<>();
		scoreList.add(10);	
		scoreList.add(20);	// 1번째 크기에 20 할당
		scoreList.add(30);
		
		System.out.println(scoreList.size()); // 리스트에 담긴 크기 3 호출
		System.out.println(scoreList.get(0)); // 0번째 값 10 호출
		
		// 중간중간에 값을 추가하는것이 편리함.
		// 인덱스1 에 100 추가
		scoreList.add(1, 100);
		scoreList.remove(2);
		// 인덱스2에 값을 제거
		
		System.out.println(scoreList);
		//24.03
		
		
		
		 
		
		// 4/8
				
		
	}	
							// ( ) 안에 인자가 `파라미터`
	
	// return을 반환하도록 메소드를 만들수 있다.
	public static int add(int x, int y) {
		return x + y;
	}
	
	public static int add(int x, int y, int z) {	
		return x + y + z;
	}
	
	public static int add(int ... numbers) { // 0개 부터 숫자를 제한없이 지정( 들어올수도 있고 안들어올수도없고 배열로 들어옴)
		int sum = 0;
		for (int i =0; i < numbers.length; i++) {
			sum = sum + i;
		}
		return sum;
	}						// 메소드 오버로드
	
	
	

}
	
	 	
//4/12 클래스 	: 클래스는 서로 겹치지 않게 작성한다 ( 이너클래스 ) 

class Person{
	private String name;	
	private int age;
	
	// 생성자 만들기 ( 일반적으로 클래스 이름과 동일한 기본 생성자 )
	Person() {
		
	}
	
	// 필드를 전달받아 만드는 오버로드 된 생성자
	Person(String name, int age) { // 이름과 나이를 받아서 
		this.name = name;	// this 는 외부에서 name이라는 변수를 통해서 넘어온 값 , 초기화 작업 
		this.age = age; 	
	}
	
	// Setter 만들기 : 마우스 오른쪽 + Source + 제너레이트 소스 and Setter 클릭 
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
	}
	
	// toString 메소드 생성 
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	// 메소드안에 코드가 많아지면 여러 메소드로 분리 , 메소드가 클래스 안에 많아지게되면 클래스 또한 여러가지로 만들어야 함, 클래스가 '' 패키지로 만듬
	
}




