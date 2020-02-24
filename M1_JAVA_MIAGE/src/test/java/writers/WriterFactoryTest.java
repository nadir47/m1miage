package writers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WriterFactoryTest {

	@Test
	public void testGetDocumentWriterCSV() throws Exception {

		Writer csvWriter = WriterFactory.getDocumentWriter("CSV", "path");
		String expected = "CsvWriter";
		String actual = csvWriter.getClass().getSimpleName().toString();
		assertEquals(expected, actual);
	}

}
