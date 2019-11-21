package effectivejava;

/**
 * 营养成分， builder模式:遇到多个构造器参数时，要考虑使用构建器
 * 
 * @author wangcaiyan[wang_cy1@suixingpay.com]
 *
 */

public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calorires;
	private final int fat;
	private final int sodium;
	private final int carbobydarete;

	public static class Builder {
		// 必传参数
		private final int servingSize;
		private final int servings;

		// 可选
		private int calorires = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbobydarete = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calorires(int val) {
			calorires = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbobydarete(int val) {
			carbobydarete = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calorires = builder.calorires;
		fat = builder.fat;
		sodium = builder.sodium;
		carbobydarete = builder.carbobydarete;
	}

	public int getServingSize() {
		return servingSize;
	}

	public int getServings() {
		return servings;
	}

	public int getCalorires() {
		return calorires;
	}

	public int getFat() {
		return fat;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCarbobydarete() {
		return carbobydarete;
	}

	public static void main(String[] args) {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8).calorires(2).fat(89).sodium(11)
				.carbobydarete(66).build();
		System.out.println("nutritionFacts=" + nutritionFacts.getServingSize());
	}

}
