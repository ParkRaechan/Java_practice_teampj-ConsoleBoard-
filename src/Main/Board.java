package Main;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Board {

	// 필드
	private String title; // 게시물 제목
	private String content; // 게시물 내용
	private String writer; // 작성자
	private LocalDateTime date; // 날짜
	private int view; // 조회수
	private String category; // 카테고리
	private int good; // 추천수
	private int bad; // 비추천수
	private ArrayList<Reply> replylist = new ArrayList<Reply>(); // 댓글클래스
	private int report;  // 신고누적횟수
	private int index; // 번호
	private ArrayList<String> p = new ArrayList<>();//아이디값 저장
	
	
	// 생성자
	public Board() {}//깡통생성자
	
	public Board(String title, String content, String writer, LocalDateTime date, int view, String category, int good
			, int bad, int report, int index) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.category = category;
		this.good = good;
		this.bad = bad;
		this.report = report;
		this.index = index; 
	}//댓글제외생성자
	public Board(String title, String content, String writer, LocalDateTime date, int view, String category, int good,
			int bad, ArrayList<Reply> replylist, int report, int index) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.category = category;
		this.good = good;
		this.bad = bad;
		this.replylist = replylist;
		this.report = report;
		this.index = index;
	}//꽉꽉생성자

	// 메소드
		//getter,setter메소드
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public ArrayList<Reply> getReplylist() {
		return replylist;
	}

	public void setReplylist(ArrayList<Reply> replylist) {
		this.replylist = replylist;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
	public ArrayList<String> getP() {
		return p;
	}

	public void setP(ArrayList<String> p) {
		this.p = p;
	}
	
	
	
	
	
}
