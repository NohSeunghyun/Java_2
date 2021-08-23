/*
 * 'Class'란 이름의 클래스
 * 자바의 모든 클래스와 인터페이스는 컴파일을 하면 .class파일이 생성됨
 * Class 클래스는 컴파일된 .class파일에 저장된 클래스나 인터페이스 정보를 가져올때 사용 
 */
package classex;

public class ClassTest {
	
	public static void main(String[] args) {
		
		// Class 클래스를 선언하고 클래스정보를 가져오는 세가지방법
		
		// 방법-1 : 생성된 객체가 필요
		Person person = new Person();
		Class p1 = person.getClass(); // Object의 getClass()메서드 사용
		System.out.println(p1.getName()); // 패키지.클래스명 출력
		
		// 방법-2
		Class p2 = Person.class; // 컴파일된 파일을 대입
		System.out.println(p2.getSimpleName()); // 클래스명만 출력
		
		// ★★방법-3 : 예외발생 처리 반드시해야함
		//Class.forName("classex.Person"); // 컴파일러가 찾아서 있으면 메모리에 로딩시킴(=동적로딩) 
		// ↓↓↓↓↓↓try~catch로 예외처리해보기↓↓↓↓↓↓
		try {
			Class p3 = Class.forName("classex.Person"); // 있는것
			//Class p3 = Class.forName("classe.Person"); // 없는것
			System.out.println(p3.getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO 이름과 일치하는 클래스가 없는경우
			//e.printStackTrace(); // ClassNotFoundException 예외가 발생하므로 반드시 처리
			System.out.println("클래스파일이 존재하지 않습니다.");
		}
			
	}//메인문

}//클래스문
/*******************************************************************************************************/