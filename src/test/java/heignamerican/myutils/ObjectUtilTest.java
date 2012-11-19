package heignamerican.myutils;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ObjectUtilTest {
	@Test
	public void testCoalesce() {
		assertThat(ObjectUtil.coalesce(1, 2, 3), is(1));
		assertThat(ObjectUtil.coalesce(null, 2, 3), is(2));

		assertThat(ObjectUtil.coalesce("1", "2", "3"), is("1"));
		assertThat(ObjectUtil.coalesce(null, "2", null), is("2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCoalesceOnNullOnly() {
		assertThat(ObjectUtil.coalesce(null, null, null), is(nullValue()));
	}
}
