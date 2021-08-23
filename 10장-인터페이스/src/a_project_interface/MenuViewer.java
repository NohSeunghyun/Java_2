package a_project_interface;

import java.util.Scanner;

public class MenuViewer {
	
	//1.멤버변수
	public static Scanner sc=new Scanner(System.in);//public static : 외부에서도 사용가능. 메모리에 바로 업로드
	
	//3.메서드
	public static void showmenu() {
		System.out.println("1~3의 메뉴 중 선택하세요.");
		System.out.println("1.고객 데이터 입력");
		System.out.println("2.주민번호로 이름과 전화번호 검색");
		System.out.println("3.프로그램 종료");
		System.out.print("선택 : ");
	}//메서드 종료
	
}//클래스문
/*******************************************************************************************************/