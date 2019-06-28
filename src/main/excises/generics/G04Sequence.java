package generics;

interface Selector<T> {
	boolean end();

	T current();

	void next();
}

// 这里其实使用泛型和使用Object的对象的效果一致
// 因为并没有使用到T对象里面的方法，泛型在这里实质上就和Object一样
public class G04Sequence<T> {
	private T[] items;
	private int next = 0;

	@SuppressWarnings("unchecked")
	public G04Sequence(int size) { items = (T[]) new Object[size]; }

	public void add(T x) {
		if (next < items.length)
			items[next++] = x;
	}

	private class SequenceSelector implements Selector<T> {
		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public T current() {
			return items[i];
		}

		public void next() {
			if (i < items.length)
				i++;
		}
	}

	public Selector<T> selector() {
		return new SequenceSelector();
	}

	public static void main(String[] args) {
		G04Sequence<String> g4Sequence = new G04Sequence<String>(4);
		g4Sequence.add("lzy");
		g4Sequence.add("wlx");
		g4Sequence.add("czx");
		g4Sequence.add("zkt");
		Selector<String> selector = g4Sequence.selector();
		while (!selector.end()) {
			System.out.println(selector.current());
			selector.next();
		}
	}
}
