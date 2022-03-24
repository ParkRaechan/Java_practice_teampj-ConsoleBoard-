package 한요한;

import java.security.PublicKey;
import java.util.Scanner;

public class main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while(true) {

			System.out.println(" -------------------------------------------------------------------------------------------");
			System.out.println("/                 *          *          *        **********      ***********               |        ");
			System.out.println("|                *          *          *         *                    *                    |        ");
			System.out.println("|               *          *          *          *                    *                    |        ");
			System.out.println("|              *          *          *           **********           *        6 6 6       |        ");
			System.out.println("|             * * *      * * *      * * *        *                    *                    |        ");
			System.out.println("|             *     *    *     *    *     *      *                    *       엔터테인먼트     |        ");
			System.out.println("|             *     *    *     *    *     *      *                    *                    |        ");
			System.out.println("|               * *        * *        * *        **********           *        커뮤니티      /        ");
			System.out.println("-------------------------------------------------------------------------------------------");
			//메뉴
			System.out.println("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기");
			int ch = scanner.nextInt();
			if(ch==1) {
				//회원가입 메소드
			}
			else if(ch==2) {
				//로그인 메소드
				//로그인 메뉴
			}
			else if(ch==3) {
				//아이디 찾기 메소드
			}
			else if(ch==4) {
				//비밀번호 찾기 메소드
			}
			else {
			 System.out.println("제시된 번호 입력 바람");	
			}
			
		}
		
	}
	
	public static void 로그인메뉴(String id) {
		while(true){
			//인기글출력
			System.out.println("1.카테고리 선택 2.놀이방 (3.회원정보 관리 4.쪽지[임시]) 5.로그아웃");
			int ch = scanner.nextInt();
			if(ch==1) {
				
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else if(ch==4) {
				
			}
			else {
				 System.out.println("제시된 번호 입력 바람");	
			}
		}	
	}
	
	public static void 카테고리메뉴(String id) {
		while(true) {
			System.out.println("1.시사 2.야구");
			int 카테고리선택 = scanner.nextInt();
			if(카테고리선택 == 1) {//시사카테고리	
					System.out.println("*** 시사 ***");
					//카테고리 글출력
					System.out.println("------------"); //구분선
					System.out.println("1. 글쓰기 2.글보기 3.뒤로가기"); int 행동선택 = scanner.nextInt();//선택입력받기
					if(행동선택 == 1) {
						System.out.println("제목: "); String title = scanner.next(); //제목 입력받기
						System.out.println("내용: "); String content = scanner.next();//내용 입력받기
						boolean pass = Controller.글쓰기(id, title, content, "시사");
						if(pass) { //성공시
						System.out.println("글작성성공");	
						}else { // 실패시
						System.out.println("글작성실패");	
						}
					}else if(행동선택 == 2) {
						System.out.println("글번호입력: "); int index = scanner.nextInt();
						boolean pass = Controller.글상세보기(index);
						if(pass) { // 글찾기 성공시
							for(Board temp : Controller.boardlist) {
								if(temp.getIndex() == index) {
									System.out.println("작성일: " + temp.getDate());
									System.out.println("번호: "+ temp.getIndex()  +" 제목: " + temp.getTitle() +" 카테고리: "+ temp.getCategory());
									System.out.println("내용: " + temp.getContent());
									System.out.println("추천수: " + temp.getGood() +" 비추: "+ temp.getBad() +" 신고수: " + temp.getReport());
									System.out.println("----댓글창-----------------------------------------------------------");
									for(Reply 댓글 : temp.getReply()) {
										System.out.println("내용: " + 댓글.getContent() +" |작성자: "+ 댓글.getWriter());
										System.out.println("추천수: " + 댓글.getGood() + " |비추: " + 댓글.getBad() + " |신고누적: " + 댓글.getReport());
										System.out.println("----------------------------------------------------------------");
									}
								}
							}// 출력 for문 end
							System.out.println("1.수정 2.삭제 3.댓글달기 4.뒤로가기"); int 선택 = scanner.nextInt();
							if(선택 == 1) {
								
							}else if(선택 == 2) {
								
							}else if(선택 == 3) {
							
							}else if(선택 == 4){ // 실패시 성공시
							}
						}//글찾기 성공 id 출력문 end
					}else if(행동선택 == 3) {
						main.로그인메뉴(id);
					}else {
						System.out.println("알수없는 행동");
					}	
			}else if(카테고리선택 == 2) {//야구카테고리
				System.out.println("*** 야구 ***");
				//카테고리 글출력
				System.out.println("------------"); //구분선
				System.out.println("1. 글쓰기 2.글보기 3.뒤로가기"); int 행동선택 = scanner.nextInt();//선택입력받기
				if(행동선택 == 1) {
					System.out.println("제목: "); String title = scanner.next(); //제목 입력받기
					System.out.println("내용: "); String content = scanner.next();//내용 입력받기
					boolean pass = Controller.글쓰기(id, title, content, "야구");
					if(pass) {
					System.out.println("글작성성공");	
					}else {
					System.out.println("글작성실패");	
					}
				}else if(행동선택 == 2) {
					
				}else if(행동선택 == 3) {
					main.로그인메뉴(id);
				}else {
					System.out.println("알수없는 행동");
				}	
			}
		}// while end
	}// 카테고리 선택 end
	
	
	
}
