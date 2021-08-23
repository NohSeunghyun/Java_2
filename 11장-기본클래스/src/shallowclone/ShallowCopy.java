/* 
 * <Object의 Clone() 메서드>
 * 1.얕은 복제 : 필드(=멤버변수)만 복제
 * 필드 - 1.기본타입 : 값을 복제
 * 		2.참조변수 : 객체의 주소를 복제 예) 배열, 클래스타입
 * 즉, 객체를 통째로 복사하지만
 * 객체가 참조하는 또 다른 객체까지 복사하지 않는다.
 * 그래서 아래의 단점이 발생함
 * 
 * 2.얕은 복제의 단점
 * 복제 객체에서 참조변수가 참조하는 주소를 변경하면
 * 원본객체도 참조하는 주소가 변경됨
 * (★★단, String은 제외됨)
 * 
 * 3.이 메서드로 객체를 복제하려면 원본 객체는 반드시
 * java.lang.Cloneable 인터페이스를 구현해야 한다.
 * 구현하지 않으면 clone() 호출할 때
 * CloneNotSupportedException 예외 발생하여 복제 실패
 * 
 * 4.CloneNotSupportedException 예외처리가 필요한 메서드이기 때문에
 * try~catch() 구문으로 예외처리를 해야한다.
 */
package shallowclone;

class Point implements Cloneable {//1.즉, 객체를 복제할 수 있는 클래스
	
	private int xPos;
	private int yPos;
	
	Point(int xPos, int yPos) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
	}
	
	void changePos(int x, int y) {//기존값을 변경
		xPos = x;
		yPos = y;
	}

	@Override//2.Object의 clone() 메서드로 복제할 수 있도록 함
	public Object clone() throws CloneNotSupportedException {
		// TODO Object의 clone() 메서드 : 얕은 복제
		return super.clone();
	}
	
}

class Rectangle implements Cloneable {
	
	Point upperLeft, lowerRight;//포함관계

	Rectangle(int x1, int y1, int x2, int y2) {
		super();
		this.upperLeft = new Point(x1, y1);
		this.lowerRight = new Point(x2, y2);
	}
	
	void showPosition() {
		System.out.println("======직사각형 위치정보======");
		System.out.print("좌 상단 : "); upperLeft.showPosition();//[x1, y1]
		System.out.print("우 하단 : "); lowerRight.showPosition();//[x2, y2]
		System.out.println("\n");//구분 위한 엔터 2번
	}
	
	void changePos(int x1, int y1, int x2, int y2) {//기존값을 변경
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

public class ShallowCopy {
	
	public static void main(String[] args) {
		
		Rectangle org = new Rectangle(1, 1, 9, 9);
		org.showPosition();//원본의 값
		Rectangle cpy;
		try {
			if (org instanceof Rectangle) {
				cpy = (Rectangle)org.clone();
				cpy.showPosition();//복제의 값
				
				org.changePos(2, 2, 7, 7);//원본 값 변경
				cpy.showPosition();//원본 값 변경 후 복제 값 확인 => 원본 값 변경 시 복제 값도 변경됨
				
				cpy.changePos(3, 3, 5, 5);//복제 값 변경
				org.showPosition();//복제 값 변경 후 원본 값 확인 => 복제 값 변경 시 원본 값도 변경됨 (=얕은 복제의 단점)
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}// 메인문

}// 클래스문
/*******************************************************************************************************/