package classex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//일반적으로 클래스의 자료형을 모르는 상태에서 사용
		
		Class str = Class.forName("java.lang.String"); // 클래스 이름으로 찾아서 메모리에 로딩
		
		System.out.println("----------String의 생성자----------");
		Constructor[] cons = str.getConstructors(); // 모든 생성자 가져오기
		
		for(Constructor c : cons) {
			System.out.println(c);
		}
		System.out.println();
		
		System.out.println("----------String의 필드(=멤버변수)----------");
		Field[] fs = str.getFields(); // 모든 멤버변수 가져오기
		
		for(Field f : fs) {
			System.out.println(f);
		}
		System.out.println();
		
		System.out.println("----------String의 메서드----------");
		Method[] ms = str.getMethods(); // 모든 메서드 가져오기
		
		for(Method m : ms) {
			System.out.println(m);
		}
		System.out.println();
		
	}//메인문

}//클래스문
/*******************************************************************************************************/