package tvvcr_abstract;

public class TVCRMain{

	public static void main(String[] args) {
		
		TV tv=new TV();
		tv.power();
		
		TVCR tvcr=new TVCR();
		tvcr.power();
		
		System.out.println(tvcr);
		
		for(int i=1;i<=10;i++) {
		tvcr.channelUp();
		}
		System.out.println("채널 UP 후 : "+tvcr.channel+"번 채널");
		
	}//메인문

}//클래스문
/*******************************************************************************************************/