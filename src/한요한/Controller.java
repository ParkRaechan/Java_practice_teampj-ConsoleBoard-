package �ѿ���;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static int boardtnum = 1;
	
	public static void ȸ������() {
		
	}
	public static void �α���() {
		
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
		return false;
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
	public static void �ۼ���() {
		
	}
	public static void �ۻ���() {
		
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
	
}