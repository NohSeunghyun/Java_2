import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOExceptionCase {
	
	// public static void main(String[] args) throws FileNotFoundException { 사용시
	// JVM이 FileNotFoundException 예외처리하도록 미룬다. e.printStackTrace();
	public static void main(String[] args) { // throws FileNotFoundException {
		/*
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a.txt"); // 파일을 만들어서 예외발생안하도록 함
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			System.out.println("finally는 항상 실행됩니다.");
		}
		System.out.println("위 실행문을 예외처리 했기때문에 여기도 실행됩니다.");
		*/
		
		/* 497p참조
		 * [try-with-resources문]
		 * 리소스를 자동해제 (=자동 close()) 하도록 제공해주는 구문
		 * 자바 7 부터 제공됨
		 * 
		 * close()를 명시적으로 호출하지 않아도
		 * try{} 블록에서 열린 리소스는 정상적인 경우나 예외 발생한 경우 모두 자동 해제됨. 
		 * 
		 * 해당 리소스(클래스(=FileInputStream))가 AutoCloseable 인터페이스를 구현해야 아래문법 사용가능
		 */
		
		try (FileInputStream fis = new FileInputStream("a.txt")) {
			
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("위 실행문을 예외처리 했기때문에 여기도 실행됩니다.");
		
	} // 메인문
	
} // 클래스문
/*******************************************************************************************************/