package practice;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �옄猷뚰삎(���엯) 蹂��닔紐�
		// 泥リ��옄�뒗 �냼臾몄옄 , �몢�떒�뼱 �씠�긽�� �씠�썑 泥リ��옄�뿉 ��臾몄옄
		int count = 10;
		
		count = 20;
		// count = 11.1;  ( X - �옄猷뚰삎 double濡� �옉�꽦 )
		System.out.print(count);
		
		// �븯�굹�쓽 �젙�빐吏� 媛믪� �긽�닔瑜� �궗�슜�븯硫� �렪由ы븯�떎 
		final int PRICE = 8920;
		int time = 5 * PRICE;
		System.out.println("�삤�뒛 �궡媛� �씪�븳 �씪�떦��" + time + "�엯�땲�떎.");
	
	    ///////////////////////////////////////////////////////
		
		/*
		 * �옄猷뚰삎 ���엯
		 * 
		 *  char ( 2byte , �븳 湲��옄留� 媛��뒫 )
		 *  -> byte -> short -> char -> int -> long
		 *  
		 *  �떎�닔�삎
		 *  float -> double 
		 *  �떒, float �뒗 媛� �뮘�뿉 f瑜� 遺숈뿬�빞 �븿 ! 
		 *  = float f = 32.4f;;
		 */
		
		int x = 50000;
		long y = x;
		/* 臾듭떆�쟻 �삎蹂��솚
		 * �옉���냸 (int) => �겙�냸 (long) �삎蹂��솚 ( O )
		 * �겙�냸 => �옉���냸 �삎蹂��솚 ( X ) 
		 */
		long x2 = 5;
//		int y2 = x2;
		int y2 = (int) x2;
		// 紐낆떆�쟻 �삎蹂��솚 = ���엯�쓣 ( ) 遺숈뿬二쇰㈃ 媛��뒫 ! 
		
	}

}
