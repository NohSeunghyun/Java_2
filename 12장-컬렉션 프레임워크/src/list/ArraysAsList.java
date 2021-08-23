package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
	
	public static void main(String[] args) {
		
		String[] s = {"윤호섭", "이수광"}; // 배열 선언과 동시에 초기화
		
		/*
		 * ArrayList : 배열처럼 선언과 동시에 초기화가 불가능하다.(기본값인 null로 채워짐)
		 * 				그러나 추가나 삭제 등은 메서드를 통해 쉽게 사용가능
		 * 
		 * Arrays : 배열을 조작하기 위해 만들어진 클래스
		 * 			배열처럼 선언과 동시에 초기화 가능하다
		 * 			그러나 추가나 삭제가 불가능
		 * 
		 * 그래서 '배열처럼 선언과 동시에 초기화'가 되고
		 * ArrayList처럼 '추가나 삭제 등은 메서드를 사용'할 수 있도록
		 * 아래 소스에서 방법을 확인
		 */
		
		/*
		 * 1. Arrays.asList() 사용하여 순차적으로 입력된 값(초기값)으로 고정된 List 객체 생성
		 * (아직 추가나 삭제 메서드 사용불가. 이유? List는 인터페이스이므로 미완성된 추상메서드로 사용불가)
		 */
		
		List<String> list1 = Arrays.asList("유신재", "김경탄", "김명강"); // 메서드안에 객체를 넣으면 객체타입으로 타입이 바뀐다
		
		/*
		 * 향상된 for문 : Index로 접근하지 않고 값을 참조할 때만 사용함
		 * 				값을 변경할 때는 사용불가 (이유? 값을 변경하려면 Index가 필요함)
		 */
		
		// 추가, 삭제 불가
//		list1.add("조지영"); // 추가 -> 예외 -> 프로그램 강제종료
//		list1.remove(0); // 삭제 -> 예외 -> 프로그램 강제종료
		
		System.out.println("총 객체 수 : " + list1.size() + "개"); // list1에 저장된 객체수 출력
		System.out.println(list1.get(1)); // 1인덱스의 값을 출력
		
		for(String name : list1) {
			System.out.println(name);
		} // for문 종료
		
		System.out.println("===================================");
		
		/*
		 * 2. 이렇게 만들어진 List객체로 ArrayList 객체 생성하여
		 * 추가나 삭제 등 메서드를 사용할 수 있다.
		 */
		
		list1 = new ArrayList<String>(list1); // 초기화 + 추가나 삭제 메서드 사용가능
		// list1대신 List<String> list2 사용해도됨.(새로 만들어 참조)
		
		// 추가, 삭제 가능
		list1.add("조지영"); // 추가
		System.out.println("Index 0에 저장된 문자열 : " + list1.remove(0) + " -> 삭제"); // 삭제
		
		for(String name : list1) {
			System.out.println(name);
		} // for문 종료 // 추가한 값 확인
		
		System.out.println("===================================");
		
		/*
		 * 교재 375p - Wrapper클래스 : 기본 자료형을 위한 클래스
		 * 부모 : Number클래스
		 * (int - Integer, double - Double, "123" -> 123
		 * 기본타입(Int) -> '자동 boxing'하여 Integer타입으로 변환
		 */
		
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		List<Integer> list3 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
		
		// Integer객체가 자동으로 unboxing하여 기본타입(int)으로 변환
		for(int value : list3) {
			System.out.println(value);
		} // for문 종료
		
		list3 = new ArrayList<Integer>(list3);
		
		list3.add(4); //기본타입(int) -> '자동 boxing'하여 Integer타입으로 변환하여 추가
		list3.add(new Integer(5));
		System.out.println("Index 0에 저장된 문자열 : " + list3.remove(0) + " -> 삭제");
		
		for (int value : list3) {
			System.out.println(value);
		} // for문 종료 // 추가한 값 확인
		
		System.out.println("===================================");
		
		System.out.println(list3.get(0)); // 삭제하고 난 후 Index가 앞으로 당겨지면서 자동 저장됨.
		// Index0 의 값인 1을 삭제하고 난 후 Index1 의 값인 2가 Index0 으로 이동 Index2 의 값인 3이 Index1 로 이동 ....
		
		System.out.println("===================================");
		// 교재 375p - wrapper클래스 참조
		
		/*
		 * 교재 375p - Wrapper클래스 : 기본 자료형을 위한 클래스
		 * 							자동으로 boxing, unboxing이 됨
		 * 
		 * 1. 부모 : Number클래스(수와 관련된 클래스) - 자동 boxing과 unboxing이 됨
		 * (int - Integer, double - Double ...emd
		 * 
		 * 2. 부모 : Object클래스 - 자동 boxing과 unboxing이 됨
		 * (char - Character, boolean - Boolean)
		 * 
		 * 							   ↓문자열
		 * Character타입만 parseCharacter()메서드가 없다.
		 * (이유? Character "abc"(문자가 여러개) -> char 'a'(문자가 1개)로 변환할 수 없으므로 불가능.(Character는 문자열을 의미, char는 문자하나를 의미))
		 * 그래서 String클래스의 charAt(int Index)메서드로 문자열의 특정 문자 1개를 추출함
		 */
		
		Integer ivalue = new Integer(123); // 부모 Number클래스
		int myvalue = ivalue.intValue(); // 수동 unboxing -> 자동으로 되기때문에 권장하지않음
		
		Integer ivalue2 = new Integer(123);
		int num2 = 200;
		num2 = ivalue2 + num2; // Integer타입인 ivalue2가 자동으로 unboxing되어 int(123)으로 변환되어 연산
		
		System.out.println(num2);
		
		// boxing
		Integer ivalue3 = num2; // int타입인 323이 자동으로 boxing되어 Integer타입으로 변환되어 대입
		Integer ivalue4 = new Integer(num2); // 수동 boxing -> 자동으로 되기때문에 권장하지않음
		
		// 문자열()을 -> 기본타입으로 변환
		int svalue = Integer.parseInt("123");
		double dvalue = Double.parseDouble("123.4");
		
		// int svalue2 = Integer.parseInt("abc"); // 문법적인 오류는 없지만 실행하면 NumberFormatException 예외오류발생 숫자로 이루어진 문자열이 아닌 문자로 이루어진 문자열이기때문에
		
		// Character와 Boolean은 Object의 자식클래스
		Character ch = 'a'; // char->Character 타입으로 변환되어 저장됨 // 자동 boxing
		char ch2 = ch; // 자동 unboxing
		
		// Character.parseCharacter(); // 메서드 자체가 없음
		char ch3 = "abc".charAt(0); // 문자열을 문자하나로 바꿀 수 있다.
		System.out.println(ch3);
		
		Boolean b1 = true; // 자동 boxing
		boolean b2 = b1; // 자동 unboxing
		
		boolean b3 = Boolean.parseBoolean("true");
		System.out.println(b3);
		
	}//메인문
	
}//클래스문
/*******************************************************************************************************/
