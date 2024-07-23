package third;

public class Box {
	long idNum;  // 0
    static long boxID = 0; // 1 2 3 4
	
	public Box() {
		idNum = boxID++; // idNum = boxID;, boxID = boxID + 1; // idNum = 0; , boxID = 0 + 1;
	}
	public String toString() {
		return "Box클래스로 만든 인스턴스를 받은 인스턴스 객체입니다.";
	}

}
