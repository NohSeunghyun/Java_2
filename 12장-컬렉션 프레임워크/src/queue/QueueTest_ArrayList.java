/*
 * Queue : '선착순'
 * 			줄을 선 대기열 처럼 먼저 추가된 데이터부터 꺼내서 사용하는 방식(FirstIn, FirstOut(=FIFO))
 */
package queue;

import java.util.ArrayList;

class MyQueue {
	
	// 멤버변수 = 필드
	private ArrayList<String> arrayQueue = new ArrayList<String>();
	
	
	
	void offer(String data) {
		arrayQueue.add(data);
	}
	
	String poll() {
		int len = arrayQueue.size(); 
		
		if (len == 0) {
			System.out.println("Queue가 비어있습니다.");
			return null;
		}
		return (arrayQueue.remove(0));
	}
	
	void showSize() {
		int length = arrayQueue.size();
		System.out.println(length);
	}
	
}

public class QueueTest_ArrayList {
	
	public static void main(String[] args) {
		
		MyQueue queqe= new MyQueue();
		
		System.out.println("======값 추가======");
		
		queqe.offer("a"); // Index : 0
		queqe.offer("b"); // Index : 1
		queqe.offer("c"); // Index : 2
		queqe.offer("d"); // Index : 3
		
		System.out.print("저장되어있는 객체 수 : ");
		queqe.showSize(); // 저장되어있는 객체 수
		System.out.println();
		
		System.out.println("======값 출력 후 삭제======"); // 사용자정의한 poll메서드 안에 remove가 들어있으므로 remove와 같다.(출력 후 삭제)
		
		System.out.println(queqe.poll()); // a // queqe의 맨 아래(=맨 처음) 객체를 가져오고 객체를 queqe에서 삭제
		System.out.println(queqe.poll()); // b
		System.out.println(queqe.poll()); // c
		System.out.println(queqe.poll()); // d
		
		System.out.print("저장되어있는 객체 수 : ");
		queqe.showSize(); // 저장되어있는 객체 수
		System.out.println();
		
		
	}//메인문
	
}//클래스문
/*******************************************************************************************************/