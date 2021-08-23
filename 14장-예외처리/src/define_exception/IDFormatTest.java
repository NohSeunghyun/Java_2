package define_exception;

import java.util.Scanner;

class IDFormatTestException extends Exception {
	IDFormatTestException(String message) {
		// TODO 상황에 따라 메세지 출력
		super(message);
	}
}

//라이브러리용 + 실행용
public class IDFormatTest {
	
	private String userID; // not null + 8자리이상 20자리이하
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) throws IDFormatTestException {
		if (userID == null)
			try {
				throw new IDFormatTestException("아이디는 null일 수 없습니다.");
			} catch (IDFormatTestException e) {
				System.out.println(e);
			}
		else if (!(userID.length() >= 8 && userID.length() <= 20)) {
			throw new IDFormatTestException("아이디는 8자 이상, 20자 이하로 쓰세요");
		}
		this.userID = userID;
	}

	public static void main(String[] args) {
		
		IDFormatTest test= new IDFormatTest();
		String userID = null;
		
		try {
			test.setUserID(userID);
		} catch (IDFormatTestException e) {
			System.out.println(e);
		}
		
		userID = "1234567";
		
		try {
			test.setUserID(userID);
		} catch (IDFormatTestException e) {
			System.out.println(e);
		}
		
	} // 메인문
	
} // 클래스문
/*******************************************************************************************************/