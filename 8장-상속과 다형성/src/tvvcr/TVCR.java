package tvvcr;

class TV {//부모
	
	//1.멤버변수
	boolean power;//전원//기본값:false
	int channel;//채널//기본값:0
	
	//2.기본생성자
	//TV(){super();}
	
	//3.메서드
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
}

class VCR {//포함관계
	
	//1.멤버변수
	boolean power;
	
	//2.기본생성자
	//VCR(){super();}
	
	//3.메서드
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

public class TVCR extends TV {//TV(부모)기능과 VCR(포함관계)의 기능을 가지고있음//자바는 단일부모. TV(부모1개) VCR(포함관계 : 부동) 
	
	//TV(부모)의 멤버(멤버변수, 메서드)만 상속, (생성자, 초기화블록, private멤버는 상속되지 않는다)
	
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
	}

	@Override
	public String toString() {
		return "TVCR [vcr=" + vcr + ", power=" + power + ", channel=" + channel + "]";
	}
	
}//클래스문
/*******************************************************************************************************/