package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;






public class Controller {

	static LocalDateTime yourDate;
	static String yourCategory;
	static int yourStoryNum;
	
	public static ArrayList<Acount> acountlist = new ArrayList<>();
	public static ArrayList<Board> boardlist = new ArrayList<>();
	public static ArrayList<Â÷´ÜÀ¯Àú> Â÷´ÜÀ¯Àúlist = new ArrayList<>();

	
	public static int boardtnum = 1;
	public static String[] Ä«Å×°í¸® = {"½Ã»ç","¾ß±¸"}; 
	public static String[] Æ÷ÀÎÆ®º¹±Ç = new String[6];
	public static String[] °ÔÀÓÆÇ = {"[¡á]","[¡á]","[¡á]","[¡á]","[¡á]",
			  "[¡á]","[¡á]","[¡á]","[¡á]","[¡á]",
			  "[¡á]","[¡á]","[¡á]","[¡á]","[¡á]"};// 0 ~ 14 ÀÎµ¦½º
	
	
	public static int È¸¿ø°¡ÀÔ¾ÆÀÌµğ(String id) {
		String pattern = "^[0-9|a-z|A-Z|¤¡-¤¾|¤¿-¤Ó|°¡-ÆR]*$";
		if(!Pattern.matches(pattern, id)){
			  return 1; // ¾ÆÀÌµğ¿¡ Æ¯¼ö¹®ÀÚ or °ø¹éÀÌ µé¾î°¨
			}
		if(id.length()<4 || id.length()>13) {
			return 2; // ¾ÆÀÌµğ±æÀÌ°¡ 4~12ÀÚ¸®°¡ ¾Æ´Ô
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				return 3; // ¾ÆÀÌµğ Áßº¹
			}
		}
		return 4; // Á¤»óÀûÀÎ ¾ÆÀÌµğ
	}
	
	public static int È¸¿ø°¡ÀÔºñ¹Ğ¹øÈ£(String pw, String pwcheck) {
		
		if(pw.contains(" ")) {
			  return 1; // ºñ¹Ğ¹øÈ£¿¡ °ø¹é Æ÷ÇÔ
			}
		if(!pw.equals(pwcheck)) {
			return 2; // ºñ¹Ğ¹øÈ£ È®ÀÎ Æ²¸²
		}
		return 3; // Á¤»óÀûÀÎ ºñ¹Ğ¹øÈ£
	}
	
	public static boolean È¸¿ø°¡ÀÔ(String id, String pw, String pwcheck, String name, String email, String phone) throws IOException {
		for(Acount temp : acountlist) {
			if(temp.getPhone().equals(phone)) {
				return false; // ÇØ´ç ÀüÈ­¹øÈ£·Î °¡ÀÔÇÑ È¸¿øÀÌ ÀÖÀ½
			}
		}
		Acount temp = new Acount(id, pw, name, email, phone, 0, 0, null );
		acountlist.add(temp);
		Controller.È¸¿øÆÄÀÏÃ³¸®(id);
		return true; // È¸¿ø°¡ÀÔ ¼º°ø
		
	}
	
	
	
	///////////////////////////////////È¸¿øÆÄÀÏ Ã³¸® ½ÃÀÛ/////////////////////////////////////////////
	static void È¸¿øÆÄÀÏÃ³¸®(String id) throws IOException{
		
		//È¸¿øÀúÀå
			//ÆÄÀÏ¿¡ [¾ÆÀÌµğ,ºñ¹ø,ÀÌ¸§,ÀÌ¸ŞÀÏ,Æù¹ø]Çü½ÄÀ¸·Î ÀúÀå
		FileOutputStream out_a = new FileOutputStream("D:/java/È¸¿øtest.txt");
		String storage_a1="";
		for(Acount temp001 : acountlist) {
				id = temp001.getId();
				String pw = temp001.getPw();
				String name = temp001.getName();
				String email = temp001.getEmail();
				String phone = temp001.getPhone();
				int point = temp001.getPoint();
				int report = temp001.getReport();
				String friend = null;
				
			
				String storage_a = id+","+pw+","+name+","+email+","+phone+","+Integer.toString(point)+","+Integer.toString(report)+","+friend+"\n";		
				
				storage_a1 =storage_a1+ storage_a;
					
				
		}

		out_a.write(storage_a1.getBytes());		
	
		
	}//È¸¿øe
	
	
	public static boolean È¸¿øÃâ·Â() throws IOException {
		
		FileInputStream input_a = new FileInputStream("D:/java/È¸¿øtest.txt");
		byte[] bytes_a = new byte[1024]; // ¹ÙÀÌÆ®¹è¿­¼±
		input_a.read(bytes_a);				// ¹ÙÀÌÆ® ÀĞ±â
		String str_a = new String(bytes_a); // ÀÏ¾î¿Â°Å ÀúÀå
		String[] È¸¿ø1 = str_a.split("\n"); //1È¸±Û¸¶´Ù ÀÚ¸£±â
		for(int t = 0; t < È¸¿ø1.length-1 ; t++) {	// È¸´ç¸ÅÃâ±æÀÌ¸¸Å­ ¹İº¹
			if(È¸¿ø1[t] != null && !È¸¿ø1[t].equals("") ) {
				String[] È¸¿ø¿ä¼Ò = È¸¿ø1[t].split(",");
				String a_a = È¸¿ø¿ä¼Ò[0]; // È¸¿ø ¾ÆÀÌµğ
				String b_a = È¸¿ø¿ä¼Ò[1]; // È¸¿ø ºñ¹ø
				String c_a = È¸¿ø¿ä¼Ò[2]; // È¸¿ø ÀÌ¸§
				String d_a = È¸¿ø¿ä¼Ò[3]; // È¸¿ø ÀÌ¸ŞÀÏ
				String e_a = È¸¿ø¿ä¼Ò[4]; // È¸¿ø Æù¹ø
				String f_a = È¸¿ø¿ä¼Ò[5]; // È¸¿ø Æ÷ÀÎÆ®
				
				String h_a = È¸¿ø¿ä¼Ò[6]; // È¸¿ø ½Å°í
				String i_a = È¸¿ø¿ä¼Ò[7]; // È¸¿ø Ä£±¸

				Acount o_a = new Acount(a_a,b_a,c_a,d_a,e_a,Integer.parseInt(f_a),Integer.parseInt(h_a),i_a);
				
				//¹è¿­¿¡ ÆÄÀÏ ¿ä¼Ò°ª ÀúÀå
				Controller.acountlist.add(o_a);
			
			}
		}
		return true; //ÀÏº°¸ÅÃâ ¸®ÅÏ
	}
	
	                       ///////È¸¿ø³»ºÎ Â÷´ÜÀ¯Àú ÆÄÀÏÃ³¸® ½ÃÀÛ/////////   
	static void Â÷´ÜÆÄÀÏÃ³¸®(String id) throws IOException {
		for(Â÷´ÜÀ¯Àú temp : Â÷´ÜÀ¯Àúlist) {
			if(temp.getIndex().equals(id)) {
				FileOutputStream out_c = new FileOutputStream("D:/java/Â÷´ÜÀ¯Àútest.txt",true);
				String storage_c = id+"@@"+temp.getTarget()+"\n";		
				out_c.write(storage_c.getBytes());		
				
			}
		}
	}
	
	public static boolean Â÷´ÜÃâ·Â() throws IOException {
		
		FileInputStream input_c = new FileInputStream("D:/java/Â÷´ÜÀ¯Àútest.txt");
		byte[] bytes_c = new byte[1024]; // ¹ÙÀÌÆ®¹è¿­¼±
		input_c.read(bytes_c);				// ¹ÙÀÌÆ® ÀĞ±â
		String str_c = new String(bytes_c); // ÀÏ¾î¿Â°Å ÀúÀå
		String[] Â÷´Ü1 = str_c.split("\n"); //1È¸±Û¸¶´Ù ÀÚ¸£±â
		for(int t = 0; t < Â÷´Ü1.length-1 ; t++) {	// È¸´ç¸ÅÃâ±æÀÌ¸¸Å­ ¹İº¹
			if(Â÷´Ü1[t] != null ) {
				String[] Â÷´Ü¿ä¼Ò = Â÷´Ü1[t].split("@@");
				
				String a_c = Â÷´Ü¿ä¼Ò[0]; 
				String b_c = Â÷´Ü¿ä¼Ò[1]; 

				Â÷´ÜÀ¯Àú o_c = new Â÷´ÜÀ¯Àú(a_c,b_c);
				
				//¹è¿­¿¡ ÆÄÀÏ ¿ä¼Ò°ª ÀúÀå
				Controller.Â÷´ÜÀ¯Àúlist.add(o_c);
			
			}
		}
		return true; 
	}
	                          //////È¸¿ø³»ºÎ Â÷´ÜÀ¯Àú ÆÄÀÏÃ³¸® ³¡//////
	
	
	
	
	///////////////////////////////////È¸¿øÆÄÀÏ Ã³¸® ³¡/////////////////////////////////////////////

	public static int ·Î±×ÀÎ(String id, String pw) {
		boolean idcheck = false;
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				idcheck = true;
			}
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getPw().equals(pw)) {
				return 1; // ·Î±×ÀÎ ¼º°ø
			}
		}
		if(idcheck==false) {
			return 2; // °¡ÀÔµÈ ¾ÆÀÌµğ°¡ ¾øÀ½
		}
		return 3; // ºñ¹Ğ¹øÈ£ Æ²¸²
	}

	
	public static boolean ±Û¾²±â(String id, String title, String content, String category) throws IOException {//¿äÇÑ
		//id, Á¦¸ñ, ³»¿ë, ÀÛ¼ºÀÚid, Ä«Å×°í¸® ¹Ş¾Æ¿À±â
		LocalDateTime date= LocalDateTime.now();// ÇöÀç³¯Â¥»ı¼º
		//¹øÈ£ ºÒ·¯¿À±â
		for(Board temp : boardlist) {
			if(boardtnum > temp.getIndex()) {
				boardtnum = temp.getIndex() + 1;
			}else {
				boardtnum++;
			}
		}
		yourDate = date;
		yourCategory = category;
		yourStoryNum = boardtnum;
		Controller.°Ô½Ã¹°ÆÄÀÏÃ³¸®(title,content, id,Controller.yourDate,0,Controller.yourCategory,0,0,0,Controller.yourStoryNum);
		
		//Á¦¸ñ, ³»¿ë, ÀÛ¼ºÀÚ, ³¯Â¥, Á¶È¸¼ö, Ä«Å×°í¸®, ÃßÃµ¼ö, ºñÃßÃµ¼ö, ´ñ±ÛÅ¬·¡½º, ½Å°í´©ÀûÈ½¼ö °´Ã¼È­ÈÄlistÀÇ ÀúÀå
		boardlist.add(new Board(title, content, id, date, 0, category, 0, 0, 0, boardtnum));
		boardtnum++;
		/* ÆÄÀÏÃ³¸® ¸Ş¼Òµå Ã³¸® ¼º°ø½Ã true¹İÈ¯
		 * 
		 */		
		return true;// ÀÓ½Ã¹İÈ¯
	}
	public static boolean ±Û»ó¼¼º¸±â(String id, int index) {// ÀÎµ¦½ºÀÏÄ¡ÇÏ´Â ¹øÈ£ Ã£ÀºÈÄ ±ÛÀÌ ÀÖÀ½ ¹İÈ¯
		ArrayList<String> templist = new ArrayList<>();
		for (Acount temp2 : Controller.acountlist) {
			for (Â÷´ÜÀ¯Àú temp : Controller.Â÷´ÜÀ¯Àúlist) {
				if (temp2.getId().equals(id) && temp.getIndex().equals(id)) {
					templist.add(temp.getTarget());
				}
			}
		}
		
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && !templist.isEmpty() ) { // ·Î±×ÀÎÇÑ ¾ÆÀÌµğÀÇ Â÷´ÜÀ¯Àú¸ñ·ÏÀÌ ÀÖÀ¸¸é
				for(Board temp2 : boardlist) {
					if(temp2.getIndex()==index && templist.contains(temp2.getWriter()) ) {
						// ÇØ´ç ÀÎµ¦½ºÀÇ ±Û ÀÛ¼ºÀÚ°¡ Â÷´ÜÀ¯Àú¸ñ·Ï¿¡ Æ÷ÇÔµÇ¾î ÀÖÀ¸¸é
						return false; // ÇØ´ç ±Û º¼·¯¿À±â ½ÇÆĞ
					}
				}
			}
		}
		//index ¹Ş¾Æ¿Í¼­ ÇØ´ç±ÛÃ£±â
		 //ÀÎµ¦½º¹øÈ£
		for(Board temp : boardlist) {
			if(temp.getIndex() == index) {
				//Ã£Àº ÀÎµ¦½º ¹øÈ£ ÀÖ´Ù°í true ¹İÈ¯
				return true;
			}
		}
		return false;	
	}
	
	
	////////////////////////////////////±Û¾²±â ÆÄÀÏÃ³¸® ½ÃÀÛ////////////////////////////////////////////////////

	static void °Ô½Ã¹°ÆÄÀÏÃ³¸®(String title,String content,String writer,LocalDateTime date,int view, String category,int good,int bad,int report,int index) throws IOException{
		//°Ô½Ã¹°ÀúÀå
			//ÆÄÀÏ¿¡ [Á¦¸ñ,³»¿ë,±Û¾´ÀÌ,¿ù,ÀÏ,½Ã°£,Á¶È¸¼ö,Ä«Å×°í¸®,ÃßÃµ,ºñÃßÃµ,½Å°í´©Àû¼ö]Çü½ÄÀ¸·Î ÀúÀå
		FileOutputStream out = new FileOutputStream("D:/java/°Ô½Ã¹°test.txt",true);
		String storage = title+","+content+","+writer+","+date.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"))+","+Integer.toString(view)+","+category+","+Integer.toString(good)+","+Integer.toString(bad)+","+Integer.toString(report)+","+Integer.toString(index)+"\n";
		out.write(storage.getBytes());		
	}//±ÛÈ®ÀÎe
	
	
	public static boolean °Ô½Ã¹°Ãâ·Â() throws IOException {
		
		FileInputStream input = new FileInputStream("D:/java/°Ô½Ã¹°test.txt");
		byte[] bytes = new byte[1024]; // ¹ÙÀÌÆ®¹è¿­¼±
		input.read(bytes);				// ¹ÙÀÌÆ® ÀĞ±â
		String str = new String(bytes); // ÀÏ¾î¿Â°Å ÀúÀå
		String[] ±Û1 = str.split("\n"); //1È¸±Û¸¶´Ù ÀÚ¸£±â
		for(int t = 0; t < ±Û1.length-1 ; t++) {	// È¸´ç¸ÅÃâ±æÀÌ¸¸Å­ ¹İº¹
			//String lastCharacter = ±Û1[t].substring(±Û1[t].length() - 1);
			if(±Û1[t] != null && !±Û1[t].equals("") ) {
				String[] °Ô½Ã¹°¿ä¼Ò = ±Û1[t].split(",");
				String a = °Ô½Ã¹°¿ä¼Ò[0]; // °Ô½Ã¹° Á¦¸ñ
				String b = °Ô½Ã¹°¿ä¼Ò[1]; // °Ô½Ã¹° ³»¿ë
				String c = °Ô½Ã¹°¿ä¼Ò[2]; // ÀÛ¼ºÀÚ
				String d = °Ô½Ã¹°¿ä¼Ò[3]; // ³¯Â¥

				
				// D(String ) -> LocaldateTime Çüº¯È¯				
				DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				LocalDateTime dd = LocalDateTime.parse( d , formatter);
				
				String e = °Ô½Ã¹°¿ä¼Ò[4]; // Á¶È¸¼ö
				String f = °Ô½Ã¹°¿ä¼Ò[5]; // Ä«Å×°í¸®
				String g = °Ô½Ã¹°¿ä¼Ò[6]; // ÃßÃµ¼ö
				String h = °Ô½Ã¹°¿ä¼Ò[7]; // ºñÃßÃµ¼ö
				String i = °Ô½Ã¹°¿ä¼Ò[8];  // ½Å°í´©ÀûÈ½¼ö
				String j = °Ô½Ã¹°¿ä¼Ò[9]; //±Û¹øÈ£
				Board o = new Board(a,b,c,dd,Integer.parseInt(e),f,Integer.parseInt(g),Integer.parseInt(h),Integer.parseInt(i),Integer.parseInt(j));
				
				//¹è¿­¿¡ ÆÄÀÏ ¿ä¼Ò°ª ÀúÀå
				Controller.boardlist.add(o);
			
			}
		}
		return true; //ÀÏº°¸ÅÃâ ¸®ÅÏ
	}
	////////////////////////////////////±Û¾²±â ÆÄÀÏÃ³¸® ³¡////////////////////////////////////////////////////
	
	
	public static void ´ñ±ÛÀÛ¼º(String con, int index, String id) {
		LocalDateTime date = LocalDateTime.now();
		for(Board temp : Controller.boardlist) {
			if(temp.getIndex() == index) { // °°ÀºÀÎµ¦½º¹øÈ£ÀÇ ±ÛÀÌÀÖÀ¸¸é
				Reply e = new Reply(con, id, date,0,0,0,index);
				temp.getReplylist().add(e);
				break;
			}
		}
	}
	public static boolean ±Û¼öÁ¤¾ÆÀÌµğÃ¼Å©(String id, int index) {
		for(Board temp : boardlist) {
			if(temp.getWriter().equals(id) && temp.getIndex()==index) {return true;}
		}
		return false;
	}
	public static boolean ±Û¼öÁ¤ºñ¹Ğ¹øÈ£Ã¼Å©(String id,String pw,int index) {
		for(Board temp : boardlist) {
				for(Acount temp2 : acountlist) {
					if(temp.getWriter().equals(id) && temp2.getPw().equals(pw) && temp.getIndex()==index) {
						return true;
					}
				}
		}
		return false;
	}
	public static void ±Û¼öÁ¤(int boardnum, String title, String content) {
		boardlist.get(boardnum).setTitle(title);
		boardlist.get(boardnum).setContent(content);
	}


	public static void ±Û»èÁ¦(String id, String pw, int index) {
		boolean delete = false;
		for(Board temp2 : boardlist) {
			if(temp2.getIndex()==index) {
				for(Acount temp : acountlist) {
					if(temp.getPw().equals(pw) && temp.getId().equals(id)) {
						delete = true;

					}
				}
			}
			
		}
		if(delete) {
			for(Board temp : boardlist) {
				if(temp.getIndex()==index) {
					boardlist.remove(temp);
					break;
				}
			}
			
		}
	}
	
	
	public static ArrayList<Board> °Ë»ö(String serch) {
		ArrayList<Board> °Ë»ö°á°ú = new ArrayList<Board>();
		°Ë»ö°á°ú.clear();
		for(Board temp : boardlist) {
			if(temp.getTitle().indexOf(serch)!=-1) {
				Board temp2 = new Board(temp.getTitle(), temp.getContent(), temp.getWriter(), 
						temp.getDate(), temp.getView(), temp.getCategory(), temp.getGood(), temp.getBad(), 
						temp.getReplylist(), temp.getReport(), temp.getIndex());
				°Ë»ö°á°ú.add(temp2);
				return °Ë»ö°á°ú; // °Ë»ö°á°ú Ãâ·Â
			}
		}
		return °Ë»ö°á°ú;
	}
	
	
	public static ArrayList<Board> ÀÎ±â±Û(String Ä«Å×°í¸®) {// Ä«Å×°í¸® ²ø°í¿Í¼­
		
		// ÀÓ½Ã·Î ¾µ board ¸®½ºÆ®
		ArrayList<Board> ÀÓ½Ã = new ArrayList<>();
		for(Board temp : boardlist) {
			if(temp.getCategory().equals(Ä«Å×°í¸®)) {
				ÀÓ½Ã.add(temp);
			}	
		}
		// ºñ±³ÈÄ °°°Å³ª Å©¸é ³Ö°í Áö¿ì±â
		for(int i = 0; i < ÀÓ½Ã.size(); i++) {
			Board temp = ÀÓ½Ã.get(i);
			for(int j = 0; j < ÀÓ½Ã.size() ; j++) {
				if(temp.getGood() - temp.getBad() > ÀÓ½Ã.get(j).getGood() - ÀÓ½Ã.get(j).getBad()) {
					temp = ÀÓ½Ã.get(j);
					ÀÓ½Ã.set(j, ÀÓ½Ã.get(i));
					ÀÓ½Ã.set(i, temp);
				}
			}
		}
		return ÀÓ½Ã;
	}// m end
	public static boolean ´ñ±Û¼öÁ¤(int ±ÛÀÎµ¦½º, int ´ñ±ÛÀÎµ¦½º, String ´ñ±Û¼öÁ¤, String id) {
		// ±ÛÀÎµ¦½º / ÀÎµ¦½º/ ¼öÁ¤ÇÒ ³»¿ë / id ¹Ş¾Æ¿Í¼­ 
		// ÇØ´ç±Û³»¿¡ ´ñ±Û¸®½ºÆ®Áß ´ñ±ÛÀÎµ¦½º ºñ±³ÇÑÈÄ ¾ÆÀÌµğ Ã¼Å© ÈÄ ¼öÁ¤
		for(Board temp : boardlist) {
			if(temp.getIndex() == ±ÛÀÎµ¦½º) { // ÇØ´ç±Û Ã£±â
				if(temp.getReplylist().get(´ñ±ÛÀÎµ¦½º).getWriter().equals(id)) {// ÇØ´ç±ÛÀÇ ¿øÇÏ´Â ´ñ±ÛÀÎµ¦½ºÀÇ ÀÛ¼ºÀÚ°¡ id¶ûÀÏÄ¡ÇßÀ»¶§
					// ³»¿ë º¯°æ
					temp.getReplylist().get(´ñ±ÛÀÎµ¦½º).setContent(´ñ±Û¼öÁ¤);
					return true;
				}		
			}// °Ô½Ã¹° ±ÛÃ£±â if end
		}
		return false;
	}
	public static boolean ´ñ±Û»èÁ¦(int ±ÛÀÎµ¦½º, int ´ñ±ÛÀÎµ¦½º, String id) {
		// ±ÛÀÎµ¦½º / ÀÎµ¦½º/ ¼öÁ¤ÇÒ ³»¿ë / id ¹Ş¾Æ¿Í¼­ 
				// ÇØ´ç±Û³»¿¡ ´ñ±Û¸®½ºÆ®Áß ´ñ±ÛÀÎµ¦½º ºñ±³ÇÑÈÄ ¾ÆÀÌµğ Ã¼Å© ÈÄ ¼öÁ¤
				for(Board temp : boardlist) {
					if(temp.getIndex() == ±ÛÀÎµ¦½º) { // ÇØ´ç±Û Ã£±â
						if(temp.getReplylist().get(´ñ±ÛÀÎµ¦½º).getWriter().equals(id)) {// ÇØ´ç±ÛÀÇ ¿øÇÏ´Â ´ñ±ÛÀÎµ¦½ºÀÇ ÀÛ¼ºÀÚ°¡ id¶ûÀÏÄ¡ÇßÀ»¶§
							// ³»¿ë º¯°æ
							temp.getReplylist().remove(´ñ±ÛÀÎµ¦½º);
							return true;
						}		
					}// °Ô½Ã¹° ±ÛÃ£±â if end
				}
				return false;
		}
	public static int º¹±Ç°á°ú(String[] result,String id) {
		int[] count = new int[result.length]; // ÀÏÄ¡ÇÏ´Â ¼ö È®ÀÎ¿ë ¹è¿­ 
		int max = 0; 
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result.length; j++) {
				if(result[i].equals("["+(j+1)+"]") ) { // °°Àº ¼ö È®ÀÎ
					count[j]++; // ÀÏÄ¡ÇÏ´Â ¼ö Áõ°¡
				}
			}
		}
		for(int i=0; i<count.length; i++) {
			if(count[i]>max) {
				max=count[i]; // °¡Àå ¸¹ÀÌ ÀÏÄ¡ÇÏ´Â ¼ö
			}
		}
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				if(max==6) { // 1µî
					temp.setPoint(temp.getPoint()+1000); // Æ÷ÀÎÆ® 1000 Ãß°¡
					return 1;
				} else if(max==5) {
					temp.setPoint(temp.getPoint()+300); // Æ÷ÀÎÆ® 300 Ãß°¡
					return 2;
				} else if(max==4) {
					temp.setPoint(temp.getPoint()+100); // Æ÷ÀÎÆ® 100 Ãß°¡
					return 3;
				} else if(max==3) {
					temp.setPoint(temp.getPoint()+10); // Æ÷ÀÎÆ® 10 Ãß°¡
					return 4;
				} 	
			} // if end
		} // for end
		return 5; // ²Î
	}
	
	public static String[] º¹±Ç(String id) {
		String[] Æ÷ÀÎÆ®º¹±Ç = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"};
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {
				if(temp.getPoint()<10) { // º¸À¯Æ÷ÀÎÆ®°¡ 10º¸´Ù ÀÛÀ¸¸é
					return Æ÷ÀÎÆ®º¹±Ç;
				}else { // º¸À¯Æ÷ÀÎÆ®°¡ 10 ÀÌ»óÀÌ¸é º¸À¯Æ÷ÀÎÆ®¿¡¼­ 10 Â÷°¨
					temp.setPoint(temp.getPoint()-10); 
				}
			}
		}
			
		Random random = new Random();
		for(int i=0; i<Æ÷ÀÎÆ®º¹±Ç.length; i++) {
			int num = random.nextInt(Æ÷ÀÎÆ®º¹±Ç.length)+1; // 1~6 ³­¼ö »ı¼º
			Æ÷ÀÎÆ®º¹±Ç[i]="["+num+"]";
		}
		return Æ÷ÀÎÆ®º¹±Ç;
	}
	
	public static ArrayList<Acount> Æ÷ÀÎÆ®·©Å·() {
		ArrayList<Acount> rank = new ArrayList<>(); // ·©Å· ¸®½ºÆ® »ı¼º
		rank.addAll(acountlist); // È¸¿ø ¸®½ºÆ®¸¦ ·©Å· ¸®½ºÆ®¿¡ ÀúÀå
		
		Collections.sort(rank, new Acountsort()); // ·©Å· ¸®½ºÆ®¸¦ Æ÷ÀÎÆ®Á¡¼ö ¼ø¼­´ë·Î Á¤·Ä
		
		return rank; // ·©Å· ¸®½ºÆ® ¹İÈ¯
		

	}
public static boolean ½Å°í(String id,int index) throws IOException {
		
		for(Board temp : boardlist) {
			if(temp.getIndex()==index && temp.getWriter().equals(id)) {
				return false; // ½Å°íÇÑ ¾ÆÀÌµğ°¡ ÀÚ½ÅÀÇ ¾ÆÀÌµğ
			}
		}
		String reportid = null;
		for(Board temp : boardlist) {
			if(temp.getIndex()==index) {
				
				temp.setReport(temp.getReport()+1);
				reportid = temp.getWriter() ;
				break;
			}
		}
		
		Â÷´ÜÀ¯Àú a = new Â÷´ÜÀ¯Àú(id, reportid); 
		Â÷´ÜÀ¯Àúlist.add(a);
		Â÷´ÜÆÄÀÏÃ³¸®(id);
		
		return true;
	}
	
	public static boolean ÂÊÁöÈ®ÀÎ(String id, int ¹øÈ£) {
		// ÂÊÁö¹øÈ£, ¾ÆÀÌµğ ¹Ş¾Æ¿Í¼­ ÀÖ´ÂÁö¾ø´ÂÁöÃ¼Å©
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id)) {// ¾ÆÀÌµğ°ªÀÌ ÀÏÄ¡ÇÏ¸é
				for(ÂÊÁöÅ¬·¡½º temp2 : temp.getÂÊÁö()) { // ±×¾È¿¡ ÂÊÁö list µÚÁ®º¸°í
					if(temp2.get¹øÈ£() == ¹øÈ£) { // list ¾È ¹øÈ£°¡ °°Àº°ÔÀÖÀ½
						return true;
					}
				}
			}
		}// for end
		return false;
	}
	
	public static boolean ÂÊÁöº¸³»±â(String receiveid, String id, String con) {
		// ¹Ş´Â»ç¶÷, id, ³»¿ë¹Ş¾Æ¼­
		for(Acount temp : acountlist) {
			if(temp.getId().equals(receiveid)) {// id°ªÀÏÄ¡ÇÏ´Â acount Å¬·¡½º¸¦ Ã£¾Æ¼­
					// ÂÊÁölist¿¡ ÂÊÁö Ãß°¡
					temp.getÂÊÁö().add(new ÂÊÁöÅ¬·¡½º(temp.getId(), id, con, temp.getÂÊÁö().size() + 1));
					return true;
			}
		}
		return false;
		
	}

	public static String ¾ÆÀÌµğÃ£±â(String name, String phone, String email) {
		for(Acount temp : acountlist) {
			if(temp.getName().equals(name) && temp.getEmail().equals(email)
					&& temp.getPhone().equals(phone)) {
				return temp.getId();
			}
		}
		return "1";
	}
	public static String ºñ¹Ğ¹øÈ£Ã£±â(String id, String phone, String email) {
		for(Acount temp : acountlist) {
			if(temp.getId().equals(id) && temp.getEmail().equals(email)
					&& temp.getPhone().equals(phone)) {
				return temp.getPw();
			}
		}
		return "1";
	}
	
	
	public static void ÃßÃµºñÃß(boolean ¿©ºÎ, int index, String id) {
		boolean pass = true; // ¾ÆÀÌµğ Áßº¹¿©ºÎ Ã¼Å©
		for(Board temp : boardlist) {
			for(String s : temp.getP()) { // ÇØ´ç±Û p¸®½ºÆ®¾È¿¡
				if(temp.getIndex()==index && s.equals(id)) {		 // ¾ÆÀÌµğ°ªÀÌ ÀÏÄ¡ÇÏ¸é
					pass = false; 		//ÃßÃµ ºñÃß ¸ø´©¸£°Ô
				}
			}	
		}
		if(pass) { // Áßº¹µÈ¾ÆÀÌµğ°¡ ¾Æ´Ï¶ó¸é
			for(Board temp : boardlist) {
				if(¿©ºÎ) {
					if(temp.getIndex() == index) {
						temp.setGood(temp.getGood() + 1);//ÃßÃµ °³¼ö´Ã¸®±â
						temp.getP().add(id);
						break;
					}		
				}else {
					if(temp.getIndex() == index) {
						temp.setBad(temp.getBad() + 1);//ºñÃß °³¼ö´Ã¸®±â
						temp.getP().add(id);
						break;
					}		
				}
			}	
		}	
	}
	
	public static int[] º¸¹°Ã£±â°ÔÀÓ¼³Á¤() {
		// 1. °ÔÀÓ¼³Á¤
		Random random = new Random();
		int[] µî¼ö = new int[3];
		for(int i = 0 ; i < µî¼ö.length ; i++) {
			boolean pass = false;
			int temp = random.nextInt(15);// ³­¼ö »ı¼º
			for(int j = 0 ; j < µî¼ö.length ; j++) {
				if(temp != µî¼ö[i]) { pass = true; }// °°Áö¾Ê´Ù¸é
			}
			if(pass) {
				µî¼ö[i] = temp;
			}else {	i--; }
			if(i == 2) {break;}
		}// for end
		return µî¼ö;
	}

	
	
	
	

	public static int º¸¹°Ã£±â(int chindex, String id, int[] µî¼ö) throws IOException { // ÀÎµ¦½º / id ¹Ş±â
		// ÀÓ½Ã °ÔÀÓ 1µî 400 /2µî 200 /3µî 100 /4Àå·Á 10
		 //2. »Ì±â
			int i = 1; // µî¼ö ±âÁØ
			if(°ÔÀÓÆÇ[chindex].equals("[¡á]")) { //ºó°ªÀÌ¶ó¸é
				for(int temp : µî¼ö) {
					if(chindex == temp) { // temp 0 1 2 ¼ø¼­´ë·Î ´çÃ·µÇ¸é
						°ÔÀÓÆÇ[chindex] = "["+i+"]";  // °ÔÀÓÆÇ º¯°æ
						break;	// ³ª°¡±â
					}else {°ÔÀÓÆÇ[chindex] = "[ ]";}
					i++; // ´ÙÀ½ µî¼ö
				}
			}
			for(Acount temp : acountlist) { // È¸¿ø ¸ñ·Ï¿¡¼­
				if(temp.getId().equals(id)) { // ¾ÆÀÌµğ°ªÀÏÄ¡ÇÏ¸é
					temp.setPoint(temp.getPoint() - 10); // Æ÷ÀÎÆ® 10À» »©°í
					if(i == 1) { // 1µî´çÃ·µÇ¸é
						temp.setPoint(temp.getPoint() + 400); // Ãß°¡
						Controller.È¸¿øÆÄÀÏÃ³¸®(id);
						return 1;
					}else if(i == 2) {
						temp.setPoint(temp.getPoint() + 300);
						Controller.È¸¿øÆÄÀÏÃ³¸®(id);
						return 2;
					}else if(i == 3) {
						temp.setPoint(temp.getPoint() + 200);
						Controller.È¸¿øÆÄÀÏÃ³¸®(id);
						return 3;
					}
					
					
				}
			}
			return -1; 
		}// º¸¹°Ã£±â ¸Ş¼Òµå end
	
}