package heignamerican.myutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOUtil {
	private IOUtil() {
	}

	public static void closeQuietly(Closeable aCloseable) {
		if (aCloseable != null) {
			try {
				aCloseable.close();
			} catch (IOException aCause) {
			}
		}
	}

	public static BufferedReader createBufferedReader(File aFile, String aCharset) throws IOException {
		final FileInputStream tFileInputStream = new FileInputStream(aFile);
		try {
			return new BufferedReader(new InputStreamReader(tFileInputStream, aCharset));
		} catch (IOException aCause) {
			closeQuietly(tFileInputStream);
			throw aCause;
		} catch (RuntimeException aCause) {
			closeQuietly(tFileInputStream);
			throw aCause;
		} catch (Error aCause) {
			closeQuietly(tFileInputStream);
			throw aCause;
		}
	}

	public static BufferedWriter createBufferedWriter(File aFile, String aCharset) throws IOException {
		final FileOutputStream tFileOutputStream = new FileOutputStream(aFile);
		try {
			return new BufferedWriter(new OutputStreamWriter(tFileOutputStream, aCharset));
		} catch (IOException aCause) {
			closeQuietly(tFileOutputStream);
			throw aCause;
		} catch (RuntimeException aCause) {
			closeQuietly(tFileOutputStream);
			throw aCause;
		} catch (Error aCause) {
			closeQuietly(tFileOutputStream);
			throw aCause;
		}
	}
}
