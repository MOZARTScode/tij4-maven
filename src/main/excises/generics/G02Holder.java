package generics;

public class G02Holder<T> {
	private T a;
	private T b;
	private T c;

	public G02Holder(T a, T b, T c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public T getA() {
		return a;
	}

	public T getB() {
		return b;
	}

	public T getC() {
		return c;
	}

	public void setA(T a) {
		this.a = a;
	}

	public void setB(T b) {
		this.b = b;
	}

	public void setC(T c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return a + " " + b + " " + c;
	}
	
	public static void main(String[] args) {
		G02Holder<String> g2Holder = new G02Holder<String>
		("lzy", "lyj", "wwd");
		System.out.println(g2Holder.toString());
	}
}
