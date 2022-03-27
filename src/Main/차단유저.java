package Main;

public class 차단유저 {
	
	
	//1.필드
	private String index; //연동되는 유저 아이디 인덱스
	private String target; //차단대상
	
	
	//2.생성자
	public 차단유저() {
		super();
	}


	public 차단유저(String index, String target) {
		super();
		this.index = index;
		this.target = target;
	}
	
	
	
	//3.메소드

	public String getIndex() {
		return index;
	}


	public void setIndex(String index) {
		this.index = index;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}
	
	
	
	
}
