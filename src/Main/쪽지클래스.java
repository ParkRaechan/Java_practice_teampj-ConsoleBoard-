package Main;

public class 쪽지클래스 {
	//필드
	private String 보낸사람;
	private String 받는사람;	
	private String 내용;	
	private int 번호;
	
	//생성자
	public 쪽지클래스() {
		// TODO Auto-generated constructor stub
	}

	public 쪽지클래스(String 보낸사람, String 받는사람, String 내용, int 번호) {
		super();
		this.보낸사람 = 보낸사람;
		this.받는사람 = 받는사람;
		this.내용 = 내용;
		this.번호 = 번호;
	}

	public String get보낸사람() {
		return 보낸사람;
	}

	public void set보낸사람(String 보낸사람) {
		this.보낸사람 = 보낸사람;
	}

	public String get받는사람() {
		return 받는사람;
	}

	public void set받는사람(String 받는사람) {
		this.받는사람 = 받는사람;
	}

	public String get내용() {
		return 내용;
	}

	public void set내용(String 내용) {
		this.내용 = 내용;
	}

	public int get번호() {
		return 번호;
	}

	public void set번호(int 번호) {
		this.번호 = 번호;
	}
	
	//메소드
	
	
}
