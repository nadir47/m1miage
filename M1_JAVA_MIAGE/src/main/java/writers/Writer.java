package writers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public abstract class Writer {
	BufferedReader csvReader;
	
	String path;
	String separator;
	public abstract void writeFileFromList(List<String[]> beforWrite) throws IOException;
}
