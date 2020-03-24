package effectivejava;

import java.util.Date;

/**
 * 保护性拷贝示例
 * 
 * @author wangcaiyan[wang_cy1@suixingpay.com]
 *
 */
public final class Period {

	private final Date start;
	private final Date end;

	public Period(Date start, Date end) {
		//为了保护实例的内部消息受到攻击，对于构造器的每个可变参数进行保护性拷贝（defensive copy）是必要的，并且使用备份对象作为实例的组件而不是使用原始的对象
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0) {
			// 周期的起始时间不能在结束时间之后
			throw new IllegalArgumentException(this.start + " after " + this.end);
		}
	}

	public Date getStart() {
		// 使访问方法返回可变内部域的保护性可变，而不是直接返回start，如return start;直接返回start有安全风险。
		return new Date(start.getTime());
	}

	public Date getEnd() {
		return new Date(end.getTime());
	}
	
	public static void main(String[] args) {
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start, end);
		p.getEnd().setYear(78);
		System.out.println(p);
	}

	@Override
	public String toString() {
		return "Period [start=" + start + ", end=" + end + "]";
	}

	
}
