import java.util.*;

class Employee {
 private String name; // private 로 선언
 private double salary; // private 로 선언
 int age; // package 로 선언

 // 생성자
 public Employee(String n, int a, double s) {
  name = n;
  age = a;
  salary = s;
  setInit();
 }

 public String getName() {
  return name;
 }

 private void setInit() {
  System.out.print("private 로 선언:");
  salary = 10;
 }
 
 public double getSalary() { 
  return salary;
 }

 int getAge() { 
  System.out.print("package 로 선언:");
  return age;
 }
}

public class Box {
 public static void main(String[] args) {
  Employee e;
  e = new Employee("홍길동", 0, 3000);
  e.age = 26; 
  double sa = e.getSalary(); 
  String s = e.getName(); 
  int a = e.getAge(); 
  System.out.println(a);
 }
}         