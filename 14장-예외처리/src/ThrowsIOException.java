import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsIOException {
	//기본생성자
	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName); // "b.txt"
		Class c = Class.forName(className); // "java.lang.String"
		return c;
	}
	
	public static void main(String[] args) {
		
		ThrowsIOException test = new ThrowsIOException();
		
		try {
			test.loadClass("b.txt", "java.lang.String");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			System.out.println(e);
		}
		System.out.println("끝");

	} // 메인문
	
} // 클래스문
/*******************************************************************************************************/