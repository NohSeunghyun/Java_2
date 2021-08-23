package gamelevel;

public class BeginnerLevel extends PlayerLevel {

	@Override
	public void run() {
		System.out.println("천천히 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("junp를 아직 사용 못합니다.");
	}

	@Override
	public void turn() {
		System.out.println("turn을 아직 사용 못합니다.");
	}

	@Override
	public void showLevelMassage() {
		System.out.println("==========초급 레벨입니다.==========");
	}
	
}//클래스문
/*******************************************************************************************************/