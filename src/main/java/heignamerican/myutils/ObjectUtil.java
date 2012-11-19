package heignamerican.myutils;

public class ObjectUtil {
	public static <T> T coalesce(T... aInput) {
		for (T tT : aInput) {
			if (tT != null)
				return tT;
		}
		throw new IllegalArgumentException("zenbu null.");
	}
}
