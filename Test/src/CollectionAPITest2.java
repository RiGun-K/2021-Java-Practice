import java.util.*;

public class CollectionAPITest2 {
	
	public static void main(String[] args) {
//		shuffLeTest();
		
	// 이진탐색은 정렬된 리스트에서 원하는 값을 찾아주는 방법
		binarySearchTest();
		
	}

	public static void shuffLeTest() {
		List<Student2> list2  = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			Student2 std = new Student2();
			std.grade = (i+1)*99;
			list2.add(std);
//			list.add((i+1)*2);
		}
		System.out.println("섞기 전");
		System.out.println(list2);
		
		Collections.shuffle(list2);
		System.out.println("섞은 후");
		System.out.println(list2);
		
	}
	
	public static void binarySearchTest() {
		// 1. 무작위 정수를 저장한 리스트에 대해 이진탐색   < = 잘못된 결과가 나오는 경우.
		// 2. 정렬된 리스트에 대해 이진탐색    < = 이렇게 사용해야 함..
		
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i =0; i < 10; i++) {
			list.add(random.nextInt(20));			// 배열의 값의 최대 크기 = 1 ~ 20 까지 
		}
		
		Collections.sort(list);			// 정렬된 방식으로 반환 , 없으면 랜덤으로 
		System.out.println(list);

		// 원소의 크기가 1000개 인 정렬된 배열에서 원소를 찾는 법 : 중간에 반을 나눠서 원하는 값보다 작으면 자르고 또 자르고 하는 식으로
		// 그 방식을 반복해서 찾는 행위의 수 : 2의 n승 ( 행위의 수 ) >= 1000   = 10번 반복하면 찾을 수 있다...
		
		int idx = Collections.binarySearch(list, 7);	// 원하는 값을 설정 
		if (idx >= 0)
		System.out.println((idx+1) + "번째에 있습니다.");
		else { 
			System.out.println(idx);					// 해당 위치에 왔어야 한다는 뜻
			System.out.println("찾고자 하는 값은 리스트에 없습니다.");
		}
	
	
	
	}	
	
	
}

class Student2 {
	int grade;
	public String toString() {
		return String.valueOf(grade);
	}
}
