package �ѿ���;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;


public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	public static String[] ī�װ� = {"�û�","�߱�"};
	public static String[] ����Ʈ���� = new String[6];
	public static String[] ������ = {"[��]","[��]","[��]","[��]","[��]",
			  "[��]","[��]","[��]","[��]","[��]",
			  "[��]","[��]","[��]","[��]","[��]"};// 0 ~ 14 �ε���
	
	public static int ȸ�����Ծ��̵�(String id) {
		String pattern = "^[0-9|a-z|A-Z|��-��|��-��|��-�R]*$";
		if(!Pattern.matches(pattern, id)){
			  return 1; // ���̵� Ư������ or ������ ��
			}
		if(id.length()<4 || id.length()>13) {
			return 2; // ���̵���̰� 4~12�ڸ��� �ƴ�
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				return 3; // ���̵� �ߺ�
			}
		}
		return 4; // �������� ���̵�
	}
	
	public static int ȸ�����Ժ�й�ȣ(String pw, String pwcheck) {
		
		if(pw.contains(" ")) {
			  return 1; // ��й�ȣ�� ���� ����
			}
		if(!pw.equals(pwcheck)) {
			return 2; // ��й�ȣ Ȯ�� Ʋ��
		}
		return 3; // �������� ��й�ȣ
	}
	
	public static boolean ȸ������(String id, String pw, String pwcheck, String name, String email, String phone) {
		for(Acount temp : acountlist) {
			if(temp.getPhone().equals(phone)) {
				return false; // �ش� ��ȭ��ȣ�� ������ ȸ���� ����
			}
		}
		Acount temp = new Acount(id, pw, name, email, phone, 0, null, 0, null );
		acountlist.add(temp);
		ȸ������();
		return true; // ȸ������ ����
		
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
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, null, 0,boardtnum));
		boardtnum++;
		/* ����ó�� �޼ҵ� ó�� ������ true��ȯ
		 * 
		 */		
		return true;// �ӽù�ȯ
	}
	
	public static boolean �ۻ󼼺���(String id, int index) {// �ε�����ġ�ϴ� ��ȣ ã���� ���� ���� ��ȯ
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getBlockuser()!=null ) { // �α����� ���̵��� ������������� ������
				for(Board temp2 : boardlist) {
					if(temp2.getIndex()==index && temp.getBlockuser().contains(temp2.getWriter())) {
						// �ش� �ε����� �� �ۼ��ڰ� ����������Ͽ� ���ԵǾ� ������
						return false; // �ش� �� �������� ����
					}
				}
			}
		}
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
	
	public static void �ۼ���(int index, String title, String content) {
		boardlist.get(index).setTitle(title);
		boardlist.get(index).setContent(content);
		�Խù�����();
	}
	
	public static void ��õ����(boolean ����, int index, String id) {
		boolean pass = true; // ���̵� �ߺ����� üũ
		for(Board temp : boardlist) {
			for(String s : temp.getP()) { // �ش�� p����Ʈ�ȿ�
				if(temp.getIndex()==index && s.equals(id)) {		 // ���̵��� ��ġ�ϸ�
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
	
	public static void �ۻ���(String id, String pw, int index) {
		for(Board temp2 : boardlist) {
			if(temp2.getIndex()==index) {
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
	
	public static ArrayList<Board> �˻�(String serch) {
		ArrayList<Board> �˻���� = new ArrayList<Board>();
		�˻����.clear();
		for(Board temp : boardlist) {
			if(temp.getTitle().indexOf(serch)!=-1) {
				Board temp2 = new Board(temp.getTitle(), temp.getContent(), temp.getWriter(), 
						temp.getDate(), temp.getView(), temp.getCategory(), temp.getGood(), temp.getBad(), 
						temp.getReplylist(), temp.getReport(), temp.getIndex());
				�˻����.add(temp2);
				return �˻����; // �˻���� ���
			}
		}
		return �˻����;
	}
	
	public static ArrayList<Board> �α��(String ī�װ�) {// ī�װ� ����ͼ�
		
		// �ӽ÷� �� board ����Ʈ
		ArrayList<Board> �ӽ� = new ArrayList<>();
		for(Board temp : boardlist) {
			if(temp.getCategory().equals(ī�װ�)) {
				�ӽ�.add(temp);
			}	
		}
		// ���� ���ų� ũ�� �ְ� �����
		for(int i = 0; i < �ӽ�.size(); i++) {
			Board temp = �ӽ�.get(i);
			for(int j = 0; j < �ӽ�.size() ; j++) {
				if(temp.getGood() > �ӽ�.get(j).getGood()) {
					temp = �ӽ�.get(j);
					�ӽ�.set(j, �ӽ�.get(i));
					�ӽ�.set(i, temp);
				}
			}
		}
		return �ӽ�;
	}// m end
	
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
	
	public static String[] ����(String id) {
		String[] ����Ʈ���� = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"};
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				if(temp.getPoint()<10) { // ��������Ʈ�� 10���� ������
					return ����Ʈ����;
				}else { // ��������Ʈ�� 10 �̻��̸� ��������Ʈ���� 10 ����
					temp.setPoint(temp.getPoint()-10); 
				}
			}
		}
			
		Random random = new Random();
		for(int i=0; i<����Ʈ����.length; i++) {
			int num = random.nextInt(����Ʈ����.length)+1; // 1~6 ���� ����
			����Ʈ����[i]="["+num+"]";
		}
		return ����Ʈ����;
	}
	
	public static int ���ǰ��(String[] result,String id) {
		int[] count = new int[result.length]; // ��ġ�ϴ� �� Ȯ�ο� �迭 
		int max = 0; 
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result.length; j++) {
				if(result[i].equals("["+(j+1)+"]") ) { // ���� �� Ȯ��
					count[j]++; // ��ġ�ϴ� �� ����
				}
			}
		}
		for(int i=0; i<count.length; i++) {
			if(count[i]>max) {
				max=count[i]; // ���� ���� ��ġ�ϴ� ��
			}
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				if(max==6) { // 1��
					temp.setPoint(temp.getPoint()+1000); // ����Ʈ 1000 �߰�
					return 1;
				} else if(max==5) {
					temp.setPoint(temp.getPoint()+300); // ����Ʈ 300 �߰�
					return 2;
				} else if(max==4) {
					temp.setPoint(temp.getPoint()+100); // ����Ʈ 100 �߰�
					return 3;
				} else if(max==3) {
					temp.setPoint(temp.getPoint()+10); // ����Ʈ 10 �߰�
					return 4;
				} 	
			} // if end
		} // for end
		return 5; // ��
	}
	
	public static ArrayList<Acount> ����Ʈ��ŷ() {
		ArrayList<Acount> rank = new ArrayList<>(); // ��ŷ ����Ʈ ����
		rank.addAll(acountlist); // ȸ�� ����Ʈ�� ��ŷ ����Ʈ�� ����
		
		Collections.sort(rank, new Acountsort()); // ��ŷ ����Ʈ�� ����Ʈ���� ������� ����
		
		return rank; // ��ŷ ����Ʈ ��ȯ
		

	}
	
	public static boolean �Ű�(String id,int index) {
		
		for(Board temp : boardlist) {
			if(temp.getIndex()==index && temp.getWriter().equals(id)) {
				return false; // �Ű��� ���̵� �ڽ��� ���̵�
			}
		}
		ArrayList<String> reportid = new ArrayList<>();
		for(Board temp : boardlist) {
			if(temp.getIndex()==index) {
				
				temp.setReport(temp.getReport()+1);
				reportid.add(temp.getWriter()) ;
				break;
			}
		}
		for(int i=0; i<acountlist.size(); i++) {
			if(acountlist.get(i).getId().equals(id)) {
				if(acountlist.get(i).getBlockuser()==null) {
					acountlist.get(i).setBlockuser(reportid);
				}
				else {
					acountlist.get(i).getBlockuser().addAll(acountlist.get(i).getBlockuser().size() ,reportid);
				}
				break;
			}
		}
		return true;
	}
	
	public static boolean ����Ȯ��(String id, int ��ȣ) {
		// ������ȣ, ���̵� �޾ƿͼ� �ִ���������üũ
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {// ���̵��� ��ġ�ϸ�
				for(����Ŭ���� temp2 : temp.get����()) { // �׾ȿ� ���� list ��������
					if(temp2.get��ȣ() == ��ȣ) { // list �� ��ȣ�� ����������
						return true;
					}
				}
			}
		}// for end
		return false;
	}
	
	public static boolean ����������(String receiveid, String id, String con) {
		// �޴»��, id, ����޾Ƽ�
		for(Acount temp : acountlist) {
			if(temp.getId().equals(receiveid)) {// id����ġ�ϴ� acount Ŭ������ ã�Ƽ�
					// ����list�� ���� �߰�
					temp.get����().add(new ����Ŭ����(temp.getId(), id, con, temp.get����().size() + 1));
					return true;
			}
		}
		return false;
		
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
	public static int[] ����ã����Ӽ���() {
		// 1. ���Ӽ���
		Random random = new Random();
		int[] ��� = new int[3];
		for(int i = 0 ; i < ���.length ; i++) {
			boolean pass = false;
			int temp = random.nextInt(15);// ���� ����
			for(int j = 0 ; j < ���.length ; j++) {
				if(temp != ���[i]) { pass = true; }// �����ʴٸ�
			}
			if(pass) {
				���[i] = temp;
			}else {	i--; }
			if(i == 2) {break;}
		}// for end
		return ���;
	}
	
	public static int ����ã��(int chindex, String id, int[] ���) { // �ε��� / id �ޱ�
		// �ӽ� ���� 1�� 400 /2�� 200 /3�� 100 /4��� 10
		 //2. �̱�
			int i = 1; // ��� ����
			if(������[chindex].equals("[��]")) { //���̶��
				for(int temp : ���) {
					if(chindex == temp) { // temp 0 1 2 ������� ��÷�Ǹ�
						������[chindex] = "["+i+"]";  // ������ ����
						break;	// ������
					}else {������[chindex] = "[ ]";}
					i++; // ���� ���
				}
			}
			for(Acount temp : acountlist) { // ȸ�� ��Ͽ���
				if(temp.getId().equals(id)) { // ���̵���ġ�ϸ�
					temp.setPoint(temp.getPoint() - 10); // ����Ʈ 10�� ����
					if(i == 1) { // 1���÷�Ǹ�
						temp.setPoint(temp.getPoint() + 400); // �߰�
						return 1;
					}else if(i == 2) {
						temp.setPoint(temp.getPoint() + 300);
						return 2;
					}else if(i == 3) {
						temp.setPoint(temp.getPoint() + 200);
						return 3;
					}
				}
			}
			return -1; 
		}// ����ã�� �޼ҵ� end
	
}
