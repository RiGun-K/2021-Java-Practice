package rigun;

import java.util.Stack;

// 스택 예제

class NumStack {
	// top = arr.length 
	int[] arr;
	int top = 0;
	NumStack(int StackSize) {
		this.arr = new int[StackSize];
	}
	
	void push(int i) {
		if(top < arr.length) {
			arr[top++] = i;
			System.out.println("pushed: "+i);
		} else {
			System.out.println("stack is full!!");
		}
	}
	
	// 맨 위에서부터 추출후 삭제 
	int pop() {
		if(top > 0) {
			return arr[--top];
		} else {
			throw new java.util.NoSuchElementException();
		}
	}
	
	
	
}

class UserArrayStack {
	int top;
	int [] stack;
	int size;
	
	UserArrayStack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;	// 초기화
	}
	
	void push(int item) {
		stack[++top] = item;
		System.out.println(stack[top] + " push!");
	}
	
	void peek() {
        System.out.println(stack[top] + " peek!");
    }
	
	void pop() {
        System.out.println(stack[top] + " pop!");
        stack[top--] = 0;
    }
}

public class Practice1019_01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserArrayStack uas = new UserArrayStack(3);
		uas.push(1);
		uas.push(2);
		uas.push(3);
		
		uas.pop();
		uas.pop();
		
//		Stack<Integer> stack = new Stack<>();
//
//		for(int i=0; i<5; i++) {
//			// 데이터에 삽입
//			stack.push(i + 1);
//			 
//		}
//		// pop = 마지막 데이터 출력후 스택에서 삭제
//		System.out.println(stack.pop());
//		// peek = 마지막 데이터만 추출
//		System.out.print(stack.peek());

		
		
		
		
	}
}
