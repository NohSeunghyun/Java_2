/*
 * player가 고 이 player가 게임을 한다.
 * 게임에서 player가 가지는 레벨(3가지:초, 중, 고급)에 따라할 수 있는 3가지 기능이 있다.
 * 3가지기능 run(), jump(), turn()입니다.
 * 
 * 초급 레벨:천천히달림
 * 중급 레벨:빠르게달림, 점프가능
 * 고급 레벨:빠르게달림, 점프가능, 턴가능
 */
package gamelevel;

public class Player {
	
	private PlayerLevel level;//포함관계클래스인 플레이어레벨 타입으로 레벨이라는 변수를 생성한다.
	
	public Player(){
		//new PlayerLevel(); 객체생성안됨. 이유? 미완성된 추상클래스이므로.
		level=new BeginnerLevel();//초급 레벨부터 시작
		level.showLevelMassage();
	}

	public PlayerLevel getLevel() {
		return level;
	}

	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMassage();
	}
	
	public void play(int count) {
		level.go(count);
	}
	
}//클래스문
/*******************************************************************************************************/