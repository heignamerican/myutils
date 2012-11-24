package heignamerican.myutils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
	public static String toString(Throwable aThrowable) {
		final StringWriter tStringWriter = new StringWriter();
		aThrowable.printStackTrace(new PrintWriter(tStringWriter));
		return tStringWriter.toString();
	}
}
