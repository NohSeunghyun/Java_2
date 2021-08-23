package stack;

import java.util.ArrayList;

class MyStack {
	
	// 멤버변수 = 필드
	private ArrayList<String> arrayStack = new ArrayList<String>();
	
	//메서드
	void push(String data) {
		arrayStack.add(data);
	}
	
	String pop() {
		int len = arrayStack.size(); // 저장된 객체의 수 // 마지막 Index + 1 = length(=size) ☆마지막 Index 구하는 방법 :  
		
		if (len == 0) {
			System.out.println("Stack이 비어있습니다.");
			return null;
		}
		return (arrayStack.remove(len - 1)); // 저장된 객체 수 - 1 = 마지막 Index 번호 // remove(len - 1) = 마지막객체 출력 후 삭제
	}
	
	void showSize() {
		int length = arrayStack.size();
		System.out.println(length);
	}
	
}

public class StackTest_ArrayList {

	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		
		System.out.println("======값 추가======");
		
		stack.push("a"); // Index : 0
		stack.push("b"); // Index : 1
		stack.push("c"); // Index : 2
		stack.push("d"); // Index : 3
		
		System.out.print("저장되어있는 객체 수 : ");
		stack.showSize(); // 저장되어있는 객체 수
		System.out.println();
		
		System.out.println("======값 출력 후 삭제======"); // 사용자정의한 pop메서드 안에 remove가 들어있으므로 remove와 같다.(출력 후 삭제)
		
		System.out.println(stack.pop()); // d // Stack의 맨 위(=맨 마지막) 객체를 가져오고 객체를 Stack에서 삭제
		System.out.println(stack.pop()); // c
		System.out.println(stack.pop()); // b
		System.out.println(stack.pop()); // a
		
		System.out.print("저장되어있는 객체 수 : ");
		stack.showSize(); // 저장되어있는 객체 수
		System.out.println();
		
	}//메인문

}//클래스문
/*******************************************************************************************************/