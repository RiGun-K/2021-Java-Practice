import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;	// 배열을 List로 바꿔줌
import java.util.List;


public class CollectionAPITest {
	private String name;		// instance 
	
	public CollectionAPITest(String name) {
		this.name = name;
	}
	
	public String getName() {	// instance 메소드로 만드는게 낫다.
		return name;		
	}
	
	public static void main(String[] args) {
	String[] sample = { "i","walk","the","line" };
	List<String> list = Arrays.asList(sample);
	
	// Collections 의 sort 메서드는 List 타입을 인자로 가진다.
	System.out.println("정렬 전 ....");
	System.out.println(list);
	
	// 기본 오름차순 정렬 // set , queue 는 안 받음 , list 사용
//	Collections.sort(list); 
	
	// 내림차순 정렬 // Comparator 인터페이스 사용  // reverse = 뒤집는다.
	// 1) 원소의 타입 클래스를 내가 변경할 수 있으면 Comparable 를 구현해서 변경 
	// 2) 변경 할 수 없으면 (String , Integer.. 등)  Comparator 클래스를 구현해서 정렬
	// 3) 그 클래스를 변경하지 않고 Comparator 클래스를 구현하기 위해 정렬 방법을 변경할 수 있다.
//	Collections.sort(list, String 원소의 새로운 정렬방법); ↓
	Collections.sort(list, new MyStringComparator()); 	// MyStringComparator 클래스를 받아와서 반환
	
//	Collections.sort(list,Comparator.reverseOrder());	
	System.out.println("내림차순 ....");
	System.out.println(list);
	
	// 		(Static) 정적 메소드 < --- > (Instance) 인스턴스 메소드 
	//	정      적 메소드 : 
	//	인스턴스 메소드 :	 객체 마다 값에 접근 
	
	
	}
	
	// 인스턴스 메소드 , add 가 하는 일은 인자로 전달된 두 값을 더하고 결과를 반환
	public int add(int x , int y) {
		return x+y;	
	}

}
