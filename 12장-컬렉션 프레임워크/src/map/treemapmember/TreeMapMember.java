package map.treemapmember;

import java.util.Iterator;
import java.util.Map.Entry;

import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapMember {
	
	private TreeMap<Integer, Member> TreeMap;
	
	public TreeMapMember() { // 오름차순 정렬된 TreeMap
		TreeMap = new TreeMap<Integer, Member>();
	}

	public void addMember(Member m) { // 회원 추가
		TreeMap.put(m.getMemberId(), m);
	}
	
	public boolean removeMember(int memberId) { // 회원아이디 = 키로 삭제
		if (TreeMap.containsKey(memberId)) {
			TreeMap.remove(memberId);
			return true;
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public boolean removeMember(Member member) { // 회원아이디 = 값으로 삭제
		if (TreeMap.containsValue(member)) {
			TreeMap.remove(member);
			return true;
		}
		System.out.println(member + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		System.out.println("---오름차순 정렬---");
		Iterator<Integer> keyItr = TreeMap.keySet().iterator();
		while(keyItr.hasNext()) {
			Integer key = keyItr.next(); // 키 값
			System.out.println(key + ", " + TreeMap.get(key));
		}
		System.out.println();
	}
	
	/*
	public void showAllDesndingMember() {
		System.out.println("---내림차순 정렬---");
		Iterator<Integer> keyItr = TreeMap.descendingKeySet().iterator();
		while(keyItr.hasNext()) {
			Integer key = keyItr.next(); // 키 값
			System.out.println(key + ", " + TreeMap.get(key));
		}
	}
	*/
	
	public void showAllDesndingMember() {
		System.out.println("---내림차순 정렬---");
		NavigableMap<Integer,Member> dMemberMap=TreeMap.descendingMap();//내림차순 정렬된 Map객체 생성. 오름차순 정렬된 Map객체 생성
		Set<Entry<Integer, Member>> dMMSet= dMemberMap.entrySet();
		for (Entry<Integer, Member> member : dMMSet) {
			System.out.println(member.getKey() + ", " + member.getValue());
		}
		System.out.println();
	}
	
}//클래스문
/*******************************************************************************************************/