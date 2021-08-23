package gamelevel;

public class AdvancedLevel extends PlayerLevel {

	@Override
	public void run() {
		System.out.println("빠르게 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("높이 점프합니다.");
	}

	@Override
	public void turn() {
		System.out.println("turn을 아직 사용 못합니다.");
	}

	@Override
	public void showLevelMassage() {
		System.out.println("==========중급 레벨입니다.==========");	
	}
	
}//클래스문
/*******************************************************************************************************/