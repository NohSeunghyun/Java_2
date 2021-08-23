package map.hashmapstudent;

import java.util.HashMap;

public class HashMap_Student {

	public static void main(String[] args) {
		// 학생의 점수를 관리하는 HashMap 객체 , 키 : 중복X, 값 : 중복O
		HashMap<Student, Integer> map = new HashMap<Student, Integer>();
		// Student 에는 사용자 정의 클래스에서 만든 Student생성자를 통해 값을 넣고,
		// Integer에는 점수를 넣으면 된다.
		
		//map.put(new Student(1, "윤호섭"), new Integer(85)); // 바로 정수를 넣어도 되고 new Integer() 괄호안에 값을 넣어도됨
		Student key = new Student(1, "윤호섭");
		//map.put(new Student(1, "윤호섭"), 85); // Hash메서드로 equals메서드를 호출해 true를 돌려받으면 중복되므로 객체 저장안함. false를 돌려받으면 중복되지 않으므로 저장함
		map.put(key, new Integer(85));
		map.put(new Student(2, "윤호섭"), 90); // 키는 중복허융안되기때문에 바꾸고 값은 중복되기때문에 같은 값으로 넣어본다. // 사용자 정의클래스에서 hash,equals 메서드에 name비교해도 중복허용되므로 값이 들어간다.
		
		System.out.println("총 객체 수 : " + map.size() + "개");
		
		map.put(new Student(1, "윤호섭"), 100); // 85 -> 100으로 값 변경
		// 학번1 출력하기
		System.out.println("학번1 윤호섭의 점수 : " + map.get(1)); // 안됨. HashMap에 들어가는 소스를 보면 <Student(키,값), Integer(=점수)>이므로 되게하려면 아래소스 사용해야함
															// 말그대로 get괄호 안에는 저장했던 Student의 소스를(=new Student(key, value)) 넣어야함
		System.out.println("학번1 윤호섭의 점수 : " + map.get(key)); // Student의 값을 key로 참조시키고 put에 key를사용후 점수를 넣어 저장하고 검색할때는 key라는 참조변수명만 써도됨
		System.out.println("학번1 윤호섭의 점수 : " + map.get(new Student(1, "윤호섭")));
		
	}// 메인문

}// 클래스문
/*******************************************************************************************************/