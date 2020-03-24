package effectivejava;

public enum OperationEnum {
	
	PLUS("+"),
	MINUS("-"),
	DIVIDE("/"),
	TIMES("*");
	
	private final String symbol;

	public String getSymbol() {
		return symbol;
	}

	private OperationEnum(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString () {
		return symbol;
	}
	

}
