package ������;

import java.util.ArrayList;

public class Acount {

	
	// �ʵ�
	private String id; // ���̵�
	private String pw; // ��й�ȣ
	private String name; // �̸�
	private String email; // �̸���
	private String phone; // ��ȭ��ȣ
	private int point; // ����Ʈ
	private ArrayList<String> blockuser = new ArrayList<>(); // �����������
	private int report; // �Ű���Ƚ��
	private String friend; // ģ��
	
	// ������
	public Acount() {}

	public Acount(String id, String pw, String name, String email, String phone, int point, ArrayList<String> blockuser,
			int report, String friend) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.point = point;
		this.blockuser = blockuser;
		this.report = report;
		this.friend = friend;
	}

	
	// �޼ҵ�
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public ArrayList<String> getBlockuser() {
		return blockuser;
	}

	public void setBlockuser(ArrayList<String> blockuser) {
		this.blockuser = blockuser;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	
	
}
