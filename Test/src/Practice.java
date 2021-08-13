import java.util.*; 		// 클래스 포함 모든것을 출력

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	proper();
		vest();
		
	}
	private static void proper() {

	Scanner input = new Scanner(System.in);	// 컴퓨터가 하는 말을 칠수있도록 만드는 설게도
	
	final double MILE = 1.603; //상수
	int j = 9;					// 변수 선언 + 초기화 
	double y;					// 변수선언
	y = 3.14*3;					// 3.14 , 3 (피연산자) * (연산자) , 수식
	String s = "리건";			// 문자열
	String a = "할수있다";
	
	String z;
	System.out.print("당신은 누구입니까");
	z = input.nextLine();   // 변수를 설정하고 변수=input.nextInt or nextLine 
	System.out.print("나는"+z+"입니다.");
	
	System.out.println(s+"이는"+a);
	
	int[] b;  					// int형의 'b'라는 이름의 배열 생성
	b = new int[10];			// 'b' 라는 배열에 int 형 변수 10 개 생성 , 첫번째 변수는 0 부터 시작 = b[1] = 0 , 0~9 / 1~10 (x) 
	b[0] = 70;					// 'b' 배열 첫번째 변수에 70의 값을 입력
	
	int[] q = new int[10];
	
	for (int i =0; i < q.length; i++) {		// 각 배열의 자리마다 0부터 시작하는 i값을 입력
		q[i]=i;
		System.out.print(q[i]+"");			// 각 자리에 해당하는 i값을 출력
	}
	

	int[] c = new int[5];  		// 배열 선언과 동시에 배열생성
	int d[] = new int[3];       // = 가능
	
	
// 무명배열 - 배열의 이름을 지정하지않고 초기값만으로 배열을 생성 * 안드로이드 프로그래밍에서 주로 사용 
//		 - 배열이 딱 한번 필요하고 다시 참조할일이 없을경우 사용
	
//	new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }
	
	}
	
	public static void vest() {
		int [] numbers = { 10, 20, 30 };  		// for ( 변수 : 배열 ) 
		for (int value : numbers)
			System.out.print(value+"");
		
// ArrayList 배열
		
		ArrayList<String> list = new ArrayList<>();
		list.add("리건");
		list.add("학생");
		list.add("선수");
		
		list.remove(3);
		
		for ( int i =0; i < list.size(); i++) {
			System.out.println(list.get(i));
												}
	
	}

	//05 p188 , 객체 = 상태와 동작의 기능을 가진다
	//			필드 (객체의 상태) , 메소드 (동작 수행) 으로 나뉘어진다.
	
	//	캡슐화 - 관련된 데이터와 알고리즘을 캡슐에 넣어 포장하는것을 의미, 필드(데이터) 메소드(알고리즘)
	//		      서로 관련되어 있는 데이터와 알고리즘을 묶는것 , 캡슐로 감싸 객체 내부를 보호(정보은닉)
	// 	필수적인 데이터들(필드)는 안에 보호 ,, 외부와의 통신을 위하는 메소드는 외부로 공개

	// 	상   속 - 기존의 작성된(부모 클래스)를 이어 받아 새로운 (자식 클래스)를 생성하는것 , 자식은 부모로부터 모든 속성과 동작을 물려받음 , 
	//		     자식 클래스에서 필요한 기능을 추가 또는 변경가능 
	
	//	다형성 - 객체의 동작이 상황에 따라서 달라짐 speak()를 출력하면 개는 '멍멍' 고양이는 '야옹'으로 반응
	//  추상화 - 불필요한 정보는 숨기고 중요한 정보만을 표현
	
	
	/* 자바에서는 일반적으로 하나의 소스파일에는 하나의 클래스만을 담는것이 원칙
	 * 하지만 하나의 소스파일에 여러개의 클래스도 넣을수있다. 이경우 파일에 포함된 여러개 의 클래스들 중에서 
	 * public 이 앞에 붙어있는 클래스의 이름과 소스 파일의 이름이 일치하여야 한다.
	 */

// p211 04 메소드
	
	/*	메소드 (= 멤버함수) 는 클래스 안에 정의된 함수(특정작업을 수행하는 문장들의 모임)
	 *  = 입럭을 받아서 처리결과를 반환하는 상자 , 각 메소드는 하나의 작업만 하도록하자..
	 */
	
//	반환형 메소드이름         매개변수
	int add ( int x, int y) { 
		return x+y; }
// 반환형은 데이터 타입지정 ,, 값이 없으면 void   // x ,y 는 add() 의 매개변수이다.

/*	int sum;
/	Television obj = new Television();		
	sum = obj.add(2,3);		// 2와 3은 인수로써 add()로 전달된다.
	System.out.print("2와 3의 합은" + sum);
*/	
	 
	 

	

}
	
	
