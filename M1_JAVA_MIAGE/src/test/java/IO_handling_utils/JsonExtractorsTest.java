package IO_handling_utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import meta_data.Column;

public class JsonExtractorsTest {

	@Test
	public void testExtractNameFromJsObject() {
		// Json object to test
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "AGE");
		jsonObject.put("should", "[BE_AN_AGE]");
		String expectedName = "AGE";
		assertEquals(JsonExtractors.extractNameFromJsObject(jsonObject), expectedName);
	}

	@Test
	public void testExtractByNameFromJsObject() {
		// Json object to test
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "AGE");
		jsonObject.put("should", "[BE_AN_AGE]");
		String str = "should";
		String expected = "[BE_AN_AGE]";
		assertEquals(JsonExtractors.extractByNameFromJsObject(str, jsonObject), expected);
	}

	@Test
	public void testExtractAnonymisation() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "NOM");
		jsonObject.put("changeTo", "RANDOM_LETTER");
		String ruleName = "changeTo";
		String expected = "RANDOM_LETTER";
		assertEquals(JsonExtractors.extractAnonymisationRuleFromJsObject(jsonObject, ruleName), expected);

	}

	@Test
	public void textractVerificationRuleFromJsObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "AGE");
		jsonObject.put("should", "[BE_AN_AGE");
		String ruleName = "name";
		String expected = "AGE";
		Column tempCOL = JsonExtractors.initCol(jsonObject, ruleName);
		JsonExtractors.extractVerificationRuleFromJsObject(tempCOL, jsonObject, ruleName);
		String actual = tempCOL.getName();
		assertEquals(expected, actual);

	}

	@Test
	public void testInitColName() {
		// Json object to test
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "AGE");
		jsonObject.put("should", "[BE_AN_AGE");
		String ruleName = "name";
		String expectedName = "AGE";
		Column testedColumn = JsonExtractors.initCol(jsonObject, ruleName);
		assertEquals(testedColumn.getName(), expectedName);

	}

	@Test
	public void testInitColRuleType() {
		// Json object to test
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "AGE");
		jsonObject.put("should", "[BE_AN_AGE]");
		String ruleName = "should";
		String expectedType = "[BE_AN_AGE]";
		Column testedColumn = JsonExtractors.initCol(jsonObject, ruleName);
		assertEquals(testedColumn.getType(), expectedType);

	}

}
