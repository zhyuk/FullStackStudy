package generic_002_yes;

public class Car { //&500
	String carName;
	String carPriduct;
	int carYear;
	int maxLoad;
	
	
	// 생성자 만들기 alt + shift + s 키 - Generate Constructor using Fields 선택 체크되어 있는 필드 모두 그대로 둘 것
	
	
	// Getter, Setter 만들기 alt + shift + s 키 - Generate Getters and Setters 선택 체크되어 있는 필드 모두 그대로 둘 것
	public String getCarName() {
		return carName;
	}
	
	public Car() {}
	public Car(String carName, String carPriduct, int carYear, int maxLoad) {
		this.carName = carName;
		this.carPriduct = carPriduct;
		this.carYear = carYear;
		this.maxLoad = maxLoad;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarPriduct() {
		return carPriduct;
	}
	public void setCarPriduct(String carPriduct) {
		this.carPriduct = carPriduct;
	}
	public int getCarYear() {
		return carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public int getMaxLoad() {
		return maxLoad;
	}
	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", carPriduct=" + carPriduct + ", carYear=" + carYear + ", maxLoad="
				+ maxLoad + "]";
	}
}
