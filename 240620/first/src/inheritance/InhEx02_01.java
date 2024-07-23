package inheritance;

class AA {
	int i;
	int j;

	public void setij(int x, int y) {
		i = x;
		j = y;
	}
}
// BB 클래스는 자식, 하위, Sub, 파생 클래스임
// BB 클래스와 AA 클래스는 부모자식 모두 클래스로 동급이기 때문에 extends 사용
class BB extends AA {
	int total;

	public void sum() {
		total = i + j;
	}
}

public class InhEx02_01 {
	public static void main(String[] args) {
		BB subOb = new BB();

		subOb.setij(10, 12); // 외부접근
		subOb.sum(); // 외부접근
		System.out.println("합계 : " + subOb.total);

	}
}
