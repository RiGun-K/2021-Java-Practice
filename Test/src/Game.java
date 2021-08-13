import java.util.Scanner;

public class Game {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double random = Math.random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위(1),바위(2),보(3) 중에서 하나를 고르시오. 단 숫자로 입력할것!");
		
		int com = (int)(Math.random()*3+1);
		int user = sc.nextInt();
		
		switch (com) {
			case 1 : 
				System.out.println("컴퓨터 : 가위");
				break;
			case 2 : 
				System.out.println("컴퓨터 : 바위");
				break;
			case 3 : 
				System.out.println("컴퓨터 : 보");
				break;
				
		}
		
		System.out.print("유   저 : ");
		
		switch (user) {
			case 1 :
				System.out.println("가위");
				break;
			case 2 :
				System.out.println("바위");
				break;
			case 3 :
				System.out.println("보");
				break;
		}
		
		if ( user == com ) 
			System.out.println("컴퓨터와 비겼습니다!");
		
		else if ( (user==1 && com==3) || (user==2 && com==1) || (user==3 && com==2) )
			System.out.println("유저가 이겼습니다.");
		
		else System.out.println("컴퓨터가 이겼습니다.");
		
		System.out.println("수고하셨습니다 !");
			
		}
/*		while(true)
		{
			System.out.print("가위(1),바위(2),보(3) 중에서 하나를 고르시오. 단 숫자로 입력할것!");
			you= sc.nextInt();
			
			if (you >= 4)
				System.out.println("숫자 1~3 중에서만  입력하시오!");
			if (you < 4)
				break;			
		}
		
		System.out.println("컴퓨터가 낸것 : " + user);
		
		if (you==user)
			System.out.println("비겼습니다.");
		else if(you==1&&user==3)
			System.out.println("당신이 이겼습니다. ");
		else if(you==2&&user==1)
			System.out.println("당신이 이겼습니다. ");
		else if(you==3&&user==2)
			System.out.println("당신이 이겼습니다. ");
		else
			System.out.println("당신이 졌습니다. ");
*/		
		
		

	
	}


