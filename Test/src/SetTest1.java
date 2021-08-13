import java.util.*;

public class SetTest1 {
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	public static void test1() {
		/*
		 * 
		 * set1 = {2, 3, 4, 5, 6, 7, 8, 9, 10}
		 * set2 = {1, 3, 5, 7, 8}
		 * 합집합 = set1.allAll(set2) = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		 * 교집합 = set1.retainAll(set2) = {3, 5, 7, 8}
		 * 차집합 = set1 - 2 : set1.removeAll(set2) => {2, 4, 6, 9, 10}   ,,  set2 - 1 : set2.removeAll(set1) => {1, 7}
		 */
		
		// Gereric 클래스 객체를 생성할 때 타입 파라미터는
		// 프리미티브 타입을 줄 수 없다. 객체타입만 줄 수 있다.
		// Set은 인터페이스
		// HashSet, LinkedHashSet, TreeSet
		
		Set<Integer> set1 = new HashSet<>();
		// {2, 3, 4, 5, 6, 8, 9, 10}
//		Integer[] arr = {2, 3, 4, 5, 6, 8, 9, 10};
		/*
		 * set1.add(2);
		 * set1.add(3); 
		 */
		// 배열을 Collection객체로 만들어주는 객체가 있다.  		HastSet, LinkedHashSet, TreeSet
		
		// LinkedHashSet 은 입력순서대로 출력 // TreeSet은 값에 따라 정렬된 순서로 인출됨 // HashSet은 랜덤으로 출력 
		
	//	List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10);
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 7, 6, 5, 4, 3, 2);
		set1.addAll(list);
//		set1.add(2); set1.add(3); set1.add(4); set1.add(5); set1.add(6);
//		set1.add(7); set1.add(8); set1.add(9); set1.add(10);
		
		
		Set<Integer> set2 = new HashSet<>();
		// { 1, 3, 5, 7, 8}
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 8);
		set2.addAll(list2);
		
		
		// set1, set2에 각각에 해당하는 원소를 넣는 작업
		
		
		System.out.println("set1:" + set1);
		System.out.println("set2:" + set2);
		
		Set<Integer> unionSet = new HashSet<>();
		unionSet.addAll(set2);
		// {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		System.out.println("set1 합집합 set2:" + unionSet);
		
		
		// 교집합
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		// {3 , 5, 9}
		System.out.println("set1 교집합 set2:" + intersectionSet);
		
		
		
		// 차집합
		
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		// {2, 4, 6, 8, 10}
		System.out.println("set1 차집합 set2" + diffSet);
		
		
		System.out.println("###################");
/* 방법 1	->			for (Integer val : diffSet) {
밑에 while문			// val 값을 적절히 처리해줘...
은 방법2				System.out.println(val);
						}
*/		
		Iterator<Integer> iter = diffSet.iterator();	// 원소를 순환할수 있는 iterator 를 주세요..

		while(iter.hasNext()) {				// hasNext 사용 , true 로 return 하는 동안 뽑아서 쓴다. . 
			Integer val = iter.next();
			// val 적절히 처리..
			System.out.println(val);
		}
		System.out.println("###################");
		
	

		
		
	}
	
	
	public static void test2() {
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 6, 5, 4, 3, 2);
//		Set<Integer> set1 = new LinkedHashSet<>();  // LinkedHastSet 사용
//		Set<Integer> set1 = new TreeSet<>();
		MyComparator mc = new MyComparator();
		Set<Integer> set1 = new TreeSet<>(mc);
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		// 입력된 순서되로 나오는지 확인
		// 또는 값의 순서대로 나오는지 확인
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
	
	
}

class MyComparator implements Comparator<Integer> {	// 두개의 원소를 비교할 방법만 알려주면 됨..

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		// 앞에 인자로 전달된 놈이 크면 양수
		// 같으면 0 
		// 뒤에 인자로 전달된 놈이 크면 음수를 return 해주자 ..
		
		return o1-o2;	// 오름차순 = 앞에 인자로 전달된 놈이 크면 양수
//		return o2-o1;   // 내림차순 = 뒤에 인자로 전달된 놈이 크면 음수를 return 해주자 ..
	}

	
			
}
