package third;

public class Box1 {
	int width;
	int height;
	int depth;
	long idNum;
	static long boxID = 100;
	
	static long getCurrentID() {
		// return ++boxID;인 경우, boxID = boxID + 1의 값을 계산한 뒤 mybox2의 idNum 변수에 대입하게 된다.
		// 따라서, 다음 박스의 번호와 mybox2 박스의 번호가 동일하게 되기 때문에, 출력할 때마다 상승하기 위해서는 후위연산자 활용해야한다.
		return boxID++;
	}
}
