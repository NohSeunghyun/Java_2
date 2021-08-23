package gamelevel;

public abstract class PlayerLevel {//부모 클래스
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	
	public abstract void showLevelMassage();
	
	final public void go(int count) {//템플릿메서드:실행순서
		run();
		
		for(int i=0;i<count;i++) {
			jump();
		}
		
		turn();
	}
	
}//클래스문
/*******************************************************************************************************/