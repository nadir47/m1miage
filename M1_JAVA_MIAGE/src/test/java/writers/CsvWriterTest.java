package writers;

import java.util.ArrayList;

import org.junit.Test;

public class CsvWriterTest {

	@Test
	public void testWriteFileFromList() throws Exception {

		
		//Créer un MOC
		ArrayList<String[]> beforWrite = new ArrayList<String[]>();
		String[] data = {"je","tu","il","nous","vous","il"};
		beforWrite.add(data);
		String pathToCsv = "ok";
		String separator = ";";
	}

}
