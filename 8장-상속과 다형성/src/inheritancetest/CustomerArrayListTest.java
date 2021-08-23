package inheritancetest;

import java.util.ArrayList;

public class CustomerArrayListTest {

	public static void main(String[] args) {
		
		//Customer타입만 저장가능한 ArrayList객체생성[null,null,null....(총10개. 11를를넣으면 20개의 null값을가진 객체생성 21개를넣으면 30개의 null값을가진 객체생성...)]
		ArrayList<Customer> CustomerList=new ArrayList<Customer>();//Customer의 자식객체는 Customer타입으로 자동형변환되어 저장
		
		//회원3명(Customer, GoldCustomer, VIPCustomer)추가
		CustomerList.add(new Customer(1, "하하하"));
		CustomerList.add(new GoldCustomer(2, "히히히"));
		CustomerList.add(new VIPCustomer(3, "호호호", 0001));
		
		System.out.println(CustomerList.toString());
		
		System.out.println("====================고객 정보 출력====================");
		
		for(Customer c:CustomerList) {
			System.out.println(c);
		}//for문 종료//재정의한 toString으로 출력
		
		for(Customer c:CustomerList) {
			System.out.println(c.showCustomerInfo());
		}//for문 종료//추가한 메서드로 출력
		
		System.out.println("====================지불가격과 보너스포인트 출력====================");
		int price=10000;
		
		for(Customer c:CustomerList) {
			int a=c.calcPrice(price);
			System.out.println(c.customerName+"님이 "+a+"원을 지불하셨습니다.");
			System.out.println(c.customerName+"님의 현재 보너스포인트는 "+c.bonusPoint+"점 입니다.");
		}//for문 종료
		
		System.out.println("====================고객의 세일비율 출력(상담원 있으면 출력)====================");
		
		for (Customer c:CustomerList) {
			if(c instanceof VIPCustomer) {
				((VIPCustomer) c).showSaleRatio();
				((VIPCustomer) c).showAgentID();
			}else if(c instanceof GoldCustomer) {
				((GoldCustomer) c).showSaleRatio();
			}else c.showSaleRatio();
		}//for문 종료
		
		System.out.println("====================★★배열객체에 저장(삽입한)된 객체수 구하기====================");
		
		System.out.println(CustomerList.size()+"개");
		
		System.out.println("====================각 고객의 등급만 출력====================");
		
		//책에서는 "if (c.customerGrade=="SILVER") {}"을 사용했는데 안되는 이유.
		for (Customer c:CustomerList) {
			if (c.customerGrade.equals("SILVER")) {
				System.out.println(c.customerName+"님의 등급은 "+c.getCustomerGrade()+"입니다.");
			}else if (c.customerGrade.equals("GOLD")) {
				System.out.println(c.customerName+"님의 등급은 "+c.getCustomerGrade()+"입니다.");
			}else System.out.println(c.customerName+"님의 등급은 "+c.getCustomerGrade()+"입니다.");
		}//for문 종료//고객등급은 String타입이기 때문에 비교연산자(==)같은 연산자를 사용할수 없으므로 문자를 비교하기위한 equals를 사용해 찾아낸다.
		
	}//메인문

}//클래스문
/*******************************************************************************************************/