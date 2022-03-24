package 김지웅;

public class Reply {

	// 필드
	private String content; // 댓글내용
	private String writer; // 댓글 작성자
	private String date; // 날짜
	private int good; // 추천수
	private int bad; // 비추천수
	private int report; // 신고누적횟수
	
	// 생성자
	public Reply() {}

	public Reply(String content, String writer, String date, int good, int bad, int report) {
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.good = good;
		this.bad = bad;
		this.report = report;
	}

	// 메소드
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}
	
	
	
	
}
