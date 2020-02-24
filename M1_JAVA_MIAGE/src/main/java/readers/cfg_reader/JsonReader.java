package readers.cfg_reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import IO_handling_utils.JsonExtractors;
import meta_data.Column;
import meta_data.LineMetaData;

/**
 * Class relative to configuration of data structures by reading a JSON configuration
 * file
 * 
 * @version 1.0
 * @author Nadir Omega
 * @author ylgn
 */
class JsonReader extends CfgReader {
	JSONParser jsonParser;
	ArrayList<JSONObject> jsonElemnts;

	public JsonReader(String path) {
		jsonParser = new JSONParser();
		this.path = path;
		try {
			this.fileReader = new FileReader(this.path);
			this.initElement();
		} catch (Exception e) {
			System.out.println("Please select correct file path");
			e.printStackTrace();
		}

	}

	/**
	 * Adding all reading data from a external file to RAM within a
	 * ArrayList<JSONObject>.
	 * 
	 * @param Int giving the number of records to read
	 * @return An ArrayList of String [] with all the data kept in it.
	 * @throws IOException, ParseException
	 */
	public void initElement() throws IOException, ParseException {
		this.jsonElemnts = (ArrayList<JSONObject>) jsonParser.parse(fileReader);
	}

	/**
	 * Return a line with the data type of each column. This elements come from a
	 * given ArrayList<JSONObject>.
	 * 
	 * @return LineMetaData with rules
	 * @throws IOException, ParseException
	 */
	public LineMetaData initMetaData() throws IOException, ParseException {
		LineMetaData ref = new LineMetaData();
		for (int i = 0; i < this.jsonElemnts.size(); i++) {
			JSONObject jsonObject = this.jsonElemnts.get(i);
			ref.add(JsonExtractors.initCol(jsonObject, "dataType"));
		}
		return ref;
	}

	/**
	 * Return a line with the verification rule of each column. This elements come
	 * from a given ArrayList<JSONObject>. Each column of the line is initialised
	 * with its own rule bounded to the JSONObject.
	 * 
	 * @return LineMetaData completed with verification rule
	 * @throws IOException, ParseException
	 */
	public LineMetaData initRuleMetaData(LineMetaData ref) throws IOException, ParseException {
		String colName;
		JSONObject jsonObject;
		Column metaDataColumn;
		for (int i = 0; i < this.jsonElemnts.size(); i++) {
			jsonObject = this.jsonElemnts.get(i);
			colName = JsonExtractors.extractNameFromJsObject(jsonObject);
			metaDataColumn = ref.getColByName(colName);
			JsonExtractors.parseRuleObject(metaDataColumn, jsonObject, "should");
		}
		return ref;
	}

	/**
	 * Return a line with the anonymisation rule of each column. This elements come
	 * from a given ArrayList<JSONObject>. Each column of the line is initialised
	 * with its own rule bounded to the JSONObject.
	 * 
	 * @return LineMetaData completed with anonymisation rule
	 * @throws IOException, ParseException
	 */
	public LineMetaData initAnonymisationMetaData(LineMetaData ref) throws IOException, ParseException {
		String colName;
		JSONObject jsonObject;
		Column metaDataColumn;
		for (int i = 0; i < this.jsonElemnts.size(); i++) {
			jsonObject = this.jsonElemnts.get(i);
			colName = JsonExtractors.extractNameFromJsObject(jsonObject);
			metaDataColumn = ref.getColByName(colName);
			metaDataColumn
					.setAnonymisationType(JsonExtractors.extractAnonymisationRuleFromJsObject(jsonObject, "changeTo"));
		}
		return ref;
	}

}