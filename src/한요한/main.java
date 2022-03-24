package 한요한;

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
			if(ch==1) { //회원가입
				System.out.println("----------------회원가입 페이지----------------");
				System.out.print("아이디 입력 : "); String id = scanner.next();
				System.out.print("비밀번호 입력 : "); String pw = scanner.next();
				System.out.print("비밀번호 확인 : "); String pwcheck = scanner.next();
				System.out.print("이름 입력 : "); String name = scanner.next();
				System.out.print("이메일 입력 : "); String email = scanner.next();
				System.out.print("전화번호 입력 : "); String phone = scanner.next();

				int result = Controller.회원가입(id,pw,pwcheck,name,email,phone);
				if(result == 1) {
					System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				}
				else if(result == 2) {
					System.out.println("중복된 아이디입니다.");
				}
				else if(result == 3) {
					System.out.println("해당 전화번호로 더이상 가입이 불가능합니다.");
				}
				else if(result == 4) {
					System.out.println("회원가입에 성공하였습니다.");
				}
				else if(result == 5) {
					System.out.println("아이디의 길이는 4~12글자만 가능합니다.");
				}
			}
			else if(ch==2) { // 로그인
				System.out.print("아이디 입력 : "); String id = scanner.next();
				System.out.print("비밀번호 입력 : "); String pw = scanner.next();
				int result = Controller.로그인(id,pw);
				if(result == 1) {
					System.out.println(id+"님 환영합니다.");
					System.out.println();
					로그인메뉴(id);
				}
				else if(result == 2) {
					System.out.println("가입된 아이디가 없습니다.");
				}
				else if(result == 3) {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}
			else if(ch==3) {
				System.out.print("이름 입력 : "); String name = scanner.next();
				System.out.print("전화번호 입력 : "); String phone = scanner.next();
				System.out.print("이메일 입력 : "); String email = scanner.next();
				String result = Controller.아이디찾기(name,phone,email);
				if(result.equals("1")) {
					System.out.println("일치하는 정보가 없습니다.");
				}else {
					System.out.println("회원님의 아이디는 \""+result+"\" 입니다.");
				}
				
				//아이디 찾기 메소드
			}
			else if(ch==4) {
				System.out.print("아이디 입력 : "); String id = scanner.next();
				System.out.print("전화번호 입력 : "); String phone = scanner.next();
				System.out.print("이메일 입력 : "); String email = scanner.next();
				
				String result = Controller.비밀번호찾기(id,phone,email);
				if(result.equals("1")) {
					System.out.println("일치하는 정보가 없습니다.");
				}else {
					System.out.println("회원님의 비밀번호는 \""+result+"\" 입니다.");
				}
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
				main.카테고리메뉴(id);
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else if(ch==4) {
				
			}else if(ch==5) {
				break;
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
							if(선택 == 1) { // 수정
								
							}else if(선택 == 2) { // 삭제
								
							}else if(선택 == 3) { // 댓글달기
							
							}else if(선택 == 4){ // 뒤로가기
							}
						}//글찾기 성공 id 출력문 end
						else {// 찾기 실패시
							System.out.println("해당글을 찾지못했습니다");
						}
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
