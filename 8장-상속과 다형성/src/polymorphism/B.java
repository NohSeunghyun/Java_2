package polymorphism;

public class B extends A {
	
	//A에서 상속받은 메서드 재정의
	@Override
	void a() {
		System.out.println("B에서 a() 재정의");
	}
	
	//메서드 추가
	void b() {
		System.out.println("B에서 b() 정의");
	}
	
}//클래스문
/*******************************************************************************************************/