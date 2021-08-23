package template;

public class ManualCar extends Car {

	//1.멤버변수
	
	//2.생성자
	
	//3.메서드-상속받은 추상메서드 재정의
	@Override
	public void drive() {
		System.out.println("사람이 운전합니다.");
		System.out.println("사람이 핸들을 조작합니다.");
	}
	
	@Override
	public void wiper() {
		System.out.println("사람이 와이퍼를 작동합니다.");	
		System.out.println("사람이 빠르기를 조절합니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("브레이크로 정지합니다.");
	}
	
}//클래스문
/*******************************************************************************************************/