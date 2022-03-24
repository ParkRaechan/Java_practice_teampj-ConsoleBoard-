package �ڷ���_�ӽ�;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class test1 {
	private String title; // �Խù� ����
	private String content; // �Խù� ����
	private String writer; // �ۼ���
	private LocalDateTime date; // ��¥
	private int view; // ��ȸ��
	private String category; // ī�װ�
	private int good; // ��õ��
	private int bad; // ����õ��
	private int report;  // �Ű���Ƚ��
	private int index; //�۹�ȣ
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
	//��Ȯ��s
	static void �Խù�����ó��(String title,String content,String writer,LocalDateTime date,int view, String category,int good,int bad,int report,int index) throws IOException{
		//�Խù�����
			//���Ͽ� [����,����,�۾���,��,��,�ð�,��ȸ��,ī�װ�,��õ,����õ,�Ű�����]�������� ����
		FileOutputStream out = new FileOutputStream("D:/java/�Խù�test.txt", true);
		String storage = title+","+content+","+writer+","+date.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"))+","+Integer.toString(view)+","+category+","+Integer.toString(good)+","+Integer.toString(bad)+","+Integer.toString(report)+","+Integer.toString(index)+"\n";
		out.write(storage.getBytes());		
	}//��Ȯ��e
		
	public static boolean �Խù����() throws IOException {
		
			FileInputStream input = new FileInputStream("D:/java/�Խù�test.txt");
			byte[] bytes = new byte[1024]; // ����Ʈ�迭��
			input.read(bytes);				// ����Ʈ �б�
			String str = new String(bytes); // �Ͼ�°� ����
			String[] ��1 = str.split("\n"); //1ȸ�۸��� �ڸ���
			for(int t = 0; t < ��1.length-1 ; t++) {	// ȸ�������̸�ŭ �ݺ�
				String lastCharacter = ��1[t].substring(��1[t].length() - 1);
				if(��1[t] != null && !��1[t].equals("") ) {// year,month,day �� �Ȱ�����
					String[] �Խù���� = ��1[t].split(","); // ,���� ��� ������
					String a = �Խù����[0]; // �Խù� ����
					String b = �Խù����[1]; // �Խù� ����
					String c = �Խù����[2]; // �ۼ���
					String d = �Խù����[3]; // ��¥

					
					// D(String ) -> LocaldateTime ����ȯ
					System.out.println(d);
					
					DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
					LocalDateTime dd = LocalDateTime.parse( d , formatter);
					
					String e = �Խù����[4]; // ��ȸ��
					String f = �Խù����[5]; // ī�װ�
					String g = �Խù����[6]; // ��õ��
					String h = �Խù����[7]; // ����õ��
					String i = �Խù����[8];  // �Ű���Ƚ��
					String j = �Խù����[9]; //�۹�ȣ
					test1 o = new test1(a,b,c,dd,Integer.parseInt(e),f,Integer.parseInt(g),Integer.parseInt(h),Integer.parseInt(i),Integer.parseInt(j));
					
					//�迭�� ���� ��Ұ� ����
					main.q.add(o);
				
				}
			}
			return true; //�Ϻ����� ����
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
