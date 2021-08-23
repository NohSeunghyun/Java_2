package a_project_interface_test;

import java.util.Scanner;

class Person {
	
	//이름,주민번호
	private String name;
	private String serialNumber;
	
	public Person(String name, String serialNumber) {
		this.name = name;
		this.serialNumber = serialNumber;
	}

	final String getName() {
		return name;
	}

	final String getSerialNumber() {
		return serialNumber;
	}
	
}

class Person2 extends Person {//Person을 상속받음

	//상속받은 변수+전화번호
	private String phoneNumber;
	
	public Person2(String name, String serialNumber, String phoneNumber) {
		super(name, serialNumber);
		this.phoneNumber = phoneNumber;
	}

	final String getPhoneNumber() {
		return phoneNumber;
	}
	
}
public class PI implements P {//P인터페이스 구현 PI:매니저클래스
	
	private Person[] p;
	
	public PI (int size) {
		p = new Person[size];
	}
	
	public static Scanner sc = new Scanner(System.in);
	
	int i = 0;//역할 : 1. 배열의 인덱스역할 
	//               2. 1씩 증가하면서 입력(저장)받은 고객수와 같다.
	
	@Override
	public void input() throws PersonSizeException {//예외처리방법2 실행하면 여기에 빨간줄 쳐지는데 f2를 누르면 P인터페이스에 추가하라는 것을 실행한다.
		
		//보기 깔끔한 예외처리방법은 방법1. 메인에 예외처리하는것을 배우기위해 방법1을 사용하지않고 방법2를 사용
		
		//예외 처리하는 방법1
		/*
		try {
			if (i == p.length) throw new PersonSizeException();
		} catch (PersonSizeException e) {
			System.out.println(e.getMessage());
			return;
		}
		*/
		
		//예외 처리하는 방법2
		
		if (i == p.length) {
			throw new PersonSizeException();//예외 발생 선언 추가. 실행문 적고 빨간줄친거 마우스커서 갖다대고 f2하고 하나 나온거누름
		}
		
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("주민번호를 입력하세요 : ");
		String serialNumber = sc.next();
		System.out.print("전화번호를 입력하세요 : ");
		String phoneNumber = sc.next();
		
		p[i++] = new Person2(name, serialNumber, phoneNumber);
	}
	
	@Override
	public void search() {
		System.out.print("주민등록번호를 입력하세요 : ");
		String serialNumber = sc.next();
		
		if (search(serialNumber) != null) {
			System.out.println("*****************고객 정보 출력*****************");
			System.out.println(search(serialNumber));
		}else System.out.println("입력한 주민등록번호에 해당하는 고객은 없습니다.");
	}
	
	private String search(String serialNumber) {
		for(Person person:p) {
			String personInfo = "";
			if(serialNumber.equals(person.getSerialNumber())) {
				personInfo += "고객 이름 : " + person.getName() + ", ";
			if(person instanceof Person2) {
				personInfo += "고객 전화번호 : " + ((Person2) person).getPhoneNumber();
			}
			return personInfo;
			}
		}
		return null;//찾아도 같은 주민등록번호가 없으면 null을 돌려줌
	}

}//클래스문
/*******************************************************************************************************/