public class Box4 {
	 public static void main(String[] args) {
		 class Car {
			 private String color;
			 private int speed;
			 private int gear;
			 // 자동차의 시리얼 번호
			 private int id;
			 // 실체화된 Car 객체의 개수를 위한 정적 변수
			 private static int numberOfCars = 0;

			 public Car(String c, int s, int g) {
			  color = c;
			  speed = s;
			  gear = g;
			  // 자동차의 개수를 증가하고 id 번호를 할당한다.
			  id = ++numberOfCars;
			 }

			 // 정적 메소드
			 public static int getNumberOfCars() {
			  return numberOfCars; // OK!
			 }
			}

			public class SoftwareProgramming {
			 public static void main(String args[]) {
			  Car c1 = new Car("blue", 100, 1); 
			  Car c2 = new Car("white", 0, 1); 
			  int n = Car.getNumberOfCars(); 
			  System.out.println(n);
			 }
			}