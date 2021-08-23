package inheritance;

public class VIPCustomer extends Customer {
	
	//부모의 멤버(멤버변수(=필드), 메서드)를 상속받아 안보이지만 존재함.(단, 생성자는 상속불가, private 상속불가)
	//여기서는 자식만의 속성이나 기능을 추가함.
	
	//1.멤버변수 : 추가할 멤버변수
	
	//1).VIP고객 상담원 ID
	private int agentID;
	//2).VIP고객 전용 세일
	double saleRatio;
	
	//2.생성자
	
	public VIPCustomer() {
		super();//기본값의 부보 객체 생성		
		customerGrade="VIP";//SILVER->VIP
		bonusRatio=0.05;//적립비율 0.01->0.05(5%)
		saleRatio=0.1;//VIP고객 전용 세일 10%
	}
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
//		super();
		super(customerID, customerName);//매개값으로 채워진 부보 객체 생성
//		this.customerID = customerID;// 0->매개값으로 변경//super() 에 값을 넣으면 처음 생성된 customer 값을 그대로 가져오기때문에 필요가 없어짐
//		this.customerName = customerName;//null->>매개값으로 변경//super() 에 값을 넣으면 처음 생성된 customer 값을 그대로 가져오기때문에 필요가 없어짐
		this.agentID = agentID;//매개값으로 변경
		
		customerGrade="VIP";//SILVER->VIP//상속받은 값을 변경
		bonusRatio=0.05;//0.01->0.05(5%)//상속받은 값을 변경
		
		saleRatio=0.1;//VIP고객 전용 세일 10%
	}
	
	//3.메서드
	
	@Override
	public int calcPrice(int price) {
		bonusPoint+=price * bonusRatio;
		return price - (int)(price*saleRatio);
	}
	
	//재정의하는 이유?멤버변수가 추가되었기때문에.
	@Override
	public String toString() {
		return "VIPCustomer [상담원ID=" + agentID + ", 세일비율(%)=" + saleRatio + ", 고객ID=" + customerID
				+ ", 고객명=" + customerName + ", 고객등급=" + customerGrade + ", 보너스포인트=" + bonusPoint
				+ ", 세일비율(%)=" + bonusRatio + "]";
	}//마우스우클릭->소스->toString재정의->inherited 메서드도 체크해야 상속받은 toString재정의 메서드도 포함됨
	
	//showCustomerInfo()재정의
	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo()+"담당 상담원 번호는 "+agentID+"입니다.";
	}
	
	
	public final int getAgentID() {
		return agentID;
	}

	public final void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public final double getSaleRatio() {
		return saleRatio;
	}
	
	//자식에만 추가한 메서드
//	String showSaleRatio() {
//		return customerName+"님의 세일 비율은"+saleRatio+"입니다.";
//	}//이 메서드를 사용하려면 getSaleRatio 메서드가 필요가없음.
	
	void showSaleRatio() {
		System.out.println(customerName+"님의 세일 비율은"+saleRatio+"입니다.");
	}

}//클래스문
/*******************************************************************************************************/