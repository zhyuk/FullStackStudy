package javalangex;

import java.util.Random;

public class RandomEx01 {

	public static void main(String[] args) {
		Random random = new Random();
//		int num = random.nextInt();
		int num = random.nextInt(11);
//		nextInt에 값 지정이 안되면 int의 유효범위 내의 정수가 임의 출력
		System.out.println("0이상 11미만의 임의의 정수 값: " + num);
		
		float f = random.nextFloat();
		System.out.println("0.0초과 1.0미만의 임의의 실수 값 : " + f);
		f = (random.nextFloat() * 10);
		System.out.println(("0.0초과 10.0미만의 임의의 실수 값 : " + f));
		
		boolean b = random.nextBoolean();
		System.out.println("임의의 논리값 : " + b);

	}

}
