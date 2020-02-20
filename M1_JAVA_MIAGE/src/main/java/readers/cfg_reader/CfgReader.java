package readers.cfg_reader;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import meta_data.LineMetaData;

public abstract class CfgReader {
	FileReader fileReader ;
	String path;
	public abstract void initElement() throws IOException, ParseException;
	public abstract LineMetaData initMetaData() throws IOException, ParseException;
	public abstract LineMetaData initRuleMetaData(LineMetaData ref) throws IOException, ParseException;
	public abstract LineMetaData initAnonymisationMetaData(LineMetaData ref) throws IOException, ParseException;
	
}
