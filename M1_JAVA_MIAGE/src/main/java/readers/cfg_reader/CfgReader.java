package readers.cfg_reader;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import meta_data.LineMetaData;

/**
 * Class relative to configuration of data structures by reading a configuration
 * file
 * 
 * @version 1.0
 * @author Nadir Omega
 * @author ylgn
 */
public abstract class CfgReader {
	FileReader fileReader;
	String path;

	/**
	 * Adding all reading data from a external file to RAM.
	 * 
	 * @param Int giving the number of records to read
	 * @return An ArrayList of String [] with all the data kept in it.
	 * @throws IOException, ParseException
	 */
	public abstract void initElement() throws IOException, ParseException;

	/**
	 * Return a line with the data type of each column.
	 * 
	 * @return LineMetaData with rules
	 * @throws IOException, ParseException
	 */
	public abstract LineMetaData initMetaData() throws IOException, ParseException;

	/**
	 * Return a line with the verification rule of each column. Each column of the
	 * line is initialised with its own rule.
	 * 
	 * @return LineMetaData completed with verification rule
	 * @throws IOException, ParseException
	 */
	public abstract LineMetaData initRuleMetaData(LineMetaData ref) throws IOException, ParseException;

	/**
	 * Return a line with the anonymisation rule of each column. Each column of the
	 * line is initialised with its own rule.
	 * 
	 * @return LineMetaData completed with anonymisation rule
	 * @throws IOException, ParseException
	 */
	public abstract LineMetaData initAnonymisationMetaData(LineMetaData ref) throws IOException, ParseException;

}
