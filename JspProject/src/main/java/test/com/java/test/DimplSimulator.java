package test.com.java.test;

public class DimplSimulator {
	
	public static void main(String[] args) {
		DImpl dImpl = new DImpl();
		dImpl.getA();
		dImpl.getB();
		dImpl.getC();
		dImpl.getD();
		dImpl.getDimpl();
		
		System.out.println("------------------");
		D d = dImpl;
		d.getA();
		d.getB();
		d.getC();
		d.getD();
		
		System.out.println("------------------");
		C c = d;
		c.getC();
		
		System.out.println("------------------");
		//B b = c; 안됨
		B b = d;
		b.getB();
		
		System.out.println("------------------");
		A a = d;
		a.getA();
		
		System.out.println("------------------");
		a = dImpl;
		a.getA();
		
		System.out.println("------------------");
		b = dImpl;
		b.getB();
		
		System.out.println("------------------");
		c = dImpl;
		c.getC();
		
	}
	
}
