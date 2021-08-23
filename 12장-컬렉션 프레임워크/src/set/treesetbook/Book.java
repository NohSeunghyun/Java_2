package set.treesetbook;

import java.util.Comparator;

// 부모는 1개만 상속, 인터페이스는 여러 개 구현 가능
public class Book implements Comparable<Book>, Comparator<Book>{
	// private 멤버변수
	private String bookname;
	private int bookprice;
	
	public Book(String bookname, int bookprice) {
		super();
		this.bookname = bookname;
		this.bookprice = bookprice;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the bookname
	 */
	public final String getBookname() {
		return bookname;
	}

	/**
	 * @return the bookprice
	 */
	public final int getBookprice() {
		return bookprice;
	}

	@Override
	public int compareTo(Book o) {
		return this.bookname.compareTo(o.bookname);
	}

	@Override
	public String toString() {
		return "Book [bookname=" + bookname + ", bookprice=" + bookprice + "]";
	}

	@Override // 내림차순정렬
	public int compare(Book o1, Book o2) {
		return o1.bookname.compareTo(o2.bookname)*-1;
	}

}//클래스문
/*******************************************************************************************************/