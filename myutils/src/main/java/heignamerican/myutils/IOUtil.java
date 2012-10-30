package heignamerican.myutils;

import java.io.Closeable;
import java.io.IOException;

public class IOUtil {
	public static void closeQuietly(Closeable aCloseable) {
		if (aCloseable != null) {
			try {
				aCloseable.close();
			} catch (IOException aCause) {
			}
		}
	}
}
