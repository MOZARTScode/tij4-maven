package generics;

interface Inter2 { 
	void f1();
	void f2();
}

class cls1 implements Inter2 {
	public void f1() {
		System.out.println("f1()");
	}

	public void f2() {
		System.out.println("f2()");
	}
	
	public void f3() {
		System.out.println("f3()");
	}
}

public class G20Erasure {
	public static <T extends Inter2> void f(T t) {
		t.f1();
		t.f2();
	}
	
	public static void main(String[] args) {
		G20Erasure.f(new cls1());
	}
}
