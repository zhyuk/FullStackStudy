package second;

public class CarEx {

	public static void main(String[] args) {
		Car tcpCar = new Car();
		System.out.println(tcpCar.getModel());
	}

}

class Car {
	private String modelName;
	private int modelYear;
	private String color;
	private int maxSpeed;
	private int currentSpeed;
	
	// 생성자 선언문
	Car(String modelName, int modelYear, String color, int maxSpeed){
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.currentSpeed = 0;
	}
	
	Car() {
		// 나를 감싸고 있는 Car 클래스 내에 매개변수 4개를 가진 Car 생성자 선언문을 호출
		this("소나타", 2012, "검정색", 160);
	}
	
	// 메소드 선언문
	public String getModel() {
		return this.modelYear + "년식 " + this.modelName + " " + this.color;
	}
}
