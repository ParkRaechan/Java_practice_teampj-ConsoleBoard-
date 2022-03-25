package 김지웅;

import java.time.LocalDateTime;
import java.util.ArrayList;



public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	
	
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
		ArrayList<Acount> templist = new ArrayList<>();
		Acount temp = new Acount(id, pw, name, email, phone, 0, templist, 0, null );
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
	
	public static boolean 글쓰기(String id, String title, String content, String category) {//요한
		//id, 제목, 내용, 작성자id, 카테고리 받아오기
		LocalDateTime date= LocalDateTime.now();// 현재날짜생성
		//제목, 내용, 작성자, 날짜, 조회수, 카테고리, 추천수, 비추천수, 댓글클래스, 신고누적횟수 객체화후list의 저장
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, null, 0, boardtnum));
		boardtnum++;
		/* 파일처리 메소드 처리 성공시 true반환
		 * 
		 */		
		return true;// 임시반환
	}
	
	public static boolean 글상세보기(int index) {// 인덱스일치하는 번호 찾은후 글이 있음 반환
		//index 받아와서 해당글찾기
		int i = 0; //인덱스번호
		for(Board temp : boardlist) {
			if(temp.getIndex() == index) {
				//찾은 인덱스 번호 있다고 true 반환
				return true;
			}
			i++;
		}
		return false;	
	}
	
	public static void 카테고리글출력() {
		
	}
	public static void 댓글작성() {
		
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
	public static void 댓글수정() {
		
	}
	public static void 댓글삭제() {
		
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
}
