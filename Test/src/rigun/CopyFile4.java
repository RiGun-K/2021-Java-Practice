package rigun;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile4 {

	static void rct() {
		FileReader fr;
		BufferedReader br;
		Scanner input;
		
		try {
			fr = new FileReader("C:\\\\Users\\\\RiGun\\\\OneDrive - yjc.ac.kr\\\\바탕 화면\\\\JAVA\\\\clw.txt");
			br = new BufferedReader(fr);
			// 읽어오기 
			input = new Scanner(br);

			// 스캐너로부터 token 단위로 가져올 수 있다. next() 메서드
			String s = input.next();
			System.out.println(s);
						
			// hasNext
			while(input.hasNext()) {
				s = input.next();
				System.out.println(s);
			}
			
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rct();
	}

}
