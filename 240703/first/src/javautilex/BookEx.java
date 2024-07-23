package javautilex;

public class BookEx {
	static void arrayPrint(String s, Book[] a) {
		System.out.println(s);
		for (Book i : a) { 
			i.showBookInfo();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Book[] book1 = new Book[3];
		Book[] book2 = new Book[3];
		
		book1[0] = new Book("동백꽃필무렵", "김유정");
		book1[1] = new Book("태백산맥", "조정래");
		book1[2] = new Book("수난이대", "하근찬");
		System.arraycopy(book1, 1, book2, 0, 2);
		
		book2[2] = new Book("진주목걸이", "모파상");
		arrayPrint("(1) book1 : ", book1);
		arrayPrint("(1) book2 : ", book2);
		System.out.println();
		
		book1[1].setBookName("운수좋은날");
		book1[1].setAuthor("현진건");
		arrayPrint("(2) book1 : ", book1);
		arrayPrint("(2) book2 : ", book2);
		System.out.println();
		
		book2[2] = (Book) book1[1].clone();
		arrayPrint("(3) book1 : ", book1);
		arrayPrint("(3) book2 : ", book2);
		System.out.println();
		
		book1[1].setBookName("그많던싱아는누가다먹었을까");
		book1[1].setAuthor("박완서");
		arrayPrint("(4) book1 : ", book1);
		arrayPrint("(4) book2 : ", book2);
		System.out.println();
		
		book2[0] = (Book) book2[2].clone();
		arrayPrint("(5) book1 : ", book1);
		arrayPrint("(5) book2 : ", book2);
		System.out.println();
		
	}
	
}
