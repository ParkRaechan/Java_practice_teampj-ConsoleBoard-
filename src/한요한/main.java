package �ѿ���;

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
			if(ch==1) { //ȸ������
				System.out.println("----------------ȸ������ ������----------------");
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
				main.ī�װ��޴�(id);
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else if(ch==4) {
				
			}else if(ch==5) {
				
			}
			else {
				 System.out.println("���õ� ��ȣ �Է� �ٶ�");	
			}
		}	
	}
	
	public static void ī�װ��޴�(String id) {
			System.out.println("0.�û� 1.�߱�");
			int ī�װ����� = scanner.nextInt();
			while(true) {
					System.out.println("*** "+Controller.ī�װ�[ī�װ�����]+" ***");
					// ���
					System.out.println("����\t����\t��ȣ");
					for(Board temp : Controller.boardlist) {
						if(temp.getCategory().equals(Controller.ī�װ�[ī�װ�����])) {
							System.out.println(temp.getTitle() + temp.getContent() + temp.getIndex());
						}
					}
					System.out.println("------------"); //���м�
					System.out.println("1. �۾��� 2.�ۺ��� 3.�ڷΰ���"); int �ൿ���� = scanner.nextInt();//�����Է¹ޱ�
					if(�ൿ���� == 1) {
						System.out.println("����: "); String title = scanner.next(); //���� �Է¹ޱ�
						System.out.println("����: "); String content = scanner.next();//���� �Է¹ޱ�
						boolean pass = Controller.�۾���(id, title, content, Controller.ī�װ�[ī�װ�����]);
						if(pass) { //������
						System.out.println("���ۼ�����");	
						}else { // ���н�
						System.out.println("���ۼ�����");	
						}
					}else if(�ൿ���� == 2) {
						System.out.println("�۹�ȣ�Է�: "); int index = scanner.nextInt();
						boolean pass = Controller.�ۻ󼼺���(index);
						if(pass) { // ��ã�� ������
							while(true) {
								for(Board temp : Controller.boardlist) {
									if(temp.getIndex() == index) {
										System.out.println("�ۼ���: " + temp.getDate());
										System.out.println("��ȣ: "+ temp.getIndex()  +" ����: " + temp.getTitle() +" ī�װ�: "+ temp.getCategory());
										System.out.println("����: " + temp.getContent());
										System.out.println("��õ��: " + temp.getGood() +" ����: "+ temp.getBad() +" �Ű��: " + temp.getReport());
										System.out.println("----���â-----------------------------------------------------------");		
										
										if(temp.getReply() == null) {
											
										}else {
											int �ε��� = 0;
											for(Reply temp2 : temp.getReply()) {
												System.out.println(�ε��� + " ����: " + temp2.getContent());
												�ε���++;
											}// ��� ��� end
										}// ��� ��� if�� end
										break;
									}								
								}// ��� for�� end
								System.out.println("1.���� 2.���� 3.��۴ޱ� 4.��ۼ��� 5.��ۻ��� 6.�ڷΰ��� 7.��õ 8.����"); int ���� = scanner.nextInt();
								if(���� == 1) { // ����
									
								}else if(���� == 2) { // ����
									
								}else if(���� == 3) { // ��۴ޱ�
									System.out.println("����: "); String con = scanner.next();
									Controller.����ۼ�(con, index, id);
								}else if(���� == 4){ // ��ۼ���
									System.out.println("�����Ҵ���ε���: "); int ����ε��� = scanner.nextInt();
									System.out.println("�����ҳ���: "); 	  String ��ۼ��� = scanner.next();
									boolean pass2 = Controller.��ۼ���(index, ����ε���, ��ۼ���, id);
									if(pass2) {
										System.out.println("��ۼ��� ����");
									}else {
										System.out.println("��ۼ��� ����");
									}
								}else if(���� == 5) {// ��ۻ���
									System.out.println("�����Ҵ���ε���: "); int ����ε��� = scanner.nextInt();
									boolean pass2 = Controller.��ۻ���(index, ����ε���, id);
									if(pass2) {
										System.out.println("��ۻ��� ����");
									}else {
										System.out.println("��ۻ��� ����");
									}
								}else if(���� == 6) {// �ڷΰ���
									break;
								}else if(���� == 7) {
									Controller.��õ����(true, index, id);
								}else if(���� == 8) {
									Controller.��õ����(false, index, id);
								}
								else {
									System.out.println("�˼����� �ൿ");
								}
							}	
						}//��ã�� ���� if ��¹� end
						else {// ã�� ���н�
							System.out.println("�ش���� ã�����߽��ϴ�");
						}
					}else if(�ൿ���� == 3) { // �ڷΰ���
						main.�α��θ޴�(id);
					}else {
						System.out.println("�˼����� �ൿ");
					}	
		}// while end
	}// ī�װ� ���� end
	
	
	
}
