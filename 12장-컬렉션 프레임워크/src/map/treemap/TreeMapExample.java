package map.treemap;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapExample {

	public static void main(String[] args) {
		// Tree : 검색기능이많음, 정렬 + map : <키,값>Entry(=쌍)
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		
		tmap.put(89, "이순신"); // 89(int)->자동 boxing되어 89(Integer)로 형변환
		tmap.put(new Integer(95), "홍길동"); // 자동 boxing이 아닌 Integer를 호출해 수동으로 바꿈
		tmap.put(78, "김유신");
		tmap.put(98, "유관순");
		tmap.put(80, "전용준");
		tmap.put(83, "김건우");
		
		tmap.put(78, "강감찬"); // Map 메서드는 키 중복 허용 안하기때문에 기존의 참조(김유신)을 끊고 새로운 값(강감찬)을 참조한다
		
		System.out.println("저장된 Entry 객체 수 : " + tmap.size() + "개 \n");
		
		System.out.println("-----------검색과 관련된 메서드들-----------");
		System.out.println("가장 낮은 객체 리턴(=가장 낮은 점수) : 점수 = " + tmap.firstEntry().getKey() + ", 이름 = " + tmap.firstEntry().getValue()); //TreeSet은 first()이나 TreeMap은 뒤에 Entry가 붙는다.
		Entry<Integer, String> entry = tmap.lastEntry(); // 코드가 길기때문에 코드를 참조시켜 변수명만 사용해도됨 하지만 아래에는 키와 값을 따로 출력하게 해놓음
		System.out.println("가장 높은 객체 리턴(=가장 높은 점수) : 점수 = " + entry.getKey() + ", 이름 = " + entry.getValue() + "\n");
		
		System.out.println("주어진 객체 '95'보다 바로 아래 객체를 리턴 : " + tmap.lowerEntry(95)); // 코드그대로사용
		entry = tmap.higherEntry(95); // 코드를 참조시켜 변수명만 사용하기
		System.out.println("주어진 객체 '95'보다 바로 위 객체를 리턴 : 점수 = " + entry.getKey() + ", 이름 = " + entry.getValue() + "\n");
		
		System.out.println("주어진 객체96와 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 아래 객체를 리턴 : " + tmap.floorEntry(96));
		entry = tmap.ceilingEntry(94); // 코드를 참조시켜 변수명만 사용하기
		System.out.println("주어진 객체94와 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 위 객체를 리턴 : 점수 = " + entry.getKey() + ", 이름 = " + entry.getValue() + "\n");
		
		System.out.println("-----------범위검색과 관련된 메서드들-----------");
		
		/*
		 * SortedMap<K, V> subMap(K fromKey, K toKey) 
		 *                     시작(포함) ~ 끝 이전까지의 부분집합 반환
         * NavigableMap<K, V> subMap(K fromKEy, boolean fromInclusive, K toKey, boolean toInclusive)
                                                              시작 (포함여부 선택 가능) ~ 끝 (포함여부 선택 가능) 까지의 부분 집합 반환
		 */
		
		System.out.print("78 <= 찾는 점수 < 95 : ");
		SortedMap<Integer, String> tmapSub1 = tmap.subMap(78, 95); // 78 이상 95 미만
		Set<Entry<Integer, String>> tmapSet1 = tmapSub1.entrySet();
		Iterator<Entry<Integer, String>> tmapSetItr1 = tmapSet1.iterator();
		
		while (tmapSetItr1.hasNext()) { // 저장된 객체가 있는지 물음
			entry = tmapSetItr1.next(); // <78, 강감찬> 부터.. <89, 이순신>까지.95포함안됨
							// Sorted 정렬이기 때문에 정렬되어 가져올 확률이 높다 // 위에 Entry<Integer, String> entry 를 선언했기 때문에 entry만 써도됨
			System.out.println("점수 = " + entry.getKey() + ", 이름 = " + entry.getValue());
		} // while문 종료
	    System.out.println();
	    
	    System.out.print("78 <= 찾는 점수 <= 95 : ");
		NavigableMap<Integer, String> tmapSub2=tmap.subMap(78, true, 95, true); // 78 이상 95 이하
		Set<Entry<Integer, String>> tmapSet2 = tmapSub2.entrySet();
		Iterator<Entry<Integer, String>> tmapSetItr2 = tmapSet2.iterator();
		
		while (tmapSetItr2.hasNext()) {
			entry = tmapSetItr2.next();
			System.out.println("점수 = " + entry.getKey() + ", 이름 = " + entry.getValue());
			
		} // while문 종료
		System.out.println();
		
		System.out.println("-----------오름차순, 내림차순-----------");		
		System.out.println("======오름차순으로 정렬된 NavigableSet 객체를 리턴======");
		NavigableSet<Integer> dKey = tmap.descendingKeySet(); // keyset을 이용한 내림차순 정렬
		//Iterator<Integer> dKeyitr = dKey.iterator(); // 내림차순에 대한 반복자. // 내림차순이 됨 
		Iterator<Integer> dKeyitr = dKey.descendingIterator(); // descendingIterator();를 사용한다면 내림차순을 다시 내림차순반복자를 한것 => 오름차순이 됨
		while (dKeyitr.hasNext()) {
			Integer key = dKeyitr.next();
			String value = tmap.get(key);
			
			System.out.println("점수 = " + key + ", 이름 = " + value);
		} // while문 종료
		System.out.println();
		
		System.out.println("======내림차순으로 정렬된 NavigableMap 객체를 리턴======");
		NavigableMap<Integer, String> dMap = tmap.descendingMap(); // 내림차순으로 정렬된 NavigableMap
		Set<Entry<Integer, String>> dMapSet = dMap.entrySet();
		
		for(Entry<Integer, String> e : dMapSet) {
			System.out.println("점수 = " + e.getKey() + ", 이름 = " + e.getValue());
		} // for문 종료
		System.out.println();
		
		System.out.println("======다시 내림차순하여 오름차순으로 정렬된 NavigableMap 객체를 리턴======");
		NavigableMap<Integer, String> aMap = dMap.descendingMap(); // 내림차순으로 정렬된 dMap1을 다시 내림차순 정렬하여 오름차순으로 정렬된 NavigableMap
		Set<Entry<Integer, String>> aMapSet = aMap.entrySet();
		
		for(Entry<Integer, String> e : aMapSet) {
			System.out.println("점수 = " + e.getKey() + ", 이름 = " + e.getValue());
		}
		System.out.println();
		
		System.out.print("제일 낮은 객체부터 꺼내오고 제거한 순서 : ");
		while(!tmap.isEmpty()) { // 비어있지 않는 동안 반복
			System.out.print(tmap.pollFirstEntry()+" "); // 제일 낮은 Entry객체를 꺼내오고 tmap 컬렉션에서 제거
		} // while문 종료
		System.out.println();
		
		System.out.print("제일 높은 객체부터 꺼내오고 제거한 순서 : ");
		while(!tmap.isEmpty()) { // 비어있지 않는 동안 반복
			System.out.print(tmap.pollLastEntry()+" "); // 제일 높은 Entry객체를 꺼내오고 tmap 컬렉션에서 제거
		} // while문 종료
		System.out.println();
		
		System.out.println("-----------범위 검색-----------");
		
		TreeMap<String, Integer> tmap2 = new TreeMap<String, Integer>();		
		tmap2.put("banana", 1);
		tmap2.put("cherry", 3);
		tmap2.put("apple", 5);
		tmap2.put("black", 10);
		tmap2.put("school", 8);
		tmap2.put("door", 6);
		tmap2.put("elememt", 4);
		
		System.out.println("-----------b~e 사이의 단어 검색-----------");
		// 시작객체 "b" <= 찾는 객체  < 끝객체"e"(★★주의 단, 끝객체 제외)
		NavigableMap<String, Integer> map = tmap2.subMap("b", true, "e", true);
		Set<Entry<String, Integer>>sMap = map.entrySet();
		
		for(Entry<String, Integer> e : sMap) {
			//System.out.println(e.getKey() + ", " + e.getValue());
			System.out.println(e); // 변수명만 사용해도됨
		} // for문 종료
		
	}// 메인문

}// 클래스문
/*******************************************************************************************************/