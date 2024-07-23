package thread01;

public class BeepTask implements Runnable {
	//Runnable 인터페이스

	@Override
	// main()과 동일한 기능. 작업을 실행하는 기능
	public void run() { // Thread0

		for (int i = 0; i < 5; i++) {
			System.out.println("동");
			try {
				Thread.sleep(500); // Thread0 0.5s 정지
			} catch (Exception e) {
				System.out.println("에러발생");
			}
		}
	}
}
