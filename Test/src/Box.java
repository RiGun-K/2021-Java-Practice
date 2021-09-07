abstract class Shape {
 int x, y;

 public void move(int x, int y) {
  this.x = x;
  this.y = y;
 }

 // 추상메소드
 public void draw() {
  System.out.print("9");
 };

 public abstract double area();
}

class Rectangle extends Shape {
 int width;
 int height;

 public Rectangle(int w, int h) {
  this.width = w;
  this.height = h;
 }

 @Override
 public void draw() {
  System.out.print("4");
 }

 @Override
 public double area() {
  return width * height;
 }
}

class Circle extends Shape {
 int radius; // 반지름

 public Circle(int r) {
  this.radius = r;
 }

 @Override
 public void draw() {
  System.out.print("0");
 }

 @Override
 public double area() {
  return (3.141592 * radius * radius);
 }

}

class Triangle extends Shape {
 int w;
 int h; //

 public Triangle(int a, int b) {
  this.w = a;
  this.h = b;
 }

 @Override
 public void draw() {
  System.out.print("3");
 }

 @Override
 public double area() {
  return (0.5 * w * h);
 }

}

public class Box {
 public static void main(String[] args) {

  Triangle t1 = new Triangle(10, 5);
  t1.draw();
  System.out.print(t1.getClass().getName());
  System.out.printf("%4.1f", t1.area());

 }
}        