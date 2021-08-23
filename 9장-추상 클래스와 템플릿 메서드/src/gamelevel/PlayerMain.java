package gamelevel;

public class PlayerMain {

	public static void main(String[] args) {
		
		Player p=new Player();
		p.play(1);
		
		p.upgradeLevel(new AdvancedLevel());
		p.play(2);
		
		p.upgradeLevel(new SuperLevel());
		p.play(3);
		
	}//메인문

}//클래스문
/*******************************************************************************************************/