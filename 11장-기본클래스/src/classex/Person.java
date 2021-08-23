package classex;

public class Person {
	
	// 멤버변수
	private String name;
	private int age;
	
	// 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person() {}
	
	// 게터앤세터 메서드
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// 기타메서드
	
	
	
}//클래스문
/*******************************************************************************************************/