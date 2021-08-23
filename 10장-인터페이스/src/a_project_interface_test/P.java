package a_project_interface_test;

interface P {
	
	int INPUT=1, SEARCH=2, EXIT=3;
	
	//1.이름,주민번호,전화번호를 저장
	void input() throws PersonSizeException;//예외처리방법2 실행하면 여기에 추가되는데. 메인클래스에 input메서드를 사용못하기때문에 메인클래스에도 추가한다.
	
	//2.주민등록번호를 기반으로 고객의 이름과 전화번호를 검색
	void search();
	
}//클래스문
/*******************************************************************************************************/