import java.util.*;

public class ListTest {

	public static void main(String[] arg) {
		test1();

	}
 
	public static void test1() {
		// List<String> list = new ArrayList<>();
		List<String> list = new LinkedList<>(); // LinkedList를 써도 호환됨 나중에 다른 리스트 종류를 써도 편함,
		// "자동차", "운동장", "유치원" ...;
		
//		list.add("자동차");
//		list.add("운동장");
//		list.add("유치원");    // 일일이 하나하나 넣는것이 불편
		
		// for문 돌려서 넣는다
		String[] sArr = {"자동차", "운동장", "유치원", "학교"};
		for (String s : sArr) list.add(s);
		
		System.out.println(list); // ArrayList 의 toString() 메소드가 이용
		
		for (int i=0; i < list.size(); i++) {
			System.out.println(list.get(i)+ " "); // 하나씩 호출한다.
			System.out.println(); // 다 찍고 줄 바꿔라
		}
	
		for (String s : list) System.out.println(s + " ");
			System.out.println(); // 다 찍고 줄 바꿔라
		
			// Iterator를 사용하여 원소들에 접근할수 있도록 만든다
		Iterator<String> iter = list.iterator();	
		
		while (iter.hasNext())
			System.out.println(iter.next() + " ");
		System.out.println();
		// next 값을 하나씩 호출하는데 호출할 배열이 있는지 없는지 판단해준다 - hasNext()
		// 다 돌았으면 더이상 안돌아감 , 즉 다시 요청을 해야 돌아감 ( iter = list.iterator(); 으로 다시만듬)
		
		// overloading된 add 메소드로 원소를 중간에 삽입할 수 있다.
		list.add(1, "さくら"); 
		
		list.remove(list.size()-1); // 중간에 삭제 remove 할 수 있다. 마지막 원소 삭제 = size-1
		list.remove(0); 			// 첫번째 인덱스 삭제

		while (list.size() > 0) {
			list.remove(0); 
		}  // 다 삭제 됨.. 처음 0 번째가 삭제되면 한칸씩 앞으로 땡겨오기때문에 하나씩 삭제됨에 따라 결국 다 삭제됨..
		
		
		
//		System.out.println(iter.next()); // 하나씩 빼먹을 수 있다. 0번째 배열값
//		System.out.println(iter.next()); // 1번째 배열값 ...
		
		// unchecked exception은 버그다
		// 이런 exception 자체가 발생하지 않게 코딩해라.. 
		
		
		
		
	}



}
