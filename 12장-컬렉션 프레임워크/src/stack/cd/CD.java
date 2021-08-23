package stack.cd;

public class CD {
	
	String cdTitle;

	public CD(String cdTitle) {
		super();
		this.cdTitle = cdTitle;
	}

	public String getCdTitle() {
		return cdTitle;
	}
	
	/*
	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}
	*/ // 값변경 불가하도록 setter 주석처리
	

	@Override
	public String toString() {
		return "cdTitle : " + cdTitle ;
	}
	
}//클래스문
/*******************************************************************************************************/