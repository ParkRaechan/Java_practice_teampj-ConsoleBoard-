package 박래찬_임시;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class test1 {
	private String title; // 게시물 제목
	private String content; // 게시물 내용
	private String writer; // 작성자
	private LocalDateTime date; // 날짜
	private int view; // 조회수
	private String category; // 카테고리
	private int good; // 추천수
	private int bad; // 비추천수
	private int report;  // 신고누적횟수
	private int index; //글번호
	//------------------------------------------------------
	public test1() {
		super();
	}
	public test1(String title, String content, String writer, LocalDateTime date, int view, String category, int good, int bad,
			int report, int index) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.view = view;
		this.category = category;
		this.good = good;
		this.bad = bad;
		this.report = report;
		this.index = index;
	}
	//-------------------------------------------------------
	//글확인s
	static void 게시물파일처리(String title,String content,String writer,LocalDateTime date,int view, String category,int good,int bad,int report,int index) throws IOException{
		//게시물저장
			//파일에 [제목,내용,글쓴이,월,일,시간,조회수,카테고리,추천,비추천,신고누적수]형식으로 저장
		FileOutputStream out = new FileOutputStream("D:/java/게시물test.txt", true);
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
				String lastCharacter = 글1[t].substring(글1[t].length() - 1);
				if(글1[t] != null && !글1[t].equals("") ) {// year,month,day 가 똑같으면
					String[] 게시물요소 = 글1[t].split(","); // ,으로 요소 얻어오기
					String a = 게시물요소[0]; // 게시물 제목
					String b = 게시물요소[1]; // 게시물 내용
					String c = 게시물요소[2]; // 작성자
					String d = 게시물요소[3]; // 날짜

					
					// D(String ) -> LocaldateTime 형변환
					System.out.println(d);
					
					DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
					LocalDateTime dd = LocalDateTime.parse( d , formatter);
					
					String e = 게시물요소[4]; // 조회수
					String f = 게시물요소[5]; // 카테고리
					String g = 게시물요소[6]; // 추천수
					String h = 게시물요소[7]; // 비추천수
					String i = 게시물요소[8];  // 신고누적횟수
					String j = 게시물요소[9]; //글번호
					test1 o = new test1(a,b,c,dd,Integer.parseInt(e),f,Integer.parseInt(g),Integer.parseInt(h),Integer.parseInt(i),Integer.parseInt(j));
					
					//배열에 파일 요소값 저장
					main.q.add(o);
				
				}
			}
			return true; //일별매출 리턴
	}
	
	//-------------------------------------------------------

		
		
		
		
		
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public LocalDateTime getDate() {
			return date;
		}
		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		public int getView() {
			return view;
		}
		public void setView(int view) {
			this.view = view;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getGood() {
			return good;
		}
		public void setGood(int good) {
			this.good = good;
		}
		public int getBad() {
			return bad;
		}
		public void setBad(int bad) {
			this.bad = bad;
		}
		public int getReport() {
			return report;
		}
		public void setReport(int report) {
			this.report = report;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
	
		
		

	
}
