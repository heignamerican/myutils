package heignamerican.myutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleTextUtil {
	/**
	 * @param aPath
	 * @param aCharset
	 * @return ファイルの内容。<br>
	 *         最終行の空行は無視される可能性があるので注意
	 * @throws IOException
	 */
	public static List<String> readTextAsListFrom(final String aPath, final String aCharset) throws IOException {
		final BufferedReader tBufferedReader = IOUtil.createBufferedReader(new File(aPath), aCharset);
		try {
			final List<String> tResult = new ArrayList<String>();

			for (String tLine = tBufferedReader.readLine(); tLine != null; tLine = tBufferedReader.readLine()) {
				tResult.add(tLine);
			}

			return tResult;
		} finally {
			IOUtil.closeQuietly(tBufferedReader);
		}
	}

	/**
	 * @see #readTextAsListFrom(String, String)
	 * @param aPath
	 * @param aCharset
	 * @param aNewLine
	 * @return
	 * @throws IOException
	 */
	public static String readTextFrom(final String aPath, final String aCharset, final String aNewLine) throws IOException {
		return StringUtil.mkString(aNewLine, readTextAsListFrom(aPath, aCharset));
	}

	public static void writeTo(final String aPath, final String aText, final String aCharset) throws IOException {
		final BufferedWriter tBufferedWriter = IOUtil.createBufferedWriter(new File(aPath), aCharset);
		try {
			tBufferedWriter.write(aText);
		} finally {
			IOUtil.closeQuietly(tBufferedWriter);
		}
	}
}
