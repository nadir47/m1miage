package readers.cfg_reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import meta_data.Column;
import meta_data.LineMetaData;
import readers.utils.JsonExtractors;
/**
 * TO DO :
 * Create new Structure
 * 
 *
 */

 class JsonReader extends CfgReader
{
	JSONParser jsonParser;
	ArrayList<JSONObject> jsonElemnts ;
	
	public  JsonReader(String path)
	{
		jsonParser = new JSONParser();
		this.path=path;
		try {
			this.fileReader=new FileReader(this.path);
			this.initElement();
		} catch (Exception e) {
			System.out.println("Please select correct file path");
			e.printStackTrace();
		}

	}
	public void initElement() throws IOException, ParseException {
		this.jsonElemnts=(ArrayList<JSONObject>) jsonParser.parse(fileReader);
	}
	public LineMetaData initMetaData() throws IOException, ParseException {
		LineMetaData ref = new LineMetaData();
		for(int i=0;i<this.jsonElemnts.size();i++) {
			JSONObject jsonObject = this.jsonElemnts.get(i); 
			ref.add(JsonExtractors.initCol(jsonObject,"dataType"));
		}
		return ref;
	}
	public LineMetaData initRuleMetaData(LineMetaData ref) throws IOException, ParseException {
		String colName;
		JSONObject jsonObject;
		Column metaDataColumn;
		for(int i=0;i<this.jsonElemnts.size();i++) {
			jsonObject = this.jsonElemnts.get(i);
			colName = JsonExtractors.extractNameFromJsObject(jsonObject);
			metaDataColumn=ref.getColByName(colName);
			JsonExtractors.parseRuleObject(metaDataColumn,jsonObject,"should");
		}
		return ref;
	}
	public LineMetaData initAnonymisationMetaData(LineMetaData ref) throws IOException, ParseException {
		String colName;
		JSONObject jsonObject;
		Column metaDataColumn;
		for(int i=0;i<this.jsonElemnts.size();i++) {
			jsonObject =  this.jsonElemnts.get(i);
			colName = JsonExtractors.extractNameFromJsObject(jsonObject);
			metaDataColumn=ref.getColByName(colName);
			metaDataColumn.setAnonymisationType(JsonExtractors.extractAnonymisationRuleFromJsObject(jsonObject,"changeTo"));
		}
		return ref;
	}


}