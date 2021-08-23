package map.hashmapstudent;

import java.util.Objects;

// 사용자 정의 클래스
public class Student { // 키 역할
	// 멤버변수
	int sno; // 학번
	String name; // 이름
	
	// 생성자
	public Student(int sno, String name) {
		super();
		this.sno = sno;
		this.name = name;
	}
	// 메인에서 값 추가할때 키값 중복 막는방법-1 : alt+shift+s -> hashcode() and equals()
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sno;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sno != other.sno)
			return false;
		return true;
	}
	*/
	
	// 메인에서 값 추가할때 키값 중복 막는방법-2 : 위 메서드가 길기때문에 함축시킴
	@Override
	public int hashCode() {
		return Objects.hash(sno, name);
	}
	
	@Override
	public boolean equals (Object obj) { // Student객체 -> Object 자동형변환
		Student s = (Student) obj; // Object를 다시 Student로 강제 형변환 // 변수명은 메인의 Student 변수명이아닌 임의로 지정해도됨
		if (s.sno == this.sno && s.name.equals(this.name)) return true; // 학번을 비교해서 있으면 true를 돌려줌
		else return false; // 없으면 false를 돌려줌
	}
	
}// 클래스문
/*******************************************************************************************************/