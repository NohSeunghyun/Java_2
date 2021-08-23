package a_project_interface;

import java.util.Scanner;

class Person {//이름과 주민번호를 가진 클래스.
	
	//1.멤버변수
	private String name;//고객의 정보보안
	private String serialNumber;//고개의 정보보안
	
	//2.생성자
	public Person(String name, String serialNumber) {//public 붙여도되고 안붙여도됨.
		this.name = name;
		this.serialNumber = serialNumber;
	}//생성자 종료
	
	//3.메서드
	String getName() {
		return name;
	}//메서드 종료

	String getSerialNumber() {
		return serialNumber;
	}//메서드 종료
	
}

class Person2 extends Person {//상속받은 멤버변수 + 전화번호만 추가
	
	//1.멤버변수
	private String phoneNumber;//고객의 정보보안
	
	//2.생성자 : super()가 부모생성자를 호출하니 부모생성자로 매개값을 그대로 전달하여 부모생성자의 기능사용+추가한 멤버변수를 매개값으로 받고 멤버변수의 기능추가
	public Person2(String name, String serialNumber,String phoneNumber) {
		super(name, serialNumber);
		this.phoneNumber=phoneNumber;
	}//생성자 종료
	
	//3.메서드 : 상속받은 메서드+추가
	String getPhoneNumber() {
		return phoneNumber;
	}//메서드 종료
}

/*
 * //PI클래스는 P인터페이스를 구현함.
 *  //인터페이스는 여러개 구현이 가능 예) implements P, A, B, List<E>....
 */

public class PI implements P {//a회사가 받은 인터페이스를 기반으로 메서드를 만드는 상황.클래스도 추가하는 상황(해당클래스 위의 클래스.) 
							  //PI매니저클래스
	
	private Person[] p;//포함관계로 Person(저장,삭제,검색)을 처리하는 배열객체생성 
	// 상속관계와 포함관계는 다르니 공부해야함. 
	//상속관계로 하려면 public calss PI extends Person {} 로 진행해야하나 이 상황에서는 상속이 아닌 포함으로 해야함.
	
	public PI(int size) {//size:고객수 10
		p=new Person[size];//배열:length의 멤버변수(읽기전용)==size
	}//메서드 종료

	public static Scanner sc=new Scanner(System.in);//public static : 외부에서도 사용가능. 메모리에 바로 업로드 //이 안에 넣어 사용해도됨.
	int i=0;//메서드안에 사용하면 값이 계속 0이 되므로 밖에쓴다.//0->입력받은 고객수
	
	@Override
	public void input() {//이름, 주민번호, 전화번호를 입력받아 저장하기때문에 scanner객체 생성해야함. 이 클래스안에 만들어도되나 새 클래스(MenuViewer)를 만들어 사용해본다.
		
		try {
			if(i==p.length) {//i==size는 사용못함 이유? size는 매개변수(=지역변수)기때문에 위 메서드(PI(int size)())에서만 사용가능하고 이 메서드에서는 사용뷸가.
				throw new PersonSizeException();//수동으로 예외객체 생성
			}//if~여기까지 쓴 후 드래그->서라운드위드->트라이캐치블럭 생성.
		} catch (PersonSizeException e) {
//			e.printStackTrace();//1. 이 메서드안에 e.getMessage()가 포함되어있어 예외메세지를 출력+예외클래스종류와 예외가 발생한 경로 출력해줌
//			System.out.println(e);//2. 예외클래스 종류+예외메세지 출력
			System.out.println(e.getMessage());//3. 예외메세지만 출력//세 방법중 이것이 제일깔끔함
			return;//해당 input()메서드만 종료-> main()의 반복문으로 돌아가 계속 프로그램이 실행.
		}//PersonSizeException클래스에 정의한 메서드를 아래 실행문이 실행되기전에 이것을 실행하고 예외발생했으니 멈춘다.
		
		System.out.print("이름을 입력하세요 : "); //String name=MenuViewer.sc.next(); MenuViewer클래스의 스캐너객체를 사용할때
		String name=sc.next();//지역변수
		
		System.out.print("주민등록번호를 입력하세요 : "); 
		String serialNumber=sc.next();
		
		System.out.print("전화번호를 입력하세요 : ");
		String phoneNumber=sc.next();
		
//		p[i++]=new Person2(name, serialNumber, phoneNumber);//여기안쓰고 밑에 새로운 메서드(addPerson)를 만들어도됨
		addPerson(name, serialNumber, phoneNumber);
	}//재정의 메서드 종료
	
	private void addPerson(String name, String serialNumber, String phoneNumber) {//외부에 노출될 필요가없으니 private
		p[i++]=new Person2(name, serialNumber, phoneNumber);//자식객체->부모타입으로 자동현변환되어 대입
	}//메서드 종료
	
	@Override
	public void search() {
		System.out.print("주민등록번호를 입력하세요 : ");
		String serialNumber=sc.next();
		
		if (search(serialNumber) != null) { 
			show ();//P인터페이스의 show()메서드:정보출력 -> 고객정보출력 으로 재정의 후 사용
			System.out.println(search(serialNumber));
		}else System.out.println("입력한 주민등록번호에 해당하는 고객은 없습니다.");
	}//메서드 종료
	
	private String search(String serialNumber) {//예)"123456-7******"
			for(Person person:p) {
				String personInfo="";
				if (serialNumber.equals(person.getSerialNumber())) { 
					personInfo+="고객의 이름:"+person.getName()+",";//return person.getName()+","+((Person2)person).getPhoneNumber();
					if(person instanceof Person2) {
						personInfo+="전화번호:"+((Person2)person).getPhoneNumber();
					}
					return personInfo;
			}
		}//for문 종료
			return null;
	}//메서드 종료
	
	/*************************************************/

	@Override
	public void show() {
//		P.super.show();
		System.out.println("*****************고객 정보 출력*****************");
	}//메서드 종료
	
}//클래스문
/*******************************************************************************************************/