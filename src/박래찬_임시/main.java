package 박래찬_임시;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class main {
	public static ArrayList<test1> q = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		//임시 리스트
		
		//테스트 출력
		test1.게시물출력();
		for(test1 t : q) {
			System.out.println(t.getTitle()+t.getContent()+ t.getWriter()+t.getDate()+t.getView()+ t.getCategory()+t.getGood()+t.getBad()+t.getReport()+t.getIndex());			
		}
		
		//임시배열추가
		LocalDateTime a = LocalDateTime.now();
		test1 q1 = new test1("제목","내용","글쓴이",a,12, "경제",6,1,1,3);
		q.add(q1);
		
		//임시 파일 저장
		for(test1 t : q) {
			test1.게시물파일처리(t.getTitle(),t.getContent(), t.getWriter(),t.getDate(),t.getView(), t.getCategory(),t.getGood(),t.getBad(),t.getReport(),t.getIndex());
			
		}
		
		
		
		
		
		
	}
}
