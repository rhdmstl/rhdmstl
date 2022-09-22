package ch13컬렉션프레임워크;

import java.util.ArrayList;

public class Arraylist {
	/*
	  	문자열 10개 저장
	 	string[ ] = new  string[10];
	 	동기화 지원 X
	 	
	 	ArrayList<자료형/클래스(type)>list = new ArrayList<>();
	 */
	
	public static void main(String[] args) {
		
		//정수 여러개 저장하는 리스트
		ArrayList<Integer>intList = new ArrayList<>();
		//실수를 여러개 저장할 수 있는 리스트 선언
		ArrayList<Double>doubles = new ArrayList<>();
		//내가 만든 자료형을 여러개 저장
		ArrayList<Member>members = new ArrayList<>();                
		
		//string를 여러개 저장할 수 있는 리스트 선언
		ArrayList<String>list = new ArrayList<>();
		
		list.add("java");	System.out.println("리스트현황 :" + list.toString());
		list.add("jdbc");	System.out.println("리스트현황 :" + list.toString());
		list.add("servlet.jsp");	System.out.println("리스트현황 :" + list.toString());
		list.add(2,"datebase");		System.out.println("리스트현황 :" + list.toString());
		list.add("iBATIS");			System.out.println("리스트현황 :"+ list.toString());
		
		int size = list.size();		System.out.println("리스트내 객체 수 : "+ list.size());
		
		System.out.println("특정 인덱스 호출 :" + list.get(0));
		
		System.out.println("동일한 객체로 인덱스 삭제"+ list.remove(0));
		System.out.println("동일한 객체로 인덱스 삭제"+ list.remove("iBATIS"));
		
		//리스트와 배열<---->반복문
			//1.
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		for(String s : list) {//for(타입파라미터 = 선언할때 사용했던 자료형사용)
			System.out.println(s);
		}
		
				//해당 객체가 존재하면 true 없으면 false
		System.out.println(list.contains("jdbc"));
		
		//인덱스 위치
		System.out.println(list.indexOf("jdbc"));
		
		//객체가 하나도 없으면 true 없으면 false
		System.out.println((list.isEmpty()));
		
		//리스트 내 객체를 순회(랜덤으로)
		System.out.println(list.iterator());
		
		list.clear();
		
		//함수 관례적 이름 get set is등
	}
}
