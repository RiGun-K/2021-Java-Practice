import java.util.Map;
import java.util.*;

public class MapTest {

	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	public static void test2() {
		/*
		 * 친구들 전화번호를 저장하는 map 객체 생성
		 * <이름 , 전화번호> = "홍길동" , "010-1234-1234"
		 * 에서 이름 치면 전화번호 바로 나오게 끔 !
		 */
		String[] names = {"김리건","김우진","박성철","김대호"};
		String[] phones = {"010-1234-1234","010-2345-2345","010-5436-5436","010-5252-5252"};
		
		Map<String ,String> phoneBook = new HashMap<>();	// < > 에 인자 두 개가 와야 함!!
		for (int i = 0; i < names.length; i++) {
			phoneBook.put(names[i], phones[i]);			
		}
		
		Scanner input = new Scanner(System.in);
			while(true) {
			System.out.println("친구 이름:");
			String name = input.nextLine();
			if(name.equals("")) break;
			String phone = phoneBook.get(name);
			System.out.println(name+ " 님의 전화번호는 " + phone + " 입니다. ");	
			// 이름을 치면 출력됨 , 빈값 이나 잘못된 값은 null 반환
			
		}
		
		
		
	}
	
	public static void test1() {
		/*
		 * Map 객체 , HashMap 객체를 생성하자.
		 * 맵은 <Key , Value> 의 쌍으로 젖아하고
		 * key 값을 통해 값을 인출한다.
		 * Map 이라는 놈이 generic 인터페이스이고,
		 * 이를 구현한 HashMap , TreeMap , LinkedHashMap 클래스들은
		 * 재네릭 클래스 라는 것입니다.
		 * 이 의미는
		 * 저 객체들을 생성할 때 타입을 지정해줘야 한다.
		 */
		
		// ArrayList<Integer> list = new ArrayLish<>();
		// ArrayList<Integer> list2 = new ArrayLish<>();
		// ArrayList<Integer> list3 = new ArrayLish<>();
	
		// Map에 <학번, 학생 객체> 로 저장할 예정.
		HashMap<String, Student> map = new HashMap<>();		// HashMap 사용
//		map = new TreeMap<>();
		
		map.put("2001291", new Student(2001291,"김리건"));					// Student 생성자에 해당하는 인자 2개를 작성하여야 함.
		map.put("2001292", new Student(2001292,"김동겸"));
		map.put("2001293", new Student(2001293,"박주형"));
		map.put("2001294", new Student(2001294,"박성철"));
		map.put("2001295", new Student(2001295,"김우진"));
	
		Student value = map.get("2001291");
		System.out.println(value.getName());
		
		map.put("2001291", new Student(2001292, "리건김"));	 // 기존의 값을 덮어쓴다.
		System.out.println(value.getName());				 // "김리건" --> "리건김"
		
		/*
		 * Map 이라는 자료구조에 들어가 있는 모든 원소들을 다 읽을 수 있는 방법은
		 * 1. map 에게 니가 가진 원소의 모든 키 집합을 요청하고
		 * 	    그 집합의 각 원소를 가지고 map에게 값을 요청하는 방법
		 * 2. map 에게 <value 와 key> 쌍으로 저장된 엔트리 집합을 요청해서
		 *    그 집합의 원소를 하나씩 읽는 방법
		 */
		
		Set<String> keyset = map.keySet();					// key 값이 String 이므로 set<String>으로 준다.
		
		// Set의 원소를 하나씩 접근하는 방법은 뭘까요?					// Iterator 사용
		Iterator<String> iter = keyset.iterator();				
		while(iter.hasNext()) {
			String key = iter.next();						// 가진 것들을 다 접근할때까지 무한 반복 ,
			Student val = map.get(key);
			System.out.println("key:" + key + ", value:" + val);
		}
	
		// Map 에서 entry라 함은 , <key , value> 의 쌍으로 구성된 객체.
		// 객체라 함은 이 객체를 정의하는 클래스가 있다는 의미.
		
		
	}
	
}

class Student {
	private int hakbun;
	private String name;
	
	@Override
	public String toString() {
		return "[학번:"+hakbun +", 이름:" + name+"]";
	}
	
	public Student(int hakbun, String name) {
		super();
		this.hakbun = hakbun;
		this.name = name;
	}
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}