package stack.cd;

import java.util.Stack;

public class CDStackMain {

	public static void main(String[] args) {
		
		Stack<CD> cdbox = new Stack<CD>();
		
		cdbox.push(new CD("BTS"));
		cdbox.push(new CD("블랙핑크"));
		cdbox.push(new CD("레드벨벳"));
		
		/*
		 * peek : Stack의 마지막 객체 출력 후 삭제안함.
		 * pop : Stack의 마지막 객체 출력 후 삭제 (java.util.Stack클래스의 pop메서드안에 remove가 있음) 
		 */
		System.out.println("======peek사용======\n");
		CD cd = cdbox.peek(); // Stack의 맨 마지막 객체를 가져오고 ★★객체를 Stack에서 삭제안함.
		System.out.println(cd);
		System.out.println("저장된 객체 수 : " + cdbox.size() + "개 \n");
		
		System.out.println("======삭제 안됐는지 확인======");
		System.out.println(cdbox.peek()); // 삭제 안되고 그대로 맨 마지막 객체 다시 출력됨 // 참조안시키고 바로 사용해도됨
		System.out.println("저장된 객체 수 : " + cdbox.size() + "개 \n");
		
		System.out.println("======pop사용======\n");
		int count = 0;
		while(!cdbox.isEmpty()) { // cdbox에 객체가 비어있지 않다면 (=객체가 있다면)
			//CD cd = cdbox.peek(); // Stack의 맨 위(=맨 마지막) 객체를 가져오고 ★★객체를 Stack에서 삭제 안함 하지만 무한루프에빠진다. // 무한루프에 안빠지게 하기위해 while문 밖에 써본다.
			cd = cdbox.pop(); // Stack의 맨 위(=맨 마지막) 객체를 가져오고 ★★객체를 Stack에서 삭제함.
			System.out.println("======삭제 됐는지 확인======");
			System.out.println("저장된 객체 수 : " + cdbox.size() + "개");
			System.out.println(++count + "-CD : " + cd.getCdTitle() + "\n");
		} // while문 종료
		
		if (!cdbox.isEmpty()) { // cdbox에 객체가 비어있지 않다면 (=객체가 있다면) 아래 실행 없으면 실행안함 // 프로그램 강제종료 되는걸 막기위한 코드
		//빈 상태에서 Index로 접근하여 값을 얻어오려고 하면 예외객체발생 -> 프로그램 강제종료
		System.out.println("======삭제 됐는지 확인======");
		CD cd1= cdbox.get(0);
		System.out.println(cd1); // 저장된 값이 없기때문에 ArrayIndexOutOfBoundsException 예외발생.(=인덱스 범위를 넘어섰다 == 검색인덱스 0으로 했는데도 오류가 났으니 저장된값이 없다.)
		} // if문 종료
		
	}//메인문

}//클래스문
/*******************************************************************************************************/