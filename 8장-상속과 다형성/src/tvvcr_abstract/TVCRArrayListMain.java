package tvvcr_abstract;

import java.util.ArrayList;

public class TVCRArrayListMain {

	public static void main(String[] args) {
		
		ArrayList<Electronics> e=new ArrayList<Electronics>();
		
		e.add(new TV());
		e.add(new VCR());
		e.add(new TVCR());
		
		System.out.println("========================각 전자제품의 정보 출력========================");
		
		System.out.println(e);
		
		System.out.println("========================각 전자제품의 정보 각각 출력========================");
		
		for(Electronics e1:e) {
			System.out.println(e1);
		}
		
		System.out.println("========================각 전자제품의 메서드 호출 후 출력========================");
		
		for(Electronics e1:e) {
			e1.power();//사용 전 제품 전원 킴//Electronics클래스에 선언된 추상메서드->자식클래스에서 재정의된 메서드이기 때문에 각각의 부모를 만나면 재정의된 메서드를 사용해 각각의 제품전원을 끄고 킴.

			//자식 클래스에 추가된 메서드를 호출하기 위해 아래 코드 작성.
			if(e1 instanceof TVCR) {//e1이 참조하는 객체가 TVCR또는 TVCR의 자식객체면 Ture(TVCR뿐임)
				for (int i=1;i<=2;i++) {
					((TVCR) e1).channelUp();
				}//for문 종료//채널 2번 Up
				((TVCR) e1).play();
				((TVCR) e1).stop();
				((TVCR) e1).rew();
				((TVCR) e1).ff();
			}else if (e1 instanceof TV) {//e1이 참조하는 객체가 TV또는 TV의 자식객체면 Ture(VCR은 자식객체가 아니므로 false)
				for (int i=1;i<=4;i++) {
					((TV) e1).channelUp();
				}//for문 종료//채널 4번 Up
			}else if (e1 instanceof VCR) {
				((VCR) e1).play();
				((VCR) e1).stop();
				((VCR) e1).rew();
				((VCR) e1).ff();
			}
			
			System.out.println(e1);
			e1.power();//사용 후 제품 전원 끔
			System.out.println();
		}//for문 종료
		
	}//메인문

}//클래스문
/*******************************************************************************************************/