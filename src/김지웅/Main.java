package ������;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while(true) {


			System.out.println("                 *          *          *        **********      ***********                       ");
			System.out.println("                *          *          *         *                    *          ");
			System.out.println("               *          *          *          *                    *            ");
			System.out.println("              *          *          *           **********           *                   ");
			System.out.println("             * * *      * * *      * * *        *                    *           ");
			System.out.println("             *     *    *     *    *     *      *                    *            ");
			System.out.println("             *     *    *     *    *     *      *                    *           ");
			System.out.println("               * *        * *        * *        **********  *        *                   ");
			System.out.println("------------666�������θ�Ʈ Ŀ�´�Ƽ----------");
			
			//�޴�
			System.out.println("1.ȸ������ 2.�α��� 3.���̵� ã�� 4.��й�ȣ ã��");
			int ch = scanner.nextInt();
			if(ch==1) { //ȸ������
				System.out.println("----------------ȸ������ ������----------------");
				System.out.println("(���̵�� 4~12���� ���̿��� �մϴ�.)");
				System.out.print("���̵� �Է� : "); String id = scanner.next();
				System.out.print("��й�ȣ �Է� : "); String pw = scanner.next();
				System.out.print("��й�ȣ Ȯ�� : "); String pwcheck = scanner.next();
				System.out.print("�̸� �Է� : "); String name = scanner.next();
				System.out.print("�̸��� �Է� : "); String email = scanner.next();
				System.out.print("��ȭ��ȣ �Է� : "); String phone = scanner.next();

				int result = Controller.ȸ������(id,pw,pwcheck,name,email,phone);
				if(result == 1) {
					System.out.println("��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.");
				}
				else if(result == 2) {
					System.out.println("�ߺ��� ���̵��Դϴ�.");
				}
				else if(result == 3) {
					System.out.println("�ش� ��ȭ��ȣ�� ���̻� ������ �Ұ����մϴ�.");
				}
				else if(result == 4) {
					System.out.println("ȸ�����Կ� �����Ͽ����ϴ�.");
				}
				else if(result == 5) {
					System.out.println("���̵��� ���̴� 4~12���ڸ� �����մϴ�.");
				}
			}
			else if(ch==2) { // �α���
				System.out.print("���̵� �Է� : "); String id = scanner.next();
				System.out.print("��й�ȣ �Է� : "); String pw = scanner.next();
				int result = Controller.�α���(id,pw);
				if(result == 1) {
					System.out.println(id+"�� ȯ���մϴ�.");
					System.out.println();
					�α��θ޴�(id);
				}
				else if(result == 2) {
					System.out.println("���Ե� ���̵� �����ϴ�.");
				}
				else if(result == 3) {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}
			else if(ch==3) {
				System.out.print("�̸� �Է� : "); String name = scanner.next();
				System.out.print("��ȭ��ȣ �Է� : "); String phone = scanner.next();
				System.out.print("�̸��� �Է� : "); String email = scanner.next();
				String result = Controller.���̵�ã��(name,phone,email);
				if(result.equals("1")) {
					System.out.println("��ġ�ϴ� ������ �����ϴ�.");
				}else {
					System.out.println("ȸ������ ���̵�� \""+result+"\" �Դϴ�.");
				}
				
				//���̵� ã�� �޼ҵ�
			}
			else if(ch==4) {
				System.out.print("���̵� �Է� : "); String id = scanner.next();
				System.out.print("��ȭ��ȣ �Է� : "); String phone = scanner.next();
				System.out.print("�̸��� �Է� : "); String email = scanner.next();
				
				String result = Controller.��й�ȣã��(id,phone,email);
				if(result.equals("1")) {
					System.out.println("��ġ�ϴ� ������ �����ϴ�.");
				}else {
					System.out.println("ȸ������ ��й�ȣ�� \""+result+"\" �Դϴ�.");
				}
				//��й�ȣ ã�� �޼ҵ�
			}
			else {
			 System.out.println("���õ� ��ȣ �Է� �ٶ�");	
			}
			
		}
		
	}
	
	public static void �α��θ޴�(String id) {
		

		while(true){
			//�α�����
			System.out.println("1.ī�װ� ���� 2.���̹� (3.ȸ������ ���� 4.����[�ӽ�]) 5.�α׾ƿ�");
			int ch = scanner.nextInt();
			if(ch==1) {
				ī�װ��޴�(id);
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else if(ch==4) {
				
			}
			else if(ch==5) {break;} // �α׾ƿ�
			else {
				 System.out.println("���õ� ��ȣ �Է� �ٶ�");	
			}
		}
		
	}
	
	
	public static void ī�װ��޴�(String id) {
		while(true) {
			System.out.println("1.�۾��� 2.�ۺ��� 3.�˻� 4.���������� 5.���������� 6.�ڷΰ���");
			int ch2 = scanner.nextInt();
			if(ch2==1) { // �۾���
				scanner.nextLine();
				System.out.print("���� �Է� : "); String title = scanner.nextLine();
				System.out.println("���� �Է� : "); String content = scanner.nextLine();
				
				
			}
			else if(ch2==2) { // �ۺ���
				System.out.print("�� ��ȣ �Է� : "); int boardnum = scanner.nextInt();
				�ۻ󼼺���޴�(id,boardnum);
			}
			else if(ch2==3) { // �˻�
				System.out.println("���� �˻� : ");
			}
			else if(ch2==4) { // ����������
				
			}
			else if(ch2==5) { // ����������
				
			}
			else if(ch2==6) {break;} // �ڷΰ���
		}
		
	}
	
	public static void �ۻ󼼺���޴�(String id, int boardnum) {
		while(true) {
			System.out.println("1.��۴ޱ� 2.��ۼ��� 3.��ۻ��� 4.�ۼ��� 5.�ۻ��� 6.�ڷΰ���");
			int ch2 = scanner.nextInt();
			if(ch2==1) { // ��۴ޱ�
				
			}
			else if(ch2==2) { // ��ۼ��� 
				
				
			}
			else if(ch2==3) { // ��ۻ���
				
			}
			
			else if(ch2==4) { // �ۼ���
				boolean result = Controller.�ۼ������̵�üũ(id);
				if(result) {
					System.out.print("��й�ȣ �Է� : "); String pw = scanner.next();
					boolean result2 = Controller.�ۼ�����й�ȣüũ(id, pw);
					if(result2) {
						System.out.print("������ ���� �Է� : "); String title = scanner.next();
						scanner.next();
						System.out.print("������ ���� �Է� : "); String content = scanner.nextLine();
						Controller.�ۼ���(boardnum, title, content);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					}
				}else System.out.println("������ �ۼ��� �۸� ������ �����մϴ�.");
			}
			
			else if(ch2==5) { // �ۻ���
				boolean result = Controller.�ۼ������̵�üũ(id);
				if(result) {
					System.out.print("��й�ȣ �Է� : "); String pw = scanner.next();
					boolean result2 = Controller.�ۼ�����й�ȣüũ(id, pw);
					if(result2) {
						Controller.�ۻ���(id,pw,boardnum);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						break;
					} else System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					
				} else System.out.println("������ �ۼ��� �۸� ������ �����մϴ�.");
			}
			
			else if(ch2==6) {break;} // �ڷΰ���
		}
		
	}
	
	
	
}
