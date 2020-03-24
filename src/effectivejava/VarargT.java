package effectivejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 谨慎并用泛型可变参数:
 * 1.可变参数的作用在于让客户端能够将可变数量的参数传给方法，但这是个技术露底：当调用一个可变参数方法时，会创建一个对象数组Object[]用来存放可变参数；这个数组应该是一个实现细节，他是可见的。因此，当可变参数有泛型或者参数化类型时，编译警告信息就会产混乱。2.当一个参数化类型的变量指向一个不是该类型的对象时，会产生堆污染（heap pullution）。它导致编辑器的自动生成转换失败，破坏了泛型系统的基本保证。
3.java7中，增加了@SafeVarargs注解，它让带泛型vararg参数的方法的设计者能够自动禁止客户端的警告。本质上@SafeVarargs注解是通过方法的设计者做出承诺，声明这类型是安全的。所以不要随意使用@SafeVarargs对方法进行注解，除非它是真正安全的。
 * 
 * @author wangcaiyan[wang_cy1@suixingpay.com]
 *
 */
public class VarargT {
	
	public static void main(String[] args) {
		// java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
		//允许另一个方法访问一个泛型可变参数数组是不安全的。
//		String[] arr = pickTwo("Good", "Fast", "Cheap");
		List<String> strList = new ArrayList<>();
		strList.add("work");
		dangerous(strList);
	}
	
	//unsafe
	//当调用一个可变参数方法时，会创建一个对象数组Object[]用来存放可变参数
	static <T> T[] toArray(T... args) {
		return args;
	}
	
	static <T> T[] pickTwo(T a , T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
		case 0:
			return toArray(a, b);
		case 1:
			return toArray(a, c);
		case 2:
			return toArray(c, b);
		}
		throw new AssertionError();
	}
	
	//当调用一个可变参数方法时，会创建一个对象数组Object[]用来存放可变参数
	static void dangerous(List<String>... stringLists) {
		List<Integer> intList = new ArrayList<>();
		intList.add(42);
		Object[] objects = stringLists;
		objects[0] = intList; // heap pullution:将List<Integer>放入List<String>
		String s = stringLists[0].get(0); // classCastException:java.lang.Integer cannot be cast to java.lang.String
		System.out.println(s);
		
	}
	
	

}
