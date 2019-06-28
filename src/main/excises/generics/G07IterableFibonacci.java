package generics;

import java.util.Iterator;

public class G07IterableFibonacci implements Iterable<Integer>{
	private int n;
	private Fibonacci fibonacci = new Fibonacci();

	public G07IterableFibonacci(int count) { n = count; }
	
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return n > 0; 
			}

			public Integer next() {
				n--;
				return fibonacci.next();
			}
		};
	}
	
	public static void main(String[] args) {
		for (int i : new G07IterableFibonacci(10))
			System.out.println(i + " ");
	}
}
