package effectivejava;

/**
 * 策略枚举示例(strategy enum):在一个枚举中 定义一个私有的嵌套枚举，并将这个策略枚举的实例传到外层枚举的构造器中。
 * 
 * @author wangcaiyan[wang_cy1@suixingpay.com]
 *
 */
public enum PayrollDay {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

	private final PayType payType;

	private PayrollDay(PayType payType) {
		this.payType = payType;
	}

	private PayrollDay() {
		this(PayType.WEEKDAY); // default
	}

	int pay(int minsWorked, int payRate) {
		return payType.pay(minsWorked, payRate);
	}

	// 策略枚举
	private enum PayType {
		WEEKDAY {
			@Override
			int overTimePay(int mins, int payRate) {
				return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
			}
		},
		WEEKEND {
			@Override
			int overTimePay(int mins, int payRate) {
				return mins * payRate / 2;
			}
		};

		abstract int overTimePay(int mins, int payRate);

		private static final int MINS_PER_SHIFT = 8 * 60;

		int pay(int minsWorked, int payRate) {
			int basePay = minsWorked * payRate;
			return basePay + overTimePay(minsWorked, payRate);
		}
	}

}
