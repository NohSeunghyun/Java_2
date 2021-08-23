/*
 * Map 인터페이스
 * 1. 키와 값으로 구성된 Map.Entry 객체를 저장
 * 2. 키와 값은 모두 객체
 * 3. 키 : 중복X, 값 : 중복O
 * 4. 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대체된다.
 */
package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		// <키,값> Map컬렉션 생성
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// 객체추가
		map.put(new Integer(6), "김진일"); // 6(Int)->Integer 
		map.put(3, "유신재"); // 기본타입인 int가 자동으로 boxing되어 Integer객체로 변환
		map.put(7, "주종환");
		map.put(6, "노승현"); // 위의 6번 "김진일"의 참조를 끊고 "노승현"으로 변경
		
		System.out.println("총 객체수 : " + map.size() + "개"); // 맨 처음 추가한 객체와 추가한 객체의 키가 같으므로 값이 변경된것이기 때문에 총 객체수는 3개
		
		// 키로 값을 얻어옴
		System.out.println("키 6번의 이름 : " + map.get(6) + "\n");
		
		System.out.println("저장된 전체 객체를 대상으로 키와 값을 얻는 4가지 방법\n");
		
		// 방법 1,2는 keySet사용
		Set<Integer> kSet = map.keySet(); // 6, 3, 7 키 객체만 가지고있음
		
		System.out.println("방법-1 : keySet() -> 반복자 iterator() 사용");
		Iterator<Integer> itr1 = kSet.iterator(); // 키(=Integer)의 반복자(=iterator)를 하나하나 가리키는 지팡이역할)를 통해
		
		while(itr1.hasNext()) { // 객체가 들어있는지 물어보는 실행문 // 키가 있으면
			int key = itr1.next(); // 하나씩 키를 가져와
			String value = map.get(key); // 값을 얻어옴
			System.out.println(key + "번의 이름은 " + value + " 입니다.");
		} // while문 종료
		
		System.out.println(); // 구분위한 빈줄
		
		System.out.println("방법-2 : keySet() -> 향상된 for 사용");
		for (Integer key : kSet) {
			System.out.println(key + "번의 이름은 " + map.get(key) + " 입니다.");
		} // for문 종료
		
		System.out.println(); // 구분위한 빈줄
		
		System.out.println("======방법 3,4 진행하기전 키로 값 삭제하기======");
		System.out.println("6번 " + map.remove(6) + "을(를) 삭제하였습니다.");
		System.out.println("총 객체수 : " + map.size() + "개");
		System.out.println("키 6번의 이름 : " + map.get(6));
		System.out.println("=====================================\n");
		
		// 방법 3,4는 entrySet사용
		Set<Entry<Integer, String>> eSet = map.entrySet(); // [3, 유신재], [7, 주종환] 이 들어있음
		
		System.out.println("방법-3 : entrySet() -> 반복자 iterator() 사용");
		Iterator<Entry<Integer, String>> eitr = eSet.iterator(); // <키,값>의 반복자(=iterator)를 통해
		
		while (eitr.hasNext()) {
			Entry<Integer, String> entry = eitr.next(); // <3, 유신재>, <7, 주종환>
			// entry.getKey(); // 엔트리 객체안의 키를 돌려줌
			// entry.getValue(); // 엔트리 객체안의 값을 돌려줌
			// ↓↓↓↓↓↓↓ 하나의 실행문으로 ↓↓↓↓↓↓↓
			System.out.println(entry.getKey() + "번의 이름은 " + entry.getValue() + "입니다.");
		} // while문 종료
		
		System.out.println(); // 구분위한 빈줄
		
		System.out.println("방법-4 : entrySet() -> 향상된 for 사용");
		for (Map.Entry<Integer, String> entry: eSet) { // Entry앞의 Map. 생략가능
			System.out.println(entry.getKey() + "번의 이름은 " + entry.getValue() + "입니다.");
		} // for문 종료
		
		System.out.println(); // 구분위한 빈줄
		
		map.clear(); // 객체 전체 삭제. void이기때문에 돌려주는값이 없기때문에 확인하려면 객체수를 찾거나 안의 값이 있는지 찾아본다. 위 방법대로 for문을사용해 값을 출력해봐도 됨 -> 하지만 출력되는것이 없으므로 비효율적.무의미
		System.out.println("총 Entry 객체 수 : " + map.size() + "개"); // 저장된 총 객체수 출력
		
		if (map.isEmpty()) System.out.println("모두 삭제됨"); // 객체안에 값이 비었는지 확인함
		else System.out.println("삭제되지 않음");
		
	}// 메인문

}// 클래스문
/*******************************************************************************************************/