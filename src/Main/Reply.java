package Main;

import java.time.LocalDateTime;

public class Reply {

	// 필드
	private String content; // 댓글내용
	private String writer; // 댓글 작성자
	private LocalDateTime date; // 날짜
	private int good; // 추천수
	private int bad; // 비추천수
	private int report; // 신고누적횟수
	private int index; // 글 번호연동 인덱스
	
	// 생성자
	public Reply() {}

	public Reply(String content, String writer, LocalDateTime date, int good, int bad, int report, int index) {
		super();
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.good = good;
		this.bad = bad;
		this.report = report;
		this.index = index;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	
	
	
	
}
