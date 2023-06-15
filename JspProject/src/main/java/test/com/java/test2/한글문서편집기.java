package test.com.java.test2;

public class 한글문서편집기 {
	public static void main(String[] args) {
		printDocument(new Canon());
		printDocument(new Hp());
		printDocument(new Samsung());
		
	}
	
	public static void printDocument(Printer printer) {
		printer.print();
	}
	
	
}
