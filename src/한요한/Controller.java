package �ѿ���;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static ArrayList<Reply> replylist = new ArrayList<>();
	
	
	
	public static void ȸ������() {
		
	}
	public static void �α���() {
		
	}
	public static void �۾���(String id, String title, String content, String writer, String category) {//����
		//id, ����, ����, �ۼ���id, ī�װ� �޾ƿ���
		LocalDateTime date= LocalDateTime.now();
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, null, 0));
		
	}
	public static void �ۻ󼼺���() {// me
		
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