package second;

public class Car { //클래스 선언문 [기타제어자] class 클래스명
	private String modelName; // 소나타, 멤버변수=멤버필드=전역변수=인스턴스변수
	private int modelYear; // 2012
	private String color; // 검정색
	private int maxSpeed; // 160
	private int currentSpeed; //0
	
	Car(String modelName, int modelYear, String color, int maxSpeed){ //기타 생성자 선언문
		this.modelName = modelName; // 소나타
		this.modelYear = modelYear; // 2012
		this.color = color; // 검정색
		this.maxSpeed = maxSpeed; // 160
		this.currentSpeed = 0;
	}
	
	Car(){
		this("소나타", 2012, "검정색", 160);
	}
	
	public String getModel() {
		return this.modelYear + "년식 " + this.modelName + " " + this.color;
	}
}
