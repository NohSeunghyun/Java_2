package template;

public abstract class Car {//부모
	
	//1.멤버변수
	
	//2.생성자
	
	//3.메서드
	public abstract void drive();//미완성된 추상메서드. 자식클래스에서 정의
	public abstract void stop();
	public abstract void wiper();
	
	void washCar() {}//완성된 메서드 : 필요하면 자식클래스에서 재정의하여 사용하라. 필요없으면 사용안해도 추상메서드가 아니기때문에 자식클래스에 재정의안해도 오류가안남.
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	//템플릿 메서드 : 메서드의 실행순서 또는 시나리오를 정의한 메서드//설계 시 사용
	final public void run() {//작동순서는 어느 차나 동일. 실행순서 즉, 시나리오를 정의한 메서드를 재정의하면 안됨.그래서 앞에 final을 붙인다.//final뒤에 public을 붙여도 문법상 상관없다.
		startCar();
		drive();
		wiper();
		stop();
		turnOff();
		washCar();
	}
	
}//클래스문
/*******************************************************************************************************/