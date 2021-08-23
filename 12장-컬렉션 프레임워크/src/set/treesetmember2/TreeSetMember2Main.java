package set.treesetmember2;

import java.util.TreeSet;

public class TreeSetMember2Main {

	public static void main(String[] args) {
		System.out.println("==========나이로 오름차순===========");
		TreeSet<Member2> tsm2 = new TreeSet<Member2>();
		
		tsm2.add(new Member2("전상호", 21));
		tsm2.add(new Member2("정성훈", 23));
		tsm2.add(new Member2("김무준", 20));
		
		for(Member2 m2 : tsm2) {
			System.out.println(m2);
		}
		System.out.println();
		
		/*
		 * 오름차순정렬뿐만아니라 내림차순정렬까지 되도록 하기 위해서...
		 * TreeSet생성자에 Comparator를 구현한 객체를 매개변수로 전달하면 오름차순,내림차순 둘다 사용가능하다
		 * 
		 */
		System.out.println("==========나이로 내림차순===========");
		tsm2 = new TreeSet<Member2>(new DescendingMember2());
		
		tsm2.add(new Member2("전상호", 21));
		tsm2.add(new Member2("정성훈", 23));
		tsm2.add(new Member2("김무준", 20));
		
		for(Member2 m2 : tsm2) {
			System.out.println(m2);
		}
		
	}//메인문

}//클래스문
/*******************************************************************************************************/