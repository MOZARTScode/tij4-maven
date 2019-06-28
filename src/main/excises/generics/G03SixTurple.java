package generics;

import net.mindview.util.FiveTuple;
import typeinfo.pets.Cat;

@SuppressWarnings("hiding")
public class G03SixTurple<A, B, C, D, E, F>
extends FiveTuple<A, B, C, D, E>{
	public final F sixth;
	
	public G03SixTurple(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		this.sixth = f;
	}
	
	@Override
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ", "
				+ fourth + ", " + fifth + ", "+ sixth + ")";
	}
	
	public static void main(String[] args) {
		G03SixTurple<Integer, String, Double, Cat, Vehicle, Amphibian> g 
			= new G03SixTurple<Integer, String, Double, Cat, Vehicle, Amphibian>
			(100, "lzy", 99.9, new Cat(), new Vehicle(), new Amphibian());
		System.out.println(g.toString());
	}
}
