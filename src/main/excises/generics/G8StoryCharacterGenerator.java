package generics;

import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Generator;

class StoryCharacter {
	private String name;
	
	public StoryCharacter() {
	}
	
	public StoryCharacter(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

class GoodGuy extends StoryCharacter {
	public GoodGuy() {}
	public GoodGuy(String name) {
		super(name);
	}
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}

class BadGuy extends StoryCharacter {
	public BadGuy() {}
	public BadGuy(String name) {
		super(name);
	}
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}

public class G8StoryCharacterGenerator 
implements Generator<StoryCharacter>, Iterable<StoryCharacter>{
	private Class<?>[] types = { GoodGuy.class, BadGuy.class };
	private static Random random = new Random();
	private int size;
	
	public G8StoryCharacterGenerator() {	}
	public G8StoryCharacterGenerator(int sz) { size = sz; };
	
	public StoryCharacter next() {
		try {
			return (StoryCharacter) types[random.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class StoryCharacterIterator implements Iterator<StoryCharacter> {
		int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public StoryCharacter next() {
			count--;
			return G8StoryCharacterGenerator.this.next();
		}
	}
	
	public Iterator<StoryCharacter> iterator() {
		return new StoryCharacterIterator();
	}
	
	public static void main(String[] args) {
		G8StoryCharacterGenerator gen = new G8StoryCharacterGenerator();
		for (int i = 0; i < 5; i++)
			System.out.println(gen.next());
		System.out.println("------------------");
		for (StoryCharacter storyCharacter : new G8StoryCharacterGenerator(8))
			System.out.println(storyCharacter);
	}
}
