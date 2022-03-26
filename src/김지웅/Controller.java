package 김지웅;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;






public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	public static String[] 카테고리 = {"시사","야구"};
	
	public static int 회원가입아이디(String id) {
		String pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$";
		if(!Pattern.matches(pattern, id)){
			  return 1; // 아이디에 특수문자 or 공백이 들어감
			}
		if(id.length()<4 || id.length()>13) {
			return 2; // 아이디길이가 4~12자리가 아님
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				return 3; // 아이디 중복
			}
		}
		return 4; // 정상적인 아이디
	}
	
	public static int 회원가입비밀번호(String pw, String pwcheck) {
		
		if(pw.contains(" ")) {
			  return 1; // 비밀번호에 공백 포함
			}
		if(!pw.equals(pwcheck)) {
			return 2; // 비밀번호 확인 틀림
		}
		return 3; // 정상적인 비밀번호
	}
	
	public static boolean 회원가입(String id, String pw, String pwcheck, String name, String email, String phone) {
		for(Acount temp : acountlist) {
			if(temp.getPhone().equals(phone)) {
				return false; // 해당 전화번호로 가입한 회원이 있음
			}
		}
		Acount temp = new Acount(id, pw, name, email, phone, 0, null, 0, null );
		acountlist.add(temp);
		회원저장();
		return true; // 회원가입 성공
		
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
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, null, 0,boardtnum));
		boardtnum++;
		/* 파일처리 메소드 처리 성공시 true반환
		 * 
		 */		
		return true;// 임시반환
	}
	
	public static boolean 글상세보기(String id, int index) {// 인덱스일치하는 번호 찾은후 글이 있음 반환
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getBlockuser()!=null ) { // 로그인한 아이디의 차단유저목록이 있으면
				for(Board temp2 : boardlist) {
					if(temp2.getIndex()==index && temp.getBlockuser().contains(temp2.getWriter())) {
						// 해당 인덱스의 글 작성자가 차단유저목록에 포함되어 있으면
						return false; // 해당 글 볼러오기 실패
					}
				}
			}
		}
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
	
	public static void 글수정(int index, String title, String content) {
		boardlist.get(index).setTitle(title);
		boardlist.get(index).setContent(content);
		게시물저장();
	}
	
	public static void 글삭제(String id, String pw, int index) {
		for(Board temp2 : boardlist) {
			if(temp2.getIndex()==index) {
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
	
	public static ArrayList<Board> 검색(String serch) {
		ArrayList<Board> 검색결과 = new ArrayList<Board>();
		검색결과.clear();
		for(Board temp : boardlist) {
			if(temp.getTitle().indexOf(serch)!=-1) {
				Board temp2 = new Board(temp.getTitle(), temp.getContent(), temp.getWriter(), 
						temp.getDate(), temp.getView(), temp.getCategory(), temp.getGood(), temp.getBad(), 
						temp.getReplylist(), temp.getReport(), temp.getIndex());
				검색결과.add(temp2);
				return 검색결과; // 검색결과 출력
			}
		}
		return 검색결과;
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
	public static ArrayList<Acount> 포인트랭킹() {
		ArrayList<Acount> rank = new ArrayList<>();
		rank.addAll(acountlist);
		
		Collections.sort(rank, new Acountsort());
		
		return rank;
		

	}
	
	public static boolean 신고(String id,int index) {
		
		for(Board temp : boardlist) {
			if(temp.getIndex()==index && temp.getWriter().equals(id)) {
				return false; // 신고한 아이디가 자신의 아이디
			}
		}
		ArrayList<String> reportid = new ArrayList<>();
		for(Board temp : boardlist) {
			if(temp.getIndex()==index) {
				
				temp.setReport(temp.getReport()+1);
				reportid.add(temp.getWriter()) ;
				break;
			}
		}
		for(int i=0; i<acountlist.size(); i++) {
			if(acountlist.get(i).getId().equals(id)) {
				if(acountlist.get(i).getBlockuser()==null) {
					acountlist.get(i).setBlockuser(reportid);
				}
				else {
					acountlist.get(i).getBlockuser().addAll(acountlist.get(i).getBlockuser().size() ,reportid);
				}
				break;
			}
		}
		return true;
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
