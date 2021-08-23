/*
 * [접근제한자] 범위 : public > protected > X > private
 * 1.public : 어디서든 접근가능.
 * 2.protected : 같은 패키지에서 접근가능.단, 다른 패키지의 자식은 접근가능.
 * 3.X (아무것도없는것) : 같은 패키지에서만 잡근가능.
 * 4.private : 같은 클래스에서만 접근가능.
 */

//이지스 233p~ 262p

package inheritance;

//부모 : 자식의 공통된 특징

public class Customer {//부모//클래스 앞에 final을 붙이면 상속불가.(=부모가 될수없다.)
	
	//1.멤버변수 : 자식들의 공통된 속성
	
	//1).고객ID-같은패키지 접근가능, 다른패키지에서 자식만 접근가능
	protected int customerID;
	//2).고객이름-같은패키지 접근가능, 다른패키지에서 자식만 접근가능
	protected String customerName;
	//3).고객등급-같은패키지 접근가능, 다른패키지에서 자식만 접근가능
	protected String customerGrade;
	//4).보너스포인트
	int bonusPoint;
	//5).적립 비율
	double bonusRatio;
	
	//2.생성자
	
	public Customer() {
		super();//기본값으로 채워짐
//		customerGrade="SILVER";//기본등급 : "SILVER"
//		bonusRatio=0.01;//기본적립비율 : 0.01(=1%)
		initCustomer();
	}
	
	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
//		customerGrade="SILVER";//기본등급 : "SILVER"
//		bonusRatio=0.01;//기본적립비율 : 0.01(=1%)
		initCustomer();
	}
	
	//3.private 메서드 : 상속 불가. 외부 클래스에서는 접근 불가. 클래스 내에서만 사용가능한 메서드
	
	private void initCustomer() {//생성자에 공통으로 들어가기 때문에 메서드를 추가하여 처리 후 생성자에 메서드를 호출시킴.
		customerGrade="SILVER";
		bonusRatio=0.01;
	}
	
	//3.메서드 : 자식의 공통된 기능만->자식클래스에서 재정의해서 사용할 수 있다.
	
		/*
		 * 제품에 대해 지불해야하는 금액 계산하여 반환
		 * 반환하기전에 보너스포인트를 계산하여 누적.
		 */
		
	public int calcPrice(int price) {//값을 돌려받기때문에 int
		bonusPoint+=price * bonusRatio;//포인트=산가격*적립비율. 누적되야하기때문에 +=
		return price;//보너스포인트 값을 다시 돌려줌//다시 안돌려주고 값만 넣어두려면 이 실행문을 제거하고 타입을 void로
	}
	
	//부모-자식 : 메서드 작성할 때 리턴타입으로 작성 여부 고민
	public String showCustomerInfo() {
		return customerName+"님의 등급은"+customerGrade+"이며, 보너스 포인트는"+bonusPoint+"입니다.";
	}
		
	@Override
	public String toString() {
		return "Customer [고객ID=" + customerID + ", 고객명=" + customerName + ", 고객등급="
				+ customerGrade + ", 보너스포인트=" + bonusPoint + ", 적립비율(%)=" + bonusRatio + "]";
	}

	/*******************************************get~ set~ 메서드*******************************************/
	
	public final int getCustomerID() {
		return customerID;
	}

	public final void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public final String getCustomerName() {
		return customerName;
	}

	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public final String getCustomerGrade() {
		return customerGrade;
	}

	public final int getBonusPoint() {
		return bonusPoint;
	}

	public final double getBonusRatio() {
		return bonusRatio;
	}
	
	void showNoSaleRatio() {
		System.out.println(customerGrade+"등급은 세일 비율이 0% 입니다.");
	}
}//클래스문
/*******************************************************************************************************/