package a_project_interface_test;

public class PersonMain {

	public static void main(String[] args) { //throws PersonSizeException {//예외처리방법2 JVM이 처리하도록 함
		//★★수정해야함!!오랜만에해서 뭐가 잘못된지 모르겠지만 이상함
		//저장할 고객 수 입력받아
		while (true) {
			System.out.print("저장할 고객 수 : ");
			try {
			String a = PI.sc.next();
			if (a.equalsIgnoreCase("stop") || a.equals("종료")) break;
			int num;
			num = Integer.parseInt(a);
			/*
			try {
				num = Integer.parseInt(a);
			} catch (NumberFormatException e) {
				System.out.println("정수로 입력하세요.");
				System.out.println("--------------------");
				continue;
			}
			if (num<0) {
				System.out.println("-값은 넣을 수 없습니다.");
				System.out.println("--------------------");
				continue;
			}
			*/
			System.out.println("====================");
		
		//그 고객수로 PI객체 생성
		P p = new PI(Integer.parseInt(a));
		
		//그 수만큼 고객의 정보입력
		//주민번호로 이름,전화번호 검색
		//프로그램 종료
			MenuViewer.showmenu();
			String b = PI.sc.next();
			int choice;
			choice = Integer.parseInt(b);
			/*
			try {
				choice = Integer.parseInt(b);
			} catch (NumberFormatException e) {
				System.out.println("1~3 중의 숫자를 입력하세요.");
				continue;
			}
			*///아래 인풋 메서드도 예외처리 가능하기때문에 한번에 묶어 트라이/캐치 블럭을 생성하기위한 주석처리
			System.out.println("====================");
			switch (choice) {
			case P.INPUT : p.input(); break;
			case P.SEARCH : p.search(); break;
			case P.EXIT : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("1~3 중의 숫자를 입력하세요. \n처음으로 돌아갑니다.");
			}
			
			}catch(NumberFormatException e) {
				System.out.println("====================");
				System.out.println("1~3 중의 숫자를 입력하세요.");
				continue;
			}catch(PersonSizeException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(Exception e) {//위 두개의 예외를 제외한 나머지 예외객체 : 가장 마지막에 부모인 exception으로 받아 처리
				System.out.println("1~3 중의 숫자를 입력하세요.");
				//System.out.println(e);//'예외클래스 종류+예외메세지'출력	
				continue;
			}finally {//예외발생 여부에 관계없이 무조건실행(단, try{}블럭 안에 진입했을 때)
				System.out.println("고객님~사랑합니다.");
				System.out.println("====================");
				//continue;가 있으면 74라인 실행 안되므로 오류발생
			}
			//System.out.println("====================");final 실행 후 실행.	
		}//while문 종료
		
	}//메인문

}//클래스문
/*******************************************************************************************************/