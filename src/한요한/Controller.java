package �ѿ���;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	public static String[] ī�װ� = {"�û�","�߱�"}; 
	
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
		Acount temp = new Acount(id, pw, name, email, phone, 0, templist, 0, "" );
		acountlist.add(temp);
		return 4; // ȸ������ ����
		
	}
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
	///////////////////////////////////////////////////////////////////////////
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
		//����, ����, �ۼ���, ��¥, ��ȸ��, ī�װ�, ��õ��, ����õ��, ���Ŭ����, �Ű���Ƚ�� ��üȭ��list�� ����
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, 0, boardtnum));
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
				temp.setView(temp.getView() + 1);
				return true;
			}
		}
		return false;	
	}
	public static void ����ۼ�(String con, int index, String id) {
		LocalDateTime date = LocalDateTime.now();
		for(Board temp : Controller.boardlist) {
			if(temp.getIndex() == index) { // �����ε�����ȣ�� ����������
				Reply e = new Reply(con, id, date,0,0,0,index);
				temp.getReply().add(e);
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
			if(temp.getWriter().equals(id)) {
				for(Acount temp2 : acountlist) {
					if(temp2.getPw().equals(pw)) {
						return true;
					}
				}
				
			}
		}
		return false;
	}
	public static void �ۼ���(String id,String pw, int boardnum, String title, String content) {
		for(Board temp : boardlist) {
			if(temp.getWriter().equals(id)) {
				
			}
		}
	}
	public static void ��õ����(boolean ����, int index, String id) {
		boolean pass = true; // ���̵� �ߺ����� üũ
		for(Board temp : boardlist) { 
			for(String s : temp.getP()) { // �ش�� p����Ʈ�ȿ�
				if(s.equals(id)) {		 // ���̵��� ��ġ�ϸ�
					pass = false; 		//��õ ���� ��������
				}
			}
		}
		if(pass) { // �ߺ��Ⱦ��̵� �ƴ϶��
			for(Board temp : boardlist) {
				if(����) {
					if(temp.getIndex() == index) {
						temp.setGood(temp.getGood() + 1);//��õ �����ø���
						temp.getP().add(id);
						break;
					}		
				}else {
					if(temp.getIndex() == index) {
						temp.setBad(temp.getBad() + 1);//���� �����ø���
						temp.getP().add(id);
						break;
					}		
				}
			}	
		}	
	}
//	public static void �ۻ���(String id, String pw, int boardnum) {
//		if(boardlist.get(boardnum).getWriter().equals(id)) {
//			for(Acount temp : acountlist) {
//				if(temp.getPw().equals(pw) && temp.getId().equals(id)) {
//					boardlist.remove(boardnum);
//					for(Board temp2 : boardlist) {
//						temp2.getReplylist().remove(boardnum);
//					}
//					�Խù�����();
//					�������();
//				}
//			}
//		}
//	}
	public static void �˻�() {
		
	}
	public static void �α��() {
		
	}
	public static boolean ��ۼ���(int ���ε���, int ����ε���, String ��ۼ���, String id) {
		// ���ε��� / �ε���/ ������ ���� / id �޾ƿͼ� 
		// �ش�۳��� ��۸���Ʈ�� ����ε��� ������ ���̵� üũ �� ����
		for(Board temp : boardlist) {
			if(temp.getIndex() == ���ε���) { // �ش�� ã��
				if(temp.getReply().get(����ε���).getWriter().equals(id)) {// �ش���� ���ϴ� ����ε����� �ۼ��ڰ� id����ġ������
					// ���� ����
					temp.getReply().get(����ε���).setContent(��ۼ���);
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
						if(temp.getReply().get(����ε���).getWriter().equals(id)) {// �ش���� ���ϴ� ����ε����� �ۼ��ڰ� id����ġ������
							// ���� ����
							temp.getReply().remove(����ε���);
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
	public static void �Ű�(int index, String id) {
		//�ش���� �ε����� �޾ƿ��� id �޾ƿ��� ����
		for(Board temp : boardlist) {
			if(temp.getIndex() == index) {
				for(Acount temp2 : acountlist) {
					if(temp2.getId().equals(id)) {
						temp2.getBlockuser().add(temp.getWriter());
					}
				}
			}
		}
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
	
}