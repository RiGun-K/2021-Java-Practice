package rigun;

class onelist {
	onelist() {
		// 선형리스트를 1차원 배열로 구현
		int list[] = new int[] {1,3,5,7,10};
		
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
					}
		
		/**
		 * @date 2021년 10월 18일
		 * @Comment 배열 중간에 원소를 넣고 삭제하는 방법
		 * 
		 */
	}
}

class twolist {
	twolist() {
		int list[][] = new int[][] {
			{1,3,5,7,9},
			{2,4,6,8,10}
		};
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(list[i][j]+ ",");
			}
			System.out.println();
		}
	}
}

public class Practice1018_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onelist ml = new onelist();
//		twolist tl = new twolist();
	}

}
