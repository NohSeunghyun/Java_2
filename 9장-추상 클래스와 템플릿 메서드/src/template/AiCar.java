package template;

public class AiCar extends Car {
	
	//1.멤버변수
	
	//2.생성자
	
	//3.메서드-상속받은 추상메서드 재정의
	@Override
	public void drive() {
		System.out.println("자율 주행합니다.");
		System.out.println("시스템이 핸들을 조작합니다.");
	}
	
	@Override
	public void wiper() {
		System.out.println("시스템이 비나 눈의 양에 따라 빠르기가 자동으로 조절 후 와이퍼를 작동합니다.");	
	}
	
	@Override
	public void stop() {
		System.out.println("시스템이 브레이크로 정지합니다.");
	}

	@Override
	void washCar() {
		System.out.println("시스템이 자동으로 세차를 진행합니다.");
	}
	
}//클래스문
/*******************************************************************************************************/