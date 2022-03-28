package �ڷ���_�ӽ�;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Controller {

	static LocalDateTime yourDate;
	static String yourCategory;
	static int yourStoryNum;
	
	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	public static String[] ī�װ� = {"�û�","�߱�"}; 
	public static ArrayList<��������> blockUser = new ArrayList<>();

	
	public static int ȸ������(String id, String pw, String pwcheck, String name, String email, String phone) {
		if(id.length()<4 || id.length()>13) {
			return 5; // ���̵���̰� 4~12�ڸ��� �ƴ�
		}
		if(!pw.equals(pwcheck)) {
			return 1; // ��й�ȣ Ȯ�� Ʋ��
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				return 2; // ���̵� �ߺ�
			}
			else {
				if(temp.getPhone().equals(phone)) {
					return 3; // �ش� ��ȭ��ȣ�� ������ ȸ���� ����
				}
			}
		}
		ArrayList<String> templist = new ArrayList<>();
		Acount temp = new Acount(id, pw, name, email, phone, 0, templist, 0, null );
		acountlist.add(temp);
		return 4; // ȸ������ ����
		
	}
	///////////////////////////////////ȸ������ ó�� ����/////////////////////////////////////////////
	static void ȸ������ó��(String id, String pw, String name, String email, String phone, int point, ArrayList<String> blockuser,
			int report, String friend) throws IOException{
		//ȸ������
			//���Ͽ� [���̵�,���,�̸�,�̸���,����]�������� ����
		FileOutputStream out_a = new FileOutputStream("D:/java/ȸ��test.txt",true);
		String storage_a = id+","+pw+","+name+","+email+","+phone+","+Integer.toString(point)+","+blockuser+","+Integer.toString(report)+","+friend+"\n";		
		out_a.write(storage_a.getBytes());		

	}//ȸ��e
	
	
	public static boolean ȸ�����() throws IOException {
		
		FileInputStream input_a = new FileInputStream("D:/java/ȸ��test.txt");
		byte[] bytes_a = new byte[1024]; // ����Ʈ�迭��
		input_a.read(bytes_a);				// ����Ʈ �б�
		String str_a = new String(bytes_a); // �Ͼ�°� ����
		String[] ȸ��1 = str_a.split("\n"); //1ȸ�۸��� �ڸ���
		for(int t = 0; t < ȸ��1.length-1 ; t++) {	// ȸ�������̸�ŭ �ݺ�
			if(ȸ��1[t] != null && !ȸ��1[t].equals("") ) {
				String[] ȸ����� = ȸ��1[t].split(",");
				String a_a = ȸ�����[0]; // ȸ�� ���̵�
				String b_a = ȸ�����[1]; // ȸ�� ���
				String c_a = ȸ�����[2]; // ȸ�� �̸�
				String d_a = ȸ�����[3]; // ȸ�� �̸���
				String e_a = ȸ�����[4]; // ȸ�� ����
				String f_a = ȸ�����[5]; // ȸ�� ����Ʈ
								
				
				ArrayList<String> g_a = null; // ȸ�� ��������
				//�������� ��� -> ���Ͽ� ��� �־ ��� �� ���ΰ�,,,,,
				String h_a = ȸ�����[7]; // ȸ�� �Ű�
				String i_a = ȸ�����[8]; // ȸ�� ģ��

				Acount o_a = new Acount(a_a,b_a,c_a,d_a,e_a,Integer.parseInt(f_a),g_a,Integer.parseInt(h_a),i_a);
				
				//�迭�� ���� ��Ұ� ����
				Controller.acountlist.add(o_a);
			
			}
		}
		return true; //�Ϻ����� ����
	}
	
	
	
	
	
	
	///////////////////////////////////ȸ������ ó�� ��/////////////////////////////////////////////

	public static int �α���(String id, String pw) {
		boolean idcheck = false;
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				idcheck = true;
			}
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getPw().equals(pw)) {
				return 1; // �α��� ����
			}
		}
		if(idcheck==false) {
			return 2; // ���Ե� ���̵� ����
		}
		return 3; // ��й�ȣ Ʋ��
	}

	
	public static boolean �۾���(String id, String title, String content, String category) {//����
		//id, ����, ����, �ۼ���id, ī�װ� �޾ƿ���
		LocalDateTime date= LocalDateTime.now();// ���糯¥����
		//��ȣ �ҷ�����
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
		//����, ����, �ۼ���, ��¥, ��ȸ��, ī�װ�, ��õ��, ����õ��, ���Ŭ����, �Ű���Ƚ�� ��üȭ��list�� ����
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, 0, boardtnum));
		boardtnum++;
		/* ����ó�� �޼ҵ� ó�� ������ true��ȯ
		 * 
		 */		
		return true;// �ӽù�ȯ
	}
	public static boolean �ۻ󼼺���(int index) {// �ε�����ġ�ϴ� ��ȣ ã���� ���� ���� ��ȯ
		//index �޾ƿͼ� �ش��ã��
		//�ε�����ȣ
		for(Board temp : boardlist) {
			if(temp.getIndex() == index) {
				//ã�� �ε��� ��ȣ �ִٰ� true ��ȯ
				return true;
			}
		}
		return false;	
	}
	
	////////////////////////////////////�۾��� ����ó�� ����////////////////////////////////////////////////////

	static void �Խù�����ó��(String title,String content,String writer,LocalDateTime date,int view, String category,int good,int bad,int report,int index) throws IOException{
		//�Խù�����
			//���Ͽ� [����,����,�۾���,��,��,�ð�,��ȸ��,ī�װ�,��õ,����õ,�Ű�����]�������� ����
		FileOutputStream out = new FileOutputStream("D:/java/�Խù�test.txt",true);
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
			//String lastCharacter = ��1[t].substring(��1[t].length() - 1);
			if(��1[t] != null && !��1[t].equals("") ) {
				String[] �Խù���� = ��1[t].split(",");
				String a = �Խù����[0]; // �Խù� ����
				String b = �Խù����[1]; // �Խù� ����
				String c = �Խù����[2]; // �ۼ���
				String d = �Խù����[3]; // ��¥

				
				// D(String ) -> LocaldateTime ����ȯ				
				DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				LocalDateTime dd = LocalDateTime.parse( d , formatter);
				
				String e = �Խù����[4]; // ��ȸ��
				String f = �Խù����[5]; // ī�װ�
				String g = �Խù����[6]; // ��õ��
				String h = �Խù����[7]; // ����õ��
				String i = �Խù����[8];  // �Ű���Ƚ��
				String j = �Խù����[9]; //�۹�ȣ
				Board o = new Board(a,b,c,dd,Integer.parseInt(e),f,Integer.parseInt(g),Integer.parseInt(h),Integer.parseInt(i),Integer.parseInt(j));
				
				//�迭�� ���� ��Ұ� ����
				Controller.boardlist.add(o);
			
			}
		}
		return true; //�Ϻ����� ����
	}
	////////////////////////////////////�۾��� ����ó�� ��////////////////////////////////////////////////////
	
	
	public static void ����ۼ�(String con, int index, String id) {
		LocalDateTime date = LocalDateTime.now();
		for(Board temp : Controller.boardlist) {
			if(temp.getIndex() == index) { // �����ε�����ȣ�� ����������
				Reply e = new Reply(con, id, date,0,0,0,index);
				temp.getReplylist().add(e);
				break;
			}
		}
	}
	public static boolean �ۼ������̵�üũ(String id) {
		for(Board temp : boardlist) {
			if(temp.getWriter().equals(id)) {return true;}
		}
		return false;
	}
	public static boolean �ۼ�����й�ȣüũ(String id,String pw) {
		for(Board temp : boardlist) {
				for(Acount temp2 : acountlist) {
					if(temp.getWriter().equals(id) && temp2.getPw().equals(pw)) {
						return true;
					}
				}
		}
		return false;
	}
	public static void �ۼ���(int boardnum, String title, String content) {
		boardlist.get(boardnum).setTitle(title);
		boardlist.get(boardnum).setContent(content);
		�Խù�����();
	}


	public static void �ۻ���(String id, String pw, int boardnum) {
		for(Board temp2 : boardlist) {
			if(temp2.getIndex()==boardnum) {
				for(Acount temp : acountlist) {
					if(temp.getPw().equals(pw) && temp.getId().equals(id)) {
						boardlist.remove(temp2);
						
						�Խù�����();
						�������();
					}
				}
			}
			
		}
	}
	
	
	public static void �˻�() {
		
	}
	public static void �α��() {
		
	}
	public static boolean ��ۼ���(int ���ε���, int ����ε���, String ��ۼ���, String id) {
		// ���ε��� / �ε���/ ������ ���� / id �޾ƿͼ� 
		// �ش�۳��� ��۸���Ʈ�� ����ε��� ������ ���̵� üũ �� ����
		for(Board temp : boardlist) {
			if(temp.getIndex() == ���ε���) { // �ش�� ã��
				if(temp.getReplylist().get(����ε���).getWriter().equals(id)) {// �ش���� ���ϴ� ����ε����� �ۼ��ڰ� id����ġ������
					// ���� ����
					temp.getReplylist().get(����ε���).setContent(��ۼ���);
					return true;
				}		
			}// �Խù� ��ã�� if end
		}
		return false;
	}
	public static boolean ��ۻ���(int ���ε���, int ����ε���, String id) {
		// ���ε��� / �ε���/ ������ ���� / id �޾ƿͼ� 
				// �ش�۳��� ��۸���Ʈ�� ����ε��� ������ ���̵� üũ �� ����
				for(Board temp : boardlist) {
					if(temp.getIndex() == ���ε���) { // �ش�� ã��
						if(temp.getReplylist().get(����ε���).getWriter().equals(id)) {// �ش���� ���ϴ� ����ε����� �ۼ��ڰ� id����ġ������
							// ���� ����
							temp.getReplylist().remove(����ε���);
							return true;
						}		
					}// �Խù� ��ã�� if end
				}
				return false;
		}
	public static void ����() {
		
	}
	public static void ����Ʈ��ŷ() {
		
	}
	public static void �Ű�() {
		
	}
	public static void ģ���߰�() {
		
	}
	public static void ����Ȯ��() {
		
	}
	public static void ����������() {
		
	}
	public static void ��۴ޱ�() {
		
	}
	public static void �Խù�����() {
		
	}
	public static void �Խù��ҷ�����() {
		
	}
	public static void ȸ������() {
		
	}
	public static void ȸ���ҷ�����() {
		
	}
	public static void �������() {
		
	}
	public static void ��ۺҷ�����() {
		
	}
	public static String ���̵�ã��(String name, String phone, String email) {
		for(Acount temp : acountlist) {
			if(temp.getName().equals(name) && temp.getEmail().equals(email)
					&& temp.getPhone().equals(phone)) {
				return temp.getId();
			}
		}
		return "1";
	}
	public static String ��й�ȣã��(String id, String phone, String email) {
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getEmail().equals(email)
					&& temp.getPhone().equals(phone)) {
				return temp.getPw();
			}
		}
		return "1";
	}
	
	
	
	
	public static boolean ��������Ȯ��(String id1, String id2) {
		for(�������� temp : blockUser) {
			if(temp.getIndex().equals(id1)&&temp.getTarget().equals(id2)) {
				return true;
			}
		}
		return false;
	}
	
/////////////////////////////////�������� ����ó�� ����//////////////////////////////////////////////////////////////
	
	static void ������������ó��(String id, String blockuser) throws IOException{
		//ȸ������
			//���Ͽ� [���̵�,���,�̸�,�̸���,����]�������� ����
		FileOutputStream out_u = new FileOutputStream("D:/java/��������test.txt",true);
		String storage_u = id+","+blockuser+"\n";	
		out_u.write(storage_u.getBytes());		

	}//��������e
	
	
	public static boolean �����������() throws IOException {
		
		FileInputStream input_u = new FileInputStream("D:/java/��������test.txt");
		byte[] bytes_u = new byte[1024]; // ����Ʈ�迭��
		input_u.read(bytes_u);				// ����Ʈ �б�
		String str_u= new String(bytes_u); // �Ͼ�°� ����
		String[] ȸ��1 = str_u.split("\n"); //1ȸ�۸��� �ڸ���
		for(int t = 0; t < ȸ��1.length-1 ; t++) {	// ȸ�������̸�ŭ �ݺ�
			if(ȸ��1[t] != null && !ȸ��1[t].equals("") ) {
				String[] ȸ����� = ȸ��1[t].split(",");
				String a_a = ȸ�����[0]; // ȸ�� ���̵�
				String b_a = ȸ�����[1]; // ȸ�� ���
				String c_a = ȸ�����[2]; // ȸ�� �̸�
				String d_a = ȸ�����[3]; // ȸ�� �̸���
				String e_a = ȸ�����[4]; // ȸ�� ����
				String f_a = ȸ�����[5]; // ȸ�� ����Ʈ
								
				
				ArrayList<String> g_a = null; // ȸ�� ��������
				//�������� ��� -> ���Ͽ� ��� �־ ��� �� ���ΰ�,,,,,
				String h_a = ȸ�����[7]; // ȸ�� �Ű�
				String i_a = ȸ�����[8]; // ȸ�� ģ��

				Acount o_a = new Acount(a_a,b_a,c_a,d_a,e_a,Integer.parseInt(f_a),g_a,Integer.parseInt(h_a),i_a);
				
				//�迭�� ���� ��Ұ� ����
				Controller.acountlist.add(o_a);
			
			}
		}
		return true; //�Ϻ����� ����
	}
	
	
	
	
/////////////////////////////////�������� ����ó�� ��//////////////////////////////////////////////////////////////

}