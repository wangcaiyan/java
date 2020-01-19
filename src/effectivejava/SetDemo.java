package effectivejava;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	private int width;
	private int hight;
	/**
	 * 拷贝工厂或者复制工厂
	 * 
	 * @param set3
	 * @return
	 */
	public static Set<?> newInstance(Set<?> set3) {
		return new TreeSet<>(set3);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}
	
	public SetDemo getSize() {
		return this;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		TreeSet<String> set2 = new TreeSet<>();
		set2.add("2");
		set.add("1");
		// 将HashSet转换为TreeSet
		set2 = (TreeSet<String>) SetDemo.newInstance(set);
		System.out.println(set2);
		
		Dimension dimension = new Dimension(1,2);
		System.out.println(dimension.getSize());
		dimension.height = -1;
		dimension.width = 9;
		System.out.println(dimension.getSize());
		
		SetDemo setDemo = new SetDemo();
		setDemo.setHight(1);
		setDemo.setWidth(3);
		System.out.println(setDemo.getSize());
		System.out.println(setDemo.getSize());
	}

}
