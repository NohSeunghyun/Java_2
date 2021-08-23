package set.treesetmember;

public class TreeSetMemberMain {

	public static void main(String[] args) {
		System.out.println("==================처음부터 오름차순 정렬================");
		TreeSetMember tsm = new TreeSetMember(); // 매개변수 없는 생성자 호출 -> TreeSet객체생성
		
		// Member클래스가 Comparable인터페이스를 구현하지 않고 저장하는 순간 ClassCastExecption예외 발생
		Member m3 = new Member(3, "안여진");
		tsm.addMember(m3); // compareTo()메서드 호출 -> 오름차순 정렬
		
		Member m1 = new Member(1, "김건우");
		tsm.addMember(m1);
		
		Member m2 = new Member(2, "전용준");
		tsm.addMember(m2);
		
		tsm.showAllMember();
		
		
		Member m3_2 = new Member(3, "양영석"); // 같은아이디의회원을 추가
		tsm.addMember(m3_2);
		
		tsm.showAllMember();
		
		Member m4 = new Member(4, "양영석"); // 같은아이디의회원을 추가
		tsm.addMember(m4);
		
		tsm.showAllMember();
		
		tsm.removeMember(4); // 아이디로 삭제
		tsm.removeMember(m3);
		
		tsm.showAllDesndingMember();
		
		/***********************************************************************/
		System.out.println("==================처음부터 내림차순 정렬================");
		// Comparator를 구현한 객체를 매개값으로 가진 매개변수가 있는 생성자 호출 -> TreeSet객체 생성
		TreeSetMember tsm2 = new TreeSetMember(new Member());
		
		// Member클래스가 Comparator인터페이스를 구현하지 않고 저장하는 순간 ClassCastExecption예외 발생
		Member m5 = new Member(5, "엄민정");
		tsm2.addMember(m5); // 재정의된 compare()메서드 호출 -> 내림차순 정렬
		
		Member m7 = new Member(7, "신명희");
		tsm2.addMember(m7);
		
		Member m6 = new Member(6, "이정은");
		tsm2.addMember(m6);
		
		tsm2.showAllMember();
		
		Member m5_2 = new Member(5, "노승현"); // 같은아이디의회원을 추가
		tsm2.addMember(m5_2);
		
		tsm2.showAllMember();
		
		Member m8 = new Member(8, "노승현"); // 같은아이디의회원을 추가
		tsm2.addMember(m8);
		
		tsm2.showAllMember();
		
		tsm2.removeMember(8); // 아이디로 삭제
		tsm2.removeMember(m5);
		
		tsm2.showAllDesndingMember();
		
	}//메인문

}//클래스문
/*******************************************************************************************************/