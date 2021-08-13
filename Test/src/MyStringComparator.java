import java.util.Comparator;

public class MyStringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		
		// o1이 크면 양수 반환, o1 과  o2 가 같으면 0을 반환
		// o2이 크면 음수 반환
		
		// 문자열 값의 비교는 Comparable 인터페이스를 구현하고 있는 String 클래스의 
		// compare 메소드를 호출하면 된다.
//		return o1.compareTo(o2);				// 오름차순 정렬
		return o1.compareTo(o2) * (-1);			// 내림차순 정렬 , -1 사용 
		
	}
	
}
