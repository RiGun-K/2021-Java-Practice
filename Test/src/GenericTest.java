
public class GenericTest {
	public static void main(String[] args) {
		GenericBox<String> box1 = new GenericBox<String>();   // 객체 생성할때 < > 안에 타입을 미리 설정. 클래스를 따로따로선언하는게 아니고 로직은 다 동일하니까 타입만 주자,
	
		box1.setContent("동해물과");
		String s = box1.getContent();
		System.out.println(s);
		
		GenericBox<Integer> box2 = new GenericBox<>();
		box2.setContent(100);
		int n = box2.getContent();
		
		GenericBox<Student> box3 = new GenericBox<>();
		box3.setContent(new Student());
		Student std = box3.getContent();
	}
}
