package rigun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		int data = 0;
        System.out.println("저장할 내용을 입력하세요. 지금 입력한 내용은 파일에 저장됩니다.");
        
        try {
            // 생성할 파일의 경로 및 파일명 으로 File 객체 생성
            File file = new File("C:\\Users\\RiGun\\OneDrive - yjc.ac.kr\\바탕 화면\\JAVA\\OutputStream.txt");
            // 경로 없이 파일명만 작성할 경우 현재 디렉토리에 파일 생성함.
//            File file = new File("test.txt");
            
            // FileOutputStream 은 무조건 해당 파일을 생성한다. 존재하는 파일일 경우 덮어쓰기함.
            FileOutputStream out = new FileOutputStream(file);
            while((data = System.in.read()) != -1) {
                // 입력받은 내용을 파일 내용으로 기록한다. 문자단위 스트림은 int 형 타입 
                out.write(data);
            }
            	out.close(); // 파일을 닫는다.
        } catch (FileNotFoundException e) {
            //FileOutputStream 객체 생성시 파일 경로가 유효하지 않으면 FileNotFoundException 발생
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
