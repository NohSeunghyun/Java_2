/*
 * 컬렉션 프레임워크 : 배열의 문제점을 해결하고 널리 알려진 자료구조를 바탕으로
 * 				 '객체들을 효율적으로 추가, 삭제, 검색' 할 수 있도록
 * 				 'java.util'패키지에 컬렉션과 관련된 인터페이스와 클래스들을 포함시켜 놓고
 * 				 이들을 총칭해서 '프레임워크'라고 부름
 * 				 (반드시 객체만 처리)
 * 
 * 				 'Collection'인터페이스
 * 						 |
 * 		  |---------------------------------|
 * 		list 인터페이스						set 인터페이스				map인터페이스
 * 		  |									|						|
 * 배열과 유사 index로 관리					index로 관리하지않음			키와 값의 쌍으로 저장
 * ->순서를 유지하고 저장						->순서를 유지하지않고 젖아		키 : 중복 허용안함, 값 : 중복허용
 * 중복 저장 가능								집합:중복 저장 안됨					|
 * 		  |									|						|
 *   1. ArrayList						1. HashSet				1. HashMap
 *   2. LinkedList												2. TreeMap
 *   3. Vector		
 *   -------------------------------------------------------------------------------------
 *   List 인터페이스를 구현한 클래스 : 
 *   <공통점> 1. 배열과 유사하여 Index로 관리 -> 순서를 유지하고 저장 => for문 사용가능
 *   		2. 중복 저장 가능
 *   
 *   1. ArrayList : 앞에서부터 차례대로 추가나 검색할 때 효율적
 *   				중간에 추가나 삭제가 빈번히 일어나는 곳에서는 비효율적
 *   				싱글 쓰레드에 사용
 *   2. Vector : ArrayList와 특징이 같다. 단, 멀티 쓰레드에 사용
 *   3. LinkedList : 앞에서부터 검색할 때 비효율적
 *   				  중간에 추가하건자 삭제가 빈번히 일어나는 곳에서는 효율적
 */
package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayListExample {

	public static void main(String[] args) {
		/*
		 * 부모인터페이스 = 자식객체가 부모타입(list)으로 자동형변환되어 대입
		 * 컴파일러 입장 : 모든 자식객체들을 부모타입인 List로 인식하여
		 * List에 선언된 추상메서드만 호출할 수 있다.
		 * 
		 * 그런데 자식 클래스들은 클래스의 특징에 맞게 추상메서드를 재정의 하였으므로
		 * 재정의된 메서드가 호출됨
		 */
		//ArrayList<String> list = new ArrayList<String>();
		//List<String> list = new ArrayList<String>(); // E타입은 ArrayList객체를 생성할 때 타입이 결정됨
		// List는 인터페이스지만 ArrayList의 부모이므로 자식을 받아들일수 있다
		
		LinkedList<String> list = new LinkedList<String>(); // LinkedList의 추가된 메서드 사용가능
		//List<String> list = new LinkedList<String>(); // 중간에 추가나 삭제가 빈번할때 사용하면 효율적
		
		//List<String> list = new Vector<String>(); // 멀티 쓰레드에 사용
		
		/*
		 * ★비동기화된 커렉션(싱글쓰레드)을 동기화된 컬렉션(멀티쓰레드)으로 변환하는 방법
		 */
		//list = Collections.synchronizedList(list); // List를 동기화된 List로 리턴 // 싱글쓰레드기 때문에 주석처리
		//List<String> list = Collections.synchronizedList(new ArrayList<String>()); // 위 두 실행문을 하나로 압축
		for(String str : list) {
			System.out.println(str);
		} // for문 종료 // 아직 저장된 값이 없으므로 출력안됨
		
		
		System.out.println("======추가 후 값 얻기======");
		
		list.add("여러분"); // 0인덱스
		list.add("힘내세요"); // 1인덱스
		list.add("^^"); // 2인덱스
		
		//		인덱스, 값
		list.add(1, "모두"); //기존의 1인덱스 값에 넣은 후 기존에 있던 1인덱스값은 2인덱스값으로 2인덱스값은 3인덱스값으로... 뒤로 밀려난다
		list.add("여러분"); // 중복 허용가능
		
		/*
		 * addFirst(), addLast()
		 * ★★LinkedList클래스 안에만 추가된 메서드 반드시 LinkedList객체에서만 사용가능
		 */
		
		list.addFirst("★★"); // LinkedList객체를 LinkedList타입으로 받으면 사용가능. // 연결리스트의 맨 앞에 추가 // 0인덱스에 넣고 그자리에 있던값은 뒤로 순차적으로 밀려남.
		list.addLast("★★"); // 연결리스트의 맨 뒤에 추가 
		
		System.out.println("총 객체수 : " + list.size() + "개 \n");
		
		if (list.contains("모두")) { // 주어진 객체가 저장되어 있으면 true, 없으면 false
			System.out.println("\"모두\"가 존재한다.\n");
		} else System.out.println("\"모두\"가 존재하지 않는다.\n");
		
		System.out.println("2Idx : " + list.get(2) + "\n"); // 2인덱스의 값을 불러온다
		// get(Index) : 해당 인덱스의 값 얻기 -> Set계통에는 없음(Index가 없으므로)
		
		System.out.println("======for문으로 저장된 값 얻기======");
				
		int i;
		for (i = 0 ; i < list.size() ; i++) { // Set계통에는 없음(Index가 없으므로)
			System.out.println(i + "idx : " + list.get(i));
		} // for문 종료
		System.out.println();
		
		System.out.println("======향상된 for문으로 저장된 값 얻기======");
		
		for (String str : list) { // Set계통에는 있음
			System.out.println(str); // 향상된for문은 원하는 인덱스값을 찍어서 출력못함. 저장된값 모두 출력됨
		} // for문 종료
		System.out.println();
		
		System.out.println("======삭제-1(인덱스)======"); // Set계통에는 없음(Index가 없으므로)
		
		System.out.println("Index 4에 저장된 문자열 : " + list.remove(4) + " -> 삭제 \n"); // remove(인덱스값)
		// 인덱스 4에 저장된 "여러분"을 출력해주고, 삭제함
		
		System.out.println("======확인======");
		
		for (i = 0 ; i < list.size() ; i++) {
			System.out.println(i + "idx : " + list.get(i));
		} // for문 종료
		System.out.println();
		
		System.out.println("======삭제-2(객체)======"); // Set계통에는 있음
		
		if (list.remove("정말")) System.out.println("찾아서 있으면 삭제 후 true -> 삭제함 \n");
		else System.out.println("찾아서 없으면 false -> 삭제안됨 \n");
		
		System.out.println("======모두 삭제======");
		
		// 방법1
		//list.removeAll(list); // 삭제하면 true 안되면 false 그래서 이 실행문을 사용하면 if문을 사용할 수 있다.
		//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		if (list.removeAll(list)) System.out.println("모두삭제됨 \n");
		else System.out.println("모두 삭제안됨 \n");
		
		// 방법2
		list.clear(); // void이므로 돌려주는 값이 없다. 그래서 확인하려면 for문이나 저장된 객체수, isEmpty로 확인한다.
		
		System.out.println("======확인======");
		
		System.out.println("총 객체수 : " + list.size() + "개 \n");
		
		if (list.isEmpty()) System.out.println("참조하는 객체 없음 \n");
		else System.out.println("참조하는 객체 있음 \n");
		
	}//메인문

}//클래스문
/*******************************************************************************************************/