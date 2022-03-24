package ������;

public class Reply {

	// �ʵ�
	private String content; // ��۳���
	private String writer; // ��� �ۼ���
	private String date; // ��¥
	private int good; // ��õ��
	private int bad; // ����õ��
	private int report; // �Ű���Ƚ��
	
	// ������
	public Reply() {}

	public Reply(String content, String writer, String date, int good, int bad, int report) {
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.good = good;
		this.bad = bad;
		this.report = report;
	}

	// �޼ҵ�
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
