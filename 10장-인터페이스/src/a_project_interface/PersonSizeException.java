package a_project_interface;

/*
 * 예외 클래스 만드는방법
 */

public class PersonSizeException extends Exception {//1.반드시 Exception을 부모로 상속받는다.
	
	//PersonMain에 고객수를 넘어서면 예외발생하면서 프로그램이 종료되기때문에
	//부드럽게 진행되게하기위해 예외클래스 생성.
	
	//멤버변수 추가 해도됨
	
	//기본생성자가 들어감. 기본생성자 대신 이러한 생성자를 많이쓴다.
	public PersonSizeException() {
		super("더 이상 고객 정보를 저장할 공간이 없습니다.");
		//Exception() 생성자한테 전달되며 e.getMessage()메서드를 호출하면 리턴되는 문자열
	}//생성자 종료
	
	//메서드 추가 해도됨
	
}// 클래스문
/*******************************************************************************************************/