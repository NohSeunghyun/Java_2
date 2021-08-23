package set.treesetstring;

import java.util.Comparator;
import java.util.TreeSet;

class ComparatorString implements Comparator<String>{

	@Override // String클래스에는 유니코드로 비교하여 오름차순정렬시키는 compareTo()가 재정의 되어 있다.
	public int compare(String o1, String o2) {
//		return o1.compareTo(o2); // 오름차순정렬
		return (o1.compareTo(o2))*-1; // 내림차순정렬
	}
	
}

public class ComparatorStringTest {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("bbb"); // compareTo()호출 오름차순 정렬
		set.add("aaa");
		set.add("ccc");
		
		System.out.println(set);
		
		
		set = new TreeSet<String>(new ComparatorString());
		
		set.add("bbb");
		set.add("aaa");
		set.add("ccc");
		
		System.out.println(set);
		
	}//메인문

}//클래스문
/*******************************************************************************************************/