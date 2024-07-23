package inheritance;

class AA { // BB extends AA 에서 오면 내부 접근
	int i;
	int j;
	
	public void setij(int x, int y) {
		i = x;
		j = y;
	}
}

class BB extends AA { //AA는 부모클래스 상위,super,기본 BB는 자식클래스 하위,sub,파생 // AA에서 오면 외부접근
	int total;
	
	public void sum() { // 내부 접근
		total = i + j;
	}
}

public class InhEx02_01 { // 외부접근인 경우

	public static void main(String[] args) {
		BB subOb = new BB(); // cha p = new cha();의 경우
		
		subOb.setij(10, 12); //  외부접근
		subOb.sum(); //  외부접근
		System.out.println("합계 : " + subOb.total); // 외부접근
	}

}
