package set.hashsetmember;

import java.util.Objects;

public class Member { // 사용자정의클래스
	String name;
	int age;
	
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

//  이클립스 : 소스 hashCode() 및 equals() 생성
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Member other = (Member) obj;
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

	

	@Override
	public int hashCode() {
//		return name.hashCode()+age;//예)방법1 "ad"-> a(97)+b(98)=195
//		return name.hashCode()+(age%3);//방법2 검색속도가 빨라진다.
		return Objects.hash(name,age);
	}


	@Override
	public boolean equals(Object obj) {
//		if (obj instanceof Member) { // 생략가능
		Member m = (Member)obj;
		
		// 값을 비교
		if(m.name.equals(this.name)&& m.age == this.age)return true;
		else return false;
//		}
		
	}//메인문

}//클래스문
/*******************************************************************************************************/