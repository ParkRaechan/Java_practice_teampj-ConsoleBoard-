package �ڷ���_�ӽ�;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class main {
	public static ArrayList<test1> q = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		//�ӽ� ����Ʈ
		
		//�׽�Ʈ ���
		test1.�Խù����();
		for(test1 t : q) {
			System.out.println(t.getTitle()+t.getContent()+ t.getWriter()+t.getDate()+t.getView()+ t.getCategory()+t.getGood()+t.getBad()+t.getReport()+t.getIndex());			
		}
		
		//�ӽù迭�߰�
		LocalDateTime a = LocalDateTime.now();
		test1 q1 = new test1("����","����","�۾���",a,12, "����",6,1,1,3);
		q.add(q1);
		
		//�ӽ� ���� ����
		for(test1 t : q) {
			test1.�Խù�����ó��(t.getTitle(),t.getContent(), t.getWriter(),t.getDate(),t.getView(), t.getCategory(),t.getGood(),t.getBad(),t.getReport(),t.getIndex());
			
		}
		
		
		
		
		
		
	}
}
