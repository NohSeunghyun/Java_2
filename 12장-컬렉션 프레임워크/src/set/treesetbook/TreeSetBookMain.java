package set.treesetbook;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetBookMain {
	public static void main(String[] args) {
		System.out.println("================제목으로 오름차순 정렬된 Book================");
		TreeSet<Book> bookset = new TreeSet<Book>();
		
		bookset.add(new Book("자바", 20000));
		bookset.add(new Book("오라클", 15000));
		bookset.add(new Book("JSP", 30000));
		
		Iterator<Book> itr = bookset.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		System.out.println("================제목으로 내림차순 정렬된 Book================");
		bookset = new TreeSet<Book>(new Book());
		
		bookset.add(new Book("자바", 20000));
		bookset.add(new Book("오라클", 15000));
		bookset.add(new Book("JSP", 30000));
		
		itr = bookset.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}//메인문

}//클래스문
/*******************************************************************************************************/