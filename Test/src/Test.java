
public class Test {

	public static void main(String[] args) {
		String s = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 !!";
//		for (int i = 0; i<s.length(); i++) {
//			System.out.println(s.CharAt(i));
//		}
		int idx = s.indexOf("백두산");
		System.out.println(idx);
		
//		String subs = s.substring(idx);
		
		String subs = s.substring(idx, idx+"백두산".length());
		
		subs = s.substring(idx, s.indexOf("마르고"));
		System.out.println("["+subs+"]");
		
		System.out.println(subs);
	}
}
