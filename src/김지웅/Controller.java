package ������;

import java.time.LocalDateTime;
import java.util.ArrayList;



public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	
	
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
		ArrayList<Acount> templist = new ArrayList<>();
		Acount temp = new Acount(id, pw, name, email, phone, 0, templist, 0, null );
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
	
	public static boolean �۾���(String id, String title, String content, String category) {//����
		//id, ����, ����, �ۼ���id, ī�װ� �޾ƿ���
		LocalDateTime date= LocalDateTime.now();// ���糯¥����
		//����, ����, �ۼ���, ��¥, ��ȸ��, ī�װ�, ��õ��, ����õ��, ���Ŭ����, �Ű���Ƚ�� ��üȭ��list�� ����
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, null, 0, boardtnum));
		boardtnum++;
		/* ����ó�� �޼ҵ� ó�� ������ true��ȯ
		 * 
		 */		
		return true;// �ӽù�ȯ
	}
	
	public static boolean �ۻ󼼺���(int index) {// �ε�����ġ�ϴ� ��ȣ ã���� ���� ���� ��ȯ
		//index �޾ƿͼ� �ش��ã��
		int i = 0; //�ε�����ȣ
		for(Board temp : boardlist) {
			if(temp.getIndex() == index) {
				//ã�� �ε��� ��ȣ �ִٰ� true ��ȯ
				return true;
			}
			i++;
		}
		return false;	
	}
	
	public static void ī�װ������() {
		
	}
	public static void ����ۼ�() {
		
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
	public static void ��ۼ���() {
		
	}
	public static void ��ۻ���() {
		
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
}
