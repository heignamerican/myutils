package heignamerican.myutils.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;

public class PeekableReader implements Closeable {
	private final Reader mSource;

	private static final int NOT_PEEKED = -2;
	private int mBefore;

	public PeekableReader(Reader aSource) {
		mSource = aSource;

		mBefore = NOT_PEEKED;
	}

	public int read() throws IOException {
		if (mBefore != NOT_PEEKED) {
			int tBefore = mBefore;
			mBefore = NOT_PEEKED;
			return tBefore;
		}
		return mSource.read();
	}

	public int peek() throws IOException {
		if (mBefore == NOT_PEEKED) {
			mBefore = mSource.read();
		}
		return mBefore;
	}

	@Override
	public void close() throws IOException {
		mSource.close();
	}
}
