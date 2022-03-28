package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;



public class Controller {

	static LocalDateTime yourDate;
	static String yourCategory;
	static int yourStoryNum;
	
	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static ArrayList<차단유저> 차단유저list = new ArrayList<>();
	public static int boardtnum = 1;
	public static String[] 카테고리 = {"시사","야구"};

	public static String[] 포인트복권 = new String[6];
	public static String[] 게임판 = {"[■]","[■]","[■]","[■]","[■]",
			  "[■]","[■]","[■]","[■]","[■]",
			  "[■]","[■]","[■]","[■]","[■]"};// 0 ~ 14 인덱스


	
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
	
	public static boolean 회원가입(String id, String pw, String pwcheck, String name, String email, String phone) throws IOException {
		for(Acount temp : acountlist) {
			if(temp.getPhone().equals(phone)) {
				return false; // 해당 전화번호로 가입한 회원이 있음
			}
		}
		Acount temp = new Acount(id, pw, name, email, phone, 0, null, 0, null );
		
		acountlist.add(temp);
		Controller.회원파일처리(id);
		return true; // 회원가입 성공
		
	}
	
	
	
	///////////////////////////////1////회원파일 처리 시작/////////////////////////////////////////////
	static void 회원파일처리(String id) throws IOException{
		
		//회원저장
			//파일에 [아이디,비번,이름,이메일,폰번]형식으로 저장
		FileOutputStream out_a = new FileOutputStream("D:/java/회원test.txt");
		String storage_a1="";
		for(Acount temp001 : acountlist) {
				id = temp001.getId();
				String pw = temp001.getPw();
				String name = temp001.getName();
				String email = temp001.getEmail();
				String phone = temp001.getPhone();
				int point = temp001.getPoint();
				ArrayList<String> blockuser = null;
				int report = temp001.getReport();
				String friend = null;
				
			
				String storage_a = id+","+pw+","+name+","+email+","+phone+","+Integer.toString(point)+","+blockuser+","+Integer.toString(report)+","+friend+"\n";		
				
				storage_a1 =storage_a1+ storage_a;
					
				
		}

		out_a.write(storage_a1.getBytes());		
	
		
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
				
				
				
				ArrayList<차단유저> g_a = null; // 회원 차단유저
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
	
	                       ///////회원내부 차단유저 파일처리 시작/////////   
	static void 차단파일처리(String id) throws IOException {
		for(차단유저 temp : 차단유저list) {
			if(temp.getIndex().equals(id)) {
				FileOutputStream out_c = new FileOutputStream("D:/java/차단유저test.txt",true);
				String storage_c = id+"@@"+temp.getTarget()+"\n";		
				out_c.write(storage_c.getBytes());		
				
			}
		}
	}
	
	public static boolean 차단출력() throws IOException {
		
		FileInputStream input_c = new FileInputStream("D:/java/차단유저test.txt");
		byte[] bytes_c = new byte[1024]; // 바이트배열선
		input_c.read(bytes_c);				// 바이트 읽기
		String str_c = new String(bytes_c); // 일어온거 저장
		String[] 차단1 = str_c.split("\n"); //1회글마다 자르기
		for(int t = 0; t < 차단1.length-1 ; t++) {	// 회당매출길이만큼 반복
			if(차단1[t] != null ) {
				String[] 차단요소 = 차단1[t].split("@@");
				
				String a_c = 차단요소[0]; 
				String b_c = 차단요소[1]; 

				차단유저 o_c = new 차단유저(a_c,b_c);
				
				//배열에 파일 요소값 저장
				Controller.차단유저list.add(o_c);
			
			}
		}
		return true; 
	}
	                          //////회원내부 차단유저 파일처리 끝//////
	
	
	
	
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

	
	public static boolean 글쓰기(String id, String title, String content, String category) throws IOException {//요한
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
		Controller.게시물파일처리(title,content, id,Controller.yourDate,0,Controller.yourCategory,0,0,0,Controller.yourStoryNum);
		
		//제목, 내용, 작성자, 날짜, 조회수, 카테고리, 추천수, 비추천수, 댓글클래스, 신고누적횟수 객체화후list의 저장
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, 0, boardtnum));
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
					for(int i=0;  i<temp.getBlockuser().size(); i++) {
						if(temp2.getIndex()==index && temp.getBlockuser().get(i).getTarget().contains(temp2.getWriter()) ) {
							// 해당 인덱스의 글 작성자가 차단유저목록에 포함되어 있으면
							return false; // 해당 글 볼러오기 실패
						}
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
	public static boolean 글수정아이디체크(String id, int index) {
		for(Board temp : boardlist) {
			if(temp.getWriter().equals(id) && temp.getIndex()==index) {return true;}
		}
		return false;
	}
	public static boolean 글수정비밀번호체크(String id,String pw,int index) {
		for(Board temp : boardlist) {
				for(Acount temp2 : acountlist) {
					if(temp.getWriter().equals(id) && temp2.getPw().equals(pw) && temp.getIndex()==index) {
						return true;
					}
				}
		}
		return false;
	}
	public static void 글수정(int boardnum, String title, String content) {
		boardlist.get(boardnum).setTitle(title);
		boardlist.get(boardnum).setContent(content);
	}


	public static void 글삭제(String id, String pw, int index) {
		boolean delete = false;
		for(Board temp2 : boardlist) {
			if(temp2.getIndex()==index) {
				for(Acount temp : acountlist) {
					if(temp.getPw().equals(pw) && temp.getId().equals(id)) {
						delete = true;

					}
				}
			}
			
		}
		if(delete) {
			for(Board temp : boardlist) {
				if(temp.getIndex()==index) {
					boardlist.remove(temp);
					break;
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
	
	
	public static ArrayList<Board> 인기글(String 카테고리) {// 카테고리 끌고와서
		
		// 임시로 쓸 board 리스트
		ArrayList<Board> 임시 = new ArrayList<>();
		for(Board temp : boardlist) {
			if(temp.getCategory().equals(카테고리)) {
				임시.add(temp);
			}	
		}
		// 비교후 같거나 크면 넣고 지우기
		for(int i = 0; i < 임시.size(); i++) {
			Board temp = 임시.get(i);
			for(int j = 0; j < 임시.size() ; j++) {
				if(temp.getGood() > 임시.get(j).getGood()) {
					temp = 임시.get(j);
					임시.set(j, 임시.get(i));
					임시.set(i, temp);
				}
			}
		}
		return 임시;
	}// m end
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
	public static int 복권결과(String[] result,String id) throws IOException {
		int[] count = new int[result.length]; // 일치하는 수 확인용 배열 
		int max = 0; 
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result.length; j++) {
				if(result[i].equals("["+(j+1)+"]") ) { // 같은 수 확인
					count[j]++; // 일치하는 수 증가
				}
			}
		}
		for(int i=0; i<count.length; i++) {
			if(count[i]>max) {
				max=count[i]; // 가장 많이 일치하는 수
			}
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				if(max==6) { // 1등
					temp.setPoint(temp.getPoint()+1000); // 포인트 1000 추가
					Controller.회원파일처리(id);
					return 1;
				} else if(max==5) {
					temp.setPoint(temp.getPoint()+300); // 포인트 300 추가
					Controller.회원파일처리(id);
					return 2;
				} else if(max==4) {
					temp.setPoint(temp.getPoint()+100); // 포인트 100 추가
					Controller.회원파일처리(id);
					return 3;
				} else if(max==3) {
					temp.setPoint(temp.getPoint()+10); // 포인트 10 추가
					Controller.회원파일처리(id);
					return 4;
				} 	
			} // if end
		} // for end
		return 5; // 꽝
	}
	
	public static String[] 복권(String id) throws IOException {
		String[] 포인트복권 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"};
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				if(temp.getPoint()<10) { // 보유포인트가 10보다 작으면
					return 포인트복권;
				}else { // 보유포인트가 10 이상이면 보유포인트에서 10 차감
					temp.setPoint(temp.getPoint()-10); 
					Controller.회원파일처리(id);
				}
			}
		}
			
		Random random = new Random();
		for(int i=0; i<포인트복권.length; i++) {
			int num = random.nextInt(포인트복권.length)+1; // 1~6 난수 생성
			포인트복권[i]="["+num+"]";
		}
		return 포인트복권;
	}
	
	public static ArrayList<Acount> 포인트랭킹() {
		ArrayList<Acount> rank = new ArrayList<>(); // 랭킹 리스트 생성
		rank.addAll(acountlist); // 회원 리스트를 랭킹 리스트에 저장
		
		Collections.sort(rank, new Acountsort()); // 랭킹 리스트를 포인트점수 순서대로 정렬
		
		return rank; // 랭킹 리스트 반환
		

	}
	public static boolean 신고(String id,int index) throws IOException {
		
		for(Board temp : boardlist) {
			if(temp.getIndex()==index && temp.getWriter().equals(id)) {
				return false; // 신고한 아이디가 자신의 아이디
			}
		}
		String reportid = null;
		for(Board temp : boardlist) {
			if(temp.getIndex()==index) {
				
				temp.setReport(temp.getReport()+1);
				reportid = temp.getWriter() ;
				break;
			}
		}
		
		차단유저 a = new 차단유저(id, reportid); 
		차단유저list.add(a);
		차단파일처리(id);
		for(int i=0; i<acountlist.size(); i++) {
			if(acountlist.get(i).getId().equals(id)) {
				if(acountlist.get(i).getBlockuser()==null) {
					acountlist.get(i).setBlockuser(차단유저list);
					
				}
				else {
					acountlist.get(i).getBlockuser().addAll(acountlist.get(i).getBlockuser().size(), 차단유저list);
				}
				break;
			}
		}
		return true;
	}
	
	public static boolean 쪽지확인(String id, int 번호) {
		// 쪽지번호, 아이디 받아와서 있는지없는지체크
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {// 아이디값이 일치하면
				for(쪽지클래스 temp2 : temp.get쪽지()) { // 그안에 쪽지 list 뒤져보고
					if(temp2.get번호() == 번호) { // list 안 번호가 같은게있음
						return true;
					}
				}
			}
		}// for end
		return false;
	}
	
	public static boolean 쪽지보내기(String receiveid, String id, String con) {
		// 받는사람, id, 내용받아서
		for(Acount temp : acountlist) {
			if(temp.getId().equals(receiveid)) {// id값일치하는 acount 클래스를 찾아서
					// 쪽지list에 쪽지 추가
					temp.get쪽지().add(new 쪽지클래스(temp.getId(), id, con, temp.get쪽지().size() + 1));
					return true;
			}
		}
		return false;
		
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
	
	
	public static void 추천비추(boolean 여부, int index, String id) {
		boolean pass = true; // 아이디 중복여부 체크
		for(Board temp : boardlist) {
			for(String s : temp.getP()) { // 해당글 p리스트안에
				if(temp.getIndex()==index && s.equals(id)) {		 // 아이디값이 일치하면
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
	
	
	
	public static int[] 보물찾기게임설정() {
		// 1. 게임설정
		Random random = new Random();
		int[] 등수 = new int[3];
		for(int i = 0 ; i < 등수.length ; i++) {
			boolean pass = false;
			int temp = random.nextInt(15);// 난수 생성
			for(int j = 0 ; j < 등수.length ; j++) {
				if(temp != 등수[i]) { pass = true; }// 같지않다면
			}
			if(pass) {
				등수[i] = temp;
			}else {	i--; }
			if(i == 2) {break;}
		}// for end
		return 등수;
	}

	
	
	
	

	public static int 보물찾기(int chindex, String id, int[] 등수) throws IOException { // 인덱스 / id 받기
		// 임시 게임 1등 400 /2등 200 /3등 100 /4장려 10
		 //2. 뽑기
			int i = 1; // 등수 기준
			if(게임판[chindex].equals("[■]")) { //빈값이라면
				for(int temp : 등수) {
					if(chindex == temp) { // temp 0 1 2 순서대로 당첨되면
						게임판[chindex] = "["+i+"]";  // 게임판 변경
						break;	// 나가기
					}else {게임판[chindex] = "[ ]";}
					i++; // 다음 등수
				}
			}
			for(Acount temp : acountlist) { // 회원 목록에서
				if(temp.getId().equals(id)) { // 아이디값일치하면
					temp.setPoint(temp.getPoint() - 10); // 포인트 10을 빼고
					if(i == 1) { // 1등당첨되면
						temp.setPoint(temp.getPoint() + 400); // 추가
						Controller.회원파일처리(id);
						return 1;
					}else if(i == 2) {
						temp.setPoint(temp.getPoint() + 300);
						Controller.회원파일처리(id);
						return 2;
					}else if(i == 3) {
						temp.setPoint(temp.getPoint() + 200);
						Controller.회원파일처리(id);
						return 3;
					}
					
					
				}
			}
			return -1; 
		}// 보물찾기 메소드 end
	
	
	
}