package readers.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import meta_data.Column;
/**
 * 
 * Contains all functions that help us to extract String from JSon Object
 *
 */
public class JsonExtractors {
	public static Column initCol(JSONObject jsonObject,String ruleName) 
	{
		Column tempCOl = new Column();
		extractNameAndTypeFromJsObj(tempCOl,jsonObject,ruleName);
		return tempCOl;	
	}
	public static void parseRuleObject(Column tempCOl,JSONObject jsonObject,String ruleName) 
	{
		extractVerificationRuleFromJsObject(tempCOl,jsonObject,ruleName);	
	}
	//

	public static String extractNameFromJsObject(JSONObject jsonObject) {
		return (String) jsonObject.get("name");
	}
	public static String extractByNameFromJsObject(String str,JSONObject jsonObject) {
		return (String) jsonObject.get(str);
	}
	public static void extractVerificationRuleFromJsObject(Column tempCOl,JSONObject jsonObject,String ruleName) {
		Object ruleObject = jsonObject.get(ruleName);
		String ruleType = ruleObject.getClass()
				.getSimpleName()
				.toString();
		if (ruleType.equals("JSONArray")) {
			JSONArray tmpJsonArray = (JSONArray)jsonObject.get(ruleName);
			for(int i=0;i<tmpJsonArray.size();i++) {
				tempCOl.setRule(tmpJsonArray.get(i).toString());
			}
		}
		else {
			tempCOl.setRule(ruleObject.toString());
		}
	}
	public static String extractAnonymisationRuleFromJsObject(JSONObject jsonObject,String ruleName) {
		//Get employee last name
		Object ruleObject = jsonObject.get(ruleName);
		return ruleObject.toString();
	}
	
	public static void extractNameAndTypeFromJsObj(Column tempCOl,JSONObject jsonObject,String ruleName) {  
		tempCOl.setName(extractNameFromJsObject(jsonObject));
		//Get employee last name
		String type = (String) jsonObject.get(ruleName);
		tempCOl.setType(type);
	}
}