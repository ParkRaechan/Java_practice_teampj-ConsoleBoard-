package �ѿ���;

import java.util.ArrayList;
import java.util.Scanner;







public class main {
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
			
			���θ޴�();
			
		} // while end
		
	} // m e
	
	public static void �α��θ޴�(String id) {
		while(true){
			////////////////////////////////////////////�α�����
			for(int i = 0; i < Controller.ī�װ�.length ; i++) {
				ArrayList<Board> �α�� = Controller.�α��(Controller.ī�װ�[i]); // �� ī�װ� �α�� ��������
				System.out.println("ī�װ�: " + Controller.ī�װ�[i]);
				
				for(int j = 0; j < �α��.size() ; j++) {
					if(�α��.size() != 0) {
						System.out.println(�α��.get(j).getTitle()+ "\t"+ �α��.get(j).getGood() );	
					}
					if(i == 4) {
						break;
					}
				}
			}
			///////////////////////////////////////////////////
			System.out.println("1.ī�װ� ���� 2.���̹� 3.���������� 4.����Ȯ�� 5.�α׾ƿ�");
			int ch = scanner.nextInt();
			if(ch==1) {
				ī�װ��޴�(id);
			}
			else if(ch==2) {
				���̹�޴�(id);
			}
			else if(ch==3) { // ���� ������
				System.out.println("�޴� ��� id: "); String receiveid  = scanner.next();
				scanner.nextLine();
				System.out.println("����: "); String con = scanner.nextLine();
				
				boolean pass = Controller.����������(receiveid, id, con);
				if(pass) {
					System.out.println("����");
				}else {
					System.out.println("����");
				}
			}
			else if(ch==4) { // ����Ȯ��
				for(Acount temp : Controller.acountlist) {
					if(temp.getId().equals(id)) {
						for(����Ŭ���� temp2 : temp.get����()) {
							System.out.println("--------------------------------------------");
							System.out.print("��ȣ : "+temp2.get��ȣ()+"\t");
							System.out.print("������� : "+temp2.get�������()+"\t");
							System.out.print("�޴»�� : "+temp2.get�޴»��()+"\n");
							System.out.print("���� : "+temp2.get����()+"\n");
							System.out.println("--------------------------------------------");
						}
					}
				}
			}
			else if(ch==5) { // �α׾ƿ�
				scanner= new Scanner(System.in); 
				���θ޴�(); 
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
				for(Acount temp : Controller.acountlist) {
					if(temp.getId().equals(id)) { // �α����� ���̵𿡼� �������� ��� ��������
						if(temp.getBlockuser()==null) { // ���������� ������ ��ü ���
							for(Board temp3 : Controller.boardlist) {
								if(temp3.getCategory().equals(Controller.ī�װ�[ī�װ�����])) {
									System.out.println(temp3.getTitle()+ "\t" + temp3.getContent()+"\t"+temp3.getWriter()+"\t" + temp3.getIndex());
								}
							} // for end
						}
						else if(temp.getBlockuser()!=null){ // ���������� ������
							for(Board temp2 : Controller.boardlist) {
								if(temp.getBlockuser().contains(temp2.getWriter())  ) { // �α����� ���̵��� ����������Ͽ� ���ۼ��ڰ� ���ԵǾ�������
									System.out.println("���ܵ� ������ ��");
								}
								else {
									System.out.println(temp2.getTitle()+ "\t" + temp2.getContent()+"\t"+temp2.getWriter()+"\t" + temp2.getIndex());
								}
							}
						}
						
					} // if end
				} // for end

				System.out.println("------------"); //���м�
				ī�װ�����(id,ī�װ�����);
					
		} // while end
} // ī�װ� ���� end
	

	////////////////////////////////////////////////////////////////////////
	
	public static void ���θ޴�() {
		while(true) {
			System.out.println("1.ȸ������ 2.�α��� 3.���̵� ã�� 4.��й�ȣ ã��");
			int ch = scanner.nextInt();
			if(ch==1) { ȸ������(); } //ȸ������
			else if(ch==2) { �α���(); } // �α���
			else if(ch==3) { ���̵�ã��(); } 	//���̵� ã��
			else if(ch==4) { ��й�ȣã��(); } //��й�ȣ ã�� �޼ҵ�
			else { System.out.println("���õ� ��ȣ �Է� �ٶ�");}
		}
		
	}
	
	public static void ȸ������() {	
		System.out.println("\t\t\t----------------ȸ������ ������----------------");
		System.out.println("\t\t\t(���̵�� 4~12���� ���̿��� �մϴ�.)");
		scanner.nextLine();
		System.out.print("\t\t\t���̵� �Է� : "); String id = scanner.nextLine();
		int idresult = Controller.ȸ�����Ծ��̵�(id);
		if(idresult==1) System.out.println("\t\t\t���� Ȥ�� Ư�����ڰ� �ԷµǾ����ϴ�.");
		else if(idresult==2) System.out.println("\t\t\t���̵��� ���̴� 4~12���ڸ� �����մϴ�.");
		else if(idresult==3) System.out.println("\t\t\t�ߺ��� ���̵��Դϴ�.");
		else if(idresult==4) {
			System.out.print("\t\t\t��й�ȣ �Է� : "); String pw = scanner.nextLine();
			System.out.print("\t\t\t��й�ȣ Ȯ�� : "); String pwcheck = scanner.nextLine();
			int pwresult = Controller.ȸ�����Ժ�й�ȣ(pw, pwcheck);
			if(pwresult==1) System.out.println("\t\t\t��й�ȣ�� ������ ���Ե� �� �����ϴ�.");
			else if(pwresult==2) System.out.println("\t\t\t��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.");
			else if(pwresult==3) {
				System.out.print("\t\t\t�̸� �Է� : "); String name = scanner.next();
				System.out.print("\t\t\t�̸��� �Է� : "); String email = scanner.next();
				System.out.print("\t\t\t��ȭ��ȣ �Է� : "); String phone = scanner.next();
				boolean result = Controller.ȸ������(id,pw,pwcheck,name,email,phone);
				if(result) System.out.println("\t\t\tȸ�����Կ� �����Ͽ����ϴ�.");
				else System.out.println("\t\t\t�ش� ��ȭ��ȣ�� ���̻� ������ �Ұ����մϴ�.");
			}
		}
	
	}
	
	public static void �α���() {
		String id = null;
		String pw = null;
		System.out.print("���̵� �Է� : "); id = scanner.next();
		System.out.print("��й�ȣ �Է� : "); pw = scanner.next();
		int result = Controller.�α���(id,pw);
		if(result == 1) {
			System.out.println(id+"�� ȯ���մϴ�.");
			System.out.println();
			///////////////// ���߿� �����/ ����Ʈ+100 ////////////////////
			for(Acount temp : Controller.acountlist) {
				if(temp.getId().equals(id)) {
					temp.setPoint(temp.getPoint()+100);
				}
			}
			///////////////////////////////////////////////////
			�α��θ޴�(id);
		}
		else if(result == 2) {
			System.out.println("���Ե� ���̵� �����ϴ�.");
		}
		else if(result == 3) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}
	
	public static void ���̵�ã��() {
		System.out.print("�̸� �Է� : "); String name = scanner.next();
		System.out.print("��ȭ��ȣ �Է� : "); String phone = scanner.next();
		System.out.print("�̸��� �Է� : "); String email = scanner.next();
		String result = Controller.���̵�ã��(name,phone,email);
		if(result.equals("1")) {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		}else {
			System.out.println("ȸ������ ���̵�� \""+result+"\" �Դϴ�.");
		}
	}
	
	public static void ��й�ȣã��() {
		System.out.print("���̵� �Է� : "); String id = scanner.next();
		System.out.print("��ȭ��ȣ �Է� : "); String phone = scanner.next();
		System.out.print("�̸��� �Է� : "); String email = scanner.next();
		
		String result = Controller.��й�ȣã��(id,phone,email);
		if(result.equals("1")) {
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
		}else {
			System.out.println("ȸ������ ��й�ȣ�� \""+result+"\" �Դϴ�.");
		}
	}
	
	public static void ī�װ�����(String id, int ī�װ�����) {
		System.out.println("1.�۾��� 2.�ۺ��� 3.�˻� 4.���������� 5.���������� 6.�ڷΰ���"); int �ൿ���� = scanner.nextInt();//�����Է¹ޱ�
		if(�ൿ���� == 1) {
			System.out.println("����: "); String title = scanner.next(); //���� �Է¹ޱ�
			System.out.println("����: "); String content = scanner.next();//���� �Է¹ޱ�
			boolean pass = Controller.�۾���(id, title, content, Controller.ī�װ�[ī�װ�����]);
			if(pass) { //������
			System.out.println("���ۼ�����");	
			}else { // ���н�
			System.out.println("���ۼ�����");	
			}
		}else if(�ൿ���� == 2) { // �ۺ���
			�ۺ���(id,ī�װ�����);
		}else if(�ൿ���� == 3) { // �˻�
			System.out.println("���� �˻� : "); String serch = scanner.next();
			
			
			ArrayList<Board> result = Controller.�˻�(serch);
			
			System.out.println("---------------------�˻� ���---------------------------");
			for(Board temp : result) {
				System.out.println(temp.getTitle()+"\t"+temp.getContent()+"\t"+temp.getIndex());
			}
			System.out.println("-------------------------------------------------------");
			
		}else if(�ൿ���� == 4) { // ���������� // ����ã�� �ӽ��׽�Ʈ
/////////////////////////////////////////////////////////////////////
			
	/////////////////////////////////////////////////////////////////////////////	
		}else if(�ൿ���� == 5) { // ����������
			
		}else if(�ൿ���� == 6) { // �ڷΰ���
			�α��θ޴�(id);
		}else {
			System.out.println("�˼����� �ൿ");
		}
	}
	
	public static void �ۺ���(String id, int ī�װ�����) {
		System.out.println("�۹�ȣ�Է�: "); int index = scanner.nextInt();
		boolean pass = Controller.�ۻ󼼺���(id, index);
		if(pass) { // ��ã�� ������
			while(true) {
				for(Board temp : Controller.boardlist) {
					if(temp.getIndex() == index) {
						System.out.println("�ۼ���: " + temp.getDate());
						System.out.println("��ȣ: "+ temp.getIndex()  +" ����: " + temp.getTitle() +" ī�װ�: "+ temp.getCategory());
						System.out.println("����: " + temp.getContent());
						System.out.println("��õ��: " + temp.getGood() +" ����: "+ temp.getBad() +" �Ű��: " + temp.getReport());
						System.out.println("----���â-----------------------------------------------------------");		
						
						if(temp.getReplylist() == null) {
							
						}else {
							int �ε��� = 0;
							for(Reply temp2 : temp.getReplylist()) {
								System.out.println(�ε��� + " ����: " + temp2.getContent());
								�ε���++;
							}// ��� ��� end
						}// ��� ��� if�� end
						break;
					}								
				}// ��� for�� end
				
				System.out.println("1.���� 2.���� 3.��۴ޱ� 4.��ۼ��� 5.��ۻ��� 6.�Ű��ϱ� 7.�ڷΰ��� 8.��õ 9.����"); int ���� = scanner.nextInt();
				////////////////////////////// �� ���� //////////////////////////////////////////////////
				if(���� == 1) {
					boolean result = Controller.�ۼ������̵�üũ(id);
					if(result) {
						System.out.print("��й�ȣ �Է� : "); String pw = scanner.next();
						boolean result2 = Controller.�ۼ�����й�ȣüũ(id, pw);
						if(result2) {
							System.out.print("������ ���� �Է� : "); String title = scanner.next();
							scanner.next();
							System.out.print("������ ���� �Է� : "); String content = scanner.nextLine();
							Controller.�ۼ���(index, title, content);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						}
					}else System.out.println("������ �ۼ��� �۸� ������ �����մϴ�.");
				//////////////////////////////////// �� ���� ////////////////////////////////////////	
				}else if(���� == 2) {
					boolean result = Controller.�ۼ������̵�üũ(id);
					if(result) {
						System.out.print("��й�ȣ �Է� : "); String pw = scanner.next();
						boolean result2 = Controller.�ۼ�����й�ȣüũ(id, pw);
						if(result2) {
							Controller.�ۻ���(id,pw,index);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							break;
						} else System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						
					} else System.out.println("������ �ۼ��� �۸� ������ �����մϴ�.");
				/////////////////////////////////// ��� �ޱ� /////////////////////////////////////////
				}else if(���� == 3) { 
					System.out.println("����: "); String con = scanner.next();
					Controller.����ۼ�(con, index, id);
				/////////////////////////////////// ��� ���� ///////////////////////////////////////////
				}else if(���� == 4){ 
					System.out.println("�����Ҵ���ε���: "); int ����ε��� = scanner.nextInt();
					System.out.println("�����ҳ���: "); 	  String ��ۼ��� = scanner.next();
					boolean pass2 = Controller.��ۼ���(index, ����ε���, ��ۼ���, id);
					if(pass2) {
						System.out.println("��ۼ��� ����");
					}else {
						System.out.println("��ۼ��� ����");
					}
				///////////////////////////////////// ��ۻ���//////////////////////////////////////////////////
				}else if(���� == 5) {
					System.out.println("�����Ҵ���ε���: "); int ����ε��� = scanner.nextInt();
					boolean pass2 = Controller.��ۻ���(index, ����ε���, id);
					if(pass2) System.out.println("��ۻ��� ����");
					else System.out.println("��ۻ��� ����");
				}else if(���� ==6) { // �Ű�
					System.out.println("�Ű��� ������ �ڵ����� ���ܵ˴ϴ�. ���� �Ű��Ͻðڽ��ϱ�?");
					System.out.println("1.�Ű��ϱ� 2.���");
					int ch = scanner.nextInt();
					if(ch==1) {
						boolean result = Controller.�Ű�(id, index);
						if(result) {
							System.out.println("\t\t\t�Ű� �Ϸ�Ǿ����ϴ�.");
							ī�װ�����(id,ī�װ�����);
						}
						else System.out.println("�ڽ��� ���̵�� �Ű� �Ұ����մϴ�.");
						
					}else if(ch==2) {
						
					}
					
				}
				else if(���� == 7) {	break;} // �ڷΰ���
				else if(���� == 8) {
					Controller.��õ����(true, index, id);
				}
				else if(���� == 9) {
					Controller.��õ����(false, index, id);
				}
				else System.out.println("�˼����� �ൿ");
			} // while end	
			
		}//��ã�� ���� if ��¹� end
		else {// ã�� ���н�
			System.out.println("�ش���� ã�����߽��ϴ�");
		}
	}

	public static void ���̹�޴�(String id) {
		System.out.println("\t\t\t1.����Ʈ���� 2.����Ʈ��ŷ 3. ����ã�� 4.�ڷΰ���");
		int ch = scanner.nextInt();
		if(ch==1) { // ����Ʈ����
			String[] result = Controller.����(id);
			if(result[0].equals("[ ]")) {
				System.out.println("\t\t\t���� ����Ʈ�� �����ؼ� ������ �� �����ϴ�.");
			}
			else {
				System.out.print("\t\t\t");
				for(int i=0; i<result.length; i++) {
					System.out.print(result[i]);
				}
				int result2 = Controller.���ǰ��(result,id);
				
				if(result2==1) System.out.println("\n\t\t\t1�� 1000����Ʈ ��÷");
				else if(result2==2) System.out.println("\n\t\t\t2�� 300����Ʈ ��÷");
				else if(result2==3) System.out.println("\n\t\t\t3�� 100����Ʈ ��÷");
				else if(result2==4) System.out.println("\n\t\t\t4�� 10����Ʈ ��÷");
				else if(result2==5) System.out.println("\n\t\t\t��");
			}
			���̹�޴�(id);
		}
		
		else if(ch==2) {
			ArrayList<Acount> ranking = Controller.����Ʈ��ŷ();
			int i=1;
			for(Acount temp : ranking) {
				System.out.println("\t\t\t"+i+"��\t"+temp.getId()+"\t"+temp.getPoint());
				i++;
			}
			���̹�޴�(id);
			
		}else if(ch == 3) {
			//1.������ �ʱ�ȭ
			while(true) { // ���α׷�����
				int �������ε��� = 0; 
				for(String temp : Controller.������) { // ���� for ��������
					if(temp != "[��]") {Controller.������[�������ε���] = "[��]";}// "[��]" �ʱ�ȭ
					�������ε���++;	//�����ε���
				}
				System.out.println("������â�� 1�� 3ȸ 30��");
				System.out.println("1.�̱� 2.�ڷΰ���"); int ch2 = scanner.nextInt(); // �����Է¹ޱ�
				if(ch2 == 1) {// �̱� ����
					boolean pass = true; // �� pass üũ
					for(Acount temp : Controller.acountlist) { //ȸ��������
						if(temp.getId().equals(id)) { // id ��ġ�ϸ�
							if(temp.getPoint() < 30) { // �� üũ
								System.out.println("������");
								pass = false; 			// ������� ����ġ ��Ȱ
							}
						}
					}
					if(pass) {// ���� �ִٸ�
						int ��ȸ = 3;
						int[] ��� = Controller.����ã����Ӽ���(); // ��÷��ȣ �ʱ�ȭ
						for(int  j= 0 ; j < 3 ; j++, ��ȸ--) { // 3�� ������
							//������ ���
							for(int i = 0; i < Controller.������.length ; i++) {
								System.out.print(Controller.������[i]);
								if(i % 5 == 4) {System.out.println();} // �ٹٲ�
							}
							System.out.println("������ȸ: "+ ��ȸ +" | �ε�������: "); int ���� = scanner.nextInt(); // �ε����ޱ�
							int ��÷���� = Controller.����ã��(����, id, ���); //����ã�� �޼ҵ� ȣ��
							if(��ȸ == 0) { break; }// ���ӳ���ȸ�� ������
							if(��÷���� == 1) {System.out.println("1�� ��÷");}
							else if(��÷���� == 2) {System.out.println("2�� ��÷");}
							else if(��÷���� == 3) {	System.out.println("3�� ��÷");}
							else if(��÷���� == -1) {System.out.println("��");}
						}
						//������ ���
						for(int i = 0; i < Controller.������.length ; i++) {
							System.out.print(Controller.������[i]);
							if(i % 5 == 4) {System.out.println();} // �ٹٲ�
						}
						System.out.println("��������");
					}else {System.out.println("������");}
				}else if(ch2 == 2) { // �ڷΰ���	
					
				}else {System.out.println("�˼����� ����");}
			}			
		}
		else if(ch== 4) {
			�α��θ޴�(id);
		}
		else { System.out.println("\t\t\t���õ� ��ȣ �Է� �ٶ�"); ���̹�޴�(id);}
		
	}
	
} // c e
