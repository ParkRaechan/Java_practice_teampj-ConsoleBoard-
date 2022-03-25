package 한요한;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	public static String[] 카테고리 = {"시사","야구"}; 
	
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
		Acount temp = new Acount(id, pw, name, email, phone, 0, templist, 0, "" );
		acountlist.add(temp);
		return 4; // 회원가입 성공
		
	}
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
	///////////////////////////////////////////////////////////////////////////
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
		//제목, 내용, 작성자, 날짜, 조회수, 카테고리, 추천수, 비추천수, 댓글클래스, 신고누적횟수 객체화후list의 저장
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, 0, boardtnum));
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
				temp.setView(temp.getView() + 1);
				return true;
			}
		}
		return false;	
	}
	public static void 댓글작성(String con, int index, String id) {
		LocalDateTime date = LocalDateTime.now();
		for(Board temp : Controller.boardlist) {
			if(temp.getIndex() == index) { // 같은인덱스번호의 글이있으면
				Reply e = new Reply(con, id, date,0,0,0,index);
				temp.getReply().add(e);
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
			if(temp.getWriter().equals(id)) {
				for(Acount temp2 : acountlist) {
					if(temp2.getPw().equals(pw)) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	public static void 글수정(String id,String pw, int boardnum, String title, String content) {
		for(Board temp : boardlist) {
			if(temp.getWriter().equals(id)) {
				
			}
		}
	}
	public static void 추천비추(boolean 여부, int index, String id) {
		boolean pass = true; // 아이디 중복여부 체크
		for(Board temp : boardlist) { 
			for(String s : temp.getP()) { // 해당글 p리스트안에
				if(s.equals(id)) {		 // 아이디값이 일치하면
					pass = false; 		//추천 비추 못누르게
				}
			}
		}
		if(pass) { // 중복된아이디가 아니라면
			for(Board temp : boardlist) {
				if(여부) {
					if(temp.getIndex() == index) {
						temp.setGood(temp.getGood() + 1);//추천 개수늘리기
						temp.getP().add(id);
						break;
					}		
				}else {
					if(temp.getIndex() == index) {
						temp.setBad(temp.getBad() + 1);//비추 개수늘리기
						temp.getP().add(id);
						break;
					}		
				}
			}	
		}	
	}
//	public static void 글삭제(String id, String pw, int boardnum) {
//		if(boardlist.get(boardnum).getWriter().equals(id)) {
//			for(Acount temp : acountlist) {
//				if(temp.getPw().equals(pw) && temp.getId().equals(id)) {
//					boardlist.remove(boardnum);
//					for(Board temp2 : boardlist) {
//						temp2.getReplylist().remove(boardnum);
//					}
//					게시물저장();
//					댓글저장();
//				}
//			}
//		}
//	}
	public static void 검색() {
		
	}
	public static void 인기글() {
		
	}
	public static boolean 댓글수정(int 글인덱스, int 댓글인덱스, String 댓글수정, String id) {
		// 글인덱스 / 인덱스/ 수정할 내용 / id 받아와서 
		// 해당글내에 댓글리스트중 댓글인덱스 비교한후 아이디 체크 후 수정
		for(Board temp : boardlist) {
			if(temp.getIndex() == 글인덱스) { // 해당글 찾기
				if(temp.getReply().get(댓글인덱스).getWriter().equals(id)) {// 해당글의 원하는 댓글인덱스의 작성자가 id랑일치했을때
					// 내용 변경
					temp.getReply().get(댓글인덱스).setContent(댓글수정);
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
						if(temp.getReply().get(댓글인덱스).getWriter().equals(id)) {// 해당글의 원하는 댓글인덱스의 작성자가 id랑일치했을때
							// 내용 변경
							temp.getReply().remove(댓글인덱스);
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
	public static void 신고(int index, String id) {
		//해당글의 인덱스를 받아오고 id 받아오고 차단
		for(Board temp : boardlist) {
			if(temp.getIndex() == index) {
				for(Acount temp2 : acountlist) {
					if(temp2.getId().equals(id)) {
						temp2.getBlockuser().add(temp.getWriter());
					}
				}
			}
		}
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
	
}