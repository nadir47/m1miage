package IO_handling_utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testStringUtilis() {
		String[] data = {"je","tu","il","elle","on","nous","vous","ils","elles"};
		String joinChar = ";";
		String expected ="je;tu;il;elle;on;nous;vous;ils;elles\n";
		String actual = StringUtils.arrayToStr(data, joinChar);
		assertEquals(expected, actual);
		
		
	}

}
