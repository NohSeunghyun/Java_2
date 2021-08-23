package inheritancetest;

public class GoldCustomer extends Customer{//자식, Customer:부모
	
	//1.부모 상속 멤버변수+세일비율(실수) 추가
	
	double saleRatio;//더높은 등급에서 받아서 세일비율을 올려야하므로 final을 붙일수없다.
	
	//2.생성자 : 고객등급=VIP로 변경, 적립비율=0.02변경, 세일비율 0.05
	
	//매개변수가 없는 생성자
	
	public GoldCustomer() {
		super();
		customerGrade="GOLD";
		bonusRatio=0.02;
		saleRatio=0.05;
	}
	
	//매개변수가 있는 생성자(고객아이디,고객이름)
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		//고객등급=GOLD로변경
		customerGrade="GOLD";
		//적립비율=0.02변경
		bonusRatio=0.02;
		//세일비율=0.05
		this.saleRatio=0.05;
	}
	
	//3.메서드 : 어디서든지 접근가능
	
	//Customer로부터 상속받은 메서드 중 제품에대해 지불하는금액을 반환하는 메서드를 찾아 재정의:세일비율을 적용하여 계산
	
	@Override
	public int calcPrice(int price) {//재정의
		//보너스 포인트 계산하여 누적
		bonusPoint+=price*bonusRatio;
		//제품에대해 지불하는 금액 계산하여 반환
		return price-(int)(price*saleRatio);
	}
	
	//Customer로부터 상속받은 메서드 중 "주소만으로 String을 리턴"하는 메서드를 찾아 재정의:멤버변수의 값 출력
	
	@Override
	public String toString() {//재정의
		return "Gold등급 고객정보 [고객번호=" + customerID + ", 고객이름=" + customerName
				+ ", 고객등급=" + customerGrade + ", 보너스포인트=" + bonusPoint + ", 적립비율=" + bonusRatio
				+ "%, 세일비율=" + saleRatio + "%]";
	}
	
	//상속받은 메서드+메서드 추가(3개: 추가된멤버변수 1개의 get~set~,showSaleRatio())
	
	@Override
	public void showSaleRatio() {//고객이름, 등급, 세일비율
		System.out.println(customerName+"님은 "+customerGrade+"등급으로 세일비율은 "+saleRatio+"% 입니다.");
	}
	
	/********** get~ set~ :재정의 불가하도록 *****************/
	
	public final double getSaleRatio() {
		return saleRatio;
	}

	public final void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	
}//클래스문
/*******************************************************************************************************/