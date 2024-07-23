package third;

public class AccountEx {

	public static void main(String[] args) {
		System.out.println("Account.total : " + Account.total);

		Account acc01 = new Account(10);
		System.out.println("acc01.total : " + acc01.total);
		System.out.println("acc01.count : " + acc01.count);

		Account acc02 = new Account(10);
		System.out.println("acc02.total : " + acc02.total);
		System.out.println("acc02.count : " + acc02.count);

		Account acc03 = new Account(10);
		System.out.println("acc03.total : " + acc03.total);
		System.out.println("acc03.count : " + acc03.count);
	}

}
