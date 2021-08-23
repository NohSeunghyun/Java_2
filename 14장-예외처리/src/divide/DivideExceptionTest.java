package divide;

public class DivideExceptionTest {
	
	public static void main(String[] args) {
		
		boolean divOK = divider(4, 2);
		if (divOK) System.out.println("나누기 연산 성공");
		else System.out.println("나누기 연산 실패");
		
		divOK = divider(4, 0); // 결과 : Infinity = 무한대
		if (divOK) System.out.println("나누기 연산 성공");
		else System.out.println("나누기 연산 실패");
		
		double result = divider2(4, 0);
		result = result + 100;
		System.out.println(result); // 결과 : Infinity = 무한대
		
		//========================================================
		
		divOK = divider3(4, 0); // 0을 넣으면 무한대가 나오기 때문에 0을 못넣게 메서드 변경. 넣을 시 예외 발생.
		if (divOK) System.out.println("나누기 연산 성공");
		else System.out.println("나누기 연산 실패");
		
		//========================================================
		
		divOK = divider4(4, 0);
		if (divOK) System.out.println("나누기 연산 성공");
		else System.out.println("나누기 연산 실패");
		
		result = divider5(4, 0);
		result = result + 100;
		System.out.println(result);
		
	} // 메인문
	
	static boolean divider(int num1, int num2) {
		double result = (double)num1 / num2; // 10/3 = 3(몫), 10.0/3.0 = 3.3333....
		System.out.println("나눗셈 결과 : " + result);
		return true;
	}
	
	static double divider2(int num1, int num2) {
		double result = (double)num1 / num2;
		return result;
	}
	
	//========================================================
	
	static boolean divider3(int num1, int num2) {
		int result = num1 / num2; // 4/0 = Infinity(=무한대) -> ArithmeticException / by zero 발생
								  // ArithmeticException은 RuntimeException의 자식
		System.out.println("나눗셈 결과 : " + result);
		return true;
	}
	
	//========================================================
	// 위 문제를 해결하기위한 메서드
	static boolean divider4(int num1, int num2) {
		if (num2 != 0) {
			System.out.println("나눗셈 결과 : " + (double)num1 / num2);
			return true;
		} else
			System.out.println("0으로 나눌 수 없습니다.");
			return false;
	}
	
	static double divider5(int num1, int num2) {
		if (num2 != 0) {
			return (double)num1 / num2;
		} else
			System.out.println("0으로 나눌 수 없습니다.");
			return 0.0;
	}
	
} // 클래스문
/*******************************************************************************************************/