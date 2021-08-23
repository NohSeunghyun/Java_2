package inheritance;

public class GOLDCustomer extends Customer {
	
	double saleRatio;//골드 전용 세일비율

	public GOLDCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade="GOLD";//SILVER->GOLD 변경
		bonusRatio=0.02;//적립비율 0.01=>0.02(=2%)
		this.saleRatio=0.05;//골드 전용 세일비율 5%
	}

	@Override
	public int calcPrice(int price) {
		bonusPoint+=price * bonusRatio;
		return price - (int)(price*saleRatio);
	}

	@Override
	public String toString() {
		return "GOLDCustomer [세일비율(%)=" + saleRatio + ", 고객ID=" + customerID + ", 고객명=" + customerName
				+ ", 고객등급=" + customerGrade + ", 보너스포인트=" + bonusPoint + ", 적립비율(%)=" + bonusRatio
				+ "]";
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