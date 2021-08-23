package polymorphism;

public class M {
	
//	static void w(A a) {//A객체와 A자식객체를 받음. 단, A자식객체는 부모인 A객체로 받음.
//		a.a();//컴파일러 입장 : 모든 객체를 A객체로 인식. 따라서 A객체에 정의된 멤버만 접근.
////		((B)a).b();//컴파일 오류는 없음. 실행시 오류(예외객체발생->프로그램이 종료)
////		((C)a).c();//실행시 오류발생 이유? 부모는 자식객체로 강제형변환 불가
//	}//★★static을 붙일수 있는것과 없는것 차이 공부하기.
	
	//위 실행문(w()의 문제점)의 오류때문에 메서드 수정.(=문제점을 해결한 메서드)
	
	static void w(A a) {
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
		
		A a=new A(); w(a);
		System.out.println("*************************");
		B b=new B(); w(b);
		System.out.println("*************************");
		C c=new C(); w(c);
		
		System.out.println("***********다향성***********");
		
		/* [자동 형변환]
		 * 1.자식객체는 부모타입으로 자동 형변환됨.예)위의 w()메서드
		 * 
		 * [강제 형변환]
		 * 1.자식객체는 부모타입으로 강제 형변환 가능.예)아래의 ((A)b2).a();
		 * 2.부모객체는 자식타입으로 강제 형변환 가능하지만 실행 시 예외발생하여 프로그램이 종료됨.
		 * 이유? 부모객체에 있는 메서드는 자식객체에 있는 메서드가 없기때문에 실행 오류.
		 */
		
		B b2=new C();//부모=자식(자식객체가 부모타입으로 자동형변환되어 대입)//[자동형변환]-1.의 예
		b2.a(); b2.b();
		
		((A)b2).a();//b2=자식.(B타입) A=부모. 자식을 부모타입으로 강제형변환//[강제형변환]-1.의 예
		
		System.out.println("*************************");
		
		A a2=new B();
		a2.a();
		
//		((C)a2).b();//[강제형변환]-2.의 예
		
		//위 실행문(강제형변환-2.의 예)의 오류난것을 해결하려면 if문+instanceof 를 사용.
		
		System.out.println("*************************");
		
		if (a2 instanceof C) {
			System.out.println("C타입으로 강제형변환?");
			((C)a2).b();
		}else {//두개만 물어보기때문에 마지막문구는 else만써도됨. else if (a2 instanceof B) {
			System.out.println("B타입으로 강제형변환?");
			((B)a2).b();
		}
		
		System.out.println("*************************");
		
		A a3=new C();
		a3.a();
		
		System.out.println("*************************");
		
		if (a3 instanceof C) {
			System.out.println("C타입으로 강제형변환?");
			((C)a3).b();
		}//else {//else if (a3 instanceof B) {
//			System.out.println("B타입으로 강제형변환?");
//			((B)a3).b();
//		}
		
	}//메인문
	
}//클래스문
/*******************************************************************************************************/