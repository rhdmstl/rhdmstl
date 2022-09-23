package EX_11;

import java.io.IOException;

public class EX_11string {
	public static void main(String[] args) {
		//기본자료형은 문자열 저장 -> string
		//byte - > 문자
		byte b = 72;	
		char c = (char)b;
		System.out.println(c);
		
		byte [] bytes = {72 , 101 , 108 , 108 , 111 , 32 , 74 , 97 , 118 , 97 };
		char [] chars = new char[10];
		
		for(int i = 0 ; i < bytes.length ; i++) {chars[i] = (char)bytes[i];}
		
		for(int i = 0 ;  i < chars.length ; i++) {System.out.print(chars[i]);}
		
		String str1 = new String(bytes);	System.out.println("\n"+str1);
		
		String str2 = new String(bytes, 6 ,4);		System.out.println(str2);
		
		//2. 스캐너 없이 입력받기
		byte[] bytes2 = new byte[100];
		
		System.out.println("입력 : ");
		
		try {
			int readByteNo =  System.in.read(bytes2);
			//for(int i = 0 ; i <= bytes2.length ; i++) {
				//System.out.println(bytes2[i]);
				//}
			String str3 = new String(bytes2 , 0 , readByteNo-2);
			System.out.println(str3);
			System.out.println("----절취선----");
			} 
		catch (Exception e) {e.printStackTrace();}
	
	
	
	
	}
	
}
