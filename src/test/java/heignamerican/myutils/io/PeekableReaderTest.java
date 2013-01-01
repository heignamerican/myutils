package heignamerican.myutils.io;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class PeekableReaderTest {
	static final String INPUT = "abcde";

	public static class 初期状態 {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is((int) 'a'));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is((int) 'a'));
		}
	}

	public static class peekを1回 {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().peek();
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is((int) 'a'));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is((int) 'a'));
		}
	}

	public static class peekを2回 {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().peek();
			mResource.get().peek();
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is((int) 'a'));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is((int) 'a'));
		}
	}

	public static class readを1回 {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().read();
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is((int) 'b'));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is((int) 'b'));
		}
	}

	public static class peekを1回とreadを1回 {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().peek();
			mResource.get().read();
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is((int) 'b'));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is((int) 'b'));
		}
	}

	public static class readを最後から1回まで {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().read(); // a
			mResource.get().read(); // b
			mResource.get().read(); // c
			mResource.get().read(); // d
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is((int) 'e'));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is((int) 'e'));
		}
	}

	public static class readを最後から1回までとpeekを1回 {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
			mResource.get().peek();
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is((int) 'e'));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is((int) 'e'));
		}
	}

	public static class readを最後まで {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is(-1));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is(-1));
		}
	}

	public static class readを最後までとpeekを2回 {
		@Rule
		public PeekableReaderStringResource mResource = new PeekableReaderStringResource(INPUT);

		@Before
		public void setUp() throws IOException {
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
			mResource.get().read();
			mResource.get().peek();
			mResource.get().peek();
		}

		@Test
		public void testPeek() throws IOException {
			assertThat(mResource.get().peek(), is(-1));
		}

		@Test
		public void testRead() throws IOException {
			assertThat(mResource.get().read(), is(-1));
		}
	}
}
