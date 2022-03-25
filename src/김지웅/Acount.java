package 김지웅;

import java.util.ArrayList;

public class Acount {

	
	// 필드
	private String id; // 아이디
	private String pw; // 비밀번호
	private String name; // 이름
	private String email; // 이메일
	private String phone; // 전화번호
	private int point; // 포인트
	private ArrayList<String> blockuser = new ArrayList<>(); // 차단유저목록
	private int report; // 신고누적횟수
	private String friend; // 친구
	
	// 생성자
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

	
	// 메소드
	
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
