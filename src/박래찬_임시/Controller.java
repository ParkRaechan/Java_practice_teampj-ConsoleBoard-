package 박래찬_임시;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Controller {

	static LocalDateTime yourDate;
	static String yourCategory;
	static int yourStoryNum;
	
	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	public static String[] 카테고리 = {"시사","야구"}; 
	public static ArrayList<차단유저> blockUser = new ArrayList<>();

	
	public static int 회원가입(String id, String pw, String pwcheck, String name, String email, String phone) {
		if(id.length()<4 || id.length()>13) {
			return 5; // 아이디길이가 4~12자리가 아님
		}
		if(!pw.equals(pwcheck)) {
			return 1; // 비밀번호 확인 틀림
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				return 2; // 아이디 중복
			}
			else {
				if(temp.getPhone().equals(phone)) {
					return 3; // 해당 전화번호로 가입한 회원이 있음
				}
			}
		}
		ArrayList<String> templist = new ArrayList<>();
		Acount temp = new Acount(id, pw, name, email, phone, 0, templist, 0, null );
		acountlist.add(temp);
		return 4; // 회원가입 성공
		
	}
	///////////////////////////////////회원파일 처리 시작/////////////////////////////////////////////
	static void 회원파일처리(String id, String pw, String name, String email, String phone, int point, ArrayList<String> blockuser,
			int report, String friend) throws IOException{
		//회원저장
			//파일에 [아이디,비번,이름,이메일,폰번]형식으로 저장
		FileOutputStream out_a = new FileOutputStream("D:/java/회원test.txt",true);
		String storage_a = id+","+pw+","+name+","+email+","+phone+","+Integer.toString(point)+","+blockuser+","+Integer.toString(report)+","+friend+"\n";		
		out_a.write(storage_a.getBytes());		

	}//회원e
	
	
	public static boolean 회원출력() throws IOException {
		
		FileInputStream input_a = new FileInputStream("D:/java/회원test.txt");
		byte[] bytes_a = new byte[1024]; // 바이트배열선
		input_a.read(bytes_a);				// 바이트 읽기
		String str_a = new String(bytes_a); // 일어온거 저장
		String[] 회원1 = str_a.split("\n"); //1회글마다 자르기
		for(int t = 0; t < 회원1.length-1 ; t++) {	// 회당매출길이만큼 반복
			if(회원1[t] != null && !회원1[t].equals("") ) {
				String[] 회원요소 = 회원1[t].split(",");
				String a_a = 회원요소[0]; // 회원 아이디
				String b_a = 회원요소[1]; // 회원 비번
				String c_a = 회원요소[2]; // 회원 이름
				String d_a = 회원요소[3]; // 회원 이메일
				String e_a = 회원요소[4]; // 회원 폰번
				String f_a = 회원요소[5]; // 회원 포인트
								
				
				ArrayList<String> g_a = null; // 회원 차단유저
				//차단유저 목록 -> 파일에 어떻게 넣어서 어떻게 뺄 것인가,,,,,
				String h_a = 회원요소[7]; // 회원 신고
				String i_a = 회원요소[8]; // 회원 친구

				Acount o_a = new Acount(a_a,b_a,c_a,d_a,e_a,Integer.parseInt(f_a),g_a,Integer.parseInt(h_a),i_a);
				
				//배열에 파일 요소값 저장
				Controller.acountlist.add(o_a);
			
			}
		}
		return true; //일별매출 리턴
	}
	
	
	
	
	
	
	///////////////////////////////////회원파일 처리 끝/////////////////////////////////////////////

	public static int 로그인(String id, String pw) {
		boolean idcheck = false;
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				idcheck = true;
			}
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getPw().equals(pw)) {
				return 1; // 로그인 성공
			}
		}
		if(idcheck==false) {
			return 2; // 가입된 아이디가 없음
		}
		return 3; // 비밀번호 틀림
	}

	
	public static boolean 글쓰기(String id, String title, String content, String category) {//요한
		//id, 제목, 내용, 작성자id, 카테고리 받아오기
		LocalDateTime date= LocalDateTime.now();// 현재날짜생성
		//번호 불러오기
		for(Board temp : boardlist) {
			if(boardtnum > temp.getIndex()) {
				boardtnum = temp.getIndex() + 1;
			}else {
				boardtnum++;
			}
		}
		yourDate = date;
		yourCategory = category;
		yourStoryNum = boardtnum;
		//제목, 내용, 작성자, 날짜, 조회수, 카테고리, 추천수, 비추천수, 댓글클래스, 신고누적횟수 객체화후list의 저장
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, 0, boardtnum));
		boardtnum++;
		/* 파일처리 메소드 처리 성공시 true반환
		 * 
		 */		
		return true;// 임시반환
	}
	public static boolean 글상세보기(int index) {// 인덱스일치하는 번호 찾은후 글이 있음 반환
		//index 받아와서 해당글찾기
		//인덱스번호
		for(Board temp : boardlist) {
			if(temp.getIndex() == index) {
				//찾은 인덱스 번호 있다고 true 반환
				return true;
			}
		}
		return false;	
	}
	
	////////////////////////////////////글쓰기 파일처리 시작////////////////////////////////////////////////////

	static void 게시물파일처리(String title,String content,String writer,LocalDateTime date,int view, String category,int good,int bad,int report,int index) throws IOException{
		//게시물저장
			//파일에 [제목,내용,글쓴이,월,일,시간,조회수,카테고리,추천,비추천,신고누적수]형식으로 저장
		FileOutputStream out = new FileOutputStream("D:/java/게시물test.txt",true);
		String storage = title+","+content+","+writer+","+date.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"))+","+Integer.toString(view)+","+category+","+Integer.toString(good)+","+Integer.toString(bad)+","+Integer.toString(report)+","+Integer.toString(index)+"\n";
		out.write(storage.getBytes());		
	}//글확인e
	
	
	public static boolean 게시물출력() throws IOException {
		
		FileInputStream input = new FileInputStream("D:/java/게시물test.txt");
		byte[] bytes = new byte[1024]; // 바이트배열선
		input.read(bytes);				// 바이트 읽기
		String str = new String(bytes); // 일어온거 저장
		String[] 글1 = str.split("\n"); //1회글마다 자르기
		for(int t = 0; t < 글1.length-1 ; t++) {	// 회당매출길이만큼 반복
			//String lastCharacter = 글1[t].substring(글1[t].length() - 1);
			if(글1[t] != null && !글1[t].equals("") ) {
				String[] 게시물요소 = 글1[t].split(",");
				String a = 게시물요소[0]; // 게시물 제목
				String b = 게시물요소[1]; // 게시물 내용
				String c = 게시물요소[2]; // 작성자
				String d = 게시물요소[3]; // 날짜

				
				// D(String ) -> LocaldateTime 형변환				
				DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				LocalDateTime dd = LocalDateTime.parse( d , formatter);
				
				String e = 게시물요소[4]; // 조회수
				String f = 게시물요소[5]; // 카테고리
				String g = 게시물요소[6]; // 추천수
				String h = 게시물요소[7]; // 비추천수
				String i = 게시물요소[8];  // 신고누적횟수
				String j = 게시물요소[9]; //글번호
				Board o = new Board(a,b,c,dd,Integer.parseInt(e),f,Integer.parseInt(g),Integer.parseInt(h),Integer.parseInt(i),Integer.parseInt(j));
				
				//배열에 파일 요소값 저장
				Controller.boardlist.add(o);
			
			}
		}
		return true; //일별매출 리턴
	}
	////////////////////////////////////글쓰기 파일처리 끝////////////////////////////////////////////////////
	
	
	public static void 댓글작성(String con, int index, String id) {
		LocalDateTime date = LocalDateTime.now();
		for(Board temp : Controller.boardlist) {
			if(temp.getIndex() == index) { // 같은인덱스번호의 글이있으면
				Reply e = new Reply(con, id, date,0,0,0,index);
				temp.getReplylist().add(e);
				break;
			}
		}
	}
	public static boolean 글수정아이디체크(String id) {
		for(Board temp : boardlist) {
			if(temp.getWriter().equals(id)) {return true;}
		}
		return false;
	}
	public static boolean 글수정비밀번호체크(String id,String pw) {
		for(Board temp : boardlist) {
				for(Acount temp2 : acountlist) {
					if(temp.getWriter().equals(id) && temp2.getPw().equals(pw)) {
						return true;
					}
				}
		}
		return false;
	}
	public static void 글수정(int boardnum, String title, String content) {
		boardlist.get(boardnum).setTitle(title);
		boardlist.get(boardnum).setContent(content);
		게시물저장();
	}


	public static void 글삭제(String id, String pw, int boardnum) {
		for(Board temp2 : boardlist) {
			if(temp2.getIndex()==boardnum) {
				for(Acount temp : acountlist) {
					if(temp.getPw().equals(pw) && temp.getId().equals(id)) {
						boardlist.remove(temp2);
						
						게시물저장();
						댓글저장();
					}
				}
			}
			
		}
	}
	
	
	public static void 검색() {
		
	}
	public static void 인기글() {
		
	}
	public static boolean 댓글수정(int 글인덱스, int 댓글인덱스, String 댓글수정, String id) {
		// 글인덱스 / 인덱스/ 수정할 내용 / id 받아와서 
		// 해당글내에 댓글리스트중 댓글인덱스 비교한후 아이디 체크 후 수정
		for(Board temp : boardlist) {
			if(temp.getIndex() == 글인덱스) { // 해당글 찾기
				if(temp.getReplylist().get(댓글인덱스).getWriter().equals(id)) {// 해당글의 원하는 댓글인덱스의 작성자가 id랑일치했을때
					// 내용 변경
					temp.getReplylist().get(댓글인덱스).setContent(댓글수정);
					return true;
				}		
			}// 게시물 글찾기 if end
		}
		return false;
	}
	public static boolean 댓글삭제(int 글인덱스, int 댓글인덱스, String id) {
		// 글인덱스 / 인덱스/ 수정할 내용 / id 받아와서 
				// 해당글내에 댓글리스트중 댓글인덱스 비교한후 아이디 체크 후 수정
				for(Board temp : boardlist) {
					if(temp.getIndex() == 글인덱스) { // 해당글 찾기
						if(temp.getReplylist().get(댓글인덱스).getWriter().equals(id)) {// 해당글의 원하는 댓글인덱스의 작성자가 id랑일치했을때
							// 내용 변경
							temp.getReplylist().remove(댓글인덱스);
							return true;
						}		
					}// 게시물 글찾기 if end
				}
				return false;
		}
	public static void 복권() {
		
	}
	public static void 포인트랭킹() {
		
	}
	public static void 신고() {
		
	}
	public static void 친구추가() {
		
	}
	public static void 쪽지확인() {
		
	}
	public static void 쪽지보내기() {
		
	}
	public static void 답글달기() {
		
	}
	public static void 게시물저장() {
		
	}
	public static void 게시물불러오기() {
		
	}
	public static void 회원저장() {
		
	}
	public static void 회원불러오기() {
		
	}
	public static void 댓글저장() {
		
	}
	public static void 댓글불러오기() {
		
	}
	public static String 아이디찾기(String name, String phone, String email) {
		for(Acount temp : acountlist) {
			if(temp.getName().equals(name) && temp.getEmail().equals(email)
					&& temp.getPhone().equals(phone)) {
				return temp.getId();
			}
		}
		return "1";
	}
	public static String 비밀번호찾기(String id, String phone, String email) {
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getEmail().equals(email)
					&& temp.getPhone().equals(phone)) {
				return temp.getPw();
			}
		}
		return "1";
	}
	
	
	
	
	public static boolean 차단유저확인(String id1, String id2) {
		for(차단유저 temp : blockUser) {
			if(temp.getIndex().equals(id1)&&temp.getTarget().equals(id2)) {
				return true;
			}
		}
		return false;
	}
	
/////////////////////////////////차단유저 파일처리 시작//////////////////////////////////////////////////////////////
	
	static void 차단유저파일처리(String id, String blockuser) throws IOException{
		//회원저장
			//파일에 [아이디,비번,이름,이메일,폰번]형식으로 저장
		FileOutputStream out_u = new FileOutputStream("D:/java/차단유저test.txt",true);
		String storage_u = id+","+blockuser+"\n";	
		out_u.write(storage_u.getBytes());		

	}//차단유저e
	
	
	public static boolean 차단유저출력() throws IOException {
		
		FileInputStream input_u = new FileInputStream("D:/java/차단유저test.txt");
		byte[] bytes_u = new byte[1024]; // 바이트배열선
		input_u.read(bytes_u);				// 바이트 읽기
		String str_u= new String(bytes_u); // 일어온거 저장
		String[] 회원1 = str_u.split("\n"); //1회글마다 자르기
		for(int t = 0; t < 회원1.length-1 ; t++) {	// 회당매출길이만큼 반복
			if(회원1[t] != null && !회원1[t].equals("") ) {
				String[] 회원요소 = 회원1[t].split(",");
				String a_a = 회원요소[0]; // 회원 아이디
				String b_a = 회원요소[1]; // 회원 비번
				String c_a = 회원요소[2]; // 회원 이름
				String d_a = 회원요소[3]; // 회원 이메일
				String e_a = 회원요소[4]; // 회원 폰번
				String f_a = 회원요소[5]; // 회원 포인트
								
				
				ArrayList<String> g_a = null; // 회원 차단유저
				//차단유저 목록 -> 파일에 어떻게 넣어서 어떻게 뺄 것인가,,,,,
				String h_a = 회원요소[7]; // 회원 신고
				String i_a = 회원요소[8]; // 회원 친구

				Acount o_a = new Acount(a_a,b_a,c_a,d_a,e_a,Integer.parseInt(f_a),g_a,Integer.parseInt(h_a),i_a);
				
				//배열에 파일 요소값 저장
				Controller.acountlist.add(o_a);
			
			}
		}
		return true; //일별매출 리턴
	}
	
	
	
	
/////////////////////////////////차단유저 파일처리 끝//////////////////////////////////////////////////////////////

}