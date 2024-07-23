package second;

class Fruits {
	private int apple;
	private int straw;
	private int grapes;
	private int sum;
	
	
	// 생성자 선언문
	public Fruits(int ap, int st, int gr) {
		apple = ap;
		straw = st;
		grapes = gr;
		// this = 나를 감싸고 있는 클래스의 (Fruits 클래스의)
		// Fruits 클래스의 count() 메소드를 
		this.count();
	}
	
	// 메소드 선언문
	private void count() {
		sum = apple + straw + grapes;
	}
	
	public int getApple() {
		return apple;
	}
	
	public int getStraw() {
		return straw;
	}
	
	public int getGrapes() {
		return grapes;
	}
	
	public int getSum() {
		return sum;
	}
	
}
