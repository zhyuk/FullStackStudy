package first;

public class Ex07{ //클래스는 자료형이 될 수 있음.
	// 속성 = 명사객체
    public String name; //String 클래스, 문자열을 담은 주솟값을 가진 참조자료형
    public int age;
    public String phone; // 전화번호 0으로 시작함. int 자료형으로 하면 0 생략되므로 String으로 설정
    
    //public Ex07(){} 생성자
    
    //public void Ex07(){} 생성자
    
    // 메서드
    public void setName(String nm) {
    	name = nm;
    }
    public void setAge(int ag) {
    	age = ag;
    }
    public void setPhone(String ph) {
    	phone = ph;
    }
}
