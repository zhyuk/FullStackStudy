package thread01;

public class BeepPrintExample1 {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			// sleep(milliS) sleep(500) = 0.5s
			try {Thread.sleep(500);} catch(Exception e) {}
		}

		for(int i = 0; i < 5; i++) {
			System.out.println("동");
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}

}
