package set.treesetmember2;

import java.util.Comparator;

public class DescendingMember2 implements Comparator<Member2> {

	@Override
	public int compare(Member2 o1, Member2 o2) {
		
		return (o1.getAge()-o2.getAge())*-1; // 새로 추가되는 값 - 기본의 비교하는 값 = 반환값이 양수:오름차순, 음수:내림차순
	}
	
}//클래스문
/*******************************************************************************************************/