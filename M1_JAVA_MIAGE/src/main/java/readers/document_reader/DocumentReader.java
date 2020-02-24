package readers.document_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * Class responsable de la lecture des fichiers CSV
 * @version 1.0
 * @author Nadir Omega
 * @author ylgn
 *
 */
public abstract class DocumentReader {

	BufferedReader csvReader;
	String path;
	protected boolean containsData = true;

	/**
	 * Return n into a given file
	 * 
	 * @param Int giving the number of records to read
	 * @return An ArrayList of String [] with all the data kept in it.
	 * @throws IOException
	 */
	public abstract ArrayList<String[]> readMultipleLine(int nb) throws IOException;

	/**
	 * Return a all the file contained into a given file
	 * 
	 * @return An ArrayList of String [] with all the data kept in it.
	 * @throws IOException
	 */
	public abstract ArrayList<String[]> readAllFile() throws IOException;

	public boolean checkContainingData() {
		return this.containsData;
	}
}