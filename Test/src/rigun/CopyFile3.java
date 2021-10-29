package rigun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyFile3 {
	
	// 문자스트림을 줄단위로 저장
	static void clw() {
		PrintWriter pw;
		FileWriter fw;
		
		try {
			// 파일생성 
			fw = new FileWriter("C:\\\\Users\\\\RiGun\\\\OneDrive - yjc.ac.kr\\\\바탕 화면\\\\JAVA\\\\clw.txt");
			// 글쓰기 
			pw = new PrintWriter(fw);
			
			pw.println("Java");
			pw.println("Spring");
			pw.println("DataBase");
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 위 저장파일을 읽어오기
	static void clr() {
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader("C:\\\\Users\\\\RiGun\\\\OneDrive - yjc.ac.kr\\\\바탕 화면\\\\JAVA\\\\clw.txt");
			br = new BufferedReader(fr);
			
			String s;
			while((s = br.readLine()) !=null) {
				System.out.println(s);
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		clw();
		clr();
	}

}
