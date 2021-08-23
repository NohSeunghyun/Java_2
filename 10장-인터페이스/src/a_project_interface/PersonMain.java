package a_project_interface;

//import java.util.Scanner;

/*
 * 홍대표는 기다리지않고 프로젝트를 진행(수행)해 나가는 상황
 */

public class PersonMain {

	public static void main(String[] args) {
		
//		Scanner sc=new Scanner(System.in);//또 만들어 사용해도됨.
		while (true) {
		System.out.print("저장할 고객 수 : ");
		String num=MenuViewer.sc.next();
		if (num.equalsIgnoreCase("stop")||num.equals("종료")) break;
		int a = 0;
		try {
			a = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			System.out.println("정수로 입력하세요.");
			System.out.println("--------------------");
			continue;
		}
		System.out.println("====================");
		
		//홍대표는 a회사에서 알려준 클래스명만 알면 사용가능함.->홍대표는 의뢰한 인터페이스p를 구현한 pi클래스명만 알고있는 상황.
		P p=new PI(Integer.parseInt(num));//홍대표는 PI클래스로 객체를 생성하고 인터페이스 P로 대입받음
		//자식 클래스객체가 부모 인터페이스로 자동형변환되어 들어감.
		
		String b;
		while (true) {
			MenuViewer.showmenu();
			b=MenuViewer.sc.next();
			int choice=0;
			try {
				choice=Integer.parseInt(b);
			} catch (NumberFormatException e) {
				System.out.println("1~3 중의 숫자를 입력하세요.");
				System.out.println("--------------------");
				continue;
			}
			System.out.println("====================");
			switch (choice) {
			case P.INPUT : p.input(); break;
				//p.INPUT = 1.고객정보입력
			case P.SEARCH : p.search(); break;
			case P.EXIT : System.out.println("프로그램을 종료합니다."); return;//해당 (main)메서드 종료->프로그램 종료
			default : System.out.println("1~3 중의 숫자를 입력하세요.");
					  System.out.println("--------------------");
			}//switch문 종료
			System.out.println("====================");
		}//while문 종료
		}
	}//메인문

}//클래스문
/*******************************************************************************************************/