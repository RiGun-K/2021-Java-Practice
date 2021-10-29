package rigun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = 0;
		FileInputStream in = null;
		
        try {
            // 생성할 파일의 경로 및 파일명 으로 File 객체 생성
            
            File file = new File("C:\\Users\\RiGun\\OneDrive - yjc.ac.kr\\바탕 화면\\JAVA\\OutputStream.txt");

            in = new FileInputStream(file);
            while((data = in.readLine()) != -1) {
                // 입력받은 내용을 파일 내용으로 기록한다. 문자단위 스트림은 int 형 타입 
                System.out.println(in);
            }
        
        } catch (IOException e) {
            System.out.println(e);
        } finally {
        	try {
        		in.close();
        	} catch(IOException io) {}
        }
        
    }
	}


