/* HashSet과 TreeSet 모두 중복을 허용하지 않고 순서가 없는 컬렉션이다.
 * 공통점 : Set이므로 모두 중복을 허용하지 않고 순서가 없는 컬렉션이다.
 * 
 * (1).구현방식 -HashSet : 해싱을 이용하여 구현
 *         -TreeSet : 이진탐색트리를 이용하여 구현
 *         
 * (2).속도비교 -HashSet > TreeSet
 *         -해싱이 이진탐색트리보다 빠르다.
 *         (HashSet은 Set에서 가장 빠른 데이터 접근 속도를 가지고 있다.)
 *         
 * (3).정렬기능 -HashSet < TreeSet
 *         -이진탐색트리를 이용했기 때문에 데이터 정렬이 가능(Comparable 이용)
 * 
 * 이지스교제 428p~
 *     TreeSet : 이진트리를 기반으로 검색 기능을 강화 (예)검색과 관련된 메서드들 : first()...
 *               저장과 동시에 '오름차순'으로 정렬 (예) 숫자(Integer, Double 등) 타입일 경우 : 값으로 정렬
 *                                          문자열(String) 타입일 경우 : 유니코드로 정렬
 *                                             
 *               그러나, 우리가 만든 사용자 정의 클래스는 정렬이 안되므로 [객체(데이터)를 정렬된 순서로 저장하기 위해]   
 *               1. 'java.lang.Comparable<T> 인터페이스'를 구현해야 함   
 *               2. 추상메서드인 compareTo()메서드를 재정의    
 *               
 *               TreeSet의 add()호출되면 compareTo() 자동호출되어
 *               크기 비교하면서 중복여부를 알 수 있기 때문에
 *               (크기 비교시 값이 같으면 0을 반환하여 같은 객체가 이미 존재한다고 간주하여 -> 추가안됨)
 *               hashCode()와 equals()메서들 재정의 안해줌.
 *                     
 * TreeSet 정리 : 자료의 중복을 허용하지 않으면서 출력 결과를 정렬하는 클래스      
 *               Tree~로 시작하는 클래스들은 객체를 추가한 후 결과를 출력하면 결과값이 정렬됨    
 * ----------------------------------------------------------------------------------------------
 * TreeSet으로 관리하는 객체와 TreeMap에서 관리하는 엔트리 키는값은 저장과 동시에 자동 오름차순 정렬
 */
package set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> stree=new TreeSet<Integer>();
		
		/*
		 * Integer는 Comparable<T>인터페이스를 구현한 클래스이므로
		 * add()할 때마다 '재정의된 compareTo()' 자동호출되어
		 * -> 크기 비교하면서 오름정렬시켜 저장
		 */
		
		stree.add(new Integer(87));
		stree.add(95); // 자동 boxing
		stree.add(78); // 자동 boxing
		stree.add(98); // 자동 boxing
		stree.add(80); // 자동 boxing
		stree.add(83); // 자동 boxing
		
		stree.add(78); // Set계열은 중복 허용하지 않음
		
		System.out.println("저장된 객체 수:"+stree.size());
		
		/**********************************************************/
		System.out.println("**검색과 관련된 메서드들**");
		System.out.println("가장 낮은 객체 리턴(=가장 낮은 점수):"+stree.first()); // 78
		System.out.println("가장 높은 객체 리턴(=가장 높은 점수):"+stree.last()); // 98
		// System.out.println("ABC".toLowerCase());//"abc"
		System.out.println("주어진 객체 95보다 바로 아래 객체를 리턴:"+stree.lower(95)); // 87
		System.out.println("주어진 객체 95보다 바로 위 객체를 리턴:"+stree.higher(95)); // 98
		
		System.out.println("주어진 객체96와 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 아래 객체를 리턴:"+stree.floor(96));
		System.out.println("주어진 객체94와 같은 객체가 있으면 리턴.만약 없으면 주어진 객체의 바로 위 객체를 리턴:"+stree.ceiling(94));
		
		
		System.out.println("-----------범위검색과 관련된 메서드들-----------------");
		/*
		 * SortedSet<E> subSet(E fromElement, E toElement) 
		 *                     시작 ~ 끝 이전까지의 부분집합 반환
         * NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
                                                              시작 (포함여부 선택 가능) ~ 끝 (포함여부 선택 가능) 까지의 부분 집합 반환
		 */
		
		SortedSet<Integer> streesub1=stree.subSet(78, 95);
		System.out.print("78<= 찾는 점수 < 95 : ");
		for(Integer i:streesub1) {
			System.out.print(i+" "); // 78 87
		}
	    System.out.println(); // 커서를 아래로
	    
		// 78 <= 찾는 점수 <= 95
		NavigableSet<Integer> streesub2=stree.subSet(78, true, 95, true);
		System.out.print("78 <= 찾는 점수 <= 95 : ");
		for(Integer i:streesub2) {
			System.out.print(i+" "); // 78 87 95
		}
		System.out.println("------------------------------------------------------------------");		
		
		
		System.out.println("**오름차순 Iterator를 리턴**");
		Iterator<Integer> itr=stree.iterator(); // 오름차순 반복자
		while(itr.hasNext()) {
			System.out.print(itr.next()+" "); // Integer(87) -> 자동 unboxing(int 87)되어 출력
		}
		System.out.println(); // 커서를 아래로
		
		System.out.println("**내림차순 Iterator를 리턴**");
		Iterator<Integer> ditr=stree.descendingIterator(); // 내림차순 반복자
		while(ditr.hasNext()) {
			System.out.print(ditr.next()+" "); // Integer(87) -> 자동 unboxing(int 87)되어 출력
		}
		System.out.println(); // 커서를 아래로
		
		/***********************************************************/
		System.out.println("**내림차순으로 정렬된 NavigableSet를 리턴**");
		NavigableSet<Integer> dSet=stree.descendingSet();
		
		for(Integer score:dSet) {
			System.out.print(score+" ");
		}
		System.out.println(); // 커서를 아래로
		
		Iterator<Integer> dSetitr=dSet.iterator();
		while(dSetitr.hasNext()) {
			System.out.print(dSetitr.next()+" ");
		}
		System.out.println(); // 커서를 아래로
		
		System.out.println("**내림차순으로 정렬된 NavigableSet을 descendingSet()으로 한번 더 호출하면**");
		NavigableSet<Integer> aSet=dSet.descendingSet(); // 내림차순 정렬 한번 더 하면 -> 오름차순 정렬됨
		
		for(Integer score:aSet) { // for(int score:aSet) {
			System.out.print(score+" ");
		}
		System.out.println();//커서를 아래로
		
		Iterator<Integer> aSetitr=aSet.iterator();
		while(aSetitr.hasNext()) {
			System.out.print(aSetitr.next()+" ");
		}
		System.out.println(); // 커서를 아래로
		
		
		//System.out.print("제일 낮은 객체부터 꺼내오고 제거한 순서 : ");
		System.out.print("제일 높은 객체부터 꺼내오고 제거한 순서 : ");
		while(!stree.isEmpty()) { // 비어있지 않는 동안 반복
			//System.out.print(stree.pollFirst()+" "); // 제일 낮은 객체를 꺼내오고 stree 컬렉션에서 제거함
			System.out.print(stree.pollLast()+" "); // 제일 낮은 객체를 꺼내오고 stree 컬렉션에서 제거함
		}
		System.out.println(); // 커서를 아래로
		
		
		/*************************************************************************/
		System.out.println("------------- 범위 검색 --------------------");
		
		TreeSet<String> stree2 = new TreeSet<String>();
		
		stree2.add("banana");
		stree2.add("cherry");
		stree2.add("apple");
		stree2.add("black");
		stree2.add("school");
		stree2.add("door");
		stree2.add("elememt");
		
		System.out.println("** b~e 사이의 단어 검색 **");
		// 시작객체 "b" <= 찾는 객체  < 끝객체"e"(★★주의 단, 끝객체 제외)
		NavigableSet<String> set=stree2.subSet("b", true, "e", true);
		
		for(String word:set) {
			System.out.print(word+" ");
		}
		System.out.println();
		
		System.out.print(" b보다 작은 객체 반환 :");
		SortedSet<String> set2 = stree2.headSet("b"); // 지정된 객체보다 작은 값의 객체들을 반환
		
		for(String word:set2) {
			System.out.println(word+" ");
		}
		System.out.println();
		
		System.out.print(" b보다 큰 객체 반환 :");
		SortedSet<String> set3 = stree2.headSet("b"); // 지정된 객체보다 작은 값의 객체들을 반환
		
		for(String word:set3) {
			System.out.println(word+" ");
		}
		System.out.println();
		/*
		 * 주의해야 할 점은, subSet 메소드의 내부에서, 
		 * 원본 set 의 데이터들을 복사해서 새로 부분 집합을 구성하는 것이 아니라, 
		 * 원본 데이터들을 그대로 두고, 원본 set 과 SubSet 이 같이 바라보고 있는 상태에서, 
		 * subSet은 해당 범위만 바라볼 수 있는 형태로 되어 있다는 것이다. 
		 * 이에 따라, subSet 메소드 후에, 원본 Set 이나 subSet 에 변경이 일어나면 (추가, 삭제 등) 
		 * 원본 Set, SubSet 모두 변경이 동시에 일어남. 
		 * (단, SubSet 은 해당 범위만 보여짐)
		 */
		stree2.removeAll(stree2);
		
		System.out.println("총객체수:"+stree2.size());
		
	}//메인문

}//클래스문
/*******************************************************************************************************/