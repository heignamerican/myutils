package heignamerican.myutils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringUtilTest extends StringUtil {
	@Test
	public void testMkString() {
		assertThat(mkString(","), is(""));
		assertThat(mkString(",", 3), is("3"));
		assertThat(mkString(",", 3, '4', "5"), is("3,4,5"));
		assertThat(mkString("\t", 13, 14, 25), is("13	14	25"));
	}

	@Test
	public void testMkEncString() {
		assertThat(mkEncString(",", "(", ")"), is(""));
		assertThat(mkEncString(",", "(", ")", 3), is("(3)"));
		assertThat(mkEncString(",", "(", ")", 3, '4', "5"), is("(3),(4),(5)"));
		assertThat(mkEncString("\t", "(", ")", 13, 14, 25), is("(13)	(14)	(25)"));
	}
}
