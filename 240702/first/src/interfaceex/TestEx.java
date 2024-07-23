package interfaceex;

class TestEx{
	public static void main(String[] args) {
		Test ts = new Test(); // ts라는 복사본 생성
		
		String nm = "동물"; 
		if(nm.equals(PaTest.KIND)) {
			ts.trueKind();
		}else {
			ts.falseKind();
		}
	}
}

