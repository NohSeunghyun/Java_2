/*
 * 오류
 * 1. 컴파일 오류 : 문법적인 오류
 * 2. 실행 오류
 *   1). 시스템 오류 = Error : JVM에서 발생 - 메모리에 문제 -> 프로그램에서 제어X
 *   2). Exception 클래스 : 프로그램에서 제어O
 *   	 488p 아래 그림 참조
 *   	 Exception 클래스의 자식 클래스들은 예외 처리 해줘야 함.
 *   	  그러나, RuntimeException(실행 오류 예외처리)은 프로그래머의 실수로 발생하는 예외이므로
 *   	 try~catch()로 처리하는 방법 보다 실수를 수정하는 방법으로 해결하는것이 더 효율적
 *   
 *   	  예외처리 방법1.
 *   	 try {
 *   		  예외가 발생할 가능성이 있는 부분
 *   	 } catch (Exception) { // Exception은 모든 예외의 부모
 *   		  처리
 *   	 } finally {
 *   		 예외 발생 여부에 관계없이 무조건 실행
 *   	 }
 */

public class RuntimeExceptionCase {
	
	public static void main(String[] args) {
		
		System.out.println("==========예외를 각각 처리==========");
		
		try {
			int[] arr = new int[3]; // [3]은 인덱스 수. 인덱스 3까지라는 뜻이 아님 고로 인덱스 0 1 2 만 존재
			arr[3] = 20; // ArrayIndexOutOfBoundsException 발생하면 
						// arr[3]은 인덱스3의 자리에 20의 값을 참조시키는데 위 실행문을 보면 인덱스 3은 존재하지않는다.
						// 그래서 예외객체 오류발생.
			System.out.println("예외가 발생하면 실행되지 않는다.");
		}catch (Exception e) { // 잡아서
			//e.printStackTrace(); // 예외객체의 종류 + e.getMassage()를 호출한 결과를 출력 + 어디서 예외발생되어서 전달된 경로 출력
			//System.out.println(e.getMessage());
			System.out.println("배열의 범위를 넘어섬");
		} finally { // 예외 발생 여부에 관계없이 무조건 실행됨
			System.out.println("예외 발생 유무에 관계없이 무조건 출력");
		}
		
		try {
			Object obj = new int[10]; // 배열이 Object타입으로 자동 형변환
			String str = (String) obj; // try~catch 안쓰면 ClassCastException 발생
			System.out.println("예외가 발생하면 실행되지 않는다.");
		} catch (Exception e) {
			System.out.println("문자열로 형변환이 안됩니다.");
		} 
		
		try {
			int[] arr2 = new int[-10]; // try~catch 안쓰면 NegativeArraySizeException 발생
			System.out.println("예외가 발생하면 실행되지 않는다.");
		} catch (Exception e) {
			System.out.println("배열크기를 음수로 할 수 없습니다.");
		}
		
		try {
			String str2=null;
			int len = str2.length(); // try~catch 안쓰면 NullPointerException 발생
			System.out.println("예외가 발생하면 실행되지 않는다.");
		} catch (Exception e) {
			System.out.println("문자열 객체가 없는 null 상태입니다.");
		}
		
		System.out.println("==========예외를 하나의 try로 처리==========");
		
		// 방법1 - try/catch 
		/*
		try {
			int[] arr = new int[3];
			arr[3] = 20;
			System.out.println("예외가 발생하면 실행되지 않는다.");
			
			Object obj = new int[10];
			String str = (String) obj;
			System.out.println("예외가 발생하면 실행되지 않는다.");
			
			int[] arr2 = new int[-10];
			System.out.println("예외가 발생하면 실행되지 않는다.");
			
			String str2=null;
			System.out.println("예외가 발생하면 실행되지 않는다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// 방법2 - try/multi-catch
		int j = 3, size = -10;
		for(int i = 0 ; i <=3 ; i++) {
			try {
				int[] arr = new int[3];
				arr[j] = 20;
				System.out.println("예외 발생 안함.");
				
				Object obj = new int[10];
				String str = (String) obj;
				System.out.println("예외 발생 안함.");
				
				int[] arr2 = new int[size];
				System.out.println("예외 발생 안함.");
				
				String str2="문자열"; // 실행되게하기위해 null->문자열 로 변경
				int len = str2.length();
				System.out.println("예외 발생 안함.");
			} catch (ArrayIndexOutOfBoundsException e) { // RuntimeException의 자식
				System.out.println("배열의 범위를 넘어섬");
				j=0;
				continue; // 이것 사용시 아래의 "내용....."은 출력안됨
			} catch (ClassCastException e) { // RuntimeException의 자식
				System.out.println("문자열로 형변환이 안됩니다.");
				continue;
			} catch (NegativeArraySizeException e) { // RuntimeException의 자식
				System.out.println("배열크기를 음수로 할 수 없습니다.");
				size = 20;
				continue;
			} catch (NullPointerException e) { // RuntimeException의 자식
				System.out.println("문자열 객체가 없는 null 상태입니다.");
				continue;
			} catch (RuntimeException e) { // RuntimeException은 Exception의 자식
				System.out.println(e);
			} catch (Exception e) { // 맨 아래는 가장 부모인 Exception
				e.printStackTrace();
			}
			System.out.println("내용.....");
		} // for문 종료
		System.out.println("예외처리 종료");
		
	} // 메인문
	
} // 클래스문
/*******************************************************************************************************/