package polymorphism;

public class C extends B {
	
	//B에서 상속받은 메서드 재정의
	@Override
	void a() {
		System.out.println("C에서 a() 재정의");
	}

	@Override
	void b() {
		System.out.println("C에서 b() 재정의");
	}
	
	//메서드 추가
	void c() {
		System.out.println("C에서 c() 정의");
	}
	
}//클래스문
/*******************************************************************************************************/