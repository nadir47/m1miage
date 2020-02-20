package IO_handling_utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import meta_data.Column;
/**
 * 
 * Contains all functions that help us to extract String from JSon Object
 * @version 1.0
 * @author Nadir Omega
 * @author ylgn
 *
 */
public class JsonExtractors {

	/**
	 * Return a data-less Column with a specified rule name and its type.
	 * The method create an empty column prior calling extractNameAndTypeFromJsObj
	 * @param  JSONObject giving an object rule
	 * @param  String giving the ruleName
	 * @return the column with the specified rule bound to a type
	 */
	public static Column initCol(JSONObject jsonObject,String ruleName) 
	{
		Column tempCOl = new Column();
		extractNameAndTypeFromJsObj(tempCOl,jsonObject,ruleName);
		return tempCOl;	
	}
	
	
	/**
	 * Set the adequate rule to a column. 
	 * It call extractVerificationRuleFromJsObject for dropping dependences 
	 * between our algorithm and our extract Verification policy.
	 * @param  Column giving the column that will receive the rule 
	 * @param  JSONObject giving the object rule
	 * @param  String giving the rule Name
	 */
	public static void parseRuleObject(Column tempCOl,JSONObject jsonObject,String ruleName) 
	{
		extractVerificationRuleFromJsObject(tempCOl,jsonObject,ruleName);	
	}	
	
	/**
	 * Return the value of an object called name in a JSONObject
	 * @param  JSONObject giving the object name
	 * @return String with the value of name
	 */
	public static String extractNameFromJsObject(JSONObject jsonObject) {
		return (String) jsonObject.get("name");
	}
	
	/**
	 * Return the value of any specified object
	 * @param  String 
	 * @param  JSONObject giving an object
	 * @return String with the value of the asked object
	 */
	public static String extractByNameFromJsObject(String str,JSONObject jsonObject) {
		return (String) jsonObject.get(str);
	}
	
	/**
	 * Parse one or n rule(s) to a given Column
	 * If the Json Object has for value a JSONArray, each item will be added to the Rules Array of the given colum
	 * Otherwise, the rule will be directly mapped.
	 * @param Column that will receive the rule 
	 * @param JsonObject carrying the rule(s) 
	 * @param String giving the targeted rule
	 * 
	 */
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
	
	
	/**
	 * Return the value of an anonymised rule given by its name
	 * @param  JSONObject giving the object rule
	 * @param  String giving the rule Name
	 * @return String with the value of the asked object
	 */
	public static String extractAnonymisationRuleFromJsObject(JSONObject jsonObject,String ruleName) {
		Object ruleObject = jsonObject.get(ruleName);
		return ruleObject.toString();
	}
	
	/**
	 * Set the type of a specified rule into a column 
	 * @param  Column given to be modified
	 * @param  JSONObject giving the object rule
	 * @param  String giving the rule Name
	 */
	public static void extractNameAndTypeFromJsObj(Column tempCOl,JSONObject jsonObject,String ruleName) {  
		tempCOl.setName(extractNameFromJsObject(jsonObject));
		String type = (String) jsonObject.get(ruleName);
		tempCOl.setType(type);
	}
}