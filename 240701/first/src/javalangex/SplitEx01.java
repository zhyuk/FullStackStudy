package javalangex;

public class SplitEx01 {

	public static void main(String[] args) {
		String str = "123::4:67:10::::";
		System.out.println(str + "\n==============================\n");
		
		String[] noLimit = str.split(":");
		System.out.println("-----noLimit-----" + noLimit.length);
		for (int cnt = 0; cnt < noLimit.length; cnt++) {
			System.out.print("[" + cnt + "]" + noLimit[cnt] + "\t");
		}
		System.out.println("\n================================\n");
		
		//구분자, 인덱스 -1배열까지
		String[] limitTwo = str.split(":", 2);
		System.out.println("-----limitTwo-----" + limitTwo.length);
		for (int cnt = 0; cnt < limitTwo.length; cnt++) {
			System.out.print("[" + cnt + "]" + noLimit[cnt] + "\t");
		}
		System.out.println("\n================================\n");
	
		String[] limitPlus = str.split(":", 7);
		System.out.println("-----limitPlus-----" + limitPlus.length);
		for (int cnt = 0; cnt < limitPlus.length; cnt++) {
			System.out.print("[" + cnt + "]" + limitPlus[cnt] + "\t");
		}
		System.out.println("\n================================\n");
		
		String[] limitZero = str.split(":", 0);
		System.out.println("-----limitZero-----" + limitZero.length);
		for (int cnt = 0; cnt < limitZero.length; cnt++) {
			System.out.print("[" + cnt + "]" + limitZero[cnt] + "\t");
		}
		System.out.println("\n================================\n");
	
		String[] limitMinus = str.split(":", -1);
		System.out.println("-----limitMinus-----" + limitMinus.length);
		for (int cnt = 0; cnt < limitMinus.length; cnt++) {
			System.out.print("[" + cnt + "]" + limitMinus[cnt] + "\t");
		}
		System.out.println("\n================================\n");
	}
	
}