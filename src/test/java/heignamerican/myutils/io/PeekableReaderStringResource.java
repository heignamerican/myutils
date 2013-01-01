package heignamerican.myutils.io;

import heignamerican.myutils.IOUtil;
import heignamerican.myutils.io.PeekableReader;

import java.io.StringReader;

import org.junit.rules.ExternalResource;

public class PeekableReaderStringResource extends ExternalResource {
	private final String mSourceString;
	private PeekableReader mPeekableReader;

	public PeekableReaderStringResource(String aSourceString) {
		mSourceString = aSourceString;
	}

	public PeekableReader get() {
		return mPeekableReader;
	}

	@Override
	protected void before() throws Throwable {
		mPeekableReader = new PeekableReader(new StringReader(mSourceString));
	}

	@Override
	protected void after() {
		IOUtil.closeQuietly(mPeekableReader);
	}
}
