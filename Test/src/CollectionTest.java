import java.util.*;
import java.util.stream.IntStream;
import java.util.Random;

public class CollectionTest {
	

	
	public static void main(String[] args) {
		// test2();
//		 setTest1();
		//   test4();
		lotto();
	}
	
	public static void test2() {
			List<Integer> list = new ArrayList<>();
	//	List<Integer> list = new LinkedList<>();
	//		for ( int i =0; i < 100000; i++) {
	//			list.add(i + 1 );
	//		}
			
			IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i + 1));		
			
			long start = System.currentTimeMillis();
//			for (int i = 0; i< 100; i++) {
//				list.add(30, 1000);
//			}
//			
			for ( int i = 0; i <list.size(); i++) {
				list.get(1);
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println((end - start) + "ms Elapsed...");
		}

		
	public static void test1() {
			/* 
			 *  List : 순서가 있고 중복허용 되는 자료구조
			 */
			
			// Integer 에 저장하겠다.
	List<Integer> list1 = new ArrayList<>(); 
	List<String> list2 = new LinkedList<>();
	List<Double> list3 = new Vector<>();	// Vector 는 오래되었기에 권장하지 않음..
	List<Integer> list4 = new Stack<>();
	
	for ( int i = 0; i < 10; i++) {
		list1.add(i+1);
		list2.add(String.valueOf(i+1));
		list3.add((i+i*1.0));
		list4.add(10 - i);
	}	
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);
		
		
		for (int i=0; i< list1.size(); i++) {
			System.out.println(list1.get(i));	
						}
		
		for (String s : list2) {
			System.out.println(s + ", ");
						}

		Iterator<Double> iter = list3.iterator();
		
		while (iter.hasNext()) {  	       	// boolean 값 = hasNext , 다 빼 먹을때 까지 반복한다.
			Double d = iter.next(); 		// 다 빼먹으면 익셉션 ( 더이상 없다 ) 
			System.out.print(d + " ");
		} 
		
	}

		public static void test3() {
			ArrayList<String> list = new ArrayList<>();
			list.add("MILK");
			list.add("BREAD");
			list.add("BUTTER");
			System.out.println(list);
			list.add(1, "APPLE");
			System.out.println("APPLE을 1번 인덱스에 추가한 후 : " + list);
			list.set(2, "GRAPE");
			System.out.println("2번 인덱스의 원소를 GRAPE로 변경한 후:" + list);
			list.remove(3);
			System.out.println("3번 인덱스의 원소를 삭제한 후: " + list);
			
			Iterator<String> iter = list.iterator(); // 다 빼먹음...
			while (iter.hasNext()) {
				System.out.println(iter.next());		
			}
			
		}
		
		public static void setTest1() {
			Set<String> set = new HashSet<>();
			String[] strArr = {"단어", "중복", "구절", "중복"};
			for (String s : strArr) {
				if(set.add(s) == false)		// 중복이 존재한다면 false ,, 존재 하지않으면 true 반환
					System.out.println(s + "값은 이미 존재!!!");
			}
			System.out.println(set);  // 중복된 단어는 제외하고 호출
		}
		
		public static void lotto() {
			Set<Integer> lottoNums = new HashSet<>();		// TreeSet  or LinkedHashSet

//			Set<Integer> lottoNums = new TreeSet<>();	// 값이 순서대로 나옴
			
			
			// lottoNums 의 원소수 가 6이 될 때까지
			// 1 ~ 45 번까지의 무작위 값을 생성하여 lottoNums에 넣자.
			while (lottoNums.size() < 6) {
				int num = (int) (Math.random() * 45) + 1;
				if (lottoNums.add(num)) {
					System.out.print(num + ", ");
					}
			}
			
//			Random random = new Random();
//			int land = random.nextInt(45);
//			System.out.println(land);
		
			System.out.println(lottoNums);
			
		}
		


}
