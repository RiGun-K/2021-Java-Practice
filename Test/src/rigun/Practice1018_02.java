package rigun;

// 2차원 배열로 다항식 덧셈하기 

public class Practice1018_02 {

	static float[][] add(float[][] poly1, float[][] poly2) {

		float[][] r = new float[100][2];
		int rowCount = 0;

		for (int k = 0; k < 100; k++) {
			int sum = 0;
			for (int j = 0; j < poly1.length; j++) {
				if (k == poly1[j][1])
					sum += poly1[j][0];
			}
			for (int j = 0; j < poly2.length; j++) {
				if (k == poly2[j][1])
					sum += poly2[j][0];
			}
			if (sum != 0) {
				r[rowCount][0] = sum;
				r[rowCount++][1] = k;
			}
		}

		float[][] newR = new float[rowCount][2];
		for (int k = 0; k < rowCount; k++) {
			newR[k][0] = r[k][0];
			newR[k][1] = r[k][1];
		}

		return newR;
	}

	// 두 다항식 더하기

	static void printPoly(float[][] poly) {

		for (int i = poly.length - 1; i >= 1; i--) {
			System.out.print("(" + poly[i][0] + "x^" + poly[i][1] + ")  ");
		}

		System.out.print("(" + poly[0][0] + "x^" + poly[0][1] + ")");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2차원 배열 만들기

		float[][] a = { { 0, 6 }, { 0, 4 }, { 4, 3 }, { 0, 3 }, { 0, 2 }, { 5, 3 } };
		float[][] b = { { 3, 4 }, { 0, 5 }, { 2, 0 }, { 0, 2 }, { 4, 5 }, { 0, 9 } };

		// 출력값

		System.out.print("다항식 A= ");
		printPoly(a);
		System.out.print("다항식 B= ");
		printPoly(b);

		System.out.print("다항식 A+B = ");
		float[][] sum = add(a, b);
		printPoly(sum);

	}
}
