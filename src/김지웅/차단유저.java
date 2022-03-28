package 김지웅;

public class 차단유저 {
	
	
	//1.필드
	private String id; //연동되는 유저 아이디
	private String target; //차단대상
	
	
	//2.생성자
	public 차단유저() {
		super();
	}


	public 차단유저(String id, String target) {
		super();
		this.id = id;
		this.target = target;
	}





	//3.메소드

	

	public String getTarget() {
		return target;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setTarget(String target) {
		this.target = target;
	}
	
	
	
	
}
