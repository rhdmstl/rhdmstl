package EX_11;

import java.util.Scanner;

public class String메소드 {
	public static void main(String[] args) {
		String ssn = "010123-1231234";
		Scanner scanner = new Scanner(System.in);
		char sex = scanner.next().charAt(7);
		
		System.out.println(sex);
		
		switch (sex) {
		case '1':
		case '3':
			System.out.println("남자입니다"); break;
			
		case '2':
		case '4':
			System.out.println("여자입니다"); break;
		}
		//2.문자열1.equals(문자열2) : 두 문자열 비교
		String strVar1 = new String("신문철");
		String strVar2 = "신문철";
		
		if(strVar1 == strVar2) {System.out.println("같은 string객체를 참조");}
		else {System.out.println("다른 string 객체를 참조");}
		
		if(strVar1.equals(strVar2)) {System.out.println("같은 문자열");}
		else {System.out.println("다른 문자열을 가짐");}
		
		//3.getBytes(인코딩타입)
		String str = "안녕하세요";
			byte[] bytes1 = str.getBytes();	System.out.println("길이 :" + bytes1.length);		
		
		String str1 = new String(bytes1);
			System.out.println("문자열 : " + str1);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
				System.out.println("문자열 -> 바이트열(EUC-KR) :" + bytes2.length);
			String str2 = new String(bytes2 , "EUC-KR");
				System.out.println("바이트열 -> 문자열 :"+str2);
			//UTF-8
			byte[] bytes3 = str.getBytes("UTF-8");
				System.out.println("문지얄 -> 바이트열(UTF-8)"+bytes3.length);
			String str3 = new String(bytes3 ,"UTF-8");
				System.out.println("바이트열 -> 문자열 "+str3);
		}catch(Exception e) {}
		
		//4.indexOf("문자") : 해당 문자의 인덱스 찾기
		String subject = "자바프로그래밍";
		
		System.out.println(subject.indexOf("프로그래밍"));
		
		int location = subject.indexOf("프로그래밍");
		if(location != 1) {System.out.println("찾았다");}
		else {System.out.println("못찾았다");}
		
		//5.length() : 문자열의 길이
		String ssn2 = "7306241230123";
		int length = ssn.length();
		
		if(length == 13) {System.out.println("주민번호 자리수가 맞습니다");}
		else {System.out.println("주민번호 자리수가 틀립니다");}
		
		//6.replace("기존문자" , "새로운 문자") : 치환
		String oldstr = "자바는 객체 지향 언어입니다 자바는 풍부한 API를 지원합니다";
		String newstr = oldstr.replace("자바", "java");
		
		System.out.println(oldstr);
		System.out.println(newstr);
		
		//7.toLowerCase()=소문자 / toUpperCase()=대문자변환
		String str2 = "Java Profamming";
		System.out.println("소문자 변환"+str2.toLowerCase());
		System.out.println("대문자 변환"+str2.toUpperCase());
		
		//8.trim() =공백제거
		String tel1 = "      02";
		String tel2 = "123     ";
		String tel3 = " 1  2  3";
		System.out.println(tel1.trim());
		System.out.println(tel2.trim());
		System.out.println(tel3.trim());
		
		//9.valueOf = 다른자료형 -> 문자열 변환
		System.out.println(    10+"");
			//숫자 + 문자 = 문자
		System.out.println(String.valueOf(10));//문자열 10 반환 
		System.out.println(String.valueOf(10.5));//실수형 10.5 -> 문자형 10.5변환
		System.out.println(String.valueOf(true));//논리형 true -> 문자열 true변환
		
		//10.substring([시작인덱스(포함)]  , [끝인덱스(제외)])문자열 자르기
		String ssn3 = "880815-1234567";
		String firstNum = ssn3.substring(0,6);
								//0번 : 8	6번 : 880815
		System.out.println(firstNum);
		
		String seconNum = ssn3.substring(7);
		System.out.println(seconNum);
		
		//11.split() 
		String[] reuslt = ssn3.split("-");	
		//하이픈 기주능로 자름 = string 2ro -> 배열이 잡아줌
		System.out.println(reuslt[0]);
		System.out.println(reuslt[1]);
		"asd".contains("a");
		
		
		
		
		
	
	
	
	
	
	}
}
