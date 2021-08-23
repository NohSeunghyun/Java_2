package queue.mail;

import java.util.LinkedList;
import java.util.Queue;

import stack.cd.CD;

public class MailQueqeMain {

	public static void main(String[] args) {
		
		/*
		 * public interface Queue<E> extends Collection<E> 
		 */
		
		// 부모 인터페이스
		Queue<Mail> mail = new LinkedList<Mail>();
		
		// 수신받은 메일 Queue에 순서대로 저장
		
		mail.offer(new Mail("정성훈", "안부인사"));
		mail.offer(new Mail("엄민정", "여행계획"));
		mail.offer(new Mail("이정은", "골프계모임"));		
		
		/*
		 * peek : Stack의 마지막 객체 출력 후 삭제안함.
		 * poll : Stack의 마지막 객체 출력 후 삭제 (java.util.Stack클래스의 pop메서드안에 remove가 있음) 
		 */
		
		System.out.println("======peek사용======\n");
		Mail mail1= mail.peek(); // Stack의 맨 마지막 객체를 가져오고 ★★객체를 Stack에서 삭제안함.
		System.out.println(mail1);
		System.out.println("저장된 객체 수 : " + mail.size() + "개 \n");
		
		System.out.println("======삭제 안됐는지 확인======");
		System.out.println(mail.peek()); // 삭제 안되고 그대로 맨 마지막 객체 다시 출력됨 // 참조안시키고 바로 사용해도됨
		System.out.println("저장된 객체 수 : " + mail.size() + "개 \n");
		
		System.out.println("======pool사용======\n");
		while(!mail.isEmpty()) { // mail에 객체가 비어있지 않다면 (=객체가 있다면) // 큐가 비어질때 까지 반복
			Mail each_Mail = mail.poll(); // queqe의 맨 아래(=맨 처음) 객체를 가져오고 객체를 queqe에서 삭제
			
			/*
			switch(each_Mail.toSome) { // 수신인 이름으로 메일확인 
				case "정성훈" : System.out.println(each_Mail); break;
				case "엄민정" : System.out.println(each_Mail); break;
				case "이정은" : System.out.println(each_Mail); break;
			} // switch문 종료
			*/
			
			switch(each_Mail.MailTitle.substring(0, 2)) { // 메일 제목으로 검색. 맨첫글자부터 두번째글자까지 (시작Index, 끝Index+1)
				case "안부" : System.out.println(each_Mail); break;
				case "여행" : System.out.println(each_Mail); break;
				case "골프" : System.out.println(each_Mail); break;
			}
			System.out.println("======삭제 됐는지 확인======");
			System.out.println("저장된 메일 수 : " + mail.size() + "개\n");
		} // while문 종료
		
	}//메인문

}//클래스문
/*******************************************************************************************************/