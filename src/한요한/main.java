package �ѿ���;

import java.security.PublicKey;
import java.util.Scanner;

public class main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while(true) {

			System.out.println(" -------------------------------------------------------------------------------------------");
			System.out.println("/                 *          *          *        **********      ***********               |        ");
			System.out.println("|                *          *          *         *                    *                    |        ");
			System.out.println("|               *          *          *          *                    *                    |        ");
			System.out.println("|              *          *          *           **********           *        6 6 6       |        ");
			System.out.println("|             * * *      * * *      * * *        *                    *                    |        ");
			System.out.println("|             *     *    *     *    *     *      *                    *       �������θ�Ʈ     |        ");
			System.out.println("|             *     *    *     *    *     *      *                    *                    |        ");
			System.out.println("|               * *        * *        * *        **********           *        Ŀ�´�Ƽ      /        ");
			System.out.println("-------------------------------------------------------------------------------------------");
			//�޴�
			System.out.println("1.ȸ������ 2.�α��� 3.���̵� ã�� 4.��й�ȣ ã��");
			int ch = scanner.nextInt();
			if(ch==1) {
				//ȸ������ �޼ҵ�
			}
			else if(ch==2) {
				//�α��� �޼ҵ�
				//�α��� �޴�
			}
			else if(ch==3) {
				//���̵� ã�� �޼ҵ�
			}
			else if(ch==4) {
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
				
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else if(ch==4) {
				
			}
			else {
				 System.out.println("���õ� ��ȣ �Է� �ٶ�");	
			}
		}	
	}
	
	public static void ī�װ��޴�(String id) {
		while(true) {
			System.out.println("1.�û� 2.�߱�");
			int ī�װ����� = scanner.nextInt();
			if(ī�װ����� == 1) {//�û�ī�װ�	
					System.out.println("*** �û� ***");
					//ī�װ� �����
					System.out.println("------------"); //���м�
					System.out.println("1. �۾��� 2.�ۺ��� 3.�ڷΰ���"); int �ൿ���� = scanner.nextInt();//�����Է¹ޱ�
					if(�ൿ���� == 1) {
						System.out.println("����: "); String title = scanner.next(); //���� �Է¹ޱ�
						System.out.println("����: "); String content = scanner.next();//���� �Է¹ޱ�
						boolean pass = Controller.�۾���(id, title, content, "�û�");
						if(pass) { //������
						System.out.println("���ۼ�����");	
						}else { // ���н�
						System.out.println("���ۼ�����");	
						}
					}else if(�ൿ���� == 2) {
						System.out.println("�۹�ȣ�Է�: "); int index = scanner.nextInt();
						boolean pass = Controller.�ۻ󼼺���(index);
						if(pass) { // ��ã�� ������
							for(Board temp : Controller.boardlist) {
								if(temp.getIndex() == index) {
									System.out.println("�ۼ���: " + temp.getDate());
									System.out.println("��ȣ: "+ temp.getIndex()  +" ����: " + temp.getTitle() +" ī�װ�: "+ temp.getCategory());
									System.out.println("����: " + temp.getContent());
									System.out.println("��õ��: " + temp.getGood() +" ����: "+ temp.getBad() +" �Ű��: " + temp.getReport());
									System.out.println("----���â-----------------------------------------------------------");
									for(Reply ��� : temp.getReply()) {
										System.out.println("����: " + ���.getContent() +" |�ۼ���: "+ ���.getWriter());
										System.out.println("��õ��: " + ���.getGood() + " |����: " + ���.getBad() + " |�Ű���: " + ���.getReport());
										System.out.println("----------------------------------------------------------------");
									}
								}
							}// ��� for�� end
							System.out.println("1.���� 2.���� 3.��۴ޱ� 4.�ڷΰ���"); int ���� = scanner.nextInt();
							if(���� == 1) {
								
							}else if(���� == 2) {
								
							}else if(���� == 3) {
							
							}else if(���� == 4){ // ���н� ������
							}
						}//��ã�� ���� id ��¹� end
					}else if(�ൿ���� == 3) {
						main.�α��θ޴�(id);
					}else {
						System.out.println("�˼����� �ൿ");
					}	
			}else if(ī�װ����� == 2) {//�߱�ī�װ�
				System.out.println("*** �߱� ***");
				//ī�װ� �����
				System.out.println("------------"); //���м�
				System.out.println("1. �۾��� 2.�ۺ��� 3.�ڷΰ���"); int �ൿ���� = scanner.nextInt();//�����Է¹ޱ�
				if(�ൿ���� == 1) {
					System.out.println("����: "); String title = scanner.next(); //���� �Է¹ޱ�
					System.out.println("����: "); String content = scanner.next();//���� �Է¹ޱ�
					boolean pass = Controller.�۾���(id, title, content, "�߱�");
					if(pass) {
					System.out.println("���ۼ�����");	
					}else {
					System.out.println("���ۼ�����");	
					}
				}else if(�ൿ���� == 2) {
					
				}else if(�ൿ���� == 3) {
					main.�α��θ޴�(id);
				}else {
					System.out.println("�˼����� �ൿ");
				}	
			}
		}// while end
	}// ī�װ� ���� end
	
	
	
}
