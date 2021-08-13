import java.io.*; // File 클래스 , ino 도 쓰기도 함
import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		
		File file = new File("wordbook.txt");
		Set<String> set = new HashSet<>();		// set은 인터페이스이므로 hashtset 으로 생성 
		
		if ( file.exists() == true) { // abc.txt 파일이 존재하냐
			System.out.println(file.getAbsolutePath() + ": 존재함");
		} else {
			System.out.println(file.getAbsolutePath() + ": 존재하지 않음");
		}
		// C:\Users\1234s\eclipse-workspace\Test\wordbook.txt
		
	
		// 파일 내용을 읽자
		// 파일에 읽고 쓰려면 Stream 객체를 이용
		/*
		 * 읽을 떄는 Input Stream
		 * 쓸 때는 Output Stream
		 * Stream은 기본적으로 Byte Stream
		 * 그런데 문자 단위로 읽고 쓸 때는 문자 스트림을 이용하는 것이 편리함,
		 * 문자 단위의  입력 스트림은 Reader 객체
		 * 문자 단위의  출력 스트림은 Writer 객체 
		 */
	int cnt = 0;
	BufferedReader bReader = null;  // bReader가 안에 있으니까 밖으로 뺴줘야됨
	try {					
		FileReader fileReader = new FileReader(file);
		//BufferedReader bReader = new BufferedReader(in);
		//한 라인 단위로 읽는다 - BufferedReader 이용
		// FileReader는 한 문자씩 읽을 때 사용 
		bReader = new BufferedReader(fileReader);
//		String line = bReader.readLine(); // 문자열로 한 라인씩 읽는다.
//		System.out.println(line);
		String line = null;
		while((line=bReader.readLine()) != null ) {
			System.out.println(line);
			set.add(line);  		// 중복되지 않는 문자열만 추가됨, 
			cnt++; 
		} // break문 필요없이 끝나면 안해도됨 
		
	} catch(Exception e) {
		System.out.println(e.getMessage());
	} finally { 	 // 다 읽고 끝나면 close를 해줘야됨
		try {
			bReader.close();
		} catch (IOException e) {
			
		}
	
	}
	System.out.println("단어 수(중복포함):" + cnt);  // cnt 는 갯수를 나타내줌  ,
	System.out.println("단어 수(중복 미포함):" + set.size()); // set 은 중복허용 안하므로 중복 빼고 출력 , set의 size로 
//
	}

	
	
//	
}

