package polymorphismtest;

public class M {
	
	static void w2(A a) {
		if (a instanceof C) {
			a.a();
			((C) a).b();
			((C) a).c();
		}else if (a instanceof B) {
			a.a();
			((B) a).b();
		}else a.a();
	}
	
	public static void main(String[] args) {
		
		A a=new A(); w2(a);
		System.out.println("====================");
		B b=new B(); w2(b);
		System.out.println("====================");
		C c=new C(); w2(c);
		System.out.println("====================");
		
	}//메인문

}//클래스문
/*******************************************************************************************************/