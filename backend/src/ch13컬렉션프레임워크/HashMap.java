package ch13컬렉션프레임워크;

public class HashMap {
	public static void main(String[] args) {

		java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
		
		map.put("신용권", 85);	System.out.println(map.toString());
		map.put("홍길동", 90);	System.out.println(map.toString());
		map.put("동장군", 95);	System.out.println(map.toString());
		map.put("홍길동", 80);	System.out.println(map.toString());
		
		System.out.println("엔트리(키:값)수 : " + map.size());
		
		System.out.println("신용권 키 호출" + map.get("신용권"));
		
		//모든 키값을 호출
		for(String key : map.keySet()) {
			System.out.println("키\n" + key);
			System.out.println("값\n" + map.get(key));
		}
		
		//삭제
		map.remove("홍길동");
		
		map.clear();
	}
}
