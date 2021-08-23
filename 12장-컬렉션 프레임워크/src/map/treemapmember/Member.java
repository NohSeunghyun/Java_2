package map.treemapmember;

public class Member implements Comparable<Member> {
	
	private int memberId;
	private String memberName;
	
	public Member() {}
	
	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public int compareTo(Member o) {
		return this.memberId-o.memberId;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}
	
}//클래스문
/*******************************************************************************************************/