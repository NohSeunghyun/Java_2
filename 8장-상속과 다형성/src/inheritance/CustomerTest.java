package inheritance;

public class CustomerTest {

	public static void main(String[] args) {
		
		Customer s=new Customer();//기본값으로 채워진 생성자로 객체생성
		
		System.out.println(s);//toString 메서드 재정의해서 주소만으로도 값이 출력됨.
		System.out.println(s.showCustomerInfo());//값을 출력하기위해 새 메서드 생성
		System.out.println("============================================================================================================");
		
		s.customerID=0001;//접근제한자가 protected이기때문에 같은패키지에있으므로 직접접근하여 값변경가능.
		s.customerName="A";//접근제한자가 protected이기때문에 같은패키지에있으므로 직접접근하여 값변경가능.
//		System.out.println(c);//보기좋게 하기위해 이 아래 실행문부터는 show메서드만 사용한다.
		System.out.println(s.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		s.setCustomerID(0002);//기본값을 변경하기위해 set메서드사용.간접접근하여 값변경
		s.setCustomerName("B");//기본값을 변경하기위해 set메서드사용.간접접근하여 값변경
		System.out.println(s.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		s=new Customer(0003, "C");//매개값을 받아 바로 저장할수있는 생성자로 객체생성
		System.out.println(s.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		VIPCustomer v=new VIPCustomer();//기본값으로 채워진 생성자로 객체생성
		
		System.out.println(v);//Customer 클래스를 VIPCustomer클래스에서 상속받았기 때문에 재정의 안해도 값이 출력됨. 다르게 출력하고자하면 재정의를 다시하면됨.//상담원번호,vip전용세일 추가하기위해 재정의함.
							  //재정의이기 때문에 return타입을 void로 바꾸고자 할 수 없음.
		System.out.println(v.showCustomerInfo());//Customer 클래스를 VIPCustomer클래스에서 상속받았기 때문에 재정의 안해도 값이 출력됨. 다르게 출력하고자하면 재정의를 다시하면됨.//상담원번호 추가하기위해 재정의함.
		System.out.println("============================================================================================================");
		
		v.customerID=0004;//접근제한자가 protected이기때문에 같은패키지에있으므로 직접접근하여 값변경가능.
		v.customerName="D";//접근제한자가 protected이기때문에 같은패키지에있으므로 직접접근하여 값변경가능.
		v.setAgentID(9999);//접근제한자가 private이기 떄문에 간접접근하여 값변경가능
		System.out.println(v.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		v.setCustomerID(0005);//기본값을 변경하기위해 set메서드사용.간접접근하여 값변경
		v.setCustomerName("E");//기본값을 변경하기위해 set메서드사용.간접접근하여 값변경
		v.setAgentID(9998);//기본값을 변경하기위해 set메서드사용.간접접근하여 값변경
		System.out.println(v.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		v=new VIPCustomer(0006, "F", 9997);//매개값을 받아 바로 저장할수있는 생성자로 객체생성
		System.out.println(v.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		System.out.println("------------------------------------------------------------------------------------------------------------");
		
		s=new Customer();
		s.setCustomerID(1);
		s.setCustomerName("전상호");
		System.out.println(s.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		v=new VIPCustomer();
		v.customerID=2;
		v.customerName="유신재";
		v.setAgentID(1234);
		System.out.println(v.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		s=new Customer(3, "이수광");
		int price=1000000;//제품구매가격
		
		int leeprice=s.calcPrice(price);
		System.out.println(s.customerName+"님이 "+leeprice+"원 지불 하셨습니다.");
		System.out.println(s);
		System.out.println(s.showCustomerInfo());
		System.out.println("============================================================================================================");

		GOLDCustomer g=new GOLDCustomer(4, "김경탄");
		price=1000000;
		
		int kimprice=g.calcPrice(price);
		System.out.println(g.customerName+"님이 "+kimprice+"원 지불 하셨습니다.");
		System.out.println(g);
		System.out.println(g.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		v=new VIPCustomer(5, "전용준", 5678);
		price=1000000;
		
		int junprice=v.calcPrice(price);
		System.out.println(v.customerName+"님이 "+junprice+"원 지불 하셨습니다.");
		System.out.println(v);
		System.out.println(v.showCustomerInfo());
		System.out.println("============================================================================================================");
		
		//일반고객에서 판매실적에따라 고객등급이 상향됨
		//그에따른 고객정보가 그대로 상속되면서 값만 바뀌고, 기존 정보(상향전 등급에있던 정보)가 삭제 되는지?만들어보자
		
	}//메인문

}//클래스문
/*******************************************************************************************************/