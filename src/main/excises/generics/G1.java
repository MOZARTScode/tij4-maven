package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Pet;

public class G1 {
	public static void main(String[] args) {
		Pet cat = new Cat();
		Holder3<Pet> catHolder = new Holder3<Pet>(cat);
		System.out.println(catHolder.get().id());
	}
}
