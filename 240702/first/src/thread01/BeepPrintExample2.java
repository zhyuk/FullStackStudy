package thread01;

public class BeepPrintExample2 {

	public static void main(String[] args) { // Main Thread
		// Runnable 객체를 직접 생성하여 스레드생성자의 매개인자로 보내어 스레드 객체 생성
//		Runnable beepTask = new BeepTask();
//		Thread thread = new Thread(beepTask); // 별도의 작업을 수행할 수 있는 새로운 스레드(Thread0) 생성
//		thread.start(); // run() 실행 ==> thread 객체에 담긴 beepTask 객체에 담긴 Runnable 클래스의 run() 메소드 실행

		// Runnable 객체를 익명클래스로 생성하여 스레드생성자의 매개인자로 보내어 스레드 객체 생성
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("동");
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
			}
		};
		thread.start();

		// Runnable 객체를 람다식으로 생성하여 스레드생성자의 매개인자로 보내어 스레드 객체 생성
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("댕");
				try {
					Thread.sleep(500);
				} catch (Exception e) {

				}
			}
		});
		thread1.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // Main Thread 0.5s 정지
			} catch (Exception e) {
				System.out.println("에러발생");
			}
		}

	}

}
