package 한요한;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	
	public static void 회원가입() {
		
	}
	public static void 로그인() {
		
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
		return false;
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
	public static void 글수정() {
		
	}
	public static void 글삭제() {
		
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
	
}