package inheritancetest;

public class Customer {//부모
	
	//1. 멤버변수 : 자식들의 공통된 속성
	
	//아래 3개:같은 패키지에서 접근 가능. 다른 패키지에서는 자식만 접근가능
	//고객 아이디
	protected int customerID;
	//고객 이름
	protected String customerName;
	//고객 등급
	protected String customerGrade;
	
	//아래 2개:같은 패키지에서만 접근 가능.
	//보너스 포인트-정수
	int bonusPoint;//보너스포인트는 구매마다 누적되기때문에 final을 붙일수없다.
	//적립 비율-실수
	double bonusRatio;//더높은 등급에서 받아서 적립비율을 올려야하므로 final을 붙일수없다.
	
	//2. 생성자 : 고객 등급="SILVER", 적립 비율=0.01
	
	//매개변수가 없는 생성자
	public Customer() {
		super();
		customerGrade="SILVER";
		bonusRatio=0.01;
	}
	
	//매개변수가 있는 생성자(고객 아이디, 고객 이름)
	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade="SILVER";
		bonusRatio=0.01;
	}
	
	//3. 메서드 : 어디서든지 접근 가능
	
	public int calcPrice(int price) {
		//보너스 포인트 계산하여 누적
		bonusPoint+=price*bonusRatio;
		//제품에 대해 지불하는 금액 계산하여 반환
		return price;	
	}
	
	public String showCustomerInfo() {//고객이름, 등급, 보너스 포인트
		return customerName+"님의 등급은"+customerGrade+"이며, 보너스 포인트는"+bonusPoint+"입니다.";
	}
	
	public void showSaleRatio() {//고객이름, 등급, 세일비율:0% 출력
		System.out.println(customerName+"님은 "+customerGrade+"등급으로 세일비율은 0% 입니다.");
	}
	
	//Object로부터 상속받은 메서드 중 "주소만으로 String을 리턴"하는 메서드를 찾아 재정의
	
	@Override
	public String toString() {
		return "일반등급 고객정보 [고객번호=" + customerID + ", 고객이름=" + customerName + ", 고객등급="
				+ customerGrade + ", 보너스포인트=" + bonusPoint + ", 적립비율=" + bonusRatio + "%]";
	}
	
	/********** get~ set~ :재정의 불가하도록 *****************/
	
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

	public final void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public final int getBonusPoint() {
		return bonusPoint;
	}

	public final void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public final double getBonusRatio() {
		return bonusRatio;
	}

	public final void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
}//클래스문
/*******************************************************************************************************/