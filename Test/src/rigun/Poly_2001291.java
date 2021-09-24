package rigun;

import java.util.Arrays;

public class Poly_2001291 {

	/**
	 * @author 2001291 , 김리건
	 * @date 2021년 09월 23일 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		float a[] = new float[] {4,3,5,0};
//		float b[] = new float[] {3,1,0,2,1};

		float[][] a = {{0,6},{0,4}, {4,3}, {0,3}, {0,2}, {5,3}};
		float[][] b = {{3,4}, {0,5}, {2,0}, {0,2}, {4,5}, {0,9}};
		float[][] c = add(a,b);
		
		System.out.println("다항식 a = "); printPoly(a);
		System.out.println("다항식 b = "); printPoly(b);
		System.out.println("다항식 a+b = "); printPoly(c);
		///////////////////////////////////////////////
		
//		float c[][] = new float[][] {{4,3,5,0}, {3,1,0,2,1}};
//		
//		///////////////////////////////////////////////
//		
//		int[] i = {4,3,5,0};
//		int[] j = {3,1,0,2,1};
//		
//		int[][] k = myArr(i, j);
//	
//		printArr(k);
//	}
//	
//	static int[][] myArr(int[]a , int[]b) {
//		
//		int[][] result = {a,b};
//		return result;
//	}
//	
//	static void printArr(int[][] a) {
//		System.out.println("2차원 배열 : ");
//		for (int i=0; i < a.length; i++) {
//			System.out.println(Arrays.toString(a[i]));
//		}
//	}

}
	
	static float[][] add(float[][] poly1, float[][] poly2) {
		float[][] r = new float[100][2];
		int rowCount=0;
		for (int i=0; i<100; i++) {
			int sum=0;
			for (int j=0; j<poly1.length; j++) {
				if (i==poly1[j][1]) sum+=poly1[j][0];
			}
			for (int j=0; j<poly2.length; j++) {
				if (i==poly2[j][1]) sum+=poly2[j][0];
			}
			if (sum!=0) {
				r[rowCount][0] = sum;
				r[rowCount++][1] = i;
			}	
		}
		float[][] newRow = new float[rowCount][2];
		for(int i=0; i<rowCount; i++) {
			newRow[i][0] = r[i][0];
			newRow[i][1] = r[i][1];
		}
		return newRow;
	}

	
	static void printPoly(float[][] poly) {
		for (int i=poly.length-1; i>=1; i--) {
			System.out.print("("+poly[i][0]+"x^"+poly[i][1]+")  ");
		}
		System.out.print("("+poly[0][0]+"x^"+poly[0][1]+")");
		System.out.println();			
	}
	
	
}



