package heignamerican.myutils.collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CollectionUtilTest extends CollectionUtil {
	@Test
	public void testMapping() throws Exception {
		List<Integer> tInput = new ArrayList<Integer>();
		tInput.add(1);
		tInput.add(23);
		List<String> tResult = mapping(tInput, new ConverterBase<Integer, String>() {
			@Override
			public String convertReal(Integer aFrom) {
				return String.format("%d%d", aFrom, aFrom);
			}
		});

		List<String> tExpected = new ArrayList<String>();
		tExpected.add("11");
		tExpected.add("2323");

		assertThat(tResult, is(tExpected));
	}
}
