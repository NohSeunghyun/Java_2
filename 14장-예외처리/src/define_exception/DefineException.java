package define_exception;

import java.util.Scanner;

/* 이지스 487p~
 * 오류
 * 1. 컴파일 오류 : 문법적인 오류
 * 2. 실행 오류
 *   1). 시스템 오류 = Error : JVM에서 발생 - 메모리에 문제 -> 프로그램에서 제어X
 *   2). Exception 클래스 : 프로그램에서 제어O
 *   	 488p 아래 그림 참조
 *   	 Exception 클래스의 자식 클래스들은 예외 처리 해줘야 함.
 *   	  그러나, RuntimeException(실행 오류 예외처리)은 프로그래머의 실수로 발생하는 예외이므로
 *   	 try~catch()로 처리하는 방법 보다 실수를 수정하는 방법으로 해결하는것이 더 효율적
 *   
 *   	  예외처리 방법1.
 *   	 try {
 *   		  예외가 발생할 가능성이 있는 부분
 *   	 } catch (Exception) { // Exception은 모든 예외의 부모
 *   		  처리
 *   	 } finally {
 *   		 예외 발생 여부에 관계없이 무조건 실행
 *   	 }
 *   
 *   	 - IOException(입출력 예외처리)의 자식 예외들은 반드시 예외처리 해줘야함
 */

// 예외 클래스 만드는 방법
class AgeInputException extends Exception { // 1.반드시 Exception 상속받아 예외클래스 만들기
	AgeInputException() {
		super("유효하지 않은 나이가 입력 되었습니다.");
		// Exception()생성자로 전달되는 문자열이 e.getMassage()메서드 호출 시 반환되는 문자열
	}
	
}

public class DefineException {

	public static void main(String[] args) {
		for (int i = 0 ; i <= 2 ; i++) {
			System.out.print("나이를 입력하세요. : "); // 2번째 부터 NoSuchElementException 발생
			try {
				int age = readAge();
				System.out.println("당신은 " + age + "살 입니다.");
			} catch (AgeInputException e) {
				System.out.println(e);
			}
		} // for문 종료
		System.out.println("==========프로그램 종료==========");
	} // 메인문
	
	// ★예외처리하는 방법2 : readAge()를 호출한 메서드로 던져서 처리 (호출한 쪽에서 처리하도록)
	static int readAge() throws AgeInputException { // 사용자가 입력한 나이를 리턴해줌
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if (age < 0) throw new AgeInputException(); //수동으로 에외객체 생성
		//sc.close(); // 이것이 있을시 NoSuchElementException 발생
		return age;
	}
	
} // 클래스문
/*******************************************************************************************************/