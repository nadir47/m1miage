package writers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
/**
 * Abstract Writer
 * Drop dependences between core application processing and kind of file
 * @version 1.0 
 */
public abstract class Writer {
	BufferedReader csvReader;
	
	String path;
	String separator;
	
	/** Write a String tab into a file
	 *@param String tab giving the String we want to write
	 *@throws IOException
	 */
	public abstract void writeFileFromList(List<String[]> beforWrite) throws IOException;
}
