package first;

public class OverloadEx {
	public static void main(String[] args) {
		Overload ob = new Overload(); //Overload 자료형. ob 객체(주소값을 가지므로). new 주소할당/공간생성. Overload자료형/클래스를 복사 => 주소값을 ob객체에 넘김
		double result; //지역변수
		
		ob.test(); //메소드 호출 및 반환값 있으면 반환값을 저장하는 공간
		ob.test(5,10);
		
		//자동형변환(업캐스팅)을 거쳐 void test(double a)를 실행
		result = ob.test(100); // double자료형 이므로 반환값도 double자료형인 실수값!!
		
		System.out.println("ob.test(100)의 결과 : " + result);
		result =  ob.test(4.2);
	}

}
