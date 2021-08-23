package set.hashsetmember;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetMember {

	public static void main(String[] args) {
		System.out.println("==========HashSetString==============");
		HashSet<String> setstr = new HashSet<String>();
		setstr.add("같은 문자열");
		setstr.add("같은 문자열"); // 중복은 추가 안됨
		System.out.println("총객체수:"+setstr.size());
		
		System.out.println("==========HashSet<Member>==============");
		Set<Member> setmem = new HashSet<Member>();
		
		/*
		 * 비동기화된 컬렉션(싱글쓰레드)을 동기화된 컬렉션(멀티쓰레드)으로 변환하는방법
		 */
		// setmem = Collections.synchronizedSet(setmem); // set을 동기화된 set으로 리턴 // 싱글쓰레드를 사용하기때문에 주석처리
		// Set<Member> setmem = Collections.synchronizedSet(new HashSet<Member>()); // 이렇게 사용해도됨 // 위 두 실행문을 하나로 압축
		
		setmem.add(new Member("김진일", 24));
		setmem.add(new Member("김진일", 24));//재정의하여 추가안되도록 해야함
		System.out.println("총객체수"+setmem.size());
	
	}//메인문

}//클래스문
/*******************************************************************************************************/