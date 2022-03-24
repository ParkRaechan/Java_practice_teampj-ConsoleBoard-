package Main;

import java.util.ArrayList;

public class Board {

	// �ʵ�
	private String title; // �Խù� ����
	private String content; // �Խù� ����
	private String writer; // �ۼ���
	private String date; // ��¥
	private int view; // ��ȸ��
	private String category; // ī�װ�
	private int good; // ��õ��
	private int bad; // ����õ��
	private ArrayList<Reply> reply; // ���Ŭ����
	private int report;  // �Ű���Ƚ��
	
	// ������
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

	// �޼ҵ�
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
