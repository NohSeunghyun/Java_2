/*
 * [set 인터페이스] index를 사용하지않으므로 순서X,중복X
 * 1. HashSet 클래스 : 저장 순서에 상관없는 출력 결과
 *                  
 * 그러나
 * 2. LinkedHashSet 클래스 : 저장 순서를 유지하는 예외적인 set클래스
 * 
 * 3. TreeSet : 이진트리를 기반으로 검색 기능을 강화  (예)검색과 관련된 메서드들 : first()...
 *              저장과 동시에 오름차순으로 정렬   (예) 숫자(Integer, Double 등) 타입일 경우 : 값으로 정렬
 *                                        문자열(String)타입일 경우 : 유니코드로 정렬
 *       그러나, 우리가 만든 사용자 정의 클래스는 정렬이 안되므로[객체(데이터)를 정렬된 순서로 저장하기 위해]
 *       1. java.lang.Comparable<T>인터페이스를 구현해야 함
 *       2. 추상메서드인 compareTo()메서드를 재정의	
 *       TreeSet 정리 : 자료의 중복을 허용하지 않으면서 출력 결과를 정렬하는 클래스
 *              Tree~로 시작하는 클래스들은 객체를 추가한 후 결과를 출력하면 결과값이 정렬됨
 *              
 *                                                       
 *                                                       
 * [★Hash~시작하는 클래스(중복을 허용하지 않을 때)에서 객체를 추가할 때 같은 객체를 판단하는 방법]
 * (예)HashSet, HashMap(키값:중복 허용하지 않음)
 * 객체를 저장(=추가)하기
 * 1. 반드시 hashCod()메서드
 *    ->리턴된 해쉬코드(정수) 비교 : 같으면 -> 2. 한번 더 같은지 확인하기 위해서 equals()메서드 호출
 *                                   ->true이면 같은 객체로 인식하여  추가하지않음
 *                                   ->false이면 다른 객체롤 인식하여 추기
 *    
 *    ->리턴된 해쉬코드(정수) 비교 : 다르면 -> 2. 다른 객체로 인식하여 추가함
 *    
 * ※해쉬코드(정수) : 객체의 주소로 만듦                                 
 * 
 * [Object]
 * - Object의 hashCode() : 객체의 주소 값으로 해쉬코드 만듦
 * - 제공받은 Object의 자식클래스(예 : String)의 hashCode() : 객체의 실제값으로 해쉬코드 만듦
 * 
 * - Object의 equals() : 객체의 주소 값을 비교
 * - 제공받은 Object의 자식클래스(예 : String)의 equals() : 객체의 실제값을 비교
 * 
 * 그러나, 우리가 만든 사용자 정의 클래스는 Object의 hashCode()와 equals()를 반드시 재정의해서 사용해야함
 * (단, Set 인터페이스를 구현한 클래스를 사용하려면 )
 * 
 * 
 * HashSet과 TreeSet 모두 중복을 허용하지 않고 순서가 없는 컬렉션이다.
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
 */

package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("여러분");
		set.add("모두");
		set.add("모두"); // set은 중복을 허용하지 않는다 : add하기잔에 중복여부를 판단할 수 있는 String클래스의 메서드 2개호출 -> 추가X
		set.add("마지막까지");
		set.add("힘내세요");
		
		
		System.out.println("총 객체수 : "+set.size());
		
		if(set.contains("모두")) { // 주어진 객체가 저장되어 있으면 true, 없으면 false
			System.out.println("\"모두\"가 존재한다.");
		}else System.out.println("'모두'가 존재하지 않는다.");
		/**Set에서 객체 얻는 방법-1 : 향상된 for문 이용, index를 사용하지 않기 때문에**/
		for(String e : set) {
			System.out.print(e+" ");
		}
		System.out.println();
		
		/**Set에서 객체 얻는 방법-2 : 반복자(=지팡이 역할)이용**/
		// Iterator<String> 저장된 객체를 한번씩 가져오는  반복자 객체를 생성하여 리턴
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		
		if(set.remove("모두"))System.out.println("'모두'를 찾아서 있으면 true->삭제");
		else System.out.println("'모두'를 찾아서 없으면 false->삭제X");
		
		set.clear();
		System.out.println("총객체수:"+set.size());
		
		
	}//메인문

}//클래스문
/*******************************************************************************************************/