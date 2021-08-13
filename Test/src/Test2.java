import java.util.*; 

public class Test2 {
	public static void main(String[] args) {
		
		
		ArrayList<String> strList = new ArrayList<>();  // 배열의 수를 늘려줌 ArrayList 
		
		for (int i = 0; i < 200; i++) {
			strList.add(String.valueOf(1));
		}
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(1));
		}
		
		ArrayList<Student> stdList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			stdList.add(new Student());
		}
	}
}
