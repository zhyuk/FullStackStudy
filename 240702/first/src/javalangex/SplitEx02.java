package javalangex;

public class SplitEx02 {

	public static void main(String[] args) {
		String mail = "hello-kitty@hellokitty.com";
		
		//구분자 : - @ . 을 구분자로 인식 .+*등은 \\. \\+ \\* 등으로 해주어야 인식됨.
		String[] strAry = mail.split("-|@|\\.");
		for (String s : strAry)
			System.out.print(s + "\t");
		System.out.println("\n");
		
		mail = "1+21+3+47+5";
		strAry = mail.split("\\+");
		for (String s : strAry)
			System.out.print(s +"\t");
		System.out.println("\n");
		
		mail = "1*21*3*47*5";
		strAry = mail.split("\\*");
		for (String s : strAry)
			System.out.print(s +"\t");
		System.out.println("\n");

	}

}
