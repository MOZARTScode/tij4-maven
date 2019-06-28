package generics;

public class G06Randomlist {

	public static void main(String[] args) {
		RandomList<Integer> r1 = new RandomList<Integer>();
		r1.add(12);
		r1.add(24);
		r1.add(36);
		r1.add(48);
		r1.add(60);
		System.out.println(r1.select());;
	}
}
