package JsonParse;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import MetaData.LineMetaData;
/**
 * TO DO :
 * Create new Structure
 * 
 *
 */
public class JsonReader 
{
	JSONParser jsonParser;
	public  JsonReader()
	{
		jsonParser = new JSONParser();

	}
	public LineMetaData initMetaData(String path) throws IOException, ParseException {
		JSONArray elemntList = (JSONArray) jsonParser.parse(new FileReader(path));
		LineMetaData ref = new LineMetaData();
		for(int i=0;i<elemntList.size();i++) {
			ref.add(JsonExtractors.initCol((JSONObject)elemntList.get(i),"dataType"));
		}
		return ref;
	}
	public LineMetaData initRuleMetaData(LineMetaData ref,String path) throws IOException, ParseException {
		JSONArray elemntList = (JSONArray) jsonParser.parse(new FileReader(path));
		for(int i=0;i<elemntList.size();i++) {
			JSONObject tempJSon = (JSONObject) elemntList.get(i);
			JsonExtractors.parseRuleObject(ref.getColByName(JsonExtractors.extractNameFromJsObject(tempJSon)),tempJSon,"should");
		}
		return ref;
	}
	public LineMetaData initAnonymisationMetaData(LineMetaData ref,String path) throws IOException, ParseException {
		JSONArray elemntList = (JSONArray) jsonParser.parse(new FileReader(path));
		String colName;
		for(int i=0;i<elemntList.size();i++) {
			JSONObject tempJSon = (JSONObject) elemntList.get(i);
			colName =JsonExtractors.extractByNameFromJsObject("name", tempJSon);
			ref.getColByName(colName)
				.setAnonymisationType(JsonExtractors.extractByNameFromJsObject("changeTo", tempJSon));
		}
		return ref;
	}


}