package generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Generator;
import net.mindview.util.Sets;

public class G09to17GenericFunc {

	public void f(Map<Integer, String> t) {
		System.out.println(t.getClass().getName());
	}
	
	@SuppressWarnings("hiding")
	public <A, B, C> void f(A a, B b, C c) {
		System.out.println(a.getClass().getName() + ", " + 
				b.getClass().getName() + ", " + c.getClass().getName());
	}
	
	@SuppressWarnings("hiding")
	public <A, B> void f(A a, B b, int i) {
		System.out.println(a.getClass().getName() + ", " + 
				b.getClass().getName() + ", int " + i);
	}

	public <T> void f(T... t) {
		StringBuilder s = new StringBuilder();
		for (T sT : t)
			s.append(sT + " ");
		System.out.println(s.toString());
	}
	public static <U, V> Map<U, V> map() {
		return new HashMap<U, V>();
	}
	
	public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++)
			list.add(gen.next());
		return list;
	}
	
	public static <T> LinkedList<T> fill(LinkedList<T> list, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++)
			list.add(gen.next());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Set<T> union(Set<T> a, Set<T> b){
		try {
			if (a instanceof EnumSet) {
				Set<T> re = ((EnumSet) a).clone();
				re.addAll(b);
				return re;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> re = new HashSet<T>(a);
		re.addAll(b);
		return re;
	}
	
	public static void main(String[] args) {
		G09to17GenericFunc g = new G09to17GenericFunc();
		g.f(2, 2.3, "123");
		g.f("23", new Date(), 12);
		Map<Integer, String> map = G09to17GenericFunc.map();
		g.f(3,4);
//		g.f(G9a10and11GenericFunc.map());
		g.f(G09to17GenericFunc.<Integer, String>map());
		
		List<Integer> l = fill(new ArrayList<Integer>(), new Fibonacci(), 5);
		System.out.println(l.getClass().getName());
		System.out.println(l);
		System.out.println(fill(new LinkedList<Integer>(), new Fibonacci(), 5).getClass().getName());
		
		
	}
}
