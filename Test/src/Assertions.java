import java.util.*;

public class Assertions {
	public static void dmain(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
				System.out.println("날짜를 입력하시오.");
				int date = input.nextInt();
				
				assert (date >= 1 && date <= 31) : "잘못된 날짜 : " + date;
				
				System.out.printf("입력된 날짜는 %d 입니다. \n", date);
				
	// 단언 , 실행되지는 않음..
				
	//			System.out.println();  // sysout + ctrl + space bar
				
				
	}
}
