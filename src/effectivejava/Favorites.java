package effectivejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {

	private Map<Class<?>, Object> favorites = new HashMap<>();

	// type.cast(instance):动态转换，保证favorites的类型安全
	public <T> void putFavorite(Class<T> type, T instance) {
		favorites.put(Objects.requireNonNull(type), type.cast(instance));
	}
	
	public <T> T getFavorites(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	public static void main(String[] args) {
		Favorites favorites = new Favorites();
		favorites.putFavorite(String.class, "java");
		favorites.putFavorite(Class.class, Favorites.class);
		
		Class<?> favoritesClass = favorites.getFavorites(Class.class);
		System.out.println(favoritesClass.getName());
		String favoritesString = favorites.getFavorites(String.class);
		System.out.println(favoritesString);
	}

}
