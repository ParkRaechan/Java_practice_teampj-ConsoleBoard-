package Main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
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
	
	public static void �α��θ޴�() {
		Scanner scanner = new Scanner(System.in);

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
}
