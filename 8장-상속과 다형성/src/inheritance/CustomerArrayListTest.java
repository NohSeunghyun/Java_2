package inheritance;

import java.util.ArrayList;

public class CustomerArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<Customer> customerList=new ArrayList<Customer>();//Customer객체와 Customer의 자식객체만 저장가능
		
		customerList.add(new Customer(1, "노승현"));
		customerList.add(new GOLDCustomer(2, "김명강"));//★★자식객체->부모로 형변환되어 저장
		customerList.add(new VIPCustomer(3, "엄민정", 1234));
		
		System.out.println("==============================================고객정보출력=====================================================");
		
		for(Customer c:customerList) {
			System.out.println(c.showCustomerInfo());
		}
		System.out.println("List에 저장된 객체수 : "+customerList.size()+"개 입니다.");
		
		System.out.println("========================================지불 가격과 보너스 포인트 출력================================================");
		
		int price=10000;
		
		for(Customer c:customerList) {
			int cost=c.calcPrice(price);
			
			System.out.println(c.customerName+"님이 "+cost+"원을 지불하셨습니다.");//지불가격
			System.out.println(c.customerName+"님의 현재 보너스 포인트는"+c.bonusPoint+"점 입니다.");
		}//for문 종료
		
		System.out.println("=============================================고객의 세일 비율====================================================");
		
		for(Customer c:customerList) {
			
			/*자식의 추가된 메서드를 호출하는 방법.(각 클래스의 세일비율 메서드(=showSaleRatio))
			 *이유?컴파일러가 자식객체를 부모객체로 인식하므로 자식의 추가된 메서드를 호출할 수 없으므로
			 *    해당 자식객체인지 먼저 if문(instanceOf)을 통해 확인 후 
			 *    해당 자식 객체로 형변환 하여 -> 자식에 추가된 메서드 호출 가능함
			 *    (★단, 가장 마지막 자식부터 확인)
			 *    
			 */
			
			//if (c instanceof GOLDCustomer) : c가 참조하는 객체가 GOLDCustomer또는 GOLDCustomer의 자식객체니?하고 물어봄
			//GOLDCustomer 자식이 없기때문에 GOLDCustomer인지 확인을함
			if (c instanceof GOLDCustomer) {//참:GOLDCustomer
				((GOLDCustomer) c).showSaleRatio();//컴파일러에 따라 그냥 c.적고 컨트롤스페이스바하면 showSaleRatio를 자동형변환 시켜줄 때도있으나
													//어떤컴파일러는 앞에 ((GOLDCustomer) c).을 적어야 showSaleRatio가 보일수 있으니 후자 를 연습한다.
			}else if (c instanceof VIPCustomer) {//참:VIPCustomer
				((VIPCustomer) c).showSaleRatio();
			}else c.showNoSaleRatio();//Customer
		}//for문 종료
		
	}//메인문

}//클래스문
/*******************************************************************************************************/