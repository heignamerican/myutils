package heignamerican.myutils;

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
}
