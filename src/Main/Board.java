package Main;

import java.util.ArrayList;

public class Board {

	// 필드
	private String title; // 게시물 제목
	private String content; // 게시물 내용
	private String writer; // 작성자
	private String date; // 날짜
	private int view; // 조회수
	private String category; // 카테고리
	private int good; // 추천수
	private int bad; // 비추천수
	private ArrayList<Reply> reply; // 댓글클래스
	private int report;  // 신고누적횟수
	
	// 생성자
	public Board() {}
	
	public Board(String title, String content, String writer, String date, int view, String category, int good, int bad,
			ArrayList<Reply> reply, int report) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.category = category;
		this.good = good;
		this.bad = bad;
		this.reply = reply;
		this.report = report;
	}

	// 메소드
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public ArrayList<Reply> getReply() {
		return reply;
	}

	public void setReply(ArrayList<Reply> reply) {
		this.reply = reply;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}
	
	
	
	
	
	
	
}
