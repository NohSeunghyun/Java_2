package template;

public class CarTest {

	public static void main(String[] args) {
		
		System.out.println("========================사람이 운전하는 자동차========================");
		
		ManualCar humancar=new ManualCar();
		humancar.run();
		
		System.out.println("========================시스템이 운전하는 자동차========================");
		
		AiCar aicar=new AiCar();
		aicar.run();
		
	}//메인문

}//클래스문
/*******************************************************************************************************/