package divide;

import java.util.Scanner;

public class DivideByZero {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나눗셈을 할 두 정수를 입력하세요.");
		
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		try {
			System.out.println("나눗셈 결과의 몫 : " + (num1/num2));
			System.out.println("나눗셈 결과의 나머지 : " + (num1%num2));
		} catch (Exception e) {
			//e.printStackTrace(); // 종류 + 메세지 + 경로
			//System.out.println(e); // 종류 + 메세지
			//System.out.println(e.getMessage()); // 메세지
			System.out.println("0으로 나눗셈이 불가합니다.");
		} finally {
			System.out.println("예외 발생 유무에 관계없이 무조건실행");
		}
		System.out.println("연산종료");
		
		System.out.println("나눗셈을 할 두 실수를 입력하세요.");
		
		System.out.print("첫번째 실수 : ");
		double num3 = sc.nextDouble();
		System.out.print("두번째 실수 : ");
		double num4 = sc.nextDouble();
		//첫번째실수 = 10, 두번째실수 = 0 입력 시 몫은 infinity = 무한대, 나머지는 nan = not a number
		
		double result1 = num3/num4;
		double result2 = num3%num4;
		
		//infinity나 nan의 값은 더이상 연산을 진행하면 안되므로 아래와 같은 학인절차를 거친다.
		if (Double.isInfinite(result1) || Double.isNaN(result1)) {
			System.out.println("연산 결과값으로 불가합니다.");
		} else System.out.println(result1 + 10000);
		
		if (Double.isInfinite(result2) || Double.isNaN(result2)) {
			System.out.println("연산 결과값으로 불가합니다.");
		} else System.out.println(result2 + 10000);
		
	} // 메인문
	
} // 클래스문
/*******************************************************************************************************/