package heignamerican.myutils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
	public static String toString(Throwable aThrowable) {
		final StringWriter tStringWriter = new StringWriter();
		try {
			final PrintWriter tPrintWriter = new PrintWriter(tStringWriter);
			try {
				aThrowable.printStackTrace(tPrintWriter);
				return tStringWriter.toString();
			} finally {
				IOUtil.closeQuietly(tPrintWriter);
			}
		} finally {
			IOUtil.closeQuietly(tStringWriter);
		}
	}
}
