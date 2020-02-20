package readers.document_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class DocumentReader {
	
	BufferedReader csvReader;
	String path;
	protected boolean containsData=true;
	public abstract ArrayList<String[]> readMultipleLine(int nb) throws IOException;
	public abstract ArrayList<String[]> readAllFile() throws IOException;
	public boolean checkContainingData() {
		return this.containsData;
	}
}
