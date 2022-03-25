package 김지웅;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while(true) {


			System.out.println("                 *          *          *        **********      ***********                       ");
			System.out.println("                *          *          *         *                    *          ");
			System.out.println("               *          *          *          *                    *            ");
			System.out.println("              *          *          *           **********           *                   ");
			System.out.println("             * * *      * * *      * * *        *                    *           ");
			System.out.println("             *     *    *     *    *     *      *                    *            ");
			System.out.println("             *     *    *     *    *     *      *                    *           ");
			System.out.println("               * *        * *        * *        **********  *        *                   ");
			System.out.println("------------666엔터테인먼트 커뮤니티----------");
			
			//메뉴
			System.out.println("1.회원가입 2.로그인 3.아이디 찾기 4.비밀번호 찾기");
			int ch = scanner.nextInt();
			if(ch==1) { //회원가입
				System.out.println("----------------회원가입 페이지----------------");
				System.out.println("(아이디는 4~12글자 사이여야 합니다.)");
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
				카테고리메뉴(id);
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else if(ch==4) {
				
			}
			else if(ch==5) {break;} // 로그아웃
			else {
				 System.out.println("제시된 번호 입력 바람");	
			}
		}
		
	}
	
	
	public static void 카테고리메뉴(String id) {
		while(true) {
			System.out.println("1.글쓰기 2.글보기 3.검색 4.이전페이지 5.다음페이지 6.뒤로가기");
			int ch2 = scanner.nextInt();
			if(ch2==1) { // 글쓰기
				scanner.nextLine();
				System.out.print("제목 입력 : "); String title = scanner.nextLine();
				System.out.println("내용 입력 : "); String content = scanner.nextLine();
				
				
			}
			else if(ch2==2) { // 글보기
				System.out.print("글 번호 입력 : "); int boardnum = scanner.nextInt();
				글상세보기메뉴(id,boardnum);
			}
			else if(ch2==3) { // 검색
				System.out.println("제목 검색 : ");
			}
			else if(ch2==4) { // 이전페이지
				
			}
			else if(ch2==5) { // 다음페이지
				
			}
			else if(ch2==6) {break;} // 뒤로가기
		}
		
	}
	
	public static void 글상세보기메뉴(String id, int boardnum) {
		while(true) {
			System.out.println("1.댓글달기 2.댓글수정 3.댓글삭제 4.글수정 5.글삭제 6.뒤로가기");
			int ch2 = scanner.nextInt();
			if(ch2==1) { // 댓글달기
				
			}
			else if(ch2==2) { // 댓글수정 
				
				
			}
			else if(ch2==3) { // 댓글삭제
				
			}
			
			else if(ch2==4) { // 글수정
				boolean result = Controller.글수정아이디체크(id);
				if(result) {
					System.out.print("비밀번호 입력 : "); String pw = scanner.next();
					boolean result2 = Controller.글수정비밀번호체크(id, pw);
					if(result2) {
						System.out.print("수정할 제목 입력 : "); String title = scanner.next();
						scanner.next();
						System.out.print("수정할 내용 입력 : "); String content = scanner.nextLine();
						Controller.글수정(boardnum, title, content);
						System.out.println("수정이 완료되었습니다.");
					}
				}else System.out.println("본인이 작성한 글만 수정이 가능합니다.");
			}
			
			else if(ch2==5) { // 글삭제
				boolean result = Controller.글수정아이디체크(id);
				if(result) {
					System.out.print("비밀번호 입력 : "); String pw = scanner.next();
					boolean result2 = Controller.글수정비밀번호체크(id, pw);
					if(result2) {
						Controller.글삭제(id,pw,boardnum);
						System.out.println("삭제가 완료되었습니다.");
						break;
					} else System.out.println("비밀번호가 일치하지 않습니다.");
					
				} else System.out.println("본인이 작성한 글만 삭제가 가능합니다.");
			}
			
			else if(ch2==6) {break;} // 뒤로가기
		}
		
	}
	
	
	
}
