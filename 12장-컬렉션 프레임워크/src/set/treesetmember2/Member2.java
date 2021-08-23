package set.treesetmember2;

public class Member2 implements Comparable<Member2>{
	private String name;
	private int age;
	
	public Member2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/*
	 * 오름차순정렬뿐만아니라 내림차순정렬까지 되도록 하기 위해서...
	 * TreeSet생성자에 Comparator를 구현한 객체를 매개변수로 전달하면 오름차순,내림차순 둘다 사용가능하다
	 * 
	 */
	@Override
	public int compareTo(Member2 o) { // 나이로 오름차순 정렬을 한다
		return this.age-o.age; // 반환값이 양수이면 오름차순
//		return (this.age-o.age)*-1; // 반환값이 음수이면 내림차순
	}

	@Override
	public String toString() {
		return "Member2 [name=" + name + ", age=" + age + "]";
	}
	
}//클래스문
/*******************************************************************************************************/