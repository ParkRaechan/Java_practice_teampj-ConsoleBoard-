package Main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
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
	
	public static void 로그인메뉴() {
		Scanner scanner = new Scanner(System.in);

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
}
