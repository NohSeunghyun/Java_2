/*
 * 문제점 : power(){} 완성된 메서드면 자식클래스에서 power()를 재정의하지 않아도 오류가 발생안함.
 * 		  그런데 부모입장에서는 반드시 power()를 재정의해서 사용하기를 원함.
 * 
 * 해결책 : power()를 미완성된 추상메서드로 만들어 자식메서드에서 재정의하도록 함. 
 * 		  재정의안하면 오류가남-오류해결방법 1 : 메서드 재정의
 * 							    2 : 상속받은 미완성된 추상메서드를 받은 클래스도 추상클래스로 만듬.
 * 		 abstract power(); 미완성된 추상메서드면(이 경우 클래스 앞에도 abstract붙여야함) 자식클래스에서 재정의를 꼭 해야 오류가 발생안함.
 * 										   만약 재정의 하기싫으면 자식클래스도 추상으로 만들어야함(=abstract를 해당메서드,클래스앞에 붙여야함)
 * 
 * [abstract class 클래스명 = 추상클래스]
 * 1. 여러 메서드중 단 1개라도 미완성된 추상메서드가 포함되어 있으면 이 클래스도 미완성이므로 abstract class(=추상클래스)가 된다.
 * 2. 객체성성 불가 : 이유? 미완성 클래스이므로
 * 3. 그러나 부모역할은 가능.
 * 	예1) method(Electronics e){//Electronics의 자식객체(TV, VCR, TVCR)->자동형변환(자동으로 Electronics로 형변환되어 대입)
 * 							 //그러나 Electronics 본인의 객체는 못받음. 미완성이므로 객체생성자체가 불가.
 * 	}
 * 	예2) Electronics e = new TV();
 * 		Electronics e = new VCR();
 * 		Electronics e = new TVCR();
 */

package tvvcr_abstract;

abstract class Electronics {//TV의 부모:전자제품 - 자식의 공통된 속성과 기능
	
	//추상클래스
	//1)객체생성 불가
	//2)부모로의 역할은 가능.(자식이 상속받아 재정의가능, 자식객체를 받아들일수 있음.)
	//미완성된 추상메서드를 1개라도 가지고있으면 추상클래스가된다. abstract붙여야함.
	//자식클래스에서 미완성된 메서드를 반드시 재정의해야함. -> 재정의하면 완성된클래스 = 객체생성가능.
	
	//1.멤버변수
	boolean power;
	
	//2.기본생성자
	//Electronics(){super();}
	
	//3.메서드
//	void power() {} //완성된 메서드
	abstract void power(); //미완성된 추상메서드
}

class TV extends Electronics {//TVCRMain의 부모 //TV의부모인 Electronics에 추상메서드가있는데 재정의를 하기싫다면 앞에 abstract를 붙여 추상클래스로 만들어아햠.
	
	//1.멤버변수
//	boolean power;//전원//기본값:false//부모인 Electronics의 멤버변수를 상속받으므로 주석처리
	int channel;//채널//기본값:0
	
	//2.기본생성자
	//TV(){super();}
	
	//3.메서드
	@Override//부모로부터 상속받은 power메서드 재정의
	void power() {
		power = !this.power;// !:false->true, true->false
		if(power==true) System.out.println("TV 전원 ON");
		else System.out.println("TV 전원 OFF");
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}

	@Override
	public String toString() {
		return "TV [power=" + power + ", channel=" + channel + "]";
	}

}

class VCR extends Electronics {//포함관계
	
	//1.멤버변수
//	boolean power;//부모인 Electronics의 멤버변수를 상속받으므로 주석처리
	
	//2.기본생성자
	//VCR(){super();}
	
	//3.메서드
	@Override
	void power() {
		power = !this.power;// !:false->true, true->false
		if(power==true) System.out.println("VCR 전원 ON");
		else System.out.println("VCR 전원 OFF");
	}
	
	//실질적인 기능을 가진 메서드
	void play() {System.out.println("재생");}
	void stop() {System.out.println("멈춤");}
	void rew() {System.out.println("되감기");}
	void ff() {System.out.println("빨리감기");}

	@Override
	public String toString() {
		return "VCR [power=" + power + "]";
	}
	
}

/*
 * 여러개의 클래스를 하나의 파일에 설계할 때
 * public은 단 1개의 클래승데만 붙일수 있다.
 * public붙은 클래스 = 파일이름
 */

public class TVCR extends TV {//TV(부모)기능과 VCR(포함관계)의 기능을 가지고있음//자바는 단일부모. TV(부모1개) VCR(포함관계 : 부품) 
	
	//TV(부모)의 멤버(멤버변수, 메서드)만 상속, (생성자, 초기화블록은 상속되지 않는다)
	
	private VCR vcr;
	
	public TVCR() {
		super();
		vcr=new VCR();
	}
	
	//외부에 노출된 버튼
	public void play() {vcr.play();}
	public void stop() {vcr.stop();}
	public void rew()  {vcr.rew(); }
	public void ff()   { vcr.ff(); }

	@Override//TVCR에서 사용하기때문에 재정의.
	void power() {
		power = !this.power;
		vcr.power = !vcr.power;
		if(power==true) System.out.println("TVCR 전원 ON");
		else System.out.println("TVCR 전원 OFF");
	}//TV클래스는 ELECTRONICS클래스에서 상속받은 추상메서드 power메서드를 상속받아 재정의를 해서 완성된 클래스가됨.
	 //TVCR클래스는 완성된 TV클래스를 상속받았기때문에 power메서드를 재정의안해도 오류발생안함.
	 //하지만 안의 내용을 바꾸기위해 재정의를함.

	@Override
	public String toString() {
		return "TVCR [VCR [power=" + power + "] power=" + power + ", channel=" + channel + "]";
	}
	
}//클래스문
/*******************************************************************************************************/