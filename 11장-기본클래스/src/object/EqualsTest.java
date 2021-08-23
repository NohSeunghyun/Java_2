package object;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student{//부모 : Object
	int studentId;
	String studentName;
	
	public Student(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId,studentName);
	}//이것사용시 아래 중복된것 제외하여 총 객체수 1개가됨
	
	//Object의 s.equals(s1) : 두 객체의 주소를 비교하여 같으면 true, 다르면 false
	//따라서, 값을 비교하도록 재정의해야한다.
	//이 떄, 비교하는 기준을 아이디와 이름이 모두 같으면 같은 객체로 인식하려면 방법-1
	//이 떄, 비교하는 기준을 아이디만 같으면 같은 객체로 인식하려면 방법-2
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student)obj;
			//방법-1								//String의 equals메서드는 이미 값을 비교하도록 재정의
			if(this.studentId == std.studentId && this.studentName.equals(std.studentName)) //이것사용시 아래 실행문 값이 다르다고나옴. id와 이름 둘다 비교하기때문에
			//방법-2
//			if(this.studentId==std.studentId) 이것사용시 아래 실행문 값이 같다고나옴. id만비교하기때문에
				return true;
		}
		return false;
	}
}

public class EqualsTest {
	
	public static void main(String[] args) {
		Student s = new Student(1,"윤호섭");
		Student s1 = s;
		Student s2 = new Student(1,"김호섭");
		
		//주소 비교는 중요하지 않다.
		if(s == s1) {//주소비교
			System.out.println("주소가 같다");
		}else System.out.println("주소가 다르다");
		
		if(s == s2) {//주소비교
			System.out.println("주소가 같다");
		}else System.out.println("주소가 다르다");
		
		//주소가 참조하는 값을 비교하는 것이 중요하다.
		if(s.equals(s1))System.out.println("값이 같다.");
		else System.out.println("같이 다르다.");
		
		if(s.equals(s2))System.out.println("값이 같다.");
		else System.out.println("값이 다르다.");
		
		System.out.println("s의 해시코드 : " + s.hashCode());
		System.out.println("s1의 해시코드 : " + s1.hashCode());
		System.out.println("s2의 해시코드 : " + s2.hashCode());
		
		System.out.println("s의 실제주소값 : " + System.identityHashCode(s));
		System.out.println("s1의 실제주소값 : " + System.identityHashCode(s1));
		System.out.println("s2의 실제주소값 : " + System.identityHashCode(s2));
		
		System.out.println("==============================");
		//HashSet의 부모는 Set
		/*
		 * Hash~ 시작하는 클래스가 사용자 정의 객체를 관리한다면
		 * 1. hashCode() 재정의 -> 2.같으면 다시 equals() 재정의
		 */
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(2, "이수광"));
		set.add(new Student(2, "이수광"));
		
		System.out.println("총 객체수: "+set.size());
		
	}//main
	
}
