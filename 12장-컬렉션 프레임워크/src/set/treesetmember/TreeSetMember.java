package set.treesetmember;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetMember {
	
	private TreeSet<Member> treeSet; // Member 관리하는 TreeSet타입을 포함관계
	
	public TreeSetMember() { // 오름차순 정렬된 TreeSet
		treeSet = new TreeSet<Member>();
	}
	
	public TreeSetMember(Member m) { // 내림차순 정렬된 TreeSet
		treeSet = new TreeSet<Member>(m);
	}
	
	// 메서드 : 외부에 노출된 버튼
	public void addMember(Member m){ // 회원추가
		treeSet.add(m); // 실질적인 기능은 TreeSet<Member>객체 안에 있으므로
		// add();를 호출하면 compareTo()자동호출되어 크기를 비교해가면서 정렬하고 저장한다.
		// (반환값이 0이면 동일객체로 인식하여 추가X.즉,중복된 객체는 추가X)
		
		//	 "			compare()  "
	}
	
	public boolean removeMember(int memberId){ // 회원 아이디로 삭제
		Iterator<Member> itr = treeSet.iterator();
		
		while(itr.hasNext()) {
			Member member = itr.next();
			if(member.getMemberId()==memberId) { // 회원의 아이디를 얻어와서 값을 비교한다 
				treeSet.remove(member);
			return true;
			}
		}
		System.out.println(memberId + "존재하지 않는 아이디입니다.");
		return false;
	}
	
	public boolean removeMember(Member member){ // 회원 아이디로 삭제
		Iterator<Member> itr = treeSet.iterator();
		
		while(itr.hasNext()) {
			Member member2 = itr.next();
			if(member.getMemberId()==member2.getMemberId()) // 회원의 아이디를 얻어와서 값을 비교한다 
			return treeSet.remove(member);
			// 찾아서 있으면 삭제하고 true
		}
		System.out.println(member + "존재하지 않는 아이디입니다.");
		return false;
	}
	
	public void showAllMember(){ // 오름차순정렬 -> 내림차순 정렬
		for(Member member : treeSet) {
			/*
			 * 참조변수만으로 원하는 결과가 출력되려면 Member클래스에서 toString()메서드가 재정의되어야 함
		     * println()호출되면 자동으로 참조변수가 참조하는 객체의 toString()메서드가 호출되어 리턴되는 문자열출력
			 */
			
			System.out.println(member);
		}                             
		System.out.println();
	}
	
	public void showAllDesndingMember(){ // 내림차순정렬 -> 오름차순 정렬
		NavigableSet<Member> dMemberSet = treeSet.descendingSet(); // 내림차순 정렬된 Set객체 생성
		
		for(Member member : treeSet) {
			System.out.println(member);
		}
		System.out.println();
	}
	
}//클래스문
/*******************************************************************************************************/