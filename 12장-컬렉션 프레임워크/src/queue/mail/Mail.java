package queue.mail;

public class Mail {

	String toSome; // 사람 이름
	String MailTitle; // 메일 제목
	
	public Mail(String toSome, String mailTitle) {
		super();
		this.toSome = toSome;
		MailTitle = mailTitle;
	}

	public String getToSome() {
		return toSome;
	}

	public void setToSome(String toSome) {
		this.toSome = toSome;
	}

	public String getMailTitle() {
		return MailTitle;
	}

	public void setMailTitle(String mailTitle) {
		MailTitle = mailTitle;
	}

	@Override
	public String toString() {
		return "수신인 : " + toSome + " - 메일 제목 : " + MailTitle;
	}
	
}//클래스문
/*******************************************************************************************************/