package rigun;

import java.util.Arrays;

public class Polyfinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				float a[] = new float[] {4,3,5,0};
				float b[] = new float[] {3,1,0,2,1};
				Polynomial A = new Polynomial(3,a);
				Polynomial B = new Polynomial(4,b);
				OperatePoly optPoly = new OperatePoly();
				Polynomial C = optPoly.addPoly(A,B);
				
				System.out.println("A(x)="); A.printPoly();
				System.out.println("B(x)="); B.printPoly();
				System.out.println("C(x)="); C.printPoly();
				
				///////////////////////////////////////////////
				
				float c[][] = new float[][] {{4,3,5,0}, {3,1,0,2,1}};
				
				///////////////////////////////////////////////
				
				int[] i = {4,3,5,0};
				int[] j = {3,1,0,2,1};
				
				int[][] k = mkArr(i, j);
			
				printArr(k);
			}
			
			static int[][] mkArr(int[]a , int[]b) {
				
				int[][] result = {a,b};
				return result;
			}
			
			static void printArr(int[][] a) {
				System.out.println("2차원 배열>>>");
				for (int i=0; i < a.length; i++) {
					System.out.println(Arrays.toString(a[i]));
				}
			}

		}

		class OperatePoly{
			
			private int degree_A=0, degree_B=0, degree_C=0, index_A=0,
						index_B=0, index_C=0;
			private int expo_A, expo_B;
			private float coef_A, coef_B, coef_c;

			public Polynomial addPoly(Polynomial A, Polynomial B) {
				degree_A = A.getDegree();
				degree_B = B.getDegree();
				expo_A = degree_A;
				expo_B = degree_B;
				if(degree_A >= degree_B) degree_C=degree_A;
				else degree_C=degree_B;
				Polynomial C = new Polynomial(degree_C);
				while(index_A <= degree_A && index_B <= degree_B) {
					if(expo_A > expo_B) {
						C.setCoef(index_C++, A.getCoef(index_A++));
						expo_A--;
					}
					else if(expo_A == expo_B) {
						C.setCoef(index_C++,
						A.getCoef(index_A++)+B.getCoef	(index_B++));
								expo_A--; expo_B--;
					}
					else {
						C.setCoef(index_C++, B.getCoef(index_B++));
						expo_B--;
			
					}
				}
				return C;
			}
		}


		class Polynomial {
			private int degree;
			private float coef[] = new float[20];
			
			Polynomial (int degree, float coef[]) {
				this.degree = degree;
				this.coef = coef;
			}
			
			Polynomial (int degree) {
				this.degree = degree;
				for(int i=0; i<=degree; i++)
					this.coef[i] = 0;
			}
			
			public int getDegree() {
				return this.degree;
			}
			
			public float getCoef(int i) {
				return this.coef[i];
			}
			
			public float setCoef(int i, float coef) {
				return this.coef[i] = coef;
			}
			
			public void printPoly() {
				int temp = this.degree;
				 for(int i=0; i<=this.degree; i++) {
					 System.out.printf("%3.0fx^%d", this.coef[i], temp--);
				 }
				 
				 System.out.println();
	}

}
