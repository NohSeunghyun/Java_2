package set.treesetmember;

import java.util.Comparator;
// 오름차순과 내림차순을 동시에 정렬
public class Member implements Comparable<Member>, Comparator<Member> {
	// 1.private 멤버변수
	private int memberId; // 회원아이디
	private String memberName; // 회원 이름
	
	public Member() {} // 생성자 추가함 (이유? TreeSet 생성자 호출할 때 Comparator를 구현한 객체를 매개값으로 주기위해)
	
	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	// public get~set메서드를 통해 private 멤버변수에 접근
	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override // memberId 오름차순 정렬
	public int compareTo(Member o) {
		
		// 오름차순 정렬 방법-1
		return this.memberId-o.memberId;//새로추가되는 값 - 기존의 비교하는 값 = 반환값이 양수 : 오름차순
		// 새로 추가되는 값 - 기존의 비교하는 값 = 반환값이 0이면 add()안됨
		
		// 오름차순 정렬 방법-2
//		if(this.memberId < o.memberId )return -1;//새로추가되는 값 - 기존의 비교하는 값 < 0 -> -1리턴
//		else if(this.memberId == o.memberId)return 0;//새로추가도는값 - 기존의 비교하는 값 =0 -> 0리턴
//		else return 1;//새로 추가되는 값 - 기존의 비교하는 값 > 0 -> 1리턴
		
		// 내림차순 정렬 방법-1
		//return (this.memberId-o.memberId)*(-1);//새로추가되는 값 - 기존의 비교하는 값 = 반환값이 음수 : 내림차순
		//새로 추가되는 값 - 기존의 비교하는 값 = 반환값이 0이면 add()안됨
		
		// 내림차순 정렬 방법-2
//		if(this.memberId < o.memberId )return 1;//새로추가되는 값 - 기존의 비교하는 값 < 0 -> 1리턴
//		else if(this.memberId == o.memberId)return 0;//새로추가도는값 - 기존의 비교하는 값 =0 -> 0리턴
//		else return -1;//새로 추가되는 값 - 기존의 비교하는 값 > 0 -> -1리턴
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}

	@Override // memberId 내림차순정렬
	public int compare(Member o1, Member o2) {
		// TODO Auto-generated method stub
		return (o1.memberId-o2.memberId)*-1;
	}
	
}//클래스문
/*******************************************************************************************************/