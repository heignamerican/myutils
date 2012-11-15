package heignamerican.myutils;

import java.util.Collection;

public class StringUtil {
	/**
	 * boxing しまくり
	 */
	public static String mkString(final String aSeparator, final Object... aArgs) {
		if (aArgs.length == 0)
			return "";

		final StringBuilder tBuilder = new StringBuilder();
		for (final Object tArg : aArgs) {
			tBuilder.append(tArg.toString());
			tBuilder.append(aSeparator);
		}
		tBuilder.setLength(tBuilder.length() - aSeparator.length());
		return tBuilder.toString();
	}

	public static <T> String mkString(final String aSeparator, final Collection<T> aCollection) {
		if (aCollection.size() == 0)
			return "";

		final StringBuilder tBuilder = new StringBuilder();
		for (final T tElement : aCollection) {
			tBuilder.append(tElement.toString());
			tBuilder.append(aSeparator);
		}
		tBuilder.setLength(tBuilder.length() - aSeparator.length());
		return tBuilder.toString();
	}

	public static String mkEncString(final String aSeparator, final String aStart, final String aEnd, final Object... aArgs) {
		if (aArgs.length == 0)
			return "";

		final StringBuilder tBuilder = new StringBuilder();
		for (final Object tArg : aArgs) {
			tBuilder.append(aStart);
			tBuilder.append(tArg.toString());
			tBuilder.append(aEnd);
			tBuilder.append(aSeparator);
		}
		tBuilder.setLength(tBuilder.length() - aSeparator.length());
		return tBuilder.toString();
	}

	public static <T> String mkEncString(final String aSeparator, final String aStart, final String aEnd, final Collection<T> aCollection) {
		if (aCollection.size() == 0)
			return "";

		final StringBuilder tBuilder = new StringBuilder();
		for (final T tElement : aCollection) {
			tBuilder.append(aStart);
			tBuilder.append(tElement.toString());
			tBuilder.append(aEnd);
			tBuilder.append(aSeparator);
		}
		tBuilder.setLength(tBuilder.length() - aSeparator.length());
		return tBuilder.toString();
	}
}
