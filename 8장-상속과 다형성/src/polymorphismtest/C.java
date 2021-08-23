package polymorphismtest;

public class C extends B{

	@Override
	void a() {
		System.out.println("C에서 a()재정의");
	}

	@Override
	void b() {
		System.out.println("C에서 b()재정의");
	}
	
	void c() {
		System.out.println("C에서 c()정의");
	}
	
	
	
	
}//클래스문
/*******************************************************************************************************/