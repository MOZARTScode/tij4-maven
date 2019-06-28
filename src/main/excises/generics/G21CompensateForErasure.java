package generics;

import java.util.HashMap;
import java.util.Map;

class Building1 {}
class House1 extends Building1 {}

public class G21CompensateForErasure<T> {
	Class<T> kind;
	Map<String,Class<?>> map;
	
	public G21CompensateForErasure(Class<T> kind) {
		map = new HashMap<String, Class<?>>();
		this.kind = kind;
	}

	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	
	public void addType(String typename, Class<?> kind) {
		map.put(typename, kind);
	}
	
	public Object createNew(String typename) {
		try {
			return map.get(typename).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		G21CompensateForErasure<String> g = new G21CompensateForErasure<String>(String.class);
		g.addType("Building1", Building1.class);
		g.addType("House1", House1.class);
		g.addType("String", String.class);
		g.addType("Integer", Integer.class);
		System.out.println(g.createNew("House1"));
		System.out.println(g.createNew("String"));
		System.out.println(g.createNew("Integer"));
	}
}
