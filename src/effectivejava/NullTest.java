package effectivejava;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class NullTest {

	@Test
	public void test() {
		String ss = Objects.requireNonNull(null, "sss");
	}

	@Test
	public void test2() {
		String sss = Objects.requireNonNull(null);
	}

	@Test
	public void testAssertion() {
		String s = null;
		assert (null != s);
	}

	/**
	 * .从java8开始，Date已经过时了， 不应该在新代码中使用。应该使用Instant或者LocalDateTIme或者ZonedDateTime代替Date。Instant是不可变类。
	 */
	@Test
	public void instantTest() {
		// Instant获取北京时间
		Instant s = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
		System.out.println(s);
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		java.time.LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
	}

}
