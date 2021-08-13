import java.util.*;

public class MyArrayList<T> {
	private Object[]
	private Integer[] arr;  	// Integer 배열 arr
	private int capacity = 10;  // 초기사이트 10 으로 설정
	private int size = 0;
	
	public MyArrayList() {
		arr = new Integer[capacity];
		
	}
	
	private void increaseCapacity() {
		// 수용할 수 없으면 arr 배열의 크기를 늘려야 된다
					capacity = capacity + capacity/2;
					Integer[] tmp = new Integer[capacity];
					
				// 원래 값들을 tmp 로 복사
					for (int i = 0; i < size; i++) {
						tmp[i] = arr[i];
					}
				
					arr = tmp;
	}
	
	public void add(Integer value) {
		// 현재 용량으로 추가되는 값을 수용할 수 있으면
		if (size >= capacity) { 
			// 수용할 수 없으면 arr 배열의 크기를 늘려야 된다
			capacity = capacity + capacity/2;
			Integer[] tmp = new Integer[capacity];
			
		// 원래 값들을 tmp 로 복사
			for (int i = 0; i < size; i++) {
				tmp[i] = arr[i];
			}
		
			arr = tmp;
			}
			arr[size++] = value;
	}
	
	public void add(int idx, Integer value) {
		// 용량이 이미 꽉차있으면 용량을 50% 늘리고
		// 아래 코드를 실행한다.
		
		if (size == capacity) {
			
			//용량을 늘리자..
			increaseCapacity();
		}
		// 맨 위에 있는 원소부터 오른쪽으로 한 칸씩 민다.
		for (int i = size-1; i>=idx; i--) {
			arr[i+1] = arr[i];
		}
		
		// idx 자리에 value를 넣는다.
		arr[idx] = value;
		size++;
		
		
			
	}
	
	public void remove() {
		if (size > 0) size--;
	}
	
	public void remove(int idx) {
		
	}
		
//		arr[size++] = value; // 배열을 ㅁ 번째 위치에 넣는다.
		// arr[0] = value;
		// arr[1] = value;   // 후위 연산자 , 전위 연산자 
		
		// 수용할 수 없으면 
		/*
		 * arr 배열의 크기를 늘려야 한다.
		 */
		
	
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if (size == 0) return "[]";	
		String result = "[";   
		
		for ( int i =0; i < size-1; i++) {
			result += arr[i] + ",";
			
			
		}
		
		result += arr[size-1];
		result += "]";		  //  [  ] 쳐서 안에 내용이 들어가도록 하자
		return result;
	}
	
	public Integer get(int idx) {
		return arr[idx];
	}
	
	public static void main(String[] args) {
// ArrayList 는 자바유틸 패키지에 속해있음.
//		ArrayList<Integer> list = new ArrayList<>();
		MyArrayList list = new MyArrayList();
		for (int i =0; i < 10; i++) {
			list.add(i);
		} 
		// ArrayList ) 배열의 정해진 크기를 초과해서 사용자가 원하는 만큼 크기를 늘림
		// 사용하기엔 편리한데 내부적으로는 복잡함 = CPU가 많이 돌아감
		
		for ( int i =0; i <list.size(); i++) {
			System.out.println(list.get(i));   // list 사이즈에 전체에 대한 값을 하나씩 받는다.
		}
		
/*		
		System.out.println(list);
	
		list.add(3,100);
		
		System.out.println(list); // 3번째 배열에 100을 넣으면 기존에 들어가지는 3번쨰 배열의 값을 한칸씩 뒤로 밀려서 출력 !! 
		
	//	list.remove(3);
		
	//	System.out.println(list); // 그 자리에 있는 값을 삭제한 후  한칸씩 떙겨놈 

		list.remove(Integer.valueOf(100));
		System.out.println(list);
*/
		
	}
	
	
	
}
