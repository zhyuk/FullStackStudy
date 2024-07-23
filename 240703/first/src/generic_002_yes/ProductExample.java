package generic_002_yes;

public class ProductExample {

	public static void main(String[] args) {
		                    //&100
		Product<Tv, String> product1 = new Product<Tv, String>();
		                  //&200
		product1.setKind(new Tv("런닝맨", 6, 15, 50));
		product1.setModel("Tv자료형");
		//&200
		Tv tv = product1.getKind(); //(1)
		System.out.println(product1.getModel());
		System.out.println(tv.toString());
								
		Product<Car, String> product2 = new Product<Car, String>();
		product2.setKind(new Car("그랜져", "현대", 2024, 220));
		product2.setModel("Car자료형");
		
		Car car = product2.getKind();
		System.out.println(product2.getModel());
		System.out.println(car);

	}

}
