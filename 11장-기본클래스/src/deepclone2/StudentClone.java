/* 
 * <Object의 Clone() 메서드>
 * 1.얕은 복제 : 필드(=멤버변수)만 복제
 * 필드 - 1.기본타입 : 값을 복제
 * 		2.참조변수 : 객체의 주소를 복제 예) 배열, 클래스타입
 * 즉, 객체를 통째로 복사하지만
 * 객체가 참조하는 또 다른 객체까지 복사하지 않는다.
 * 그래서 아래의 단점이 발생함
 * 
 * 2.얕은 복제의 단점
 * 복제 객체에서 참조변수가 참조하는 주소를 변경하면
 * 원본객체도 참조하는 주소가 변경됨
 * (★★단, String은 제외됨)
 * 
 * 3.이 메서드로 객체를 복제하려면 원본 객체는 반드시
 * java.lang.Cloneable 인터페이스를 구현해야 한다.
 * 구현하지 않으면 clone() 호출할 때
 * CloneNotSupportedException 예외 발생하여 복제 실패
 * 
 * 4.CloneNotSupportedException 예외처리가 필요한 메서드이기 때문에
 * try~catch() 구문으로 예외처리를 해야한다.
 */
package deepclone2;

import java.util.Arrays;

class Computer {
	
	String brand;

	Computer(String brand) {
		super();
		this.brand = brand;
	}
	
}

class Student implements Cloneable {//implements Cloneable => Cloneable을 구현함으로써 객체를 복제할 수 있는 클래스라고 알림. 사용안할 시 예외발생->프로그램 종료됨. 반드시 구현해줘야함
									//Cloneable을 구현하지 않고 clone()메서드 호출하면 CloneNotSupportedException 예외 발생하여 복제 실패.
	/*
	 * 깊은 복제의 대상 : 배열, 클래스타입 (★단, String제외)
	 */
	int StudentId;//기본타입 : 깊은복제에서 제외
	String Studentname;//String타입 : 깊은복제에서 제외 (이유? 값 변경 불가함)
	int[] scores;//배열 : 깊은복제의 대상
	Computer com;//사용자 정의 클래스(=클래스타입) : 깊은복제의 대상.

	Student(int studentId, String studentname, int[] scores, Computer com) {
		super();
		StudentId = studentId;
		Studentname = studentname;
		this.scores = scores;
		this.com = com;
	}
	
	//Object의 clone()은 얕은복제하므로 문제가 발생할 수 있으므로 깊은복제가 되도록 재정의함
	/*
	 * 얕은 복제를 한 클래스를 그대로 옮겨온 후
	 * 얕은 복제의 단점을 해결하기 위해 깊은 복제로 변경
	 * 깊은 복제 방법 : 객체를 통째로 복사하고 객체가 참조하는 또 다른 객체까지 복사한다.
	 */
	/*
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//1.먼저 얕은복제로 객체를 통째로 복제한다.
		Student cpy = (Student)super.clone();
		//2.깊은복제의 대상이되는 객체들을 복제한다.
		cpy.scores = Arrays.copyOf(scores, scores.length);
		cpy.com = new Computer(this.com.brand);
		//3.깊은복제된 cpy를 리턴
		return cpy;
	}
	*/
	
	//★오버라이딩(=재정의)할 때 부모 메서드의 반환 타입을 자식 클래스의 타입으로 변경을 허용한다.
	@Override
	protected Student clone() throws CloneNotSupportedException {
		//1.먼저 얕은복제로 객체를 통째로 복제한다.
		Student cpy = (Student)super.clone();
		//2.깊은복제의 대상이되는 객체들을 복제한다.
		cpy.scores = Arrays.copyOf(scores, scores.length);
		cpy.com = new Computer(this.com.brand);
		//3.깊은복제된 cpy를 리턴
		return cpy;
	}
	
	Student copyStudent() {//복제된 학생을 리턴
		Student cpy = null;//지역변수(클래스타입)이므로 초기화해야함
		try {
			cpy = clone();//재정의된 메서드가 호출되어 복제된 Student 리턴
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cpy;
	}
	
	void showStudent() {
		System.out.println("아이디 : " + StudentId);
		System.out.println("이름 : " + Studentname);
		System.out.println("점수 : " + Arrays.toString(scores));
		System.out.println("컴퓨터 브랜드 : " + com.brand + "\n");
	}
	
}

public class StudentClone {

	public static void main(String[] args) {
		
		Student org = new Student(3, "유신재", new int[] {100, 95}, new Computer("LG"));
		System.out.println("[원본 학생]");
		org.showStudent();
		
		Student cpy = org.copyStudent();
		System.out.println("[복제 학생]");
		cpy.showStudent();
		
		System.out.println("**********복제학생 값 변경 함**********");
		cpy.Studentname = "김경탄"; // 값이 바뀌는것이 아닌 새로운 객체가 생성됨 // 그러나 기존 객체는 안나옴 이유?
		cpy.scores[0] = 0;
		cpy.com.brand = "SAMSUNG";
		
		System.out.println("[복제 학생 값 변경 후 원본학생]");
		org.showStudent();
		
		System.out.println("[복제 학생 값 변경 후 복제학생]");
		cpy.showStudent();
		
	}// 메인문

}// 클래스문
/*******************************************************************************************************/